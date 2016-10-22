package cn.zmlio.tinycms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZML on 2016/10/16.
 */
@Controller
@RequestMapping("/admin/init")
public class InitController {
    @RequestMapping(value = {"","/"})
    public String init() {
        return "redirect:/";
    }
}
