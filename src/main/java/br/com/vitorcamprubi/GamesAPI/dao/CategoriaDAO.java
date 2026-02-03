package br.com.vitorcamprubi.GamesAPI.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.vitorcamprubi.GamesAPI.model.Categoria;

public interface CategoriaDAO extends CrudRepository<Categoria, Integer> {

}
