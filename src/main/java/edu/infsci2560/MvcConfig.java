package edu.infsci2560;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/main").setViewName("main");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/recipes").setViewName("recipes");
        registry.addViewController("/recipes").setViewName("ratings");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/signup").setViewName("signup");
        registry.addViewController("/users").setViewName("users");
        registry.addViewController("/details").setViewName("details");
        registry.addViewController("/publish").setViewName("publish");
        registry.addViewController("/best").setViewName("best");

        
    }

}