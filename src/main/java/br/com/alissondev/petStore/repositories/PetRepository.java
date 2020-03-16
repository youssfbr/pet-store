package br.com.alissondev.petStore.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.alissondev.petStore.models.Pet;

public interface PetRepository extends MongoRepository<Pet, String>{
	
	Pet findBy_id(Object _id);
	
	List<Pet> findByBreed(String breed);

}
