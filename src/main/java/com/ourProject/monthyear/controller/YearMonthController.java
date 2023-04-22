package com.ourProject.monthyear.controller;

import com.ourProject.monthyear.model.YearMonth;
import com.ourProject.monthyear.repo.YearMonthRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class YearMonthController {

    private final YearMonthRepo yearMonthRepo;

    public YearMonthController(YearMonthRepo yearMonthRepo) {
        this.yearMonthRepo = yearMonthRepo;
    }

    @GetMapping("/")
    private String home(ModelMap modelMap) {
        List<YearMonth> all = yearMonthRepo.findAll();
        modelMap.addAttribute("monthYears", all);
        return "index";
    }

    @PostMapping("/save")
    private String save(@ModelAttribute YearMonth yearMonth){
        System.out.println(yearMonth.getYear());
        System.out.println(yearMonth.getNameOfMonth());
        switch (yearMonth.getNameOfMonth()){
            case "January" -> {
                yearMonth.setNameOfMonth("January");
                yearMonth.setDays(31);
            }
            case "February" -> {
                yearMonth.setNameOfMonth("February");
                if ((yearMonth.getYear() % 400 == 0) || ((yearMonth.getYear() % 4 == 0) && (yearMonth.getYear() % 100 != 0))){
                    yearMonth.setDays(29);
                }else {
                    yearMonth.setDays(28);
                }
            }
            case "March" -> {
                yearMonth.setNameOfMonth("March");
                yearMonth.setDays(31);
            }

            case "April" -> {
                yearMonth.setNameOfMonth("April");
                yearMonth.setDays(30);
            }

            case "May" -> {
                yearMonth.setNameOfMonth("May");
                yearMonth.setDays(31);
            }

            case "June" -> {
                yearMonth.setNameOfMonth("June");
                yearMonth.setDays(30);
            }

            case "July" -> {
                yearMonth.setNameOfMonth("July");
                yearMonth.setDays(31);
            }

            case "August" -> {
                yearMonth.setNameOfMonth("August");
                yearMonth.setDays(31);
            }

            case "September" -> {
                yearMonth.setNameOfMonth("September");
                yearMonth.setDays(30);
            }

            case "October" -> {
                yearMonth.setNameOfMonth("October");
                yearMonth.setDays(31);
            }

            case "November" -> {
                yearMonth.setNameOfMonth("November");
                yearMonth.setDays(30);

            }

            case "December" -> {
                yearMonth.setNameOfMonth("December");
                yearMonth.setDays(31);
            }
        }

        yearMonthRepo.save(yearMonth);
        return "redirect:/";
    }
}
