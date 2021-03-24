package com.mappers;

import com.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class CategoryDto {
    private Long id;
    private String name;
    private int level;
    private List<Category> children;

    public boolean hasChildren() {
        return children.isEmpty();
    }


}
