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
import com.pet_shop.Entity.Raca;
import com.pet_shop.Service.RacaService;

@RestController
@RequestMapping("/Raca")
public class RacaController {
	
	private final RacaService racaService;
	public RacaController (RacaService racaService) {
		this.racaService = racaService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Raca>> getAllRaca() {
		List<Raca> racas = racaService.getAllRaca();
		return ResponseEntity.ok(racas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Raca> getRacaById(@PathVariable Long id) {
		Raca raca = racaService.getRacaById(id);
		if (raca !=null) {
			return ResponseEntity.ok(raca);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/Raca")
	public ResponseEntity<Raca> criarRaca(@RequestBody Raca raca) {
		Raca criarRaca = racaService.saveRaca(raca);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarRaca);
	}
	
	@PutMapping("/")
	public ResponseEntity<Raca> alteraRaca(@PathVariable Long id,
			@RequestBody Raca raca) {
		Raca alteraRaca = racaService.alteraRaca(id, raca);
		if(alteraRaca !=null) {
			return ResponseEntity.ok(alteraRaca);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/Raca")
	public ResponseEntity<String> deleteRaca (@PathVariable Long id) {
		boolean deleted = racaService.deleteRaca(id);
		if(deleted) {
			return ResponseEntity.ok().body("Raca apagado com sucesso!");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	

}

	





