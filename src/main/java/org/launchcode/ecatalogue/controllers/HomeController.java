package org.launchcode.ecatalogue.controllers;

import org.launchcode.ecatalogue.models.*;
import org.launchcode.ecatalogue.models.data.PartData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private PartData partData = PartData.getInstance();

    @RequestMapping(value="")
    public String index(Model model){
        PartFieldType[] fields = PartFieldType.values();
        model.addAttribute("fields", fields.toString());
        model.addAttribute("parts", partData.findAll());
        model.addAttribute("message", "Hello, World!");
        System.out.println("!!!! From HomeController: " + partData + "!!!!");
        System.out.println("!!!!" + fields + "!!!!");
        return "index";
    }
}
