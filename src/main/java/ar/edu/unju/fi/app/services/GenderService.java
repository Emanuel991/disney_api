package ar.edu.unju.fi.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.app.models.Gender;
import ar.edu.unju.fi.app.repositories.GenderRepository;

@Service
public class GenderService {
	
	@Autowired
	GenderRepository genderRepository;
	
	public Gender save(Gender gender) {
		return genderRepository.save(gender);
	}
}
