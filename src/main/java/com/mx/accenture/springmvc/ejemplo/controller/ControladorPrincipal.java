package com.mx.accenture.springmvc.ejemplo.controller;

import com.google.gson.Gson;
import com.mx.accenture.springmvc.ejemplo.model.Cursos;
import com.mx.accenture.springmvc.ejemplo.service.ICursosService;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
public class ControladorPrincipal{

    @Autowired
    private ICursosService cursosService;
    
    @GetMapping(value = {"/principal","/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String presentacion() {
        log.info("Ejecutando controlador Spring MVC");
        var mensajeSalida = "Mensaje desde el controlador";

        Cursos curso1 = new Cursos();
        curso1.setIdCurso(1);
        curso1.setNombreCurso("Fundamentos de Spring MVC");
        curso1.setTipoCurso("Tecnología");
        curso1.setNombreProfesor("Kevin");
        curso1.setNumeroAlumnos(100);
        curso1.setNumeroLecciones(1);

        Cursos curso2 = new Cursos();
        curso2.setIdCurso(2);
        curso2.setNombreCurso("Uso de Spring MVC");
        curso2.setTipoCurso("Tecnología");
        curso2.setNombreProfesor("Kevin");
        curso2.setNumeroAlumnos(50);
        curso2.setNumeroLecciones(5);

        List<Cursos> cursos1 = new ArrayList();

        List<Cursos> cursos = new ArrayList();
        cursos.add(curso1);
        cursos.add(curso2);

        String jsonResponse = new Gson().toJson(cursos);

        return jsonResponse;
    }

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public String listaRepository(){
        log.info("Ejecutando controlador Spring MVC con lista dinamica de JPARepository");

        List<Cursos> listaRepository = new ArrayList();
        listaRepository.addAll(cursosService.listarCursos());
        var lista = cursosService.listarCursos();

        String jsonResponse = new Gson().toJson(lista);

        return jsonResponse;
    }
}
