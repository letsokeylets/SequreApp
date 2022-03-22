package netology.ru.sequreapp.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import netology.ru.sequreapp.repository.HibernateRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Data
@AllArgsConstructor
public class HibernateController {

    private final HibernateRepository hibernateRepository;

    @GetMapping("/persons/by-city")
    public String getPersonsOfCity(@RequestParam("city") String city) {
        return hibernateRepository.findByCityOfLiving(city).toString();
    }

    @GetMapping("/persons/by-age")
    public String getPersonsOfAge(@RequestParam("age") int age) {
        return hibernateRepository.findByInfoPersonAge(age).toString();
    }

    @GetMapping("/persons/by-name-surname")
    public String getPersonsOfAge(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return hibernateRepository.findByInfoPersonNameAndInfoPersonSurname(name, surname).toString();
    }
}
