package pl.sda.exercises;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class exConfiguration  {

    @Bean("msv1")
    public LanguageResolver languageResolver() {
        return new LanguageResolver();
    }


    @Bean("ENG")
    @Primary
    public myserv msv1() {
        return new myserv() {
            @Override
            public String wyp() {
                return "hello";
            }
        };
    }

    @Bean("PL")
    public myserv msv2() {
        return new myserv() {
            @Override
            public String wyp() {
                return "CZEŚĆ";
            }
        };
    }


}
