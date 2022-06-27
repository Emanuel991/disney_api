package ar.edu.unju.fi.app.dto;

import ar.edu.unju.fi.app.models.Personaje;

public class CharacterFilmDto {
	
	private Personaje character;

	/*
	public Integer getIdCharacterFilm() {
		return idCharacterFilm;
	}

	public void setIdCharacterFilm(Integer idCharacterFilm) {
		this.idCharacterFilm = idCharacterFilm;
	}

	
	public Integer getFilm() {
		return film.getIdFilm();
	}

	public void setFilm(Film film) {
		this.film = film;
	} */
	
	public String getNameCharacter() {
		return character.getName();
	}

	public Integer getIdCharacter() {
		return character.getIdCharacter();
	}

	public void setCharacter(Personaje character) {
		this.character = character;
	}

}
