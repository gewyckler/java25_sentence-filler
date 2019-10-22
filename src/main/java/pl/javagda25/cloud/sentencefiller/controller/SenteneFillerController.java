package pl.javagda25.cloud.sentencefiller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.javagda25.cloud.sentencefiller.api.Randomizer;

@RestController
public class SenteneFillerController {

    @Autowired
    private Randomizer randomizer;

    @GetMapping("/fill")
    public String fill(@RequestParam(name = "sentence", required = false) String sentence) {
        if (sentence != null) {
            //ToDo: zastąp wszystekie $$$ slowem j25
            //ToDo: zastąp wszystkie ### liczba 2

            while (sentence.contains("!!!")) {
                sentence = sentence.replaceFirst("!!!", getRandomNumber());
            }
            while (sentence.contains("@@@")) {
                sentence = sentence.replaceFirst("@@@", getRandomWord());
            }
            return sentence;
        }
        return "Proszę podać zdanie do wypełnienia.";
    }

    private String getRandomWord() {
        return randomizer.randomWord();
    }

    private String getRandomNumber() {
        return randomizer.randomNumber();
    }
}
