package ar.edu.unju.fi.app.dto;

import java.util.Set;

public class CharacterDto {
	private Integer idCharacter;
	private String image;
	private String name;
	private String age;
	private String weight;
	private String history;
	
	Set<FilmCharacterDto> charactersFilms;
	
	public Integer getIdCharacter() {
		return idCharacter;
	}
	
	public void setIdCharacter(Integer idCharacter) {
		this.idCharacter = idCharacter;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getWeight() {
		return weight;
	}
	
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHistory() {
		return history;
	}
	
	public void setHistory(String history) {
		this.history = history;
	}
	
	public Set<FilmCharacterDto> getCharactersFilms() {
		return charactersFilms;
	}
	
	public void setCharactersFilms(Set<FilmCharacterDto> charactersFilms) {
		this.charactersFilms = charactersFilms;
	}
}
