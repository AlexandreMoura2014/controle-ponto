package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dio.live.exception.NotFoundException;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaRepository;

@Service
public class JornadaService {

	@Autowired
	private JornadaRepository jornadaTrabalhoRepository;

	public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho) {
		return jornadaTrabalhoRepository.save(jornadaTrabalho);
	}

	public List<JornadaTrabalho> findAll() {
		return jornadaTrabalhoRepository.findAll();
	}

	public Optional<JornadaTrabalho> getById(Long id) {
		return jornadaTrabalhoRepository.findById(id);
	}

	public void remover(Long id) {
		try {
			jornadaTrabalhoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException();
		}
	}

}
