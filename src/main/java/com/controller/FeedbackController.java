package com.controller;


import com.model.Feedback;
import com.validator.FeedbackValidator;
import com.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.stream.IntStream;

@Controller
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;
    @Autowired
    FeedbackValidator feedbackValidator;

    @GetMapping("/")
    public String getFeedbackPage(Model model,
                                 // @RequestParam (value = "size", required = false, defaultValue = "0") Integer size,
                                  @RequestParam (value = "page", required = false, defaultValue = "5") Integer page
    ) {
        //model.addAttribute("feedbacks", feedbackService.findAllFeedBacks());
        model.addAttribute("feedbacks", feedbackService.findAllFeedBacks());
        model.addAttribute("feedbacksPages", feedbackService.findAllFeedBacksPages(page, 5));
        model.addAttribute("numbers", IntStream.range(0, feedbackService.findAllFeedBacksPages(page, 5).getTotalPages()).toArray());
        model.addAttribute("categoriesAll", feedbackService.loadCategories());
        model.addAttribute("newFeedback", new Feedback());
        return "index";
    }

    @PostMapping("/")
    public String createFeedback(@Valid @ModelAttribute("newFeedback") Feedback feedback, BindingResult errors, Model model,
//                                 @RequestParam (value = "size", required = false, defaultValue = "0") Integer size,
                                 @RequestParam (value = "page", required = false, defaultValue = "5") Integer page) {
        feedbackValidator.validate(feedback, errors);
        if (errors.hasErrors()) {
            model.addAttribute("feedbacks", feedbackService.findAllFeedBacks());
            model.addAttribute("feedbacksPages", feedbackService.findAllFeedBacksPages(page, 5).getTotalPages());
            model.addAttribute("numbers", IntStream.range(0, feedbackService.findAllFeedBacksPages(page, 5).getTotalPages()).toArray());
            model.addAttribute("categoriesAll", feedbackService.loadCategories());
            return "index";
        }
        feedbackService.save(feedback);
        return "redirect:/";
    }
}
