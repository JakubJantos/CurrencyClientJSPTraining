package pl.sda.exercises;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class LanguageControler {

    private String lang;

    public LanguageControler(@Value("${app.languages}") String lang) {
        this.lang = lang;
    }

    @GetMapping("/lang")
    private String showLanguages() {
        String[] langList = lang.split(",");

        return Stream.of(langList)
                .map(l -> "- " + l)
                .collect(Collectors.joining("<br/>"));

//        return langList;
    }
}
