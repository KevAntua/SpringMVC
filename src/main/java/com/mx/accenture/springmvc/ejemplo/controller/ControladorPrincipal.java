package com.mx.accenture.springmvc.ejemplo.controller;

import com.mx.accenture.springmvc.ejemplo.dto.CursosDTO;
import com.mx.accenture.springmvc.ejemplo.service.ICursosService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
public class ControladorPrincipal{

    //@Autowired
    //CursosRepository cursosRepository;
    @Autowired
    private ICursosService cursosService;
    
    //@GetMapping({"/principal","/"})
    /*@GetMapping("/principal")
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
    }*/


    @GetMapping("/listar")
    public List<CursosDTO> listaRepository(Model model){
        log.info("Ejecutando controlador Spring MVC con lista dinamica de JPARepository");
        var mensajeSalidaJPA = "Mensaje desde el controlador con JPA";
        List<CursosDTO> listaRepository = cursosService.listarCursos();//new ArrayList();
        /*listaRepository.addAll(cursosService.listarCursos());
        var lista = cursosService.listarCursos();
        model.addAttribute("mensajeControllerJPA", mensajeSalidaJPA);
        model.addAttribute("listaBDH2", lista);*/
        return listaRepository;
    }

    @GetMapping("/eliminar/{id}")
    public void eliminarCurso (@PathVariable int id){
        log.info("Ejecutando controlador para eliminar del repository con Spring");
        cursosService.eliminarCurso(id);
    }
}
