package com.controller;


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

@Controller
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        feedbackService.getIndexPage(model);
        return "index";
    }


    @PostMapping("/")
    public String createFeedback(@Valid @ModelAttribute("newfeedback") Feedback newfeedback, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        feedbackService.save(newfeedback,bindingResult);

        return "redirect:/";
    }
}
