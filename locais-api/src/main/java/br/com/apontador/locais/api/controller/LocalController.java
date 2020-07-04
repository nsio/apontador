package br.com.apontador.locais.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apontador.locais.api.domain.dto.LocalDTO;
import br.com.apontador.locais.api.domain.service.LocalService;

@RestController
@RequestMapping("/locais")
public class LocalController {
	
	@Autowired
	private LocalService localService;
	
	@PostMapping
	public ResponseEntity<LocalDTO> salvarLocal(@RequestBody @Validated LocalDTO localDto){
		LocalDTO localSalvoDto = this.localService.salvar(localDto.transformarParaEntidade());
		return ResponseEntity.status(HttpStatus.CREATED).body(localSalvoDto);
	}
	
	@GetMapping("/{chave}")
	public ResponseEntity<Page<LocalDTO>> pesquisar(@PathVariable("chave") String chave, Pageable pageable){
		Page<LocalDTO> retorno = this.localService.pesquisar(chave, pageable);
		if (Optional.of(retorno.getContent()).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(retorno);
	}
	
}
