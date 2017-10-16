package cn.liweifa.spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import cn.liweifa.spittr.config.RootConfig.WebPackage;
import java.util.regex.Pattern;

/**
 * Created by josli on 17/10/16.
 */
@Configuration
@ComponentScan(value = "cn.liweifa.spittr",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = WebPackage.class)})
@Import(DataConfig.class)
public class RootConfig {

    //不扫描spittr 下面的web包
    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage() {
            super(Pattern.compile("spittr\\.web"));
        }
    }
}
