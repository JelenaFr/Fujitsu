package com.controller;


import com.model.Feedback;
import com.service.FeedbackService;
import com.validator.FeedbackValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;
    @Autowired
    FeedbackValidator feedbackValidator;

    @GetMapping("/")
    public String getFeedbackPage(Model model) {
        model.addAttribute("feedbacks", feedbackService.findAllFeedBacks());
        model.addAttribute("categoriesAll", feedbackService.loadCategories());
        model.addAttribute("newFeedback", new Feedback());
        return "index";
    }

    @PostMapping("/")
    public String createFeedback(@Valid @ModelAttribute("newFeedback") Feedback feedback, BindingResult errors, Model model) {
        feedbackValidator.validate(feedback, errors);
        if (errors.hasErrors()) {
            model.addAttribute("feedbacks", feedbackService.findAllFeedBacks());
            model.addAttribute("categoriesAll", feedbackService.loadCategories());
            return "index";
        }
        feedbackService.save(feedback);
        return "redirect:/";
    }
}
