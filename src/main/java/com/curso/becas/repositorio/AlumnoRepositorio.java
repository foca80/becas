package com.curso.becas.repositorio;

import com.curso.becas.entidades.Alumno;
import com.curso.becas.entidades.ReporteGeneral;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AlumnoRepositorio extends CrudRepository<Alumno, Long> {
    @Query("SELECT a FROM Alumno a WHERE a.dni=:dni")
    public Alumno buscarAlumno(@Param("dni") String dni);

    @Query("SELECT new com.curso.becas.entidades.ReporteGeneral(a.id, " +
            "a.dni, a.nombre, a.edad, a.grado, a.promedioPonderado, a.notaEntrevista," +
            "a.tipoUniversidad, 0.00 ) FROM Alumno a")
    public Iterable<ReporteGeneral> obtenerReporteGeneral();
}
