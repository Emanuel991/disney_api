package ar.edu.unju.fi.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.app.models.CharacterFilm;
import ar.edu.unju.fi.app.repositories.CharacterFilmRepository;

@Service
public class CharacterFIlmService {
	@Autowired
	CharacterFilmRepository characterFilmRepository; 
	
	public void saveCharacterToMovie(CharacterFilm characterFilm) {
		characterFilmRepository.save(characterFilm);
	}

	public CharacterFilm findByMovieAndCharacter(Integer idMovie, Integer idCharacter) {
		return characterFilmRepository.findByIds(idMovie, idCharacter);
	}
	
	public void deleteCharacterToMovie(CharacterFilm characterFilm) {
		characterFilmRepository.delete(characterFilm);
	}
}
