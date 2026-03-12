package com.pet_shop.Controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pet_shop.Entity.Tutor;
import com.pet_shop.Service.TutorService;

@RestController
@RequestMapping("/Tutor")
public class TutorController {
	
	private final TutorService tutorService;
	public TutorController (TutorService tutorService) {
		this.tutorService = tutorService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Tutor>> getAllTutor() {
		List<Tutor> tutores = tutorService.getAllTutor();
		return ResponseEntity.ok(tutores);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tutor> getTutorById(@PathVariable Long id) {
		Tutor tutor = tutorService.getTutorById(id);
		if (tutor !=null) {
			return ResponseEntity.ok(tutor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Tutor> criarTutor(@RequestBody Tutor tutor) {
		Tutor criarTutor = tutorService.saveTutor(tutor);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarTutor);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Tutor> alteraTutor(@PathVariable Long id,
			@RequestBody Tutor tutor) {
		Tutor alteraTutor = tutorService.alteraTutor(id, tutor);
		if(alteraTutor !=null) {
			return ResponseEntity.ok(alteraTutor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTutor (@PathVariable Long id) {
		boolean deleted = tutorService.deleteTutor(id);
		if(deleted) {
			return ResponseEntity.ok().body("Tutor apagado com sucesso!");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	


}

