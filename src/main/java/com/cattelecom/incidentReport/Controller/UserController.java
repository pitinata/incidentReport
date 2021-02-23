package com.cattelecom.incidentReport.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @GetMapping("/setting")
    public ModelAndView dashboard(){
        ModelAndView mav = new ModelAndView(); 
        mav.setViewName("user/setting");
        return mav;
    }
}
