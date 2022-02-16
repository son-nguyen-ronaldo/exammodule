package com.example.kiemtramd4.controller;

import com.example.kiemtramd4.model.City;
import com.example.kiemtramd4.model.Nation;
import com.example.kiemtramd4.service.City.CityService;
import com.example.kiemtramd4.service.Nation.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    CityService cityService;
    @Autowired
    NationService nationService;

    @GetMapping("/showcity")
    public ModelAndView show(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("listCity", cityService.findAll(PageRequest.of(page, 5)));
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showcreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("createCity", new City());
        modelAndView.addObject("createNation", nationService.findAll());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute("createCity") City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/create");
            List<Nation> list = nationService.findAll();
            modelAndView.addObject("createCity", city);
            modelAndView.addObject("createNation", list);
            return modelAndView;
        }
        cityService.save(city);
        return new ModelAndView("redirect:/showcity");
    }

    @ModelAttribute("editNation")
    public List<Nation> getNation(){
        return nationService.findAll();
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Optional<City> city = cityService.findByID(id);
        modelAndView.addObject("editCity", city);
        modelAndView.addObject("editNation", nationService.findAll());
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute(value = "editCity") City city, @RequestParam long idCate) {

        Nation nat = new Nation();
        nat.setIdNation(idCate);
        city.setNation(nat);
        cityService.save(city);
        return "redirect:/showcity";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        Optional<City> city = cityService.findByID(id);
        modelAndView.addObject("deleteProduct", city);
        modelAndView.addObject("deleteCategory", nationService.findAll());
        return modelAndView;
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        cityService.delete(id);
        return "redirect:/showcity";
    }
    @GetMapping("/details/{id}")
    public ModelAndView showdetails(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("details");
        Optional<City> city = cityService.findByID(id);
        modelAndView.addObject("editCity", city);
        modelAndView.addObject("editNation", nationService.findAll());
        return modelAndView;
    }
}
