package ar.edu.unju.fi.app.dto;

import java.util.Date;

public class MovieModifiedDto {
	private Integer idFilm;
	private String image;
	private String title;
	private Date creationDate;
	private Integer qualification;
	private GenderDto gender;
	
	
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
	
	public GenderDto getGender() {
		return gender;
	}
	
	public void setGender(GenderDto gender) {
		this.gender = gender;
	}
	
	
}
