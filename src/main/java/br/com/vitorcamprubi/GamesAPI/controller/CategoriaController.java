package br.com.vitorcamprubi.GamesAPI.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitorcamprubi.GamesAPI.dao.CategoriaDAO;
import br.com.vitorcamprubi.GamesAPI.model.Categoria;

@RestController
public class CategoriaController {
	
	@Autowired
	private CategoriaDAO dao;
	
	@GetMapping("/categoria")
	public ArrayList<Categoria> recuperarTodos() {
		ArrayList<Categoria> lista;
		lista = (ArrayList<Categoria>)dao.findAll();
		return lista;
	}
	
	@GetMapping("/categoria/{id}")
	public ResponseEntity<Categoria> recuperarPorId(@PathVariable int id) {
	    return dao.findById(id)
	            .map(ResponseEntity::ok)
	            .orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping("/categoria")
	public String cadastrarNovo(@RequestBody Categoria categoria) {
		System.out.println("Recebido: "+categoria.getId()+"/"+categoria.getNome());
		dao.save(categoria);
		return "Deu tudo certo";
	}
	
	@PutMapping("/categoria/{id}")
	public Categoria alterar(@PathVariable int id, @RequestBody Categoria categoria) {
	    categoria.setId(id);
	    return dao.save(categoria);
	}
	
	@DeleteMapping("/categoria/{id}")
	public ResponseEntity<Void> deletar(@PathVariable int id) {

	    if (!dao.existsById(id)) {
	        return ResponseEntity.notFound().build();
	    }

	    dao.deleteById(id);
	    return ResponseEntity.noContent().build();
	}

}