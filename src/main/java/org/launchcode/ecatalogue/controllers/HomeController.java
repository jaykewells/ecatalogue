package org.launchcode.ecatalogue.controllers;

import org.launchcode.ecatalogue.models.*;
import org.launchcode.ecatalogue.models.data.PartData;
import org.launchcode.ecatalogue.models.forms.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private PartData partData = PartData.getInstance();

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute(new SearchForm());
        return "index";
    }
}
