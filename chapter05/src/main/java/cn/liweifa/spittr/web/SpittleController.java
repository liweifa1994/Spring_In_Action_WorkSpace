package cn.liweifa.spittr.web;

import cn.liweifa.spittr.data.SpitterRepository;
import cn.liweifa.spittr.data.SpittleRepository;
import cn.liweifa.spittr.pojo.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.annotation.Native;
import java.util.List;

/**
 * Created by josli on 17/10/16.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    @Autowired
    private SpittleRepository spittleRepository;

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){
        List<Spittle> spittles = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
        model.addAttribute(spittles);
        return "spittles";
    }


    @RequestMapping(method = RequestMethod.GET)
    public String spittles(@RequestParam(value = "max",defaultValue = MAX_LONG_AS_STRING) long max,){
        List<Spittle> spittles = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
//        model.addAttribute(spittles);
        return "spittles";
    }

}
