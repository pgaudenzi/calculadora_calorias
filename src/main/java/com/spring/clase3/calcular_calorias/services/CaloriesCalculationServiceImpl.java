package com.spring.clase3.calcular_calorias.services;

import com.spring.clase3.calcular_calorias.dtos.CaloriesCalculationDto;
import com.spring.clase3.calcular_calorias.dtos.DishDto;
import com.spring.clase3.calcular_calorias.dtos.FoodDto;
import com.spring.clase3.calcular_calorias.dtos.IngredientDto;
import com.spring.clase3.calcular_calorias.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaloriesCalculationServiceImpl implements CaloriesCalculationService {

    @Autowired
    private IngredientRepository repository;

    @Override
    public CaloriesCalculationDto calculateCalories(DishDto dish) {
        CaloriesCalculationDto calculation = new CaloriesCalculationDto();
        List<FoodDto> foodList = this.getIngredients(dish);

        calculation.setTotalCalories(this.calculateTotalCalories(dish));
        calculation.setIngredientsCalories(foodList);
        calculation.setHigherCalories(this.getHigherCaloriesIngredient(foodList));

        return calculation;
    }

    @Override
    public List<CaloriesCalculationDto> processFood(List<DishDto> dishes) {
        List<CaloriesCalculationDto> processedDishes = new ArrayList<>();
        for (DishDto dish : dishes) {
            processedDishes.add(calculateCalories(dish));
        }
        return processedDishes;
    }

    private int calculateTotalCalories(DishDto dish) {
        int totalCalories = 0;
        FoodDto food = null;
        for (IngredientDto ingredient : dish.getIngredients()) {
            food = repository.findCaloriesByFoodName(ingredient.getName());
            totalCalories += food.getCalories() * ingredient.getGrams();
        }
        return totalCalories;
    }

    private List<FoodDto> getIngredients(DishDto dish) {
        List<FoodDto> ingredients = new ArrayList<>();
        FoodDto food = null;
        for (IngredientDto ingredient : dish.getIngredients()) {
            food = repository.findCaloriesByFoodName(ingredient.getName());
            food.setCalories(food.getCalories() * ingredient.getGrams());
            ingredients.add(food);
        }
        return ingredients;
    }

    private FoodDto getHigherCaloriesIngredient(List<FoodDto> foodDtos) {
        int max = 0;
        FoodDto ingredient = null;
        for (FoodDto food : foodDtos) {
            if (food.getCalories() > max) {
                max = food.getCalories();
                ingredient = food;
            }
        }
        return ingredient;
    }

}
