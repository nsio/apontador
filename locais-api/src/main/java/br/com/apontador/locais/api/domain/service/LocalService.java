package br.com.apontador.locais.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.apontador.locais.api.domain.dto.EnderecoDTO;
import br.com.apontador.locais.api.domain.dto.LocalDTO;
import br.com.apontador.locais.api.domain.model.Local;
import br.com.apontador.locais.api.domain.repository.LocalRepository;

@Service
public class LocalService {
	
	@Autowired
	private LocalRepository localRepository;
	
	public LocalDTO salvar(Local local) {
		Local localSalvo = this.localRepository.save(local);
		return entidadeParaDto(localSalvo);
	}
	
	public Page<LocalDTO> pesquisar(String chave, Pageable pageable){
		Page<Local> locaisDaPesquisa = this.localRepository.findByDescricaoContainingIgnoreCase(chave, pageable);
		Page<LocalDTO> retorno = locaisDaPesquisa.map(this::entidadeParaDto);
		return retorno;
	}
	
	public LocalDTO entidadeParaDto(Local local) {
		return new LocalDTO(local.getId(), local.getDescricao(), local.getTelefone(), 
						   new EnderecoDTO(local.getEndereco().getId(), local.getEndereco().getCep(), 
								           local.getEndereco().getBairro(), local.getEndereco().getCidade(), 
								           local.getEndereco().getEndereco(), local.getEndereco().getComplemento(), 
								           local.getEndereco().getNumero()));
	}
	
}
