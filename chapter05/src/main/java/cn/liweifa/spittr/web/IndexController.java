package cn.liweifa.spittr.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by josli on 17/10/16.
 */
@Controller//
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(){
        logger.info("进入首页");
        return "home";
    }

    
}
