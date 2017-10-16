package cn.liweifa.spittr.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by josli on 17/10/16.
 */
@RestController
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping("/hello")
    public String helloWorld(){
        logger.info("abcdef");
        System.out.println("hello world");
        return "helloWorld";
    }
}
