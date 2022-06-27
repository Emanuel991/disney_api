package ar.edu.unju.fi.app.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "character_film")
public class CharacterFilm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCharacterFilm;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idFilm")
	private Film film;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCharacter")
	private Personaje character;

	public CharacterFilm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdCharacterFilm() {
		return idCharacterFilm;
	}

	public void setIdCharacterFilm(Integer idCharacterFilm) {
		this.idCharacterFilm = idCharacterFilm;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Personaje getCharacter() {
		return character;
	}

	public void setCharacter(Personaje character) {
		this.character = character;
	}

	@Override
	public String toString() {
		return "CharacterFilm [idCharacterFilm=" + idCharacterFilm + ", film=" + film + ", character=" + character
				+ "]";
	}
	
	
}
