package com.spring.clase3.calcular_calorias.controllers;

import com.spring.clase3.calcular_calorias.dtos.CaloriesCalculationDto;
import com.spring.clase3.calcular_calorias.dtos.DishDto;
import com.spring.clase3.calcular_calorias.dtos.ProcessedDish;
import com.spring.clase3.calcular_calorias.services.CaloriesCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CaloriesCalculationController {

    @Autowired
    private CaloriesCalculationService caloriesService;

    @PostMapping("/getCalories")
    public CaloriesCalculationDto getCalories(@RequestBody DishDto dish) {
        return caloriesService.calculateCalories(dish);
    }

    @PostMapping("/getDishes")
    public List<CaloriesCalculationDto> getDishes(@RequestBody ProcessedDish dish) {
        return caloriesService.processFood(dish.getDishes());
    }

}
