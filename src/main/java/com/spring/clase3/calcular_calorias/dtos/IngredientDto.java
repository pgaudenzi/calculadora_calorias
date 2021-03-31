package com.spring.clase3.calcular_calorias.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredientDto {

    private String name;
    private int grams;

}
