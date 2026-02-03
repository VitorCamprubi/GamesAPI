package br.com.vitorcamprubi.GamesAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitorcamprubi.GamesAPI.dao.GameDAO;
import br.com.vitorcamprubi.GamesAPI.model.Game;

@RestController
public class GameController {
	
	@Autowired
	private GameDAO dao;
	
	@GetMapping("/game")
	public ArrayList<Game> recuperarTodos() {
		ArrayList<Game> lista;
		lista = (ArrayList<Game>)dao.findAll();
		return lista;
	}
	
	@GetMapping("/game/categoria/{id}")
	public List<Game> recuperarPorCateg(@PathVariable int id) {
		return dao.findByCategoriaId(id);
	}
	
	@GetMapping("/game/{id}")
	public ResponseEntity<Game> recuperarPorId(@PathVariable int id) {
	    return dao.findById(id)
	            .map(ResponseEntity::ok)
	            .orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping("/game")
	public String cadastrarNovo(@RequestBody Game game) {
		System.out.println("Recebido: "+game.getId()+"/"+game.getNome()+"/"+game.getNome()+"/"+game.getDescricao()+"/"+game.getCategoria()+"/"+game.getRanking());
		dao.save(game);
		return "Deu tudo certo";
	}
	
	@PutMapping("/game/{id}")
	public Game alterar(@PathVariable int id, @RequestBody Game game) {
	    game.setId(id);
	    return dao.save(game);
	}
	
	@DeleteMapping("/game/{id}")
	public ResponseEntity<Void> deletar(@PathVariable int id) {

	    if (!dao.existsById(id)) {
	        return ResponseEntity.notFound().build();
	    }

	    dao.deleteById(id);
	    return ResponseEntity.noContent().build();
	}

}
