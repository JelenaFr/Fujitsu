package com.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table
@Builder
@AllArgsConstructor
@ToString
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    private String name;
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cat_feed"
            , joinColumns = @JoinColumn(name = "feedback_id" )
            , inverseJoinColumns = @JoinColumn (name = "category_id" ))
    List<Category> categories = new ArrayList<>();

    private String text;

    public void addCategoriesToFeedback(Category category) {
        if (categories == null) {
            categories = new ArrayList<>();
        }
        categories.add(category);
    }
}


