package com.cattelecom.incidentReport.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    
    @GetMapping
    public ModelAndView dashboard(){
        ModelAndView mav = new ModelAndView(); 
        mav.setViewName("dashboard/overall");
        return mav;
    }

    @GetMapping("/me")
    public ModelAndView privateboard(){
        ModelAndView mav = new ModelAndView(); 
        mav.setViewName("dashboard/private");
        return mav;
    }
}
