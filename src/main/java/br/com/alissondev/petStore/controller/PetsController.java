package br.com.alissondev.petStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alissondev.petStore.models.Pet;
import br.com.alissondev.petStore.repositories.PetRepository;

@RestController
@ResponseBody
@RequestMapping("/pets")
public class PetsController {
	
	@Autowired
	private PetRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Pet>> getTest() {
		
		return ResponseEntity.ok().body(repository.findAll()); 
	}

}
