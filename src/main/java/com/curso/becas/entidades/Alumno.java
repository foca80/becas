package com.curso.becas.entidades;

import javax.persistence.*;

@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String dni;
    private String nombre;
    private int edad;
    private String grado;
    private double promedioPonderado;
    private double notaEntrevista;
    private String tipoUniversidad;

    public Alumno() {
    }

    public Alumno(Long id, String dni, String nombre, int edad, String grado, double promedioPonderado, double notaEntrevista, String tipoUniversidad) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.grado = grado;
        this.promedioPonderado = promedioPonderado;
        this.notaEntrevista = notaEntrevista;
        this.tipoUniversidad = tipoUniversidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public double getPromedioPonderado() {
        return promedioPonderado;
    }

    public void setPromedioPonderado(double promedioPonderado) {
        this.promedioPonderado = promedioPonderado;
    }

    public double getNotaEntrevista() {
        return notaEntrevista;
    }

    public void setNotaEntrevista(double notaEntrevista) {
        this.notaEntrevista = notaEntrevista;
    }

    public String getTipoUniversidad() {
        return tipoUniversidad;
    }

    public void setTipoUniversidad(String tipoUniversidad) {
        this.tipoUniversidad = tipoUniversidad;
    }
}
