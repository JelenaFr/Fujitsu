package com.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
@AllArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Size(min = 3, max = 25, message = "The name must be {min} to {max} characters in length.")
    private String userName;

    @Email
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email address is invalid")
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "category_feedback"
            , joinColumns = @JoinColumn(name = "feedback_id")
            , inverseJoinColumns = @JoinColumn(name = "category_id"))
    //@NotEmpty
    List<Category> categories = new ArrayList<>();

    @NotBlank(message = "Text can not be blank!")
    private String feedbackText;


}


