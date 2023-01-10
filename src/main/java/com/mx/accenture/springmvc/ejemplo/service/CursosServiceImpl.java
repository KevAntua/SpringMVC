package com.mx.accenture.springmvc.ejemplo.service;

import com.mx.accenture.springmvc.ejemplo.dao.CursosRepository;
import com.mx.accenture.springmvc.ejemplo.model.Cursos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursosServiceImpl implements ICursosService{

    @Autowired
    private CursosRepository cursosRepository;

    @Override
    public List<Cursos> listarCursos() {
        return (List<Cursos>) cursosRepository.findAll();
    }

    @Override
    public void eliminarCurso(int idCurso) {
        cursosRepository.deleteById(idCurso);
    }

}