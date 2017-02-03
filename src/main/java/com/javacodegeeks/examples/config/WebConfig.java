package com.javacodegeeks.examples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@EnableWebMvc
@Configuration
@ComponentScan("com.javacodegeeks.examples")
public class WebConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/static/js/**")
                .addResourceLocations("/resources/static/js/");
        registry.addResourceHandler("/resources/static/css/**")
                .addResourceLocations("/resources/static/css/");
        registry.addResourceHandler("/resources/static/views/**")
                .addResourceLocations("/resources/static/views/");
        registry.addResourceHandler("/resources/static/**")
                .addResourceLocations("/resources/static/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/");
    }

    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/html/");
        resolver.setSuffix(".html");
        //MappingJackson2JsonView defaultView = new MappingJackson2JsonView();
	//defaultView.setExtractValueFromSingleKeyModel(true);
     //resolver.setViewClass(MappingJackson2JsonView.class);
        
        return resolver;
    }

 
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
