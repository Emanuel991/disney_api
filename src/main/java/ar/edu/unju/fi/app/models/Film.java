package ar.edu.unju.fi.app.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFilm;
	private String image;
	private String title;
	private Date creationDate;
	private Integer qualification;
	
	@ManyToOne
	@JoinColumn(name = "gender")
	private Gender gender;
	
	//@ManyToMany(mappedBy = "films")
	//Set<Personaje> personajes;
	
	//@JsonManagedReference
	@OneToMany(mappedBy = "film", 
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
    Set<CharacterFilm> charactersFilms;
	
	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getQualification() {
		return qualification;
	}

	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Set<CharacterFilm> getCharactersFilms() {
		return charactersFilms;
	}

	public void setCharactersFilms(Set<CharacterFilm> charactersFilms) {
		this.charactersFilms = charactersFilms;
	}
	
}
