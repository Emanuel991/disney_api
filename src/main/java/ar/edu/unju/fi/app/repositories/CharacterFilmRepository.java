package ar.edu.unju.fi.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.app.models.CharacterFilm;

@Repository
public interface CharacterFilmRepository extends JpaRepository<CharacterFilm, Integer>{

	@Query("from CharacterFilm c where c.film.idFilm = :idMovie and c.character.idCharacter = :idCharacter")
	public CharacterFilm findByIds(@Param("idMovie") Integer IdMovie, @Param("idCharacter") Integer idCharacter);
}
