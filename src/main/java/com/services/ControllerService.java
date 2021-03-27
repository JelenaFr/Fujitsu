package com.services;

import com.mappers.FeedbackDto;
import com.model.Category;
import com.model.Feedback;
import com.repo.CategoryRepo;
import com.repo.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ControllerService {

    @Autowired
    private FeedbackRepo feedbackRepo;

    @Autowired
    private CategoryRepo categoryRepo;

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

    public void saveFeedback(FeedbackDto feedbackDto){
    List<Category> categories = new ArrayList<>();
    categoryRepo.findAllById(feedbackDto.getCategoriesIds()).forEach(categories::add);

        Feedback feedback = Feedback.builder()
                .name(feedbackDto.getName())
                .categories(categories)
                .build();
        feedbackRepo.save(feedback);
    }



}
