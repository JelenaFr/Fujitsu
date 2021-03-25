package com.controller;

import com.model.Category;
import com.model.Feedback;
import com.repo.CategoryRepo;
import com.repo.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GeneralController {
    @Autowired
    private FeedbackRepo feedbackRepo;
    @Autowired
    private CategoryRepo categoryRepo;


    @GetMapping("/")
    public String indexPage(Model model) {

        model.addAttribute("feedbacks", feedbackRepo.findAll());
        List<Category> sortedCategories = new ArrayList<>();
        categoryRepo.findParentCategories().forEach(category -> treeStructureToList(sortedCategories, category));
        model.addAttribute("categories", sortedCategories);
        model.addAttribute("newfeedback", new Feedback());
        return "index";
    }

    private List<Category> treeStructureToList(List<Category> sortedCategories, Category parentCategory) {
        sortedCategories.add(parentCategory);
        parentCategory.getChildren().forEach(category -> treeStructureToList(sortedCategories, category));
        return sortedCategories;
    }


    @PostMapping("/")
    public String createFeedback(@ModelAttribute("newfeedback") Feedback feedback, Category category, Model model) {
        List<Category> listCategoryes = new ArrayList<>();


        //model.addAttribute("method", "post");
        System.out.println(feedback);
//        model.getAttribute("newcategory");
        model.getAttribute("newfeedback");
        categoryRepo.save(category);
        feedbackRepo.save(feedback);
        return "redirect:/";
    }


}
