package com.cibertec.examen.rest;

import com.cibertec.examen.model.Alumno;
import com.cibertec.examen.service.IAlumnoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/api/cibertec/alumno")
public class AlumnoController {

    @Autowired
    private IAlumnoService service;

    @GetMapping
    public List<Alumno> getAllAlumnos() {
        return service.listarAlumnos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        return  ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno) {
        ZoneId zonaLima = ZoneId.of("America/Lima");
        LocalDateTime fechaActualLima = LocalDateTime.now(zonaLima);

        alumno.setFechaCreacion(fechaActualLima);
        Alumno savedAlumno = service.guardar(alumno);
        return ResponseEntity.status(201).body(savedAlumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        Alumno updatedAlumno = service.actualizar(id, alumno);
        return ResponseEntity.ok().body(updatedAlumno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
