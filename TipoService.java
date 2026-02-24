package com.pet_shop.Service;

import org.springframework.stereotype.Service;
import com.pet_shop.Entity.Tipo;
import com.pet_shop.Repository.TipoRepository;
import java.util.List;
import java.util.Optional;


@Service
public class TipoService {
	
	private final TipoRepository tipoRepository;
	public TipoService(TipoRepository tipoRepository) {
		this.tipoRepository = tipoRepository;
	}
	
	public Tipo saveTipo (Tipo tipo) {
		return tipoRepository.save(tipo);
	}
	
	public Tipo getTipoById(Long id) {
		return tipoRepository.findById(id).orElse(null);
	}
	
	public List<Tipo> getAllTipo() {
		return tipoRepository.findAll();
	}
	
	public Tipo alteraTipo (Long id, Tipo alteraTipo) {
		Optional<Tipo> existeTipo = tipoRepository.findById(id);
		if (existeTipo.isPresent()) {
			alteraTipo.setId(id);
			return tipoRepository.save(alteraTipo);
		}
		else {
			return null;
		}
	}
	
	public boolean deleteTipo (Long id) {
		Optional<Tipo> existeTipo = tipoRepository.findById(id);
		if (existeTipo.isPresent()) {
			tipoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
