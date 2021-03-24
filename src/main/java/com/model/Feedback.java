package com.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table
@Builder
@AllArgsConstructor
@ToString
public class Feedback  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    private String name;
    private String email;

    @OneToMany
    List<Category> categories = new ArrayList<>();

    private String text;
}


