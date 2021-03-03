package com.cattelecom.incidentReport.Controller;

import java.util.List;

import javax.validation.Valid;

import com.cattelecom.incidentReport.Model.Entry;
import com.cattelecom.incidentReport.Model.Status;
import com.cattelecom.incidentReport.Service.EntryService;
import com.cattelecom.incidentReport.Service.StatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    EntryService entryService;

    @Autowired
    StatusService statusService;

    @GetMapping("/add")
    public ModelAndView addView() {
        Entry entry = new Entry();
        List<Status> statusList = statusService.getSortedStatus();
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("entry/add");
        mav.addObject("entry", entry);
        mav.addObject("statusList", statusList);

        return mav;
    }

    @GetMapping("/info/{id}")
    public ModelAndView infoView(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        Entry entry = entryService.getEntry(id);

        if(entry.getId() == null){
            redirectAttrs.addFlashAttribute("status", "entry not found.");
            return new ModelAndView("redirect:/dashboard/me");
        }

        ModelAndView mav = new ModelAndView();
        mav.setViewName("entry/info");
        mav.addObject("entry", entry);
        return mav;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editView(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        Entry entry = entryService.getEntry(id);
        List<Status> statusList = statusService.getSortedStatus();

        if(entry.getId() == null){
            redirectAttrs.addFlashAttribute("status", "entry not found.");
            return new ModelAndView("redirect:/dashboard/me");
        }

        ModelAndView mav = new ModelAndView();
        mav.setViewName("entry/edit");
        mav.addObject("entry", entry);
        mav.addObject("statusList", statusList);
        return mav;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteView(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        ModelAndView mav = new ModelAndView();
        Entry entry = entryService.getEntry(id);

        if(entry.getId() == null){
            redirectAttrs.addFlashAttribute("status", "entry not found.");
            return new ModelAndView("redirect:/dashboard/me");
        }

        mav.setViewName("entry/delete");
        mav.addObject("entry", entry);
        return mav;
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("entry") Entry entry, BindingResult result, Model model,
            RedirectAttributes redirectAttrs) {
        if(result.hasErrors()){
            model.addAttribute("statusList", statusService.getSortedStatus());
            return "entry/add";
        }
        Entry afterSubmit = entryService.save(entry);
        redirectAttrs.addFlashAttribute("status", "entry has been added.");
        return "redirect:/entry/info/"+afterSubmit.getId();
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("entry") Entry entry, BindingResult result, Model model,
    RedirectAttributes redirectAttrs){
        if(result.hasErrors()){
            model.addAttribute("statusList", statusService.getSortedStatus());
            return "entry/edit/"+entry.getId();
        }

        Entry afterSubmit = entryService.update(entry);
        if(afterSubmit.getId() == null){
            redirectAttrs.addFlashAttribute("status", "entry not found.");
            return "redirect:/dashboard/me";
        }
        redirectAttrs.addFlashAttribute("status", "entry has been updated.");
        return "redirect:/entry/info/"+afterSubmit.getId();
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes redirectAttrs){
        Entry entry = entryService.getEntry(id);

        if(entry.getId() == null){
            redirectAttrs.addFlashAttribute("status", "entry not found.");
            return "redirect:/dashboard/me";
        }

        entryService.delete(id);
        redirectAttrs.addFlashAttribute("status", "entry has been deleted.");
        return "redirect:/dashboard/me";

    }
}
