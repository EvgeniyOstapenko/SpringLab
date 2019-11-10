package com.epam.labSpringProject.config;

import com.epam.labSpringProject.controller.UserController;
import com.epam.labSpringProject.repository.UserRepository;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebApplicationConfig implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("com.epam.labSpringProject");
        servletContext.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic appServlet = servletContext
                .addServlet("mvc", new DispatcherServlet(context));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");

        context.refresh();
        UserController userController = context.getBean(UserController.class);
        System.out.println(userController.findById(1L));

    }
}
