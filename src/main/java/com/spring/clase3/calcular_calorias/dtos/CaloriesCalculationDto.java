package com.spring.clase3.calcular_calorias.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class CaloriesCalculationDto {

    private int totalCalories;
    private List<FoodDto> ingredientsCalories;
    private FoodDto higherCalories;

}
