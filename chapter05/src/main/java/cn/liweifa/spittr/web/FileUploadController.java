package cn.liweifa.spittr.web;

import cn.liweifa.spittr.pojo.Spitter;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class FileUploadController {
    private Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    @RequestMapping(value = "/show/register/form",method = RequestMethod.POST)
    @ResponseBody
    public String porcessRegistranstion(MultipartFile profilePicture){
        String fileName = "/home/suse/uploads/demo01/";
        File file = new File(fileName);
        if (!file.exists()){
            file.mkdir();
        }
       String uploadFileName =  fileName+profilePicture.getOriginalFilename();
        try {
            profilePicture.transferTo(new File(uploadFileName));
        }catch (Exception e){
            logger.error(ExceptionUtils.getMessage(e));
        }
        return uploadFileName;
    }

    @RequestMapping(value = "/show/register/form",method = RequestMethod.GET)
    public String showRegisterView(Model model){
        model.addAttribute(new Spitter());
        return "registerForm";
    }
}
