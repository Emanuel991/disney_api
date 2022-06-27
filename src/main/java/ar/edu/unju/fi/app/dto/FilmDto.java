package ar.edu.unju.fi.app.dto;

import java.util.Date;
import java.util.Set;

import lombok.Data;

@Data
public class FilmDto {
	private Integer idFilm;
	private String image;
	private String title;
	private Date creationDate;
	private Integer qualification;
	//private Gender gender;
	
	Set<CharacterFilmDto> charactersFilms;
	
	public Integer getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(Integer idFilm) {
		this.idFilm = idFilm;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getQualification() {
		return qualification;
	}
	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/*
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	} */
	public Set<CharacterFilmDto> getCharactersFilms() {
		return charactersFilms;
	}
	public void setCharactersFilms(Set<CharacterFilmDto> charactersFilms) {
		this.charactersFilms = charactersFilms;
	}
}
