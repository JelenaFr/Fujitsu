package com.repo;

import com.model.Feedback;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepo extends CrudRepository<Feedback, Long> {
}
