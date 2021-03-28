package com.service;

;
import com.model.Category;
import com.model.Feedback;
import com.repository.CategoryRepository;
import com.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    public String getIndexPage(Model model) {
        model.addAttribute("feedbacks", feedbackRepository.findAll());
        List<Category> sortedCategories = new ArrayList<>();
        categoryRepository.findParentCategories().forEach(category -> treeStructureToList(sortedCategories, category));
        model.addAttribute("categoriesAll", sortedCategories);
        model.addAttribute("newfeedback", new Feedback());

        return "index";
    }

    private List<Category> treeStructureToList(List<Category> sortedCategories, Category parentCategory) {
        sortedCategories.add(parentCategory);
        parentCategory.getChildren().forEach(category -> treeStructureToList(sortedCategories, category));
        return sortedCategories;
    }


    public String save(Feedback feedback) {
        feedbackRepository.save(feedback);
        return "redirect:/";
    }


}


