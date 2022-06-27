package ar.edu.unju.fi.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.app.models.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

	@Query("from Film f where f.idFilm = :id")
	public Film getFilmById(@Param("id") Integer id);
	
	@Query("from Film f where f.title = :name")
	public List<Film> findByName(@Param("name") String name);

	@Query("from Film f where f.gender.idGender = :gender")
	public List<Film> findByGender(Integer gender);
	
	@Query("from Film f order by f.creationDate ASC")
	public List<Film> findByOrder();
	
	@Query("from Film f order by f.creationDate DESC")
	public List<Film> findByOrderDesc();
	
}
