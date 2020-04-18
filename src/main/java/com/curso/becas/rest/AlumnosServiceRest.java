package com.curso.becas.rest;

import com.curso.becas.entidades.Alumno;
import com.curso.becas.entidades.ReporteGeneral;
import com.curso.becas.negocio.AlumnoNegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlumnosServiceRest {
    @Autowired
    private AlumnoNegocioService alumnoNegocioService;

    @GetMapping("/alumno/{dni}")
    public double obtenerPuntajeFinal(@PathVariable(value = "dni") String dni) {
        return alumnoNegocioService.obtenerPuntajeFinal(dni);
    }

    @GetMapping("/alumnos")
    public List<ReporteGeneral> obtenReporteGeneral() {
        return alumnoNegocioService.obtenerResultadosGenerales();
    }

    @PostMapping("/alumno")
    public Alumno actualizarNotaEntrevista(@RequestBody Alumno alumno) {
        return alumnoNegocioService.actualizarNotaEntrevista(alumno);
    }

    @PostMapping("/alumnoNuevo")
    public Alumno registrar(@RequestBody Alumno alumno) throws Exception {
        try {
            return alumnoNegocioService.registrar(alumno);
        } catch (RuntimeException e) {
            throw new Exception("Error de Registrar!!!");
        }
    }
}
