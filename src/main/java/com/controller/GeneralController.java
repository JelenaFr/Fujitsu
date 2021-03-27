package com.controller;

//import com.mappers.FeedbackDto;
import com.mappers.FeedbackDto;
import com.model.Category;
import com.model.Feedback;
import com.repo.CategoryRepo;
import com.repo.FeedbackRepo;

import com.services.ControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class GeneralController {

    @Autowired
    ControllerService controllerService;

    @GetMapping("/")
    public String indexPage(Model model) {

        controllerService.indexPage(model);

        return "index";
    }




    @PostMapping("/")
    public String createFeedback(Feedback feedback) {
        feedback.getCategories();
        controllerService.saveFeedback(FeedbackDto.builder().build());
        return "redirect:/";
    }
//@PostMapping("/")
//    public String createFeedback(Feedback feedback) {
//        controllerService.saveFeedback(FeedbackDto.builder().build());
//        return "redirect:/";
//    }



}
