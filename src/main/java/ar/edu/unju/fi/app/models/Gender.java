package ar.edu.unju.fi.app.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gender")
public class Gender {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGender;
	private String name;
	private String image;
	
	@OneToMany(mappedBy="gender")
    private Set<Film> movies;
	
	public Gender() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdGender() {
		return idGender;
	}
	public void setIdGender(Integer idGender) {
		this.idGender = idGender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public Set<Film> getMovies() {
		return movies;
	}

	public void setMovies(Set<Film> movies) {
		this.movies = movies;
	}
	
	
}
