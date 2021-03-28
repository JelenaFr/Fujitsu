package com.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @Size(min = 2, max = 25, message = "The category name must be {min} to {max} characters in length.")
    private String name;

    @Email(message = "{fooCommand.textField.email.message}")
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "category_feedback"
            , joinColumns = @JoinColumn(name = "feedback_id")
            , inverseJoinColumns = @JoinColumn(name = "category_id"))
    List<Category> categories = new ArrayList<>();

    @NotBlank (message = "Field can't be blank!")
    private String text;


}


