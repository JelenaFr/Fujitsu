package com.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private int level;

    @ManyToOne
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private Collection<Category> children;

    public boolean hasChildren() {
        return children.isEmpty();
    }


}
