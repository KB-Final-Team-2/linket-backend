package com.spacebetween.linket.chat.controller;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    private Logger logger = LoggerFactory.getLogger(ChatController.class);

    @GetMapping("/chat")
    public String chatGET() {
        logger.info("@ChatController, chat GET()");
        return "chat";
    }
}
