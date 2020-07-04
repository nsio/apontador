package br.com.apontador.locais.api.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonRootName;

import br.com.apontador.locais.api.domain.model.Local;

@JsonRootName("local")
public class LocalDTO {
	
	private Long id;
	@NotNull
	@NotBlank
	private String descricao;
	@NotNull
	@NotBlank
	private String telefone;
	@NotNull
	private EnderecoDTO endereco;
	
	public Local transformarParaEntidade() {
		return new Local(id, descricao, telefone, endereco.transformarParaEntidade());
	}
	
	public LocalDTO(Long id, String descricao, String telefone, EnderecoDTO endereco) {
		this.id = id;
		this.descricao = descricao;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocalDTO other = (LocalDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
