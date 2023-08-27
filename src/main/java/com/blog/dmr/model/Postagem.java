package com.blog.dmr.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "postagem")
public class Postagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postagem_cd_id")
	private Integer idPostagem;
	
	@Column(name = "postagem_tx_titulo")
	private String tituloPostagem;
	
	@Column(name = "postagem_tx_subtitulo")
	private String subtituloPostagem;
	
	@Column(name = "postagem_tx_descricao")
	private String descricaoPostagem;
	
	@Column(name = "postagem_dt_data_post")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataPost;
	
	@Column(name = "postagem_imagem")
	private byte[] imagemPost;

	public Integer getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(Integer idPostagem) {
		this.idPostagem = idPostagem;
	}

	public String getTituloPostagem() {
		return tituloPostagem;
	}

	public void setTituloPostagem(String tituloPostagem) {
		this.tituloPostagem = tituloPostagem;
	}

	public String getSubtituloPostagem() {
		return subtituloPostagem;
	}

	public void setSubtituloPostagem(String subtituloPostagem) {
		this.subtituloPostagem = subtituloPostagem;
	}

	public String getDescricaoPostagem() {
		return descricaoPostagem;
	}

	public void setDescricaoPostagem(String descricaoPostagem) {
		this.descricaoPostagem = descricaoPostagem;
	}

	public LocalDate getDataPost() {
		return dataPost;
	}

	public void setDataPost(LocalDate dataPost) {
		this.dataPost = dataPost;
	}

	public byte[] getImagemPost() {
		return imagemPost;
	}

	public void setImagemPost(byte[] imagemPost) {
		this.imagemPost = imagemPost;
	}
	
	
	
	
}
