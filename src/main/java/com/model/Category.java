package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private byte level;

    @ManyToOne
    private Category parent;


    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Collection<Category> children;

    public Category( String name, byte level) {
        super();
        this.name = name;
        this.level = level;
    }

    public  Category fillData(String name, byte level, Category parent ) {
        Category category = new Category();
        category.setName(name);
        category.setLevel(level);
        category.setParent(parent);
        return category;

    }


//    void ccc() {
//        var feedback = Feedback.builder()
//                .email("asdasd@asdasd")
//                .name("asdasd")
//                .text("asdasd")
//                .build();
//    }


}
