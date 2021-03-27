package com.mappers;

import com.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class FeedbackDto {
    private Long id;
    private String name;
    private String email;
    private List<Long> categoriesIds;
    private String text;


}
