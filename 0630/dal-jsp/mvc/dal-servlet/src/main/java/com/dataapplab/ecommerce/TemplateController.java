package com.dataapplab.ecommerce;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TemplateController {

    @GetMapping("/newstart")
    public String index(Model model) {
        model.addAttribute("name","Joshua");
        return "greeting";
    }
    
}
