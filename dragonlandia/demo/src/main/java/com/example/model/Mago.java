package com.example.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Clase que representa un Mago en el sistema.
 */
@Entity
@Table(name = "magos")
public class Mago {
    /**
     * Identificado unico del mago autoincremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Nombre del mago
     */
    private String nombre;
    /**
     * Vida del mago
     */
    private int vida;
    /**
     * Nivel de magia del mago
     */
    private int nivelMagia;

    /**
     * Hechizos del mago
     */
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Hechizo> conjuros;

    /**
     * Obtiene el ID del mago.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del mago.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del mago.
     * 
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del mago.
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la vida del mago.
     * 
     * @return
     */
    public int getVida() {
        return vida;
    }

    /**
     * Establece la vida del mago.
     * 
     * @param vida
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * Obtiene el nivel de magia del mago.
     * 
     * @return
     */
    public int getNivelMagia() {
        return nivelMagia;
    }

    /**
     * Establece el nivel de magia del mago.
     * 
     * @param nivelMagia
     */
    public void setNivelMagia(int nivelMagia) {
        this.nivelMagia = nivelMagia;
    }

    /**
     * Obtiene los hechizos del mago.
     * 
     * @return
     */
    public List<Hechizo> getConjuros() {
        return conjuros;
    }

    /**
     * Establece los hechizos del mago.
     * 
     * @param hechizos
     */
    public void setConjuros(List<Hechizo> hechizos) {
        this.conjuros = hechizos;
    }

    /**
     * constructor vacio para el hibernatte
     */
    public Mago() {
    }

    /**
     * Constructor con parametros para añadir el objeto a la bd o hacer pruebas
     * 
     * @param nombre
     * @param vida
     * @param nivelMagia
     */
    public Mago(String nombre, int vida, int nivelMagia, List<Hechizo> conjuros) {
        this.nombre = nombre;
        this.vida = vida;
        this.nivelMagia = nivelMagia;
        this.conjuros = conjuros;
    }

    /**
     * Lanza un hechizo a un monstruo.
     * 
     * @param monstruo
     */
    public void lanzarHechizo(Monstruo monstruo) {
        monstruo.setVida(monstruo.getVida() - this.nivelMagia);
    }

    /**
     * Lanza un hechizo a un monstruo especificando el hechizo.
     * 
     * @param monstruo
     * @param hechizo
     */
    public void lanzarHechizo(Monstruo monstruo, Hechizo hechizo) {
        if (this.conjuros.contains(hechizo)) {
            monstruo.setVida(monstruo.getVida() - this.nivelMagia);
        } else {
            this.vida = this.vida - 1;
        }
    }

    /**
     * Mostramos los datos del mago
     */
    @Override
    public String toString() {
        return "Mago [id=" + id + ", nombre=" + nombre + ", vida=" + vida + ", nivelMagia=" + nivelMagia + ", conjuros="
                + conjuros.size() + "]";
    }

}
