package br.com.apontador.locais.api.domain.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonRootName;

import br.com.apontador.locais.api.domain.model.Endereco;

@JsonRootName("endereco")
public class EnderecoDTO {
	
	private Long id;
	@NotBlank
	@NotNull
	private String cep;
	@NotBlank
	@NotNull
	private String bairro;
	@NotBlank
	@NotNull
	private String cidade;
	@NotBlank
	@NotNull
	private String endereco;
	@NotBlank
	@NotNull
	private String complemento;
		
	@NotNull
	@Min(1)
	private Integer numero;
	
	public Endereco transformarParaEntidade() {
		return new Endereco(id, cep, bairro, cidade, endereco, complemento, numero);
	}
	
	public EnderecoDTO(Long id, String cep, String bairro, String cidade, String endereco, String complemento, Integer numero) {
		this.id = id;
		this.cep = cep; 
		this.bairro = bairro;
		this.cidade = cidade;
		this.endereco = endereco;
		this.complemento = complemento;
		this.numero = numero;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
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
		EnderecoDTO other = (EnderecoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
