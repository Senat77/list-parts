package com.nodomain.listparts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController
{
    @Autowired
    private PartRepository partRepository;

    @GetMapping
    public String getAllParts(Model model)
    {
        model.addAttribute("parts",partRepository.findAll());
        return "index";
    }

    @PostMapping
    public String add(@RequestParam String name,@RequestParam Long amount,@RequestParam Boolean isnecessary,Model model)
    {
        Part part = new Part(name,isnecessary,amount);
        partRepository.save(part);
        model.addAttribute("parts",partRepository.findAll());
        return "index";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter,Model model)
    {
        model.addAttribute("parts",partRepository.findByName(filter));
        return "index";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "greeting";
    }
}
