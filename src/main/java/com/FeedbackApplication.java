package com;

import com.model.Category;
import com.model.Feedback;
import com.repository.CategoryRepository;
import com.repository.FeedbackRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class FeedbackApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FeedbackApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FeedbackApplication.class);
    }

    public Category createCategory(String description, int level, Category parent, CategoryRepository categoryRepository) {
        Category category = new Category();
        category.setDescription(description);
        category.setLevel(level);
        category.setParent(parent);
        return categoryRepository.save(category);
    }

    @Bean
    CommandLineRunner runner(FeedbackRepository feedbackRepository, CategoryRepository categoryRepository) {
        return args -> {
            Category application = createCategory("Application", 1, null, categoryRepository);
            Category health = createCategory("Health", 2, application, categoryRepository);
            Category patientsPortal = createCategory("Patients portal", 3, health, categoryRepository);
            Category doctorsPortal = createCategory("Doctors portal", 3, health, categoryRepository);
            Category remoteVisitsPortal = createCategory("Remote visits portal", 3, health, categoryRepository);
            Category registration = createCategory("Registration", 4, remoteVisitsPortal, categoryRepository);
            Category virtualVisit = createCategory("Virtual visit", 4, remoteVisitsPortal, categoryRepository);
            Category documentManagement = createCategory("Document management", 2, application, categoryRepository);
            Category openKM = createCategory("OpenKM", 3, documentManagement, categoryRepository);
            Category microsoftSharePoint = createCategory("Microsoft SharePoint", 3, documentManagement, categoryRepository);

            List<Category> categories1 = Arrays.asList(patientsPortal, microsoftSharePoint);
            List<Category> categories2 = Arrays.asList(registration, doctorsPortal);

            feedbackRepository.save(new Feedback(1L, "Otto Lakk", "test@fujitsu.ee", categories1, "some text"));
            feedbackRepository.save(new Feedback(2L, "Melania Trump", "trump@gmail.com", categories2, "one more text"));

        };
    }

}
