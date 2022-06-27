package ar.edu.unju.fi.app.dto;

import ar.edu.unju.fi.app.models.Film;

public class FilmCharacterDto {
	
	private Film film;

	public Integer getFilmId() {
		return film.getIdFilm();
	}
	
	public String getTitle() {
		return film.getTitle();
	}

	public void setFilm(Film film) {
		this.film = film;
	}
	
	

}
