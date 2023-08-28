package com.blog.dmr.model;

import java.util.Arrays;
import java.util.Objects;

import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.VarbinaryJdbcType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagem")
public class Imagem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_imagem")
	private Integer idImagem;
	
	@Column(name = "imagem", length = 30, nullable = false)
	private String nomeImagem;

	@Column(name = "type", length = 10, nullable = false)
	private String mimetype;
	
	
	@Lob
	@Column(name = "dados", nullable = false)
//	@Type(type = "org.hibernate.type.BinaryType")
	@JdbcType(VarbinaryJdbcType.class)
	private byte[] dados;

	public Imagem(Integer idImagem, String nomeImagem, String mimetype, byte[] dados) {
		super();
		this.idImagem = idImagem;
		this.nomeImagem = nomeImagem;
		this.mimetype = mimetype;
		this.dados = dados;
	}

	public Imagem() {
		super();
	}

	public Integer getIdImagem() {
		return idImagem;
	}

	public void setIdImagem(Integer idImagem) {
		this.idImagem = idImagem;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public byte[] getDados() {
		return dados;
	}

	public void setDados(byte[] dados) {
		this.dados = dados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(dados);
		result = prime * result + Objects.hash(idImagem, mimetype, nomeImagem);
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
		Imagem other = (Imagem) obj;
		return Arrays.equals(dados, other.dados) && Objects.equals(idImagem, other.idImagem)
				&& Objects.equals(mimetype, other.mimetype) && Objects.equals(nomeImagem, other.nomeImagem);
	}
}
