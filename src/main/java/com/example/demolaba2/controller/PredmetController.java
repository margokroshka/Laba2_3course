package com.example.demolaba2.controller;

import com.example.demolaba2.dto.Predmet;
import com.example.demolaba2.dto.Prepod;
import com.example.demolaba2.repository.PredmetRepository;
import com.example.demolaba2.repository.PrepodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/predmet", produces = MediaType.APPLICATION_JSON_VALUE)
public class PredmetController {
    private final PredmetRepository predmetRepository;
    private final PrepodRepository prepodRepository;

    @Autowired
    public PredmetController(PredmetRepository predmetRepository, PrepodRepository prepodRepository) {
        this.predmetRepository = predmetRepository;
        this.prepodRepository = prepodRepository;
    }

    @GetMapping("/prepodDayClassroom")
    public String inputPrepodDayClassroom() {
        return "inputPrepodDayClassroom";
    }


    @PostMapping("/prepodDayClassroom")
    public String showPrepodDayClassroom(@RequestParam("day_of_week") String day_of_week,
                                         @RequestParam("number_class") Integer number_class) {
        List<Predmet> prepodList = prepodRepository.getPrepodDayClassroom(day_of_week, number_class);

        return prepodList.toString();
    }

    //Task2

    @GetMapping("/prepodNotInThisDay")
    public String inputPrepodNotInThisDay() {
        return "inputPrepodNotInThisDay";
    }

    @PostMapping("/prepodNotInThisDay")
    public String showPrepodNotInThisDay(@RequestParam("day_of_week") String day_of_week, Model model) {
        List<Prepod> prepods = prepodRepository.getPrepodNotInThisDay(day_of_week);
        return model.addAttribute("info", prepods).toString();
    }

    //Task3

    @GetMapping("/dayOfWeekInDayClassesAmount")
    public String inputDayOfWeekInDayClassesAmount() {
        return "inputDayOfWeekInDayClassAmount";
    }

    @PostMapping("/dayOfWeekInDayClassesAmount")
    public String showDayOfWeekInDayClassesAmount(@RequestParam("classesAmount") Integer classesAmount, Model model) {
        List<Predmet> predmets = predmetRepository.getDayOfWeekInDayClassesAmount(classesAmount);
        return model.addAttribute("info", predmets).toString();
    }

    //Task4

    @GetMapping("/dayOfWeekInDayClassroomsAmount")
    public String inputDayOfWeekInDayClassroomsAmount() {
        return "inputDayOfWeekInDayClassroomsAmount";
    }

    @PostMapping("/dayOfWeekInDayClassroomsAmount")
    public String showDayOfWeekInDayClassroomsAmount(@RequestParam("classroomsAmount") Integer classroomsAmount, Model model) {
        List<Predmet> predmets = predmetRepository.getDayOfWeekInDayClassroomsAmount(classroomsAmount);
        System.out.println(predmets);
        return model.addAttribute("info", predmets).toString();
    }
}
