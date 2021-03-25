package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int level;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "category_feedback"
            , joinColumns = @JoinColumn(name = "category_id")
            , inverseJoinColumns = @JoinColumn (name = "feedback_id"))
    List<Feedback> feedbacks = new ArrayList<>();

    @ManyToOne
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private Collection<Category> children;

    public boolean hasChildren() {
        return children.isEmpty();
    }

    public void addCategoryToFeedback(Feedback feedback){
        if(feedbacks==null){
            feedbacks = new ArrayList<>();
        }
        feedbacks.add(feedback);
    }


}
