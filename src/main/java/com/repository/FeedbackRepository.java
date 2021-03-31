package com.repository;

import com.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {

    Page<Feedback> findAll(Pageable pageable);
}
