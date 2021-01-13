package com.springmvcv5.springapp;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.springmvcv5.springapp.business.SpringappBusinessConfig;
import com.springmvcv5.springapp.web.SpringappWebConfig;

public class SpringappWebApplicationInitilizer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { SpringappBusinessConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { SpringappWebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
}
