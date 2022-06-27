package ar.edu.unju.fi.app.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personaje")
public class Personaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCharacter;
	private String image;
	private String name;
	private String age;
	private String weight;
	private String history;
	
	@OneToMany(mappedBy = "character")
    Set<CharacterFilm> charactersFilms;
	
	public Personaje() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	
	public Set<CharacterFilm> getCharactersFilms() {
		return charactersFilms;
	}

	public void setCharactersFilms(Set<CharacterFilm> charactersFilms) {
		this.charactersFilms = charactersFilms;
	} 
	
}
