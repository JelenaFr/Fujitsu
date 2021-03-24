package com.mappers;

import com.model.Feedback;


public class FeedbackMapper {
    public FeedbackDto toDTO(Feedback feedback) {
        return FeedbackDto.builder()
                .id(feedback.getId())
                .name(feedback.getName())
                .email(feedback.getEmail())
                .categories(feedback.getCategories())
                .text(feedback.getText())

                .build();

    }


}
