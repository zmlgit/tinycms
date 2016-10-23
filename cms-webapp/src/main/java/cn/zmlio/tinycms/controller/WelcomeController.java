package cn.zmlio.tinycms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZML on 2016/10/22.
 */
@RequestMapping(path = {"", "/", "index"})
@Controller
public class WelcomeController {

    @GetMapping(name = "")
    public String index() {
        return "index";
    }

    @PostMapping(name = "")
    public String add() {
        return "index";
    }
}
