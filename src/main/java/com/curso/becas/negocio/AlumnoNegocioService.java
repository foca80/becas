package com.curso.becas.negocio;

import com.curso.becas.entidades.Alumno;
import com.curso.becas.entidades.ReporteGeneral;
import com.curso.becas.repositorio.AlumnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoNegocioService {
    @Autowired
    private AlumnoRepositorio alumnoRepositorio;

    public Alumno registrar(Alumno alumno) {
        return alumnoRepositorio.save(alumno);
    }

    public double calcularPuntaje(Alumno alumno) {
        double puntos;
        puntos = alumno.getNotaEntrevista() * 0.6 + alumno.getPromedioPonderado() * 0.4;
        if (alumno.getTipoUniversidad().equals("Publica")) {
            puntos++;
        }
        return puntos;
    }

    public double obtenerPuntajeFinal(String dni) {
        Alumno alumno;
        alumno = alumnoRepositorio.buscarAlumno(dni);
        return calcularPuntaje(alumno);
    }

    public List<ReporteGeneral> obtenerResultadosGenerales() {
        List<ReporteGeneral> listado =
                (List<ReporteGeneral>) alumnoRepositorio.obtenerReporteGeneral();
        Alumno alumno = new Alumno();
        double puntos;
        for (ReporteGeneral rep : listado) {
            alumno.setNotaEntrevista(rep.getNotaEntrevista());
            alumno.setPromedioPonderado(rep.getPromedioPonderado());
            alumno.setTipoUniversidad(rep.getTipoUniversidad());
            puntos = calcularPuntaje(alumno);
            rep.setPuntajeFinal(puntos);
        }
        return listado;
    }

    public Alumno actualizarNotaEntrevista(Alumno alumno) {
        Alumno a = null;
        a = alumnoRepositorio.buscarAlumno(alumno.getDni());
        if (a != null) {
            a.setNotaEntrevista(alumno.getNotaEntrevista());
            alumnoRepositorio.save(a);
        }
        return a;
    }

}
