package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;


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
    private byte level;

    @ManyToOne
    private Category parent;
    @OneToMany(mappedBy = "parent")
    private Collection<Category> children;

    public Category( String name, byte level) {
        super();
        this.name = name;
        this.level = level;
    }


//    void ccc() {
//        var feedback = Feedback.builder()
//                .email("asdasd@asdasd")
//                .name("asdasd")
//                .text("asdasd")
//                .build();
//    }


}
