package com.service;

import com.model.Category;
import com.model.Feedback;

import com.repository.CategoryRepository;
import com.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    private List<Category> treeStructureToList(List<Category> sortedCategories, Category parentCategory) {
        sortedCategories.add(parentCategory);
        parentCategory.getChildren().forEach(category -> treeStructureToList(sortedCategories, category));
        return sortedCategories;
    }
    public void save(Feedback feedback) {
        feedbackRepository.save(feedback);

    }
    public Iterable<Feedback> findAllFeedBacks() {
        return feedbackRepository.findAll();
    }

    public List<Category> loadCategories() {
        List<Category> sortedCategories = new ArrayList<>();
        categoryRepository.findParentCategories().forEach(category -> treeStructureToList(sortedCategories, category));
        return sortedCategories;
    }
}


