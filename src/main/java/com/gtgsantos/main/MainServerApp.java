package com.gtgsantos.main;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;


public class MainServerApp {

    public static void main(String[] args) throws Exception {

            WebAppContext root = new WebAppContext();
            //root.setContextPath("/gtgsantos");  as example; we dont need this.
            root.setResourceBase("src/main/webapp/");        
            root.setDescriptor(root.getResourceBase() + "/WEB-INF/web.xml"); 
            root.setParentLoaderPriority(true);

            Server server = new Server(Integer.valueOf(StringUtils.defaultIfEmpty(System.getenv("PORT"), "8080")));
            server.setHandler(root);
            server.start();
            server.join();
    }
}
