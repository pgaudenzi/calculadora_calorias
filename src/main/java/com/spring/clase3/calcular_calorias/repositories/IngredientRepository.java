package com.spring.clase3.calcular_calorias.repositories;

import com.spring.clase3.calcular_calorias.dtos.FoodDto;

public interface IngredientRepository {

    FoodDto findCaloriesByFoodName(String name);

}
