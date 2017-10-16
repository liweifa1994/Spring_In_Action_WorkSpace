package cn.liweifa.spittr.config;

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
        System.out.println("kargo card");
//        EnumSet<DispatcherType> dispatcherTypes = EnumSet
//                .allOf(DispatcherType.class);
//        dispatcherTypes.add(DispatcherType.REQUEST);
//        dispatcherTypes.add(DispatcherType.FORWARD);
//        dispatcherTypes.add(DispatcherType.INCLUDE);
//        dispatcherTypes.add(DispatcherType.ERROR);
//        FilterRegistration.Dynamic log4jServletFilter = servletContext.addFilter("log4jServletFilter",Log4jServletFilter.class.getName());
//        log4jServletFilter.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
        //添加系统参数 在这里指定 logback.xml文件的路径
        servletContext.setInitParameter("logbackConfigLocation","classpath:logback.xml");
        //添加logback的监听器
        servletContext.addListener(LogbackConfigListener.class.getName());
    }
}
