package com.herb.example.web;

import com.herb.example.exception.web.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by herb on 2016/8/13.
 */

@Controller
public class HelloController extends AbstractController {

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("description", "This is Restfull API project seed.");
        return "index";
    }

    @RequestMapping("/exception")
    public String hello() throws Exception {
        throw new Exception("发生exception");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生myexception");
    }

}
