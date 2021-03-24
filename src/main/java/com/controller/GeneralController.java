package com.controller;

import com.mappers.FeedbackDto;
import com.model.Category;
import com.model.Feedback;
import com.repo.CategoryRepo;
import com.repo.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class GeneralController {
    @Autowired
    private FeedbackRepo feedbackRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    private FeedbackDto feedbackDto;




    @RequestMapping("/")
    public String indexPage(Model model) {
        System.out.println("AUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
        model.addAttribute("feedbacks", feedbackRepo.findAll());
        model.addAttribute("usercategories", categoryRepo.findAllFeedbackCategories());
        //List<Category> usercategories = categoryRepo.findAllFeedbackCategories();


        List<Category> sortedCategories = new ArrayList<>();
        categoryRepo.findParentCategories().forEach(category -> treeStructureToList(sortedCategories, category));
        model.addAttribute("categories", sortedCategories);
        return "index";
    }
    private List<Category> treeStructureToList(List<Category> sortedCategories, Category parentCategory) {
        sortedCategories.add(parentCategory);
        parentCategory.getChildren().forEach(category -> treeStructureToList(sortedCategories, category));
        return sortedCategories;
    }

//    @RequestMapping("/" )
//    public String indexPage(Model model, Category category) {
//        model.addAttribute("feedbacks", feedbackRepo.findAll() );
//        List<Category> l = categoryRepo.findAllFeedbackCategories();
//        model.addAttribute("categories", l );
//        return "index";
//    }


//    @PostMapping
//    public String createFeedback(@RequestBody Feedback feedback, @RequestBody Category category, Model model) {
//        model.getAttribute("newcategory");
//        model.getAttribute("newfeedback");
//        categoryRepo.save(category);
//        feedbackRepo.save(feedback);
//        return "redirect:/";
//    }
//
//    @GetMapping ("/")
//    public  String categorySelector (Model model){
//        model. addAttribute("categories", categoryRepo.findAll());
//        return "index";
//    }
//
//
//    @GetMapping("/")
//    public String addFeedback(@RequestParam String name, @RequestParam String email, @RequestParam String text, Map<String, Object> model) {
//        Iterable<Category> l = categoryRepo.findAll();
//        Feedback feedback = new Feedback();
//        feedbackRepo.save(feedback);
//        Iterable<Feedback> messages = feedbackRepo.findAll();
//        model.put("messages", messages);
//        return "index";
//    }

}
