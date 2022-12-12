package pl.coderslab.dogmeat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dogmeat.user.converter.UserConverter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversionConfig {

    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        return bean;
    }
    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<>();
        converters.add(new UserConverter());

        return converters;
    }
}
