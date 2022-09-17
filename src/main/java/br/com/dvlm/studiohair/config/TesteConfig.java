package br.com.dvlm.studiohair.config;

import br.com.dvlm.studiohair.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("teste")
public class TesteConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public void InstanciaDB() throws ParseException {
        this.dbService.instanciaDB();
    }
}
