package com.springmvcv5.springapp.web.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.springmvcv5.springapp.business.SpringappBusinessConfig;
import main.java.com.springmvcv5.springapp.web.SpringappWebConfig;
import main.java.com.springmvcv5.springapp.web.controllers.HelloController;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringappBusinessConfig.class, SpringappWebConfig.class})
@WebAppConfiguration
public class HelloControllerTests {

    @Autowired
    private HelloController controller;

    @Test
    public void testHandleRequestView() {	
        ModelAndView modelAndView = controller.handleRequest();		
        assertEquals("hello.jsp", modelAndView.getViewName());
    }
}
