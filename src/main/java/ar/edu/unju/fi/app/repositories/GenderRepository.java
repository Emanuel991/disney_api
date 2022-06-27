package ar.edu.unju.fi.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.app.models.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer>{

}
