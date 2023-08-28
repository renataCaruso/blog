package com.blog.dmr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.dmr.model.Postagem;


public interface PostagemRepository extends JpaRepository<Postagem, Integer>  {


	
}
