package br.com.apontador.locais.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.apontador.locais.api.domain.model.Endereco;
import br.com.apontador.locais.api.domain.model.Local;
import br.com.apontador.locais.api.domain.repository.LocalRepository;
import br.com.apontador.locais.api.domain.service.LocalService;

@RunWith(SpringRunner.class)
@SpringBootTest
class LocaisApiApplicationTests {

	@Autowired
	private LocalService localService;

	@MockBean
	private LocalRepository localRepository;
	
	@Mock
	private Pageable pageable;
	
	@Test
	public void pesquisaTest() {
		List<Local> locais = new ArrayList<Local>();
		locais.add(new Local("Local 1", "999", new Endereco("00000", "bairro", "cidade", "endereco", "complemento", 100)));
		locais.add(new Local("Local 2", "999", new Endereco("00000", "bairro", "cidade", "endereco", "complemento", 100)));
		Page<Local> locaisPage = new PageImpl<Local>(locais);
		
		this.localRepository.save(locais.get(0));
		this.localRepository.save(locais.get(1));
		
		when(localRepository.findByDescricaoContainingIgnoreCase("Local", this.pageable)).thenReturn(locaisPage);
		
		assertEquals(2, this.localRepository.findByDescricaoContainingIgnoreCase("local", pageable).getSize());
						
	}
	
	@Test
	public void saveLocalTest() {
		Local local = new Local("Local 1", "999", new Endereco("00000", "bairro", "cidade", "endereco", "complemento", 100));
		when(this.localRepository.save(local)).thenReturn(local);
		assertEquals(local, this.localRepository.save(local));
	}
	
}
