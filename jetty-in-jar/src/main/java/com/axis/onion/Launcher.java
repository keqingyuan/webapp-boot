package com.axis.onion;

import com.axis.onion.handler.HelloHandler;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

/**
 * Created by qingyuan on 2018/10/19.
 */
public class Launcher {

    private void startJetty(int port, String... context) throws Exception {
        // 创建指定监听端口的jetty服务器
        Server server = new Server();
        // 配置connector
        ServerConnector http = new ServerConnector(server);
        http.setPort(port);
        server.setConnectors(new Connector[]{http});

        // 配置handler
        server.setHandler(new HelloHandler("hello"));

        // 启动
        server.start();
        // 输出错误日志
        server.dumpStdErr();
        // 准备完毕启动服务器
        server.join();
    }

    public static void main(String[] args) {
        try {

            new Launcher().startJetty(8080, "/");

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
