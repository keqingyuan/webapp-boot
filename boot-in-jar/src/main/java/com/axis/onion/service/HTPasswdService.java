package com.axis.onion.service;

import cc.kebei.expands.shell.Shell;
import com.axis.onion.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.io.IOException;

/**
 * Created by Ke Qingyuan on 2019-06-04.
 */
@Service("hTPasswdService")
public class HTPasswdService {

    private static final Logger LOG = LoggerFactory.getLogger(HTPasswdService.class);

    @Autowired private AppConfig appConfig;

    public String updatePassword(String name, String passwd, String env) {
        LOG.info("name={},password={}", name, passwd);
        String result = "";
        try {
            synchronized (this) {
                String pwd = new String(Base64Utils.decodeFromString(passwd), "UTF-8");
                String command = appConfig.getHtpasswd2UpdateCommandForTest();
                if ("prd".equals(env))
                    command = appConfig.getHtpasswd2UpdateCommand();
                command = command + " " + name + " " + pwd;
                Shell.build(command)
                        .onProcess((line, helper) -> LOG.info(line))
                        .onError((line, helper) -> LOG.error(line))
                        .exec();
            }

        } catch (IOException e) {
            result = e.getLocalizedMessage();
            LOG.error(e.getLocalizedMessage(), e);
        }
        return result;
    }
}
