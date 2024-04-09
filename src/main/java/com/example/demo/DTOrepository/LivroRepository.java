package com.example.demo.DTOrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.DTOentities.Livro;

public interface LivroRepository extends JpaRepository<Livro,Long>{

}
