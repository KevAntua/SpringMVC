package com.mx.accenture.springmvc.ejemplo.controller;

import com.mx.accenture.springmvc.ejemplo.model.Cursos;
import com.mx.accenture.springmvc.ejemplo.service.ICursosService;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


@Slf4j
@RestController
@RequestMapping("/")
public class ControladorPrincipal{

    @Autowired
    private ICursosService cursosService;
    
    //@GetMapping({"/principal","/"})
    @GetMapping("/principal")
    public String presentacion(Model model) {
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

        List<Cursos> cursos = new ArrayList();
        cursos.add(curso1);
        cursos.add(curso2);
        
        model.addAttribute("mensajeController", mensajeSalida);
      //model.addAttribute("objetocurso1", curso1);
        model.addAttribute("listaPersonas", cursos);


        //return cursos.toString();
        return mensajeSalida;
    }

    @GetMapping("/listar")
    public String listaRepository(Model model){
        log.info("Ejecutando controlador Spring MVC con lista dinamica de JPARepository");
        var mensajeSalidaJPA = "Mensaje desde el controlador con JPA";
        List<Cursos> listaRepository = new ArrayList();
        listaRepository.addAll(cursosService.listarCursos());
        var lista = cursosService.listarCursos();
        model.addAttribute("mensajeControllerJPA", mensajeSalidaJPA);
        model.addAttribute("listaBDH2", lista);

        Integer test = Integer.valueOf(lista.size());
        return "viewJPARepository Number of rows-->"+test;
    }

    /*@PostMapping("/agregarCurso")
    @ResponseStatus(HttpStatus.CREATED)
    public Course addCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
        void addCourse (@RequestBody Course course){
            courseServiceImpl.saveCourse(course);
        }
    }*/
}
