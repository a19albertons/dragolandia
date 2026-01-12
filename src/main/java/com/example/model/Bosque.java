package com.example.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    @OneToMany(fetch = FetchType.EAGER)
    private List<Monstruo> listaMonstruos;

    /**
     * Dragon que habita en el bosque
     */
    @OneToOne
    private Dragon dragon;

    /**
     * Obtiene el ID del bosque.
     * 
     * @return id del bosque
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del bosque.
     * 
     * @param id id a establecer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del bosque.
     * 
     * @return nombre del bosque
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del bosque.
     * 
     * @param nombre nombre a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nivel de peligro del bosque.
     * 
     * @return nivel de peligro del bosque
     */
    public int getNivelPeligro() {
        return nivelPeligro;
    }

    /**
     * Establece el nivel de peligro del bosque.
     * 
     * @param nivelPeligro nivel de peligro a establecer
     */
    public void setNivelPeligro(int nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }

    /**
     * Obtiene el monstruo jefe del bosque.
     * 
     * @return monstruo jefe del bosque
     */
    public Monstruo getMonstruoJefe() {
        return monstruoJefe;
    }

    /**
     * Establece el monstruo jefe del bosque.
     * 
     * @param monstruoJefe monstruo jefe a establecer
     */
    public void setMonstruoJefe(Monstruo monstruoJefe) {
        this.monstruoJefe = monstruoJefe;
    }

    /**
     * Obtiene la lista de monstruos del bosque.
     * 
     * @return lista de monstruos del bosque
     */
    public List<Monstruo> getListaMonstruos() {
        return listaMonstruos;
    }

    /**
     * Establece la lista de monstruos del bosque.
     * 
     * @param listaMonstruos lista de monstruos a establecer
     */
    public void setListaMonstruos(List<Monstruo> listaMonstruos) {
        this.listaMonstruos = listaMonstruos;
    }

    /**
     * Obtiene el dragon del bosque.
     * 
     * @return dragon del bosque
     */
    public Dragon getDragon() {
        return dragon;
    }

    /**
     * Establece el dragon del bosque.
     * 
     * @param dragon dragon a establecer
     */
    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    /**
     * constructor vacio para el hibernatte
     */
    public Bosque() {
    }

    /**
     * Constructor con parametros para construir el objeto
     * 
     * @param nombre nombre del bosque
     * @param nivelPeligro nivel de peligro del bosque
     * @param monstruoJefe monstruo jefe del bosque
     * @param listaMonstruos lista de monstruos del bosque
     * @param dragon dragon del bosque
     */
    public Bosque(String nombre, int nivelPeligro, Monstruo monstruoJefe, List<Monstruo> listaMonstruos,
            Dragon dragon) {
        this.nombre = nombre;
        this.nivelPeligro = nivelPeligro;
        this.monstruoJefe = monstruoJefe;
        this.listaMonstruos = listaMonstruos;
        this.dragon = dragon;
    }

    /**
     * Muestra por consola los datos del jefe
     */
    public void mostrarJefe() {
        System.out.println(monstruoJefe.toString());
    }

    /**
     * Metodo que cambia el jefe del bosque
     * 
     * @param nuevoJefe nuevo jefe del bosque
     */
    public void cambiarJefe(Monstruo nuevoJefe) {
        this.monstruoJefe = nuevoJefe;
    }

    /**
     * Añade un monstruo a la lista de monstruos del bosque.
     * 
     * @param monstruo monstruo a añadir
     */
    public void addMonstruo(Monstruo monstruo) {
        this.listaMonstruos.add(monstruo);
    }

    /**
     * Mostramos los datos del bosque
     * 
     * @return cadena con los datos del bosque
     */
    @Override
    public String toString() {
        return "Bosque [id=" + id + ", nombre=" + nombre + ", nivelPeligro=" + nivelPeligro + ", monstruoJefe="
                + monstruoJefe + ", listaMonstruos=" + listaMonstruos + ", dragon=" + dragon + "]";
    }

}
