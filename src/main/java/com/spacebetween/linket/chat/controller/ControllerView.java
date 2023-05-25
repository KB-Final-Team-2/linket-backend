package com.spacebetween.linket.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ControllerView {

    // 채팅방 입장
    @RequestMapping(value = "/chat.do", method = RequestMethod.GET)
    public String viewChat(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "view_chat";
    }
}
