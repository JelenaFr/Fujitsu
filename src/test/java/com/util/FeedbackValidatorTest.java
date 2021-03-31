//package com.util;
//
//import com.model.Category;
//import com.model.Feedback;
//import com.service.FeedbackService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
//import org.springframework.validation.Errors;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = TestConfiguration.class, loader = AnnotationConfigContextLoader.class)
//class FeedbackValidatorTest {
//
//    @Bean
//    public FeedbackValidator feedbackValidator() {
//        return new FeedbackValidator();
//
//    }
//    @Bean
//    public FeedbackService feedbackService() {
//        return mock(FeedbackService.class);
//    }
//
//
//    @Test
//    boolean supports(Class<?> clazz) {
//        return Feedback.class.equals(clazz);
//
//    }
//
//    public static final List<Category> categories = Arrays.asList("first", "second");
//
//    @Test
//    void validate(Object target, Errors errors) {
//        Category category = createMock()
//        Feedback feedback = (Feedback) target;
//        if (feedbackService.)
//    }
//}