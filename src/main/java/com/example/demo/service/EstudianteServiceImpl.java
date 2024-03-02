package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void guardar(EstudianteTO estudianteTO) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(this.conversion(estudianteTO));
	}

	@Override
	public List<EstudianteTO> buscarTodos() {
		// TODO Auto-generated method stub
		List<Estudiante> lista = this.estudianteRepository.seleccionarTodos("M");
		List<EstudianteTO> listaFinal = new ArrayList<>();
		for (Estudiante est : lista) {
			listaFinal.add(this.convertir(est));
		}
		return listaFinal;
	}

	private EstudianteTO convertir(Estudiante estudiante) {
		EstudianteTO estuTO = new EstudianteTO();
		estuTO.setApellido(estudiante.getApellido());
		estuTO.setId(estudiante.getId());
		estuTO.setNombre(estudiante.getNombre());
		estuTO.setCedula(estudiante.getCedula());
		return estuTO;
	}

	public Estudiante conversion(EstudianteTO estudiante) {
		Estudiante estu = new Estudiante();
		estu.setApellido(estudiante.getApellido());
		estu.setNombre(estudiante.getNombre());
		estu.setId(estudiante.getId());
		estu.setCedula(estudiante.getCedula());
		return estu;
	}

}
