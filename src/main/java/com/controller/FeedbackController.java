package com.controller;


import com.model.Category;
import com.model.Feedback;
import com.repository.CategoryRepository;
import com.repository.FeedbackRepository;
import com.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("feedbacks", feedbackService.findAllFeedBacks());
        model.addAttribute("categoriesAll", feedbackService.loadCategories());
        model.addAttribute("newfeedback", new Feedback());
        return "index";
    }




    @PostMapping("/")
    public String createFeedback(@Valid @ModelAttribute("newfeedback") Feedback feedback, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        if(bindingResult.hasErrors()){
            return "index";
        }
        feedbackService.save(feedback);
        return "redirect:/";
    }
}
