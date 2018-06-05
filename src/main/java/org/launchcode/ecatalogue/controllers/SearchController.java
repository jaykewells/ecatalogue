package org.launchcode.ecatalogue.controllers;

import org.launchcode.ecatalogue.models.Part;
import org.launchcode.ecatalogue.models.PartFieldType;
import org.launchcode.ecatalogue.models.data.PartData;
import org.launchcode.ecatalogue.models.forms.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;


@Controller
@RequestMapping(value="search")
public class SearchController {

    private PartData partData = PartData.getInstance();


    @RequestMapping(value= "")
    public String search(Model model){
        model.addAttribute(new SearchForm());
        return "index";

    }

    @RequestMapping(value= "results")
    public String search(Model model, @ModelAttribute SearchForm searchForm){

        ArrayList<Part> parts;

        if(searchForm.getSearchField().equals(PartFieldType.ALL)){
            parts = partData.findByValue(searchForm.getKeyword());
        }
        else{
            parts = partData.findByColumnAndValue(searchForm.getSearchField(), searchForm.getKeyword());
        }
        if(parts.size() == 0){
            return "custom";
        }
        model.addAttribute("parts", parts);

        return "search";
    }
}
