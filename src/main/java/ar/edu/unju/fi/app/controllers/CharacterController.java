package ar.edu.unju.fi.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unju.fi.app.dto.CharacterDto;
import ar.edu.unju.fi.app.dto.CharacterModifiedDto;
import ar.edu.unju.fi.app.dto.CharactersDetailsDto;
import ar.edu.unju.fi.app.models.CharacterFilm;
import ar.edu.unju.fi.app.models.Film;
import ar.edu.unju.fi.app.models.Personaje;
import ar.edu.unju.fi.app.services.CharacterFIlmService;
import ar.edu.unju.fi.app.services.CharacterService;
import ar.edu.unju.fi.app.services.FilmService;

@RestController
public class CharacterController {
	
	@Autowired
	CharacterService characterService;
	
	@Autowired
	FilmService filmService;
	
	@Autowired
	CharacterFIlmService characterFilmService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@PostMapping("/newCharacter")
	public Personaje save(@RequestBody Personaje character) {
		return characterService.save(character);
	}
	
	@PutMapping("/modifiedCharacter")
	public Personaje edit(@RequestBody CharacterModifiedDto characterDto) {
		return characterService.update(convertToEntity(characterDto));
	}
	
	@DeleteMapping("/deletedCharacter/{id}")
	public void delete(@PathVariable Integer id) {
		Personaje character = characterService.getCharacter(id);
		characterService.delete(character);
	}
	
	@GetMapping("/detailsCharacter/{userId}")
	public CharacterDto viewDetails(@PathVariable Integer userId) {
		return convertToDto(characterService.getCharacter(userId));
	}
	
	@GetMapping("/characters")
	@ResponseBody
	public List<CharactersDetailsDto> search(@RequestParam Optional<String> name, @RequestParam Optional<String> age,@RequestParam Optional<Integer> id) {
		if(!name.isEmpty() && !age.isEmpty()) {
			List<Personaje> listName = characterService.getCharactersOptional(name.get(), age.get()); 
			return listName.stream().map(this::convertToDetailsDto).collect(Collectors.toList());
		}
		if(!id.isEmpty()) {
			Film listMovies = filmService.getFilmById(id.get());
			Set<CharacterFilm> characterList = listMovies.getCharactersFilms();
			List<Personaje> characters = new ArrayList<Personaje>();
			for(CharacterFilm cf : characterList) {
				characters.add(cf.getCharacter());
			}
			return characters.stream().map(this::convertToDetailsDto).collect(Collectors.toList());
		} 
		if(!name.isEmpty()) {
			List<Personaje> listName = characterService.getCharactersByName(name.get()); 
			return listName.stream().map(this::convertToDetailsDto).collect(Collectors.toList());
		}
		if(!age.isEmpty()) {
			List<Personaje> listAge = characterService.getCharactersByAge(age.get());
			return listAge.stream().map(this::convertToDetailsDto).collect(Collectors.toList());
		}
		return characterService.getAll().stream().map(this::convertToDetailsDto).collect(Collectors.toList());
	}
	
	@PostMapping("/movies/{idMovie}/characters/{idCharacter}")
	public void addCharacterToMovie(@PathVariable Integer idMovie, @PathVariable Integer idCharacter) {
		Film film = filmService.getFilmById(idMovie);
		Personaje character = characterService.getCharacter(idCharacter);
		CharacterFilm characterFilm = new CharacterFilm();
		characterFilm.setCharacter(character);
		characterFilm.setFilm(film);
		characterFilmService.saveCharacterToMovie(characterFilm);
	}
	
	@DeleteMapping("/movies/{idMovie}/characters/{idCharacter}")
	public void deleteCharacterToMovie(@PathVariable Integer idMovie, @PathVariable Integer idCharacter) {
		CharacterFilm characterFilm = characterFilmService.findByMovieAndCharacter(idMovie, idCharacter);
		characterFilmService.deleteCharacterToMovie(characterFilm);
	}
	
	private CharacterDto convertToDto(Personaje character) {
		CharacterDto characterDto = modelMapper.map(character, CharacterDto.class);
	    return characterDto;
	}
	
	private CharactersDetailsDto convertToDetailsDto(Personaje character) {
		CharactersDetailsDto characterDto = modelMapper.map(character, CharactersDetailsDto.class);
	    return characterDto;
	}
	
	private Personaje convertToEntity(CharacterModifiedDto characterDto) throws ParseException {
	    Personaje character = modelMapper.map(characterDto, Personaje.class);
	    return character;
	}
}
