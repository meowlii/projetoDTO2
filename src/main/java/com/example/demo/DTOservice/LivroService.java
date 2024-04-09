package com.example.demo.DTOservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTOdto.LivroDTO;
import com.example.demo.DTOentities.Livro;
import com.example.demo.DTOrepository.LivroRepository;

@Service
public class LivroService {

private final LivroRepository livroRepository;

@Autowired
public LivroService(LivroRepository livroRepository) {
	this.livroRepository = livroRepository;
}

//serviço de busca de todos os registros
public List<Livro> buscaTodos() {
	return livroRepository.findAll();
}

//serviço de busca de registro por id
public Livro buscaPorId(Long id) {
	return livroRepository.findById(id).orElse(null);
}

//serviço de salvar livro
public LivroDTO salvar(Livro livro) {
	Livro salvarLivro = livroRepository.save(livro);
	return new LivroDTO(salvarLivro.getId(), salvarLivro.getTitulo(), salvarLivro.getAutor());
}

//serviço de atualizar o livro
public LivroDTO atualizar(Long id, Livro livro) {
	Livro exiteLivro = livroRepository.findById(id)
			orElseThrow(() -> new RuntimeException("livro " + " não encontrado"));
	exiteLivro.setTitulo(livroGetTitulo());
	exiteLivro.setAutor(livro.getAutor());
	Livro updateLivro(updateLivro.getId(), updateLivro.getTitulo(), updateLivro.getAutor());
}

//serviço de deletar livro
public boolean deletar(Long id) {
	Optional<Livro> exiteLivro = livroRepository.findById(id);
	if (exiteLivro.isPresent()) {
		livroRepository.deleteById(id);
		return true;
	} else {
		return false;
	}
}