package com.mx.accenture.springmvc.ejemplo.dao;

import com.mx.accenture.springmvc.ejemplo.model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosRepository extends JpaRepository <Cursos, Integer> {

}
