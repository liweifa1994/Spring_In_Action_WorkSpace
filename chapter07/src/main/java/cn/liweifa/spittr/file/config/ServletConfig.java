package cn.liweifa.spittr.file.config;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by josli on 17/10/16.
 */
public class ServletConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("logbackConfigLocation","classpath:logback.xml");
        //添加logback的监听器
        servletContext.addListener(LogbackConfigListener.class.getName());
    }
}
