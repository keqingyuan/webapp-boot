package com.axis.onion;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by qingyuan on 2018/10/20.
 */
public class Launcher {

    public void start(int port, String context) throws Exception {
        Server server = new Server();
        // 配置connector
        ServerConnector http = new ServerConnector(server);
        http.setPort(port);
        server.setConnectors(new Connector[]{http});

        // 创建多handler
        //HandlerCollection handlers = new HandlerCollection();

        // 创建多上下文的
        WebAppContext webapp = new WebAppContext();
        webapp.setResourceBase("src/main/"); // 设置资源根目录
        webapp.setDescriptor("WEB-INF/web.xml"); // 设置web描述文件
        webapp.setContextPath(context); // 设置访问上下文
        webapp.setParentLoaderPriority(false);

        server.setHandler(webapp); // 单handler

        // 配置多handler
        //handlers.addHandler(webapp);
        //server.setHandler(handlers);


        // 启动服务
        server.start();
        server.dumpStdErr();
        server.join();
    }

    public static void main(String[] args) {
        try {
            new Launcher().start(8090, "/");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
