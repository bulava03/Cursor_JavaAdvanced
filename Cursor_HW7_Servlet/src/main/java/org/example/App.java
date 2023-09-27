package org.example;

import jakarta.servlet.ServletException;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) throws ServletException, LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addContext("/", "/");
        Tomcat.addServlet(context, "HiServlet", new HiServlet());
        context.addServletMappingDecoded("/hello", "HiServlet");

        tomcat.start();
        tomcat.getServer().await();
    }
}
