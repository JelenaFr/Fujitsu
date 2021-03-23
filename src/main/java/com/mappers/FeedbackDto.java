package com.mappers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor
public class FeedbackDto {
    private Long userid;
    private String username;
    private String useremail;
    List<CategoryDto> usercategories;
    private String usertext;

    private FeedbackDto() {
    }

    public static FeedbackDtoBuilder builder() {
        return new FeedbackDto().new FeedbackDtoBuilder();
    }


    public class FeedbackDtoBuilder {
        private FeedbackDtoBuilder() {
        }

        public FeedbackDtoBuilder setUserId(Long userid) {
            FeedbackDto.this.userid = userid;
            return this;
        }

        public FeedbackDtoBuilder setUsername(String username) {
            FeedbackDto.this.username = username;
            return this;
        }



        public FeedbackDtoBuilder setUseremail(String useremail) {
            FeedbackDto.this.useremail = useremail;
            return this;
        }

        public FeedbackDtoBuilder setUsercategories(List<CategoryDto> usercategories) {
            FeedbackDto.this.usercategories = usercategories;
            return this;
        }

        public FeedbackDtoBuilder setUsertext(String usertext) {
            FeedbackDto.this.usertext = usertext;
            return this;
        }
        public FeedbackDto build() {
            return FeedbackDto.this;
        }
    }


}
