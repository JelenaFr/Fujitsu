package com.mappers;

import com.model.Category;
import com.model.Feedback;
import org.mapstruct.factory.Mappers;


public class FeedbackMapper {
    public FeedbackDto toDTO(Feedback feedback) {
        return FeedbackDto.builder()
                .id(feedback.getId())
                .name(feedback.getName())
                .categories(feedback.getCategories())
                .text(feedback.getText())

                .build();

    }





}
