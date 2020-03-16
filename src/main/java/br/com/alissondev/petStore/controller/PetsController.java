package br.com.alissondev.petStore.controller;

import java.net.URI;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.alissondev.petStore.models.Pet;
import br.com.alissondev.petStore.repositories.PetRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@ResponseBody
@RequestMapping("/pets")
public class PetsController {
	
	@Autowired
	private PetRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Pet>> getAllPets() {
		
		return ResponseEntity.ok().body(repository.findAll()); 
	}

	@GetMapping("/{_id}")
	public ResponseEntity<Pet> findPetById(@PathVariable("_id") Object _id) {

		return ResponseEntity.ok().body(repository.findBy_id(_id));
	}
	
	@PostMapping
	public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {

		pet.set_id(ObjectId.get());
		Pet petResponse = repository.save(pet);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(pet.get_id()).toUri();

		return ResponseEntity.created(location).body(petResponse);
	}

	@DeleteMapping("{_id}")
	public ResponseEntity<Void> deletePet(@PathVariable("_id") ObjectId _id) {
		checkIfExist(_id);
		repository.delete(repository.findBy_id(_id));

		return ResponseEntity.accepted().build();
	}

	@PutMapping("{_id}")
	public ResponseEntity<Void> modifyPetById(@PathVariable("_id") ObjectId _id, @RequestBody Pet pet) {
		checkIfExist(_id);
		pet.set_id(_id);
		repository.save(pet);

		return  ResponseEntity.accepted().build();
	}

	private ResponseEntity<Void> checkIfExist(ObjectId _id) {
		if (!repository.existsById(_id.toHexString())) {
			return ResponseEntity.noContent().build();
		};

		return null;
	}

}
