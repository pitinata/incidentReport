package com.cattelecom.incidentReport.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/entry")
public class EntryController {
    
    @GetMapping("/add")
    public ModelAndView addView(){
        ModelAndView mav = new ModelAndView(); 
        mav.setViewName("entry/add");
        return mav;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editView(){
        ModelAndView mav = new ModelAndView(); 
        mav.setViewName("entry/edit");
        return mav;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteView(){
        ModelAndView mav = new ModelAndView(); 
        mav.setViewName("entry/delete");
        return mav;
    }

    @PostMapping("/add")
    public String add( ){
        return "added";
    }

    @PutMapping("/edit/{id}")
    public Long edit(@PathVariable Long id){
        return id;
    }

    @DeleteMapping("/delete/{id}")
    public Long delete(@PathVariable Long id){
        return id;
    }
}
