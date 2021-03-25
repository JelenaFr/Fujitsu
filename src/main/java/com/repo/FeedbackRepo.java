package com.repo;

import com.model.Category;
import com.model.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo extends CrudRepository<Feedback, Long> {

}
