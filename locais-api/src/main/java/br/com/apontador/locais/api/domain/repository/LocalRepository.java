package br.com.apontador.locais.api.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apontador.locais.api.domain.model.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long>{
	
	Page<Local> findByDescricaoContainingIgnoreCase(String chave, Pageable pageable);
	
}
