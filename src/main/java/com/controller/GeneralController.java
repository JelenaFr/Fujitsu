package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GeneralController {


    @RequestMapping("/")
    public String indexPage() {

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
