package com.mx.accenture.springmvc.ejemplo.service;

import com.mx.accenture.springmvc.ejemplo.dto.CursosDTO;

import java.util.List;

public interface ICursosService {

    public List<CursosDTO> listarCursos();

    public void eliminarCurso (int idCurso);

}