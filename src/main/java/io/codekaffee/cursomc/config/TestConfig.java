package io.codekaffee.cursomc.config;


import io.codekaffee.cursomc.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public boolean instatiateDB() throws ParseException {
        dbService.instantiateTestDatabase();
        return true;
    }
}
