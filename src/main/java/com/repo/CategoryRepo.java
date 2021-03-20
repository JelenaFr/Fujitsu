package com.repo;

import com.model.Category;
import com.model.Feedback;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
String q = "SELECT category.name \n" +
        "    FROM category \n" +
        "    INNER JOIN  feedback_categories ON category.id = feedback_categories.categories_id\n" +
        "    INNER JOIN feedback ON feedback.id = feedback_categories.feedback_id\n" +
        "    WHERE  feedback.id = feedback_categories.feedback_id\n" +
        "\t\n" +
        "\t ";
    @Query(value = q ,  nativeQuery = true)

    Collection<Category> findAllFeedbackCategories();
}


