package com.blog.dmr.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.dmr.DTO.PostagemDTO;
import com.blog.dmr.model.Postagem;
import com.blog.dmr.repository.PostagemRepository;
import com.blog.dmr.service.PostagemService;

@RestController
@RequestMapping("/postagem")
public class PostagemController {

	@Autowired
	PostagemRepository postagemRepository;
	
	
	@Autowired
	PostagemService postagemService;
	
	  @GetMapping("/lista")
	    public List<Postagem> getPostagens() {
	        return postagemRepository.findAll();
	    }
	  
	    @PostMapping("/salvar")
	    public void addPostagem(@RequestParam Integer idPostagem, // Adicione esta linha
	                            @RequestParam String tituloPostagem,
	                            @RequestParam String subtituloPostagem,
	                            @RequestParam String descricaoPostagem,
	                            @RequestParam LocalDate dataPost,
	                            @RequestParam MultipartFile imagemPost) throws IOException {
	        Postagem postagem = new Postagem();
	        postagem.setIdPostagem(idPostagem); // Adicione esta linha
	        postagem.setTituloPostagem(tituloPostagem);
	        postagem.setSubtituloPostagem(subtituloPostagem);
	        postagem.setDescricaoPostagem(descricaoPostagem);
	        postagem.setDataPost(dataPost);
	        postagem.setImagemPost(imagemPost.getBytes());
	        postagemRepository.save(postagem);
	    }
	
	
//	@PostMapping("/salvar")
//	public ResponseEntity<Void> salvar(@RequestBody PostagemDTO postagemDTO, Postagem postagem) {
//		postagemService.salvar(postagemDTO);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}
	
//	@GetMapping("/lista")
//	public ResponseEntity<List<PostagemDTO>> buscarTodos() {
//		return ResponseEntity.ok(postagemService.buscarTodos());
//	}
	
}
