package com.cibertec.examen.service.impl;

import com.cibertec.examen.model.Alumno;
import com.cibertec.examen.repository.IAlumnoRepository;
import com.cibertec.examen.service.IAlumnoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    private IAlumnoRepository repo;

    @Override
    public List<Alumno> listarAlumnos() {
        return repo.findAll();
    }

    @Override
    public Alumno guardar(Alumno alumno) {
        return repo.save(alumno);
    }

    @Override
    public Alumno actualizar(Long id,Alumno alumno) {
        if (repo.findById(id).isPresent()) {
            return repo.save(alumno);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Alumno buscarPorId(Long id) {
        return repo.findById(id).get();
    }
}
