package com.pet_shop.Service;

import org.springframework.stereotype.Service;
import com.pet_shop.Entity.Vacinacao;
import com.pet_shop.Repository.VacinacaoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class VacinacaoService {
	
		
		private final VacinacaoRepository vacinacaoRepository;
		public VacinacaoService(VacinacaoRepository vacinacaoRepository) {
			this.vacinacaoRepository = vacinacaoRepository;
		}
		
		public Vacinacao saveVacinacao (Vacinacao vacinacao) {
			return vacinacaoRepository.save(vacinacao);
		}
		
		public Vacinacao getVacinacaoById(Long id) {
			return vacinacaoRepository.findById(id).orElse(null);
		}
		
		public List<Vacinacao> getAllVacinacao() {
			return vacinacaoRepository.findAll();
		}
		
		public Vacinacao alteraVacinacao (Long id, Vacinacao alteraVacinacao) {
			Optional<Vacinacao> existeVacinacao = vacinacaoRepository.findById(id);
			if (existeVacinacao.isPresent()) {
				alteraVacinacao.setId(id);
				return vacinacaoRepository.save(alteraVacinacao);
			}
			else {
				return null;
			}
		}
		
		public boolean deleteVacinacao (Long id) {
			Optional<Vacinacao> existeTutor = vacinacaoRepository.findById(id);
			if (existeTutor.isPresent()) {
				vacinacaoRepository.deleteById(id);
				return true;
			} else {
				return false;
			}
		}

	}






