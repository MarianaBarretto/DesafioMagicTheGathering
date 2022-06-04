package br.com.springboot.magic_the_gathering.model;

import java.io.Serializable;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_carta", sequenceName = "seq_carta", allocationSize = 1, initialValue = 1)
public class Carta implements Serializable {
	
	private static final long serialVersionUID= 1L;	 

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carta")
	private long id;
	
	
	private String nomeCarta;	
	private String edicao;
	private String idioma;
	private String laminada;
	private Double preco;
	private int quantidade;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeCarta() {
		return nomeCarta;
	}

	public void setNomeCarta(String nomeCarta) {
		this.nomeCarta = nomeCarta;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getLaminada() {
		return laminada;
	}

	public void setLaminada(String laminada) {
		this.laminada = laminada;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Carta [id=" + id + ", nomeCarta=" + nomeCarta + ", edicao=" + edicao + ", idioma=" + idioma
				+ ", laminada=" + laminada + ", preco=" + preco + ", quantidade=" + quantidade + "]";
	}
	
	
	
	
	
}
