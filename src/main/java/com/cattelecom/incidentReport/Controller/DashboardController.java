package com.cattelecom.incidentReport.Controller;

import java.util.List;
import java.util.Map;

import com.cattelecom.incidentReport.Model.Entry;
import com.cattelecom.incidentReport.Model.Status;
import com.cattelecom.incidentReport.Service.EntryService;
import com.cattelecom.incidentReport.Service.StatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    EntryService entryService;

    @Autowired
    StatusService statusService;
    
    @GetMapping()
    public ModelAndView dashboard(){
        Map<Status, List<Entry>> groups = entryService.getGroupedEntries();

        ModelAndView mav = new ModelAndView(); 
        mav.setViewName("dashboard/overall");
        mav.addObject("groups", groups);
        mav.addObject("orderedStatus", statusService.getSortedStatus());

        return mav;
    }

    @GetMapping("/me")
    public ModelAndView privateboard(){
        Map<Status, List<Entry>> groups = entryService.getGroupedEntries();

        ModelAndView mav = new ModelAndView(); 
        mav.setViewName("dashboard/private");
        mav.addObject("groups", groups);
        mav.addObject("orderedStatus", statusService.getSortedStatus()); 
        
        return mav;
    }
}
