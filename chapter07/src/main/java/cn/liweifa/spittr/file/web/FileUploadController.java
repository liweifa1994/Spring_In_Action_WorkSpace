package cn.liweifa.spittr.file.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by josli on 17/10/17.
 */
@Controller
public class FileUploadController {

    /**跳转到上传文件的页面**/
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String showUploadView(){
        return "upload";
    }

    /**上传文件的逻辑 上传到本地服务器中*/
    @RequestMapping(value = "/file/upload",method = RequestMethod.POST)
    @ResponseBody
    public String uploadProcess (MultipartFile profilePicture){
        String fileName = "/Users/josli/workspace/uploads/demo01/";
        File file = new File(fileName);
        if (!file.exists()){
            file.mkdir();
        }
        String uploadFileName =  fileName+profilePicture.getOriginalFilename();
        try {
            profilePicture.transferTo(new File(uploadFileName));
        }catch (Exception e){
            e.printStackTrace();
        }
        return uploadFileName;
    }
}
