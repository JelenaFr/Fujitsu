package com.mappers;

import com.model.Feedback;
import org.mapstruct.Builder;
import org.mapstruct.factory.Mappers;


public class FeedbackMapperImpl implements FeedbackMapper {
    private final CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    @Override
    public FeedbackDto toDTO(Feedback feedback) {
        if(feedback == null) {
            return null;
        }
        FeedbackDto.FeedbackDtoBuilder feedbackDto = FeedbackDto.builder();
        feedbackDto.

    }


}
