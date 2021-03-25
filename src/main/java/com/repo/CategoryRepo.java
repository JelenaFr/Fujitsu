package com.repo;

import com.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long>  {
//    String g = "SELECT * FROM category LEFT JOIN  feedback_category ON category.id = feedback_category.categories_id LEFT JOIN feedback ON feedback.id = feedback_category.feedback_id WHERE  feedback.id = feedback_category.feedback_id;";

    String querty = "SELECT * FROM category c WHERE c.parent_id is null order by c.name asc";
    @Query(value = querty, nativeQuery = true)
    List<Category> findParentCategories();




//    List<Category> findAllFeedbackCategoriesByUser(){};
//



}


