package cn.liweifa.spittr.web;

import cn.liweifa.spittr.config.RootConfig;
import cn.liweifa.spittr.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.io.File;

/**
 * Created by josli on 17/10/16.
 */
public class WebInitlizer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        File file = new File("/tmp/spittr/uploads");
        if (!file.exists()) file.mkdir();
        registration.setMultipartConfig(new MultipartConfigElement(file.getAbsolutePath()));
        super.customizeRegistration(registration);
    }
}
