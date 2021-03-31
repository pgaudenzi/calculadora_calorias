package com.spring.clase3.calcular_calorias.services;

import com.spring.clase3.calcular_calorias.dtos.CaloriesCalculationDto;
import com.spring.clase3.calcular_calorias.dtos.DishDto;

import java.util.List;

public interface CaloriesCalculationService {

    CaloriesCalculationDto calculateCalories(DishDto dish);

    List<CaloriesCalculationDto> processFood(List<DishDto> dishes);

}
