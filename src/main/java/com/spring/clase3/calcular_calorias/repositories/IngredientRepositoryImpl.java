package com.spring.clase3.calcular_calorias.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.clase3.calcular_calorias.dtos.FoodDto;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {

    @Override
    public FoodDto findCaloriesByFoodName(String name) {
        List<FoodDto> ingredients = loadDatabase();
        FoodDto result = null;
        if (ingredients != null) {
            Optional<FoodDto> item = ingredients.stream()
                    .filter(ingredient -> ingredient.getName().equals(name))
                    .findFirst();
            if (item.isPresent()) result = item.get();
        }
        return result;
    }

    private List<FoodDto> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<FoodDto>> typeReference = new TypeReference<List<FoodDto>>() {};
        List<FoodDto> ingredients = new ArrayList<>();
        try {
            ingredients = objectMapper.readValue(file, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ingredients;
    }

}
