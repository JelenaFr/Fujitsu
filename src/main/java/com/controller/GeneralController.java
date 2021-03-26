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
import java.util.Arrays;
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
        List<Category> getsCategories = new ArrayList<>();
        categoryRepo.findParentCategories().forEach(category -> treeStructureToList(sortedCategories, category));
        model.addAttribute("categories", sortedCategories);
        model.addAttribute("newfeedback", new Feedback());
//        model.addAttribute("newcategory", categoryfrom);


        return "index";
    }

    private List<Category> treeStructureToList(List<Category> sortedCategories, Category parentCategory) {
        sortedCategories.add(parentCategory);
        parentCategory.getChildren().forEach(category -> treeStructureToList(sortedCategories, category));
        return sortedCategories;
    }



    public List<Category> findCategoryById(Category category) {
        categoryRepo.findByIdMy(category.getId());
        List<Category> findCategorylist = Arrays.asList();
        findCategorylist.add((Category) categoryRepo.findByIdMy(category.getId()));
        return findCategorylist;
    }

//        categoryRepo.save(category);
//        feedbackRepo.save(feedback);
//        return "redirect:/";
//    }

    @PostMapping("/")
    public String createFeedback(Feedback feedback,  Category category, Model model) {
        findCategoryById(category);

        model.addAttribute("newfeedback", new Feedback());
        model.addAttribute("newcategory", feedback.setCategories(););




        System.out.println(feedback);
        feedbackRepo.save(feedback);
        return "redirect:/";
    }

//        @PostMapping("/")
//        public String createFeedback (Feedback feedback, Category category, Model model){
//            model.addAttribute("newfeedback", new Feedback());
//            List<Category> listCategoryes = new ArrayList<>();
//            model.addAttribute("listcategories", listCategoryes);
//            feedback.setCategories(listCategoryes);
//
//            System.out.println(feedback);
//            feedbackRepo.save(feedback);
//            return "redirect:/";
//        }



//@PostMapping("/")
//    public String createFeedback( Feedback feedback, Category category, Model model) {
//        model.addAttribute("newfeedback", new Feedback());
//        List<Category> listCategoryes = new ArrayList<>();
//        model.addAttribute("newcatlist", listCategoryes);
//        System.out.println(feedback);
//        feedbackRepo.save(feedback);
//        return "redirect:/";
//    }


    }
