package com.pet_shop.Service;

import org.springframework.stereotype.Service;
import com.pet_shop.Entity.Chip;
import com.pet_shop.Repository.ChipRepository;
import java.util.List;
import java.util.Optional;


@Service
public class ChipService {
	
	private final ChipRepository chipRepository;
	
	public ChipService(ChipRepository chipRepository) {
		this.chipRepository = chipRepository;	
	}
	
	public Chip saveChip (Chip chip) {
		return chipRepository.save(chip);
	}
	
	public Chip getChipById(Long id) {
		return chipRepository.findById(id).orElse(null);
	}
	
	public List<Chip> getAllChip() {
		return chipRepository.findAll();
	}
	
	public Chip altearChip (Long id, com.pet_shop.Entity.Chip alteraChip) {
		Optional<Chip> existeChip = chipRepository.findById(id);
		if (existeChip.isPresent()) {
			alteraChip.setId(id);
			return chipRepository.save(alteraChip);
			
		}
		else {
			return null;
		}
	}
	
	public boolean deleteChip (Long id) {
		Optional<Chip> existeChip = chipRepository.findById(id);
		if (existeChip.isPresent()) {
			chipRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
