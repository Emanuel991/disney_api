package ar.edu.unju.fi.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.app.models.Film;
import ar.edu.unju.fi.app.repositories.FilmRepository;

@Service
public class FilmService {
	
	@Autowired
	FilmRepository filmRepository;
	
	public Film getFilmById(Integer id) {
		return filmRepository.getFilmById(id);
	}
	
	public Film save(Film film) {
		return filmRepository.save(film);
	}
	
	public List<Film> findByName(String name){
		return filmRepository.findByName(name);
	}
	
	public List<Film> findByGender(Integer gender){
		return filmRepository.findByGender(gender);
	}
	
	public List<Film> getAll(){
		return filmRepository.findAll();
	}

	public List<Film> finnByOrder() {
		return filmRepository.findByOrder();
	}

	public List<Film> finnByOrderDesc() {
		return filmRepository.findByOrderDesc();
	}

	public void delete(Film film) {
		filmRepository.delete(film);
		
	}
}
