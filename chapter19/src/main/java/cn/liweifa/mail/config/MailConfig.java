package cn.liweifa.mail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.Set;

/**
 * Created by josli on 17/10/17.
 */
@Configuration
@ComponentScan(basePackages = "cn.liweifa.mail")
public class MailConfig {
    @Bean
    public JavaMailSender mailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("xxx");
        mailSender.setUsername("xxx");
        mailSender.setPassword("xxx");
        return mailSender;
    }

    /**
     * 创建 模板引擎 该类面向程序 以下的两个模板引擎
     * @param resolvers
     * @return
     */
    @Bean
    public SpringTemplateEngine templateEngine(Set<ITemplateResolver> resolvers) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolvers(resolvers);
        return templateEngine;
    }
    /**
     * 该模板引擎用于解析类路径下的模板 HTML
     * @return
     */
    @Bean
    public ClassLoaderTemplateResolver emailTemplateResolver(){
        ClassLoaderTemplateResolver resolver =
                new ClassLoaderTemplateResolver();
        resolver.setPrefix("mail/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCharacterEncoding("UTF-8");
        //优先使用 ClassLoaderTemplateResolver 模板引擎
        //优先使用该模板引擎 如果是web开发 则使用 ServletContextTemplateResolver 模板引擎
        resolver.setOrder(1);
        return resolver;
    }

    /**
     * 该模板引擎用于解析web模板 HTML
     * @return
     */
    @Bean
    public  ServletContextTemplateResolver servletContextTemplateResolver(){
        ServletContextTemplateResolver servletContextTemplateResolver =
                new ServletContextTemplateResolver();
        servletContextTemplateResolver.setPrefix("/WEB-INF/templates");
        servletContextTemplateResolver.setSuffix(".html");
        servletContextTemplateResolver.setTemplateMode("HTML5");
        servletContextTemplateResolver.setCharacterEncoding("UTF-8");
        servletContextTemplateResolver.setOrder(2);
        return servletContextTemplateResolver;
    }

}
