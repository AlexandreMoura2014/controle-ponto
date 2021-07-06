package com.dio.live.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.live.exception.NotFoundException;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;

@RestController
@RequestMapping("/Jornada")
public class JornadaTrabalhoController {

	@Autowired
	private JornadaService jornadaTrabalhoService;

	@GetMapping
	public ResponseEntity<List<JornadaTrabalho>> fndAll() {
		return ResponseEntity.ok(jornadaTrabalhoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Optional<JornadaTrabalho> jornadaExiste = jornadaTrabalhoService.getById(id);
		if (jornadaExiste.isPresent()) {
			return ResponseEntity.ok(jornadaExiste.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public JornadaTrabalho save(@RequestBody JornadaTrabalho jornadaTrabalho) {
		return jornadaTrabalhoService.save(jornadaTrabalho);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody JornadaTrabalho jornadaTrabalho) {
		Optional<JornadaTrabalho> jornadaAtual = jornadaTrabalhoService.getById(id);
		if (jornadaAtual.isPresent()) {
			BeanUtils.copyProperties(jornadaTrabalho, jornadaAtual.get(), "id");
			return ResponseEntity.ok(jornadaTrabalhoService.save(jornadaAtual.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<JornadaTrabalho> remover(@PathVariable Long id) {
		try {
			jornadaTrabalhoService.remover(id);
			return ResponseEntity.noContent().build();
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
