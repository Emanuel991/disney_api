package ar.edu.unju.fi.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.app.models.Personaje;
import ar.edu.unju.fi.app.repositories.CharacterRepository;

@Service
public class CharacterService {
	@Autowired
	CharacterRepository characterRepository;
	
	public Personaje save(Personaje character) {
		return characterRepository.save(character);
	}
	
	public Personaje update(Personaje character) {
		return characterRepository.save(character);
	}
	
	public void delete(Personaje character) {
		characterRepository.delete(character);
	}

	public Personaje getCharacter(Integer id) {
		return characterRepository.getCharacterById(id);
	}
	
	public List<Personaje> getCharactersByName(String name){
		return characterRepository.findAllByName(name);
	}
	
	public List<Personaje> getAll(){
		return characterRepository.findAll();
	}

	public List<Personaje> getCharactersByAge(String age) {
		return characterRepository.findAllByAge(age);
	}

	public List<Personaje> getCharactersOptional(String name, String age) {
		return characterRepository.getCharactersOptioal(name, age);
	}

	/*public List<Personaje> getCharactersByNameOrAge(String name, String age) {
		return characterRepository.getCharactersByNameOrAge(name, age);
	}*/

	/*
	public List<Personaje> getCharactersByMovie(Integer idMovie) {
		return characterRepository.getCharacterByMovie(idMovie);
	} */
	
}
