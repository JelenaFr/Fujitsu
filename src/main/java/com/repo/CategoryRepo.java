package com.repo;

import com.model.Category;
import com.model.Feedback;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Long> {
}
