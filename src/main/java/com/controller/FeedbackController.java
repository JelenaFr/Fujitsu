package com.controller;


import com.model.Feedback;
import com.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeedbackController {

    @Autowired
    FeedbackService controllerService;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        controllerService.getIndexPage(model);
        return "index";
    }

    @PostMapping("/")
    public String createFeedback(Feedback feedback) {
        controllerService.save(feedback);
        return "redirect:/";
    }
}
