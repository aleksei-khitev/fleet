package ru.akhitev.rp.fleet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.akhitev.rp.fleet.ship.business_logic.converter.ShipConverter;
import ru.akhitev.rp.fleet.ship.business_logic.vo.ShipVO;
import ru.akhitev.rp.fleet.ship.db.entity.Ship;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories
public class Application extends SpringBootServletInitializer  {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean
                conversionServiceFactoryBean =
                new ConversionServiceFactoryBean();
        Set<Converter> convs = new HashSet<>();
        convs.add(shipConverter());
        conversionServiceFactoryBean.setConverters(convs);
        conversionServiceFactoryBean.afterPropertiesSet();
        return conversionServiceFactoryBean;
    }

    @Bean
    Converter<Ship, ShipVO> shipConverter() {
        return new ShipConverter();
    }
}
