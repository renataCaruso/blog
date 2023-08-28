package com.blog.dmr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dmr.DTO.PostagemDTO;
import com.blog.dmr.model.Postagem;
import com.blog.dmr.repository.ImagemRepository;
import com.blog.dmr.repository.PostagemRepository;

@Service
public class PostagemService {

	@Autowired
	PostagemRepository postagemRepository;
	
	@Autowired
	ImagemRepository imagemRepository;
	
	@Autowired
	private ImagemService imagemService;
	
	public PostagemDTO transformarModelEmDTO(Postagem postagem, PostagemDTO postagemDTO) {
	
		postagemDTO.setIdPostagem(postagem.getIdPostagem());
		postagemDTO.setTituloPostagem(postagem.getTituloPostagem());
		postagemDTO.setSubtituloPostagem(postagem.getSubtituloPostagem());
		postagemDTO.setDescricaoPostagem(postagem.getDescricaoPostagem());
		postagemDTO.setDataPost(postagem.getDataPost());
		postagemDTO.setImagemPost(imagemService.encodeImage(postagem.getImagemPost()));
		
		return postagemDTO;
	}

	public Postagem transformarDTOEmModel(Postagem postagem, PostagemDTO postagemDTO) {
		
		postagem.setIdPostagem(postagemDTO.getIdPostagem());
		postagem.setTituloPostagem(postagemDTO.getTituloPostagem());
		postagem.setSubtituloPostagem(postagemDTO.getSubtituloPostagem());
		postagem.setDescricaoPostagem(postagemDTO.getDescricaoPostagem());
		postagem.setDataPost(postagemDTO.getDataPost());
		postagem.setImagemPost(imagemService.decodeImage(postagemDTO.getImagemPost()));
		
		return postagem;
	}
	
	public String salvar(PostagemDTO postagemDTO) {
		Postagem postagem = new Postagem();
		postagem = transformarDTOEmModel(postagem, postagemDTO);
		postagemRepository.save(postagem);
		return "O id da postagem criada é: " + postagem.getTituloPostagem();

	}
	
	public List<PostagemDTO> buscarTodos() {
		List<Postagem> listaPostagemModel = postagemRepository.findAll();
		List<PostagemDTO> listaPostagemDTO = new ArrayList<>();

		for (Postagem postagem : listaPostagemModel) {
			PostagemDTO postagemDTO = new PostagemDTO();
			postagemDTO = transformarModelEmDTO(postagem, postagemDTO);
			listaPostagemDTO.add(postagemDTO);
		}
		return listaPostagemDTO;
	}
	
}