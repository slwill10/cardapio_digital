package com.example.cardapio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.dto.FoodDTO;
import com.example.cardapio.dto.FoodRequestDTO;
import com.example.cardapio.service.FoodService;

@RestController
@RequestMapping(value = "/foods")
public class FoodController {

	@Autowired
	private FoodService service;
	

	@GetMapping
	public List<FoodDTO> getAll() {
		List<FoodDTO> list = (List<FoodDTO>) service.findAll().stream().map(FoodDTO::new).toList();
		return list;
	}

	public FoodController(FoodService foodService) {
        this.service = foodService;
    }

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Void> saveFood(@RequestBody FoodRequestDTO data) {
        service.saveFood(data);
        return ResponseEntity.ok().build();
    }
}
