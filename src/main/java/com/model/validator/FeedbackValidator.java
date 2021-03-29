package com.model.validator;

import com.model.Feedback;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class FeedbackValidator implements Validator {




    @Override
    public boolean supports(Class<?> aClass) {
        return Feedback.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Feedback feedback = (Feedback) o;
        if (feedback.getCategories().isEmpty())
        {
           errors.rejectValue("categories",  "Required");
        }



    }


}
