package com.curso.becas;

import com.curso.becas.entidades.Alumno;
import com.curso.becas.entidades.ReporteGeneral;
import com.curso.becas.negocio.AlumnoNegocioService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BecasApplicationTests {

    @Autowired
    private AlumnoNegocioService alumnoNegocioService;

    @Test
    public void probarRegistro() {
        Alumno alumno = new Alumno();
        alumno.setDni("99999999");
        alumno.setEdad(31);
        alumno.setGrado("Magister");
        alumno.setNombre("Ana");
        alumno.setNotaEntrevista(18);
        alumno.setPromedioPonderado(18);
        alumno.setTipoUniversidad("Publica");
        Alumno a;
        a = alumnoNegocioService.registrar(alumno);
        Assert.assertNotNull(a);

    }

    @Test
    public void probarPuntaje() {
        double puntos;
        puntos = alumnoNegocioService.obtenerPuntajeFinal("99999999");
        Assert.assertEquals(19, puntos, 0.00);

    }

    @Test
    public void probarReporteFinal() {
        List<ReporteGeneral> reporte;
        reporte = alumnoNegocioService.obtenerResultadosGenerales();
        for (ReporteGeneral rep : reporte) {
            System.out.println(rep.getNombre() + "  " + rep.getPuntajeFinal());
        }
        Assert.assertNotNull(reporte);
    }

    @Test
    public void probarActualizarAlumno() {
        Alumno alumno = new Alumno();
        alumno.setDni("99999999");
        alumno.setNotaEntrevista(20);//nueva nota
        Alumno respuesta = null;
        respuesta = alumnoNegocioService.actualizarNotaEntrevista(alumno);
        Assert.assertNotNull(respuesta);
    }

}
