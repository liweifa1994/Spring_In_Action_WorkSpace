package cn.liweifa.spittr.file.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.io.File;

/**
 * Created by josli on 17/10/17.
 */

public class WebApp extends AbstractAnnotationConfigDispatcherServletInitializer{
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

    // 文件上传的临时路径
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        File file = new File("/Users/josli/workspace/uploads");
        if (!file.exists()) file.mkdir();
        registration.setMultipartConfig(new MultipartConfigElement(file.getAbsolutePath()));
        super.customizeRegistration(registration);
    }
}
