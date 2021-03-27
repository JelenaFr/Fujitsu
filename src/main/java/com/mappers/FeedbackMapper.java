//package com.mappers;
//
//import com.model.Category;
//import com.model.Feedback;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.Collections;
//import java.util.List;
//
//
//public class FeedbackMapper {
//    public FeedbackDto toDTO(Feedback feedback) {
//        return FeedbackDto.builder()
//                .id(feedback.getId())
//                .name(feedback.getName())
//                .email(feedback.getEmail())
////                .categoriesIds(Collections.singletonList(feedback.getId()))
//                .text(feedback.getText())
//
//                .build();
//
//    }
//    public Feedback toEntity (FeedbackDto dto){
//        return new Feedback();
//    }
//
//
//}
