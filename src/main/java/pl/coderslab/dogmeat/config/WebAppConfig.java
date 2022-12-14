package pl.coderslab.dogmeat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("admin/login");
        registry.addViewController("/logout").setViewName("admin/logout");
        registry.addViewController("/403").setViewName("errors/403");
        registry.addViewController("/404").setViewName("errors/404");
    }





}
