package com.uap.it1311l.registrationapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.uap.it1311l.registrationapi.model.Attendee;
import com.uap.it1311l.registrationapi.repository.RegistrationMybatisRepository;
import java.util.List;

@RestController
public class RegistrationController {
	
	@Autowired
    private RegistrationMybatisRepository registrationRepo;
	
	@PostMapping("/event/register")
    public Attendee register(@RequestBody Attendee student) {
		registrationRepo.insert(student);
		
		return student;
    }
	
	@GetMapping("/attendees")
    public List<Attendee> findAll() {
        return registrationRepo.findAll();
    }
}
