package com.repo;

import com.model.Category;
import com.model.Feedback;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
String q = "SELECT * \n" +
        "    FROM category \n" +
        "    LEFT JOIN  feedback_categories ON category.id = feedback_categories.categories_id\n" +
        "    LEFT JOIN feedback ON feedback.id = feedback_categories.feedback_id\n" +
        "    WHERE  feedback.id = feedback_categories.feedback_id\n" +
        "\t\n" +
        "\t ";


    @Query(value = q ,  nativeQuery = true)
    List<Category> findAllFeedbackCategories();


}


