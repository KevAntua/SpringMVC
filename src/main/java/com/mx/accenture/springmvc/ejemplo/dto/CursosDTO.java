package com.mx.accenture.springmvc.ejemplo.dto;

import javax.persistence.Column;
import java.io.Serializable;

public class CursosDTO implements Serializable {
    private String nombreCurso;
    private String tipoCurso;
    private String nombreProfesor;
    private int numeroAlumnos;
    private int numeroLecciones;

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    private int idCurso;

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public int getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public void setNumeroAlumnos(int numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    public int getNumeroLecciones() {
        return numeroLecciones;
    }

    public void setNumeroLecciones(int numeroLecciones) {
        this.numeroLecciones = numeroLecciones;
    }

    public CursosDTO(int idCurso, String nombreCurso, String tipoCurso, String nombreProfesor, int numeroAlumnos, int numeroLecciones) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.tipoCurso = tipoCurso;
        this.nombreProfesor = nombreProfesor;
        this.numeroAlumnos = numeroAlumnos;
        this.numeroLecciones = numeroLecciones;

    }
}


