package com.epam.labSpringProject.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.epam.labSpringProject")
@EnableAspectJAutoProxy
public class ApplicationConfig {
}
