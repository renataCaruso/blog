package com.blog.dmr.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.dmr.model.Imagem;
import com.blog.dmr.service.ImagemService;

@RestController
public class ImagemController {

	@Autowired
	ImagemService service;
	
	@PostMapping(path = "/imagem", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Integer> salvar(@RequestParam MultipartFile arquivo) throws IOException {
		Imagem img = service.create(arquivo);
		return new ResponseEntity<>(img.getIdImagem(), HttpStatus.CREATED);
	}
}
