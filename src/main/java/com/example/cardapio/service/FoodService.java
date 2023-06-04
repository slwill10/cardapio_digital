package com.example.cardapio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.cardapio.dto.FoodRequestDTO;
import com.example.cardapio.food.Food;
import com.example.cardapio.repository.FoodRepository;

@Service
public class FoodService {
	
	@Autowired
	private FoodRepository repo;
	
	public List<Food> findAll(){
		return repo.findAll();
	}
	
	public void saveFood(@RequestBody FoodRequestDTO data) {
		Food foodData = new Food(data);
		repo.save(foodData);
		return;
	}
}
