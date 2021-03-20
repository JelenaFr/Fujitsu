package com.controller;

import com.repo.CategoryRepo;
import com.repo.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GeneralController {
    @Autowired
    private FeedbackRepo feedbackRepo;
    @Autowired
    CategoryRepo categoryRepo;

    @RequestMapping("/" )
    public String indexPage(Model model) {
        model.addAttribute("feedbacks", feedbackRepo.findAll() );
        model.addAttribute("categories", categoryRepo.findAllFeedbackCategories());
        return "index";
    }


//    @Autowired
//    private MessageRepo messageRepo;
//
//    @GetMapping
//    public String findAllFeedbacks (Map<String, Object> model) {
//        Iterable<Message>messages = messageRepo.findAll();
//        model.put("messages", messages);
//        return "index";
//    }
//
//
//    @PostMapping
//    public String addFeedback (@RequestParam String name, @RequestParam String email, @RequestParam String text, Map<String, Object> model){
//        Message message = new Message(name, email, text);
//        messageRepo.save(message);
//        Iterable<Message>messages = messageRepo.findAll();
//        model.put("messages", messages);
//        return "index";
//    }

}
