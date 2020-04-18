package com.curso.becas.entidades;

public class ReporteGeneral extends Alumno {
    private double puntajeFinal;

    public ReporteGeneral(double puntajeFinal) {
        this.puntajeFinal = puntajeFinal;
    }

    public ReporteGeneral(Long id, String dni, String nombre, int edad, String grado, double promedioPonderado, double notaEntrevista, String tipoUniversidad, double puntajeFinal) {
        super(id, dni, nombre, edad, grado, promedioPonderado, notaEntrevista, tipoUniversidad);
        this.puntajeFinal = puntajeFinal;
    }

    public double getPuntajeFinal() {
        return puntajeFinal;
    }

    public void setPuntajeFinal(double puntajeFinal) {
        this.puntajeFinal = puntajeFinal;
    }
}
