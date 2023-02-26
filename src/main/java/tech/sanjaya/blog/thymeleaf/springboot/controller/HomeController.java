package tech.sanjaya.blog.thymeleaf.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends BaseController {
    @GetMapping({"/", "/index"})
    public String index() {
        LOG.info("In index view");
        return "index";
    }
}
