package com.Controller;

import com.Model.Message;
import com.Repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Map;
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
