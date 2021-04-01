package com.service;

import com.model.Category;
import com.model.Feedback;
import com.repository.CategoryRepository;
import com.repository.FeedbackRepository;
import lombok.val;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class FeedbackServiceTest {

    @InjectMocks
    private FeedbackService feedbackService;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private FeedbackRepository feedbackRepository;

    @Test
    void save() {
        Feedback feedback = new Feedback();
        feedbackService.save(feedback);
        Mockito.verify(feedbackRepository).save(feedback);

    }

    @Test
    void findAllFeedBacks() {
        feedbackService.findAllFeedBacks();
        Mockito.verify(feedbackRepository).findAll();

    }

    @Test
    void loadCategories() {
        List<Category> categories = Arrays.asList(Category.builder()
                .children(Arrays.asList(new Category()))
                .build());
        Mockito.when(categoryRepository.findParentCategories()).thenReturn(categories);
        val result = feedbackService.loadCategories();
        Mockito.verify(categoryRepository).findParentCategories();

        Assertions.assertThat(result).hasSize(2);


    }
}