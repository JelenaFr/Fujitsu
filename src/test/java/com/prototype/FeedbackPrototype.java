package com.prototype;

import com.model.Category;
import com.model.Feedback;

import java.util.Arrays;
import java.util.List;

public class FeedbackPrototype {

    public static Category createCategory(String description, int level, Category parent) {
        Category category = new Category();
        category.setDescription(description);
        category.setLevel(level);
        category.setParent(parent);
        return new Category();
    }

    public static Feedback aFeedback() {
        Category application = createCategory("Application", 1, null);
        Category health = createCategory("Health", 2, application);
        Category patientsPortal = createCategory("Patients portal", 3, health);
        Category doctorsPortal = createCategory("Doctors portal", 3, health);
        Category remoteVisitsPortal = createCategory("Remote visits portal", 3, health);
        Category registration = createCategory("Registration", 4, remoteVisitsPortal);
        Category virtualVisit = createCategory("Virtual visit", 4, remoteVisitsPortal);
        Category documentManagement = createCategory("Document management", 2, application);
        Category openKM = createCategory("OpenKM", 3, documentManagement);
        Category microsoftSharePoint = createCategory("Microsoft SharePoint", 3, documentManagement);

        List<Category> categories1 = Arrays.asList(patientsPortal, microsoftSharePoint);
        List<Category> categories2 = Arrays.asList(registration, doctorsPortal);

        return new Feedback(1L, "Otto Lakk", "test@fujitsu.ee", categories1, "some text");
//        return new Feedback(2L, "Melania Trump", "trump@gmail.com", categories2, "one more text");


    }
}
