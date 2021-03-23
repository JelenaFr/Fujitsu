package com.mappers;

import com.model.Category;
import com.model.Feedback;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public class CategoryMapper {
//    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
//    @Mapping(source = "category.id", target = "categoryid")
//    @Mapping(source = "category.name", target = "categoryname")
//    @Mapping(source = "category.level", target = "categorylevel")
//
//    CategoryDto toDto(Feedback feedback);

    public CategoryDto toDto (Category category){
        return CategoryDto.builder()
                .name(category.getName())
                .level(category.getLevel())
                .parent (category.getParent())
                .build();
    }
}
