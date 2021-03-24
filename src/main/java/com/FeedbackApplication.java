package com;

import com.model.Category;
import com.model.Feedback;
import com.repo.CategoryRepo;
import com.repo.FeedbackRepo;
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

    public Category createCategory(String name, int level, Category parent, CategoryRepo categoryRepo) {
        Category category = new Category();
        category.setName(name);
        category.setLevel(level);
        category.setParent(parent);
        return categoryRepo.save(category);
    }

    @Bean
    CommandLineRunner runner(FeedbackRepo feedbackRepo, CategoryRepo categoryRepo) {
        return args -> {
            Category application = createCategory("Application", 1, null, categoryRepo);
            Category health = createCategory("Health", 2, application, categoryRepo);
            Category patientsPortal = createCategory("Patients portal", 3, health, categoryRepo);
            Category doctorsPortal = createCategory("Doctors portal", 3, health, categoryRepo);
            Category remoteVisitsPortal = createCategory("Remote visits portal", 3, health, categoryRepo);
            Category registration = createCategory("Registration", 4, remoteVisitsPortal, categoryRepo);
            Category virtualVisit = createCategory("Virtual visit", 4, remoteVisitsPortal, categoryRepo);
            Category documentManagement = createCategory("Document management", 2, application, categoryRepo);
            Category openKM = createCategory("OpenKM", 3, documentManagement, categoryRepo);
            Category microsoftSharePoint = createCategory("Microsoft SharePoint", 3, documentManagement, categoryRepo);

            List<Category> categories = Arrays.asList(patientsPortal, microsoftSharePoint);

            feedbackRepo.save(new Feedback(1L, "test@fujitsu.ee", "Otto Lakk", categories, "some text"));

        };
    }

}
