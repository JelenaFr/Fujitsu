package com.controller;


import com.model.Category;
import com.model.Feedback;
import com.repo.CategoryRepo;
import com.repo.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GeneralController {


    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    FeedbackRepo feedbackRepo;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("feedbacks", feedbackRepo.findAll());
        List<Category> sortedCategories = new ArrayList<>();
        categoryRepo.findParentCategories().forEach(category -> treeStructureToList(sortedCategories, category));
        model.addAttribute("categoriesAll", sortedCategories);
        model.addAttribute("newfeedback", new Feedback());

        return "index";
    }


    private List<Category> treeStructureToList(List<Category> sortedCategories, Category parentCategory) {
        sortedCategories.add(parentCategory);
        parentCategory.getChildren().forEach(category -> treeStructureToList(sortedCategories, category));
        return sortedCategories;
    }


    @PostMapping("/")
    public String createFeedback(Feedback feedback) {
        feedbackRepo.save(feedback);
        //System.out.println(feedback);
        return "redirect:/";
    }
}




//      @PostMapping("/")
//    public String createFeedback( @RequestParam Category category, @RequestParam String name, @RequestParam String email, @RequestParam String text) {
//
//
//
//        Feedback newFeedback = new Feedback();
//        newFeedback.setName(name);
//        newFeedback.setEmail(email);
//        newFeedback.setText(text);
//        newFeedback.setCategories(Arrays.asList(category));
//
//        feedbackRepo.save(newFeedback);
//        System.out.println(newFeedback);
////        model.addAttribute("newfeedback", newFeedback);
////        model.addAttribute("categories", categoryRepo.findAll());
//        return "redirect:/";
//    }