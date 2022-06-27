package ar.edu.unju.fi.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unju.fi.app.models.Gender;
import ar.edu.unju.fi.app.services.GenderService;

@RestController
public class GenderController {
	
	@Autowired
	GenderService genderService;
	
	@PostMapping("/newGender")
	public Gender create(@RequestBody Gender gender) {
		return genderService.save(gender);
	}
}
