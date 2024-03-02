package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {
	// CRUD
	// Create, Read, Uopdate, Delete
	public void guardar(EstudianteTO estudianteTO);

	public List<EstudianteTO> buscarTodos();

}
