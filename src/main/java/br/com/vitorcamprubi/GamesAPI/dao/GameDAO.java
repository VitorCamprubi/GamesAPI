package br.com.vitorcamprubi.GamesAPI.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.vitorcamprubi.GamesAPI.model.Game;

public interface GameDAO extends CrudRepository<Game, Integer> {
	
	public List<Game> findByCategoriaId(int id);

}

