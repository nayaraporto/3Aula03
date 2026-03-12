package com.pet_shop.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pet_shop.Entity.Chip;
import com.pet_shop.Service.ChipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/Chip")
public class ChipController {
	
	private final ChipService chipService;
	public ChipController (ChipService chipService) {
		this.chipService = chipService;
	}
	
	@GetMapping("{id}")
	public ResponseEntity<List<Chip>> getAllChip() {
		List<Chip> chips = chipService.getAllChip();
		return ResponseEntity.ok(chips);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Chip> getChipById(@PathVariable Long id) {
		Chip chip = chipService.getChipById(id);
		if (chip !=null) {
			return ResponseEntity.ok(chip);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Chip> criarChip(@RequestBody Chip chip) {
		Chip criarChip = chipService.saveChip(chip);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarChip);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Chip> alteraChip(@PathVariable Long id,
			@RequestBody Chip chip) {
		Chip alteraChip = chipService.alteraChip(id, chip);
		if(alteraChip !=null) {
			return ResponseEntity.ok(alteraChip);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteChip (@PathVariable Long id) {
		boolean deleted = chipService.deleteChip(id);
		if(deleted) {
			return ResponseEntity.ok().body("Chip apagado com sucesso!");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	

}

