package com.mx.accenture.springmvc.ejemplo.service;

import com.mx.accenture.springmvc.ejemplo.dao.CursosRepository;
import com.mx.accenture.springmvc.ejemplo.dto.CursosDTO;
import com.mx.accenture.springmvc.ejemplo.model.Cursos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class CursosServiceImpl implements ICursosService{

    @Autowired
    private CursosRepository cursosRepository;

    public List<CursosDTO> listarCursos() {
        List<Cursos> cursos = cursosRepository.findAll();
        List<CursosDTO> customersDTO=cursos.stream()
                .map((customer)-> mapCursosToCursosDTO(customer))
                .collect(Collectors.toList());
        return customersDTO;
    }

    @Override
    public void eliminarCurso(int idCurso) {
        cursosRepository.deleteById(idCurso);
    }


    /***
     *  Map a Customer Object into A costumerDTO object (hidden fields )
     * @param curso object to be mapped
     * @return A CursosDTO Object
     */
    private CursosDTO mapCursosToCursosDTO(Cursos curso){
        CursosDTO filteredCustomer = new CursosDTO(curso.getIdCurso(), curso.getNombreCurso(), curso.getTipoCurso(),
                curso.getNombreProfesor(), curso.getNumeroAlumnos(), curso.getNumeroLecciones());
        return filteredCustomer;
    }

}