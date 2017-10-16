package cn.liweifa.spittr.web;

import cn.liweifa.spittr.data.SpitterRepository;
import cn.liweifa.spittr.pojo.Spitter;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by josli on 17/10/16.
 */
@Controller
@RequestMapping("/spitter")

public class SpitterController {
    private Logger logger = LoggerFactory.getLogger(SpitterController.class);
    @Autowired
    private SpitterRepository spitterRepository;

    //显示注册页面
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    //注册用户时候处理的逻辑
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String processRegister( Spitter spitter){
        try {
            spitterRepository.save(spitter);
        }catch (Exception e){
            logger.error(ExceptionUtils.getMessage(e));
        }
        return "redirect:/spitter/" + spitter.getUsername();
    }

    //显示注册成功以后 个人的基本信息
    @RequestMapping(value="/{username}", method=RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }

}
