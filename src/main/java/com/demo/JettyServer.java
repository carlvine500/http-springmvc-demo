package com.demo;


import org.apache.commons.io.FileUtils;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;

public class JettyServer {
    public static void main(String[] args) {
        try {

            FileUtils.deleteDirectory(new File("/Users/tingfeng/work/dms/httl-springmvc/src/main/java/httl"));
            // mock tomcat home
            System.setProperty("catalina.home", System.getProperty("user.home"));
            Server server = new Server(8080);
            WebAppContext context = new WebAppContext();
            // /Users/tingfeng/work/java/pinpoint/collector
//            context.setResourceBase("./collector/src/main/webapp");
            context.setResourceBase("/Users/tingfeng/work/dms/httl-springmvc/src/main/webapp");
            context.setParentLoaderPriority(true);
            server.setHandler(context);
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
