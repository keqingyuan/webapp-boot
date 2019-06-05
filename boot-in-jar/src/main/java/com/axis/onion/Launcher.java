package com.axis.onion;

import com.axis.onion.handler.HelloHandler;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;

/**
 * Created by qingyuan on 2018/10/19.
 */
public class Launcher {

    private void start(int port, String... context) {

        // 创建指定监听端口的jetty服务器
        Server server = new Server();
        // 配置connector
        ServerConnector http = new ServerConnector(server);
        http.setPort(port);
        server.setConnectors(new Connector[]{http});

        // 配置handler
        server.setHandler(new HelloHandler("hello"));
        try {
            // 启动
            server.start();
            // 输出错误日志
            server.dumpStdErr();
            // 准备完毕启动服务器
            server.join();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            server.destroy();
            System.exit(-1);
        }
    }

    private void startWithServletContext(int port, String context) {
        // servletContextHandler
        ServletContextHandler servletContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContext.setContextPath(context);

        // add spring contextLoaderListener
        servletContext.addEventListener(new ContextLoaderListener());
        servletContext.setInitParameter("contextConfigLocation", "classpath*:**/application-context.xml");

        // jetty server
        Server server = new Server(port);
        server.setHandler(servletContext);

        // add jersey servlet
        ServletHolder jerseyServlet = servletContext.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/api/*");
        jerseyServlet.setInitOrder(1);

        // Tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter("com.sun.jersey.config.property.resourceConfigClass","com.sun.jersey.api.core.PackagesResourceConfig");
        // pojo mapper json
        jerseyServlet.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");
        // jersey resources package
        jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "com.axis.onion");


        try {
            // 启动
            server.start();
            // 准备完毕启动服务器
            server.join();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            server.destroy();
            System.exit(-1);
        }


    }

    public static void main(String[] args) {

        new Launcher().startWithServletContext(8090, "/");

    }
}
