package com.mx.accenture.springmvc.ejemplo.service;

import com.mx.accenture.springmvc.ejemplo.model.Cursos;
import java.util.List;

public interface ICursosService {

    public List<Cursos> listarCursos();

    public void eliminarCurso (int idCurso);

}