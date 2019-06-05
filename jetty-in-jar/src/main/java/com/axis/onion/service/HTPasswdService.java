package com.axis.onion.service;

import cc.kebei.expands.shell.Shell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.io.IOException;

/**
 * Created by Ke Qingyuan on 2019-06-04.
 */
@Service("hTPasswdService")
public class HTPasswdService {

    private static final Logger LOG = LoggerFactory.getLogger(HTPasswdService.class);

    private final String UPDATE_COMMAND_TEST = "/usr/bin/htpasswd2 -mb /svn_test/conf/passwd.conf";

    private final String UPDATE_COMMAND = "/usr/bin/htpasswd2 -mb /apache/svn_common_conf/passwd.conf";

    public String updatePassword(String name, String passwd, String env) {
        LOG.info("name={},password={}", name, passwd);
        String result = "";
        try {
            synchronized (this) {
                String pwd = new String(Base64Utils.decodeFromString(passwd), "UTF-8");
                String command = UPDATE_COMMAND_TEST;
                if ("prd".equals(env))
                    command = UPDATE_COMMAND;
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
