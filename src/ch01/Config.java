package ch01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Quest getQuest(){
        return new SlayDragonQuest();
    }

    @Bean
    public Minister getMinister(){
        return new Minister();
    }
    @Bean
    public Knight getKnight(){
        return new BraveKnight(getQuest(), getMinister());
    }
}
