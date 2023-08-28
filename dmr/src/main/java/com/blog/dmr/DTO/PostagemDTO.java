package com.blog.dmr.DTO;

import java.io.Serializable;
import java.time.LocalDate;

public class PostagemDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idPostagem;
	private String tituloPostagem;
	private String subtituloPostagem;
	private String descricaoPostagem;
	private LocalDate dataPost;
	private String imagemPost;
	
	public PostagemDTO() {
		super();
	}

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

	public String getImagemPost() {
		return imagemPost;
	}

	public void setImagemPost(String imagemPost) {
		this.imagemPost = imagemPost;
	}
	
}
