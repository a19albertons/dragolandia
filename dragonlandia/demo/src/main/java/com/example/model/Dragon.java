package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase que representa un Dragon en el sistema.
 */
@Entity
@Table(name = "dragones")
public class Dragon {
    /**
     * Identificado unico del dragon autoincremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Nombre del dragon
     */
    private String nombre;
    /**
     * Nivel de fuego del dragon
     */
    private int intensidadFuego;
    /**
     * Resistencia del dragon
     */
    private int resistencia;

    /**
     * Obtiene el nombre del dragon.
     * 
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del dragon.
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nivel de fuego del dragon.
     * 
     * @return
     */
    public int getIntensidadFuego() {
        return intensidadFuego;
    }

    /**
     * Establece el nivel de fuego del dragon.
     * 
     * @param nivelFuego
     */
    public void setIntensidadFuego(int nivelFuego) {
        this.intensidadFuego = nivelFuego;
    }

    /**
     * Obtiene la resistencia del dragon.
     * 
     * @return
     */
    public int getResistencia() {
        return resistencia;
    }

    /**
     * Establece la resistencia del dragon.
     * 
     * @param resistencia
     */
    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    /**
     * Constructor por defecto para hibernate
     */
    public Dragon() {
    }

    /**
     * Constructor parametrizado
     * 
     * @param nombre
     * @param nivelFuego
     * @param resistencia
     */
    public Dragon(String nombre, int nivelFuego, int resistencia) {
        this.nombre = nombre;
        this.intensidadFuego = nivelFuego;
        this.resistencia = resistencia;
    }

    public void exhalar(Monstruo monstruo) {
        monstruo.setVida(monstruo.getVida() - this.intensidadFuego);
    }
    
}
