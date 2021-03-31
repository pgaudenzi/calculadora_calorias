package com.spring.clase3.calcular_calorias.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ProcessedDish {

    private List<DishDto> dishes;

}
