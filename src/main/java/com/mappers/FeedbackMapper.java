package com.mappers;

import com.model.Category;
import com.model.Feedback;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper (uses = {CategoryMapper.class})
public interface FeedbackMapper {
    FeedbackMapper INSTANCE = Mappers.getMapper(FeedbackMapper.class);
    @Mapping(source = "feedback.id", target = "userid")
    @Mapping(source = "feedback.name", target = "username")
    @Mapping(source = "feedback.email", target = "useremail")
    @Mapping(source = "feedback.categories", target = "usercategories")
    @Mapping(source = "feedback.text", target = "useremail")

    FeedbackDto toDTO(Feedback feedback);
}
