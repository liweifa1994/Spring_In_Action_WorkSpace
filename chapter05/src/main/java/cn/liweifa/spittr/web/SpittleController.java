package cn.liweifa.spittr.web;

import cn.liweifa.spittr.data.SpittleRepository;
import cn.liweifa.spittr.pojo.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
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
    //查找20条消息
    @RequestMapping(method = RequestMethod.GET)
    public  List<Spittle> spittles(@RequestParam(value = "max",defaultValue = MAX_LONG_AS_STRING) long max,
                                   @RequestParam(value = "count",defaultValue = "20") int count){
        return spittleRepository.findSpittles(Long.MAX_VALUE, count);
    }

    //根据 id 查找 某一条消息
    @RequestMapping(value = "/{spittleId}",method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model){
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

    /**
     *
     * @param spittleForm
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm spittleForm,Model model)throws Exception{
        spittleRepository.save(new Spittle(null,spittleForm.getMessage()
                ,new Date()
                ,spittleForm.getLongitude()
                ,spittleForm.getLatitude()));
        return "redirect:/spittles";
    }

}
