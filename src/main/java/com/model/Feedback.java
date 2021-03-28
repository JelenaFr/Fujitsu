package com.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table
@AllArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Size(min = 3, max = 25, message = "The name must be {min} to {max} characters in length.")
    private String name;

    @Email
    @NotBlank(message = "Email can't be blank!")
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "category_feedback"
            , joinColumns = @JoinColumn(name = "feedback_id")
            , inverseJoinColumns = @JoinColumn(name = "category_id"))

    List<Category> categories = new ArrayList<>();

    @NotBlank(message = "Text can't be blank!")
    private String text;


}


