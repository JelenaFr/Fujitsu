package com.service;

;
import com.model.Category;
import com.model.Feedback;
import com.repository.CategoryRepository;
import com.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    public void getIndexPage(Model model) {
        model.addAttribute("feedbacks", feedbackRepository.findAll());
        List<Category> sortedCategories = new ArrayList<>();
        categoryRepository.findParentCategories().forEach(category -> treeStructureToList(sortedCategories, category));
        model.addAttribute("categoriesAll", sortedCategories);
        model.addAttribute("newfeedback", new Feedback());


    }

    private List<Category> treeStructureToList(List<Category> sortedCategories, Category parentCategory) {
        sortedCategories.add(parentCategory);
        parentCategory.getChildren().forEach(category -> treeStructureToList(sortedCategories, category));
        return sortedCategories;
    }


    public String save(@Valid @ModelAttribute("newfeedback") Feedback newfeedback, BindingResult errors) {
        if (errors.hasErrors()){
            return "index";
        }
        feedbackRepository.save(newfeedback);
        return "redirect:/";
    }


}


