package com.repo;

import com.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long>  {

    String categoryOrder = "SELECT * FROM category c WHERE c.parent_id is null order by c.name asc";
    @Query(value = categoryOrder, nativeQuery = true)
    List<Category> findParentCategories();


}


