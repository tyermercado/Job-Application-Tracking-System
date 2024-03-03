package com.example.JobApplicationTrackingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.JobApplicationTrackingSystem.model.JobApplicationTS;
import com.example.JobApplicationTrackingSystem.service.JobAppService;

@Controller
public class JobAppController {
    
    @Autowired
    private JobAppService service;
    
    @GetMapping({"/", "/viewJobApplications"})
    public String viewAllJobApplications(Model model, @ModelAttribute("message") String message) {
        model.addAttribute("list", service.getAllJobApplications());
        model.addAttribute("msg", message);
        model.addAttribute("company", new String()); 
        return "ViewJobApplications";
    }
    
    @PostMapping("/updateJobApplicationStatus/{id}")
    public String updateJobAppStatus(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (service.updateStatus(id)) {
            redirectAttributes.addFlashAttribute("message", "Successfully updated");
        } else {
            redirectAttributes.addFlashAttribute("message", "Update failed");
        }
        return "redirect:/viewJobApplications";
    }
    
    @GetMapping("/addJobApp")
    public String addJobApp(Model model) {
        model.addAttribute("jobapp", new JobApplicationTS());
        model.addAttribute("company", new String()); 
        return "AddJobApp";
    }
    
    @PostMapping("/saveJobApp")
    public String saveJobApp(JobApplicationTS jobApp, RedirectAttributes redirectAttributes) {
        if (service.saveOrUpdateJobApp(jobApp)) {
            redirectAttributes.addFlashAttribute("message", "Successfully saved");
        } else {
            redirectAttributes.addFlashAttribute("message", "Save failed");
        }
        return "redirect:/viewJobApplications";
    }
    
    @GetMapping("/editJobApp/{id}")
    public String editJobApp(@PathVariable Long id, Model model) {
        model.addAttribute("jobapp", service.getJobApplicationTSById(id));
        return "EditJobApp";
    }
    
    @PostMapping("/editSaveJobApp")
    public String editSaveJobApp(JobApplicationTS jobApp, RedirectAttributes redirectAttributes) {
        if (service.saveOrUpdateJobApp(jobApp)) {
            redirectAttributes.addFlashAttribute("message", "Edit successfully");
        } else {
            redirectAttributes.addFlashAttribute("message", "Edit failed");
        }
        return "redirect:/viewJobApplications";
    }
    
    @GetMapping("/deleteJobApp/{id}")
    public String deleteJobApp(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (service.deleteJobApp(id)) {
            redirectAttributes.addFlashAttribute("message", "Successfully deleted");
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete failed");
        }
        return "redirect:/viewJobApplications";
    }
    


}
