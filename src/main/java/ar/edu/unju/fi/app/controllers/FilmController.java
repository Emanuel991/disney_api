package ar.edu.unju.fi.app.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unju.fi.app.dto.FilmDto;
import ar.edu.unju.fi.app.dto.MovieDetailsDto;
import ar.edu.unju.fi.app.models.Film;
import ar.edu.unju.fi.app.services.FilmService;

@RestController
public class FilmController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	FilmService filmService;
	
	@GetMapping("/movieDetails/{id}")
	public FilmDto getFilm(@PathVariable("id") Integer id) {
		Film movie = filmService.getFilmById(id);
		return convertToDto(movie);
	}
	
	@GetMapping("/movies")
	@ResponseBody
	public List<MovieDetailsDto> search(@RequestParam Optional<String> name, @RequestParam Optional<Integer> genre,
			@RequestParam Optional<String> order) {
		if(!name.isEmpty()) {
			List<Film> listName = filmService.findByName(name.get()); 
			return listName.stream().map(this::convertToDetailsDto).collect(Collectors.toList());
		}
		if(!genre.isEmpty()) {
			List<Film> listName = filmService.findByGender(genre.get()); 
			return listName.stream().map(this::convertToDetailsDto).collect(Collectors.toList());
		}
		if(!order.isEmpty() && order.get().equals("ASC")) {
			List<Film> listName = filmService.finnByOrder(); 
			return listName.stream().map(this::convertToDetailsDto).collect(Collectors.toList());
		}
		if(!order.isEmpty() && order.get().equals("DESC")) {
			List<Film> listName = filmService.finnByOrderDesc(); 
			return listName.stream().map(this::convertToDetailsDto).collect(Collectors.toList());
		}
		return filmService.getAll().stream().map(this::convertToDetailsDto).collect(Collectors.toList());
	}
	
	@PostMapping("/newMovie")
	public Film add(@RequestBody Film film) {
		return filmService.save(film);
	}
	
	@DeleteMapping("/movieDeleted/{id}")
	public void delete(@PathVariable Integer id) {
		Film film = filmService.getFilmById(id);
		filmService.delete(film);
	}
	
	@PutMapping("/movieModified")
	public Film update(@RequestBody Film film) {
		return filmService.save(film);
	}
	
	private FilmDto convertToDto(Film film) {
		FilmDto filmDto = modelMapper.map(film, FilmDto.class);
	    return filmDto;
	}
	
	private MovieDetailsDto convertToDetailsDto(Film film) {
		MovieDetailsDto filmDto = modelMapper.map(film, MovieDetailsDto.class);
	    return filmDto;
	}
}
