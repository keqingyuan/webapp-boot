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

    private static Logger log = LoggerFactory.getLogger(HTPasswdService.class);

    private final String UPDATE_COMMAND = "/usr/bin/htpasswd2 -mb /svn_test/conf/passwd.conf";

    public String updatePassword(String name, String passwd) {
        log.info("name={},passwd={}", name, passwd);
        String result = "";
        try {
            String pwd = new String(Base64Utils.decodeFromString(passwd), "UTF-8");
            String command = UPDATE_COMMAND + " " + name + " " + pwd;
            Shell.build(command)
                    .onProcess((line, helper) -> log.info(line))
                    .onError((line, helper) -> log.error(line))
                    .exec();

        } catch (IOException e) {
            result = e.getLocalizedMessage();
            log.error(e.getLocalizedMessage(), e);
        }
        return result;
    }
}
