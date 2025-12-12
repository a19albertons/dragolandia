package com.example.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Clase que representa un Bosque en el sistema.
 */
@Entity
@Table(name = "bosques")
public class Bosque {
    /**
     * Identificado unico del bosque autoincremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Nombre del bosque
     */
    private String nombre;
    /**
     * Nivel de peligro del bosque
     */
    private int nivelPeligro;
    /**
     * Monstruo jefe del bosque
     */
    @OneToOne
    private Monstruo monstruoJefe;

    /**
     * Lista de monstruos que habitan en el bosque
     */
    @OneToMany
    private List<Monstruo> listaMonstruos;

    /**
     * Obtiene el ID del bosque.
     * 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del bosque.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del bosque.
     * 
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del bosque.
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nivel de peligro del bosque.
     * 
     * @return
     */
    public int getNivelPeligro() {
        return nivelPeligro;
    }

    /**
     * Establece el nivel de peligro del bosque.
     * 
     * @param nivelPeligro
     */
    public void setNivelPeligro(int nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }

    /**
     * Obtiene el monstruo jefe del bosque.
     * 
     * @return
     */
    public Monstruo getMonstruoJefe() {
        return monstruoJefe;
    }

    /**
     * Establece el monstruo jefe del bosque.
     * 
     * @param monstruoJefe
     */
    public void setMonstruoJefe(Monstruo monstruoJefe) {
        this.monstruoJefe = monstruoJefe;
    }

    /**
     * Obtiene la lista de monstruos del bosque.
     * 
     * @return
     */
    public List<Monstruo> getListaMonstruos() {
        return listaMonstruos;
    }

    /**
     * Establece la lista de monstruos del bosque.
     * 
     * @param listaMonstruos
     */
    public void setListaMonstruos(List<Monstruo> listaMonstruos) {
        this.listaMonstruos = listaMonstruos;
    }

    /**
     * constructor vacio para el hibernatte
     */
    public Bosque() {
    }

    /**
     * Constructor con parametros para construir el objeto
     * 
     * @param nombre
     * @param nivelPeligro
     * @param monstruoJefe
     */
    public Bosque(String nombre, int nivelPeligro, Monstruo monstruoJefe) {
        this.nombre = nombre;
        this.nivelPeligro = nivelPeligro;
        this.monstruoJefe = monstruoJefe;
    }

    /**
     * Muestra por consola los datos del jefe
     */
    public void mostrarJefe() {
        System.out.println(monstruoJefe.toString());
    }

    /**
     * Metodo que cambia el jefe del bosque
     */
    public void cambiarJefe(Monstruo nuevoJefe) {
        this.monstruoJefe = nuevoJefe;
    }

    /**
     * Añade un monstruo a la lista de monstruos del bosque.
     * 
     * @param monstruo
     */
    public void addMonstruo(Monstruo monstruo) {
        this.listaMonstruos.add(monstruo);
    }

    /**
     * Mostramos los datos del bosque
     */
    @Override
    public String toString() {
        return "Bosque [id=" + id + ", nombre=" + nombre + ", nivelPeligro=" + nivelPeligro + ", monstruoJefe="
                + monstruoJefe + "]";
    }

}
