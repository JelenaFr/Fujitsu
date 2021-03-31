package com.prototype;

import com.model.Category;
import com.model.Feedback;

public class CategoryPrototype {
    public static Category createCategory(String description, int level, Category parent) {
        Category category = new Category();
        category.setDescription(description);
        category.setLevel(level);
        category.setParent(parent);
        return new Category();
    }

    Category someCategory = createCategory("Application", 1, null);
}