package com.mx.accenture.springmvc.ejemplo.service;

import com.mx.accenture.springmvc.ejemplo.dao.CursosRepository;
import com.mx.accenture.springmvc.ejemplo.model.Cursos;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.Store;
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
    public Cursos guardarCourso(Cursos curso) {
        return cursosRepository.save(curso);
    }

    /*
    @Override
    public void eliminarCurso(Integer id){
        try {
            Optional<Cursos> course = cursosRepository.findById(id);
            courseRepository.deleteById(course.ge);
        } catch (StudentNotFoundException exception){
            throw exception;
        }
    }*/
    
}
