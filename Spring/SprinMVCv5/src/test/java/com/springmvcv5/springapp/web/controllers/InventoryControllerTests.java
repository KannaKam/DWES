package com.springmvcv5.springapp.web.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcv5.springapp.business.SpringappBusinessConfig;
import com.springmvcv5.springapp.web.SpringappWebConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringappBusinessConfig.class, SpringappWebConfig.class})
@WebAppConfiguration
public class InventoryControllerTests {

	 @Autowired
	    private InventoryController controller;

	    @Test
	    public void testHandleRequestView() {	
	        ModelAndView modelAndView = controller.handleRequest();		
	        assertEquals("hello", modelAndView.getViewName());
	        assertNotNull(modelAndView.getModel());
	        @SuppressWarnings("unchecked")
	        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
	        String nowValue = (String) modelMap.get("now");
	        assertNotNull(nowValue);
	    }
}
