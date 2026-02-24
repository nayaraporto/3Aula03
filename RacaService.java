package com.pet_shop.Service;

import org.springframework.stereotype.Service;
import com.pet_shop.Entity.Raca;
import com.pet_shop.Repository.RacaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class RacaService {
	
		private final RacaRepository racaRepository;
		public RacaService(RacaRepository racaRepository) {
			this.racaRepository = racaRepository;
		}
		
		public Raca saveRaca (Raca raca) {
			return racaRepository.save(raca);
		}
		
		public Raca getRacaById(Long id) {
			return racaRepository.findById(id).orElse(null);
		}
		public List<Raca> getAllRaca() {
			return racaRepository.findAll();
		}
		
		public Raca alteraRaca (Long id, Raca alteraRaca) {
			Optional<Raca> existeRaca = racaRepository.findById(id);
			if (existeRaca.isPresent()) {
				alteraRaca.setId(id);
				return racaRepository.save(alteraRaca);
			}
			else {
				return null;
			}		
		}
		
		public boolean deleteRaca (Long id) {
			Optional<Raca> existeRaca = racaRepository.findById(id);
			if (existeRaca.isPresent()) {
				racaRepository.deleteById(id);
				return true;
			} else {
				return false;
			}
		}
		
	}



