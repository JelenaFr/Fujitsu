package com.service;

import com.model.Category;
import com.model.Feedback;
import com.repository.CategoryRepository;
import com.repository.FeedbackRepository;
import org.junit.experimental.categories.Categories;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static com.prototype.FeedbackPrototype.aFeedback;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class FeedbackServiceTest {
    @MockBean
    private CategoryRepository categoryRepository;
    @InjectMocks
    private FeedbackRepository feedbackRepository;
    @InjectMocks
    private FeedbackService feedbackService;


    @Test
    void save() {
        String userName = "Melania";
        String email = "melania@gmail.com";
        String text = "some text";

        List<Category> categories =null;
        Feedback feedback = new Feedback();

        feedback.setUserName(userName);
        feedback.setFeedbackText(text);
        feedback.setEmail(email);
        feedback.setCategories(categories);

        Mockito.when(feedbackRepository.save(feedback)).thenReturn(null);

    }


//    @Test
//    void findAllFeedBacks() {
//        feedbackService.findAllFeedBacks()
//
//        when(feedbackService.findAllFeedBacks()).thenReturn(Collections.singletonList(aFeedback()));
//
//    }
//
//    @Test
//    void loadCategories() {
//    }
}