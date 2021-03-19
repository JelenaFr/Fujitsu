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

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class FeedbackApplication extends SpringBootServletInitializer {

//extends SpringBootServletInitializer


    public static void main(String[] args) {
        SpringApplication.run(FeedbackApplication.class, args);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FeedbackApplication.class);
    }

    @Bean
    CommandLineRunner runner(FeedbackRepo repositoryFeed, CategoryRepo repositoryCateg) {
        return args -> {
            List<Category> categories = new ArrayList<>();
            Category category1 = new Category();
            Category category2 = new Category();
            Category category3 = new Category();
            Category category4 = new Category();
            Category category5 = new Category();
            Category category6 = new Category();
            Category category7 = new Category();
            Category category8 = new Category();
            Category category9 = new Category();
            Category category10 = new Category();

            category1.setId(1L);
            category1.setName("Application");
            category1.setLevel((byte) 1);
            category1.setParent(null);


            category2.setId(2L);
            category2.setName("Health");
            category2.setLevel((byte) 2);
            category2.setParent(category1);


            category3.setId(3L);
            category3.setName("Patients portal");
            category3.setLevel((byte) 3);
            category3.setParent(category2);
            categories.add(category3);

            category4.setId(4L);
            category4.setName("Doctors portal");
            category4.setLevel((byte) 3);
            category4.setParent(category2);


            category5.setId(5L);
            category5.setName("Remote visits portal");
            category5.setLevel((byte) 3);
            category5.setParent(category2);


            category6.setId(6L);
            category6.setName("Registration");
            category6.setLevel((byte) 4);
            category6.setParent(category5);


            category7.setId(7L);
            category7.setName("Virtual visit");
            category7.setLevel((byte) 4);
            category7.setParent(category5);


            category8.setId(8L);
            category8.setName("Document management");
            category8.setLevel((byte) 2);
            category8.setParent(category1);

            category9.setId(9L);
            category9.setName("OpenKM");
            category9.setLevel((byte) 3);
            category9.setParent(category8);

            category10.setId(10L);
            category10.setName("Microsoft SharePoint");
            category10.setLevel((byte) 3);
            category10.setParent(category8);
            categories.add(category10);

            repositoryCateg.save(category1);
            repositoryCateg.save(category2);
            repositoryCateg.save(category3);
            repositoryCateg.save(category4);
            repositoryCateg.save(category5);
            repositoryCateg.save(category6);
            repositoryCateg.save(category7);
            repositoryCateg.save(category8);
            repositoryCateg.save(category9);
            repositoryCateg.save(category10);

            repositoryFeed.save(new Feedback(1L, "test@fujitsu.ee", "Otto Lakk", categories, "some text"));

        };
    }

}
