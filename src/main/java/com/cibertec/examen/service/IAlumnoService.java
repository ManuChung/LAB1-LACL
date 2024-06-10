package com.cibertec.examen.service;

import com.cibertec.examen.model.Alumno;

import java.util.List;

public interface IAlumnoService {

    List<Alumno> listarAlumnos();

    Alumno guardar(Alumno alumno);

    Alumno actualizar(Long id,Alumno alumno);

    void eliminar(Long id);

    Alumno buscarPorId(Long id);

}
