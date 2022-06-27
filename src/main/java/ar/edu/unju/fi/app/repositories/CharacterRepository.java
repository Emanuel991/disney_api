package ar.edu.unju.fi.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.app.models.Personaje;

@Repository
public interface CharacterRepository extends JpaRepository<Personaje, Integer>{

	@Query("from Personaje p where p.idCharacter=:id")
	public Personaje getCharacterById(@Param("id") Integer id);

	//@Query("SELECT p.image from Personaje p where p.name=:name")
	public List<Personaje> findAllByName(String name);
	
	public List<Personaje> findOneByName(String name);

	public List<Personaje> findAllByAge(String age);

	@Query("from Personaje p where p.name =:name and p.age=:age")
	public List<Personaje> getCharactersOptioal(@Param("name")String name, @Param("age")String age);

	//@Query("from Personaje p where p.name =:name or p.age=:age")
	//public List<Personaje> getCharactersByNameOrAge(@Param("name")String name, @Param("age")String age);

	//@Query("from Personaje p where p.charactersFilms.filmId =:movieId")
	//public List<Personaje> getCharacterByMovie(@Param("movieId")Integer movieId);
	
}
