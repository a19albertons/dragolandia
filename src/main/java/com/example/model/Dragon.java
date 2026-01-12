package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
     * Bosque donde habita el dragon
     */
    @OneToOne
    private Bosque bosqueHabita;

    /**
     * Obtiene el id del dragon.
     * 
     * @return id del dragon
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id del dragon.
     * 
     * @param id id del dragon
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del dragon.
     * 
     * @return nombre del dragon
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del dragon.
     * 
     * @param nombre nombre del dragon
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nivel de fuego del dragon.
     * 
     * @return nivel de fuego del dragon
     */
    public int getIntensidadFuego() {
        return intensidadFuego;
    }

    /**
     * Establece el nivel de fuego del dragon.
     * 
     * @param nivelFuego nivel de fuego del dragon
     */
    public void setIntensidadFuego(int nivelFuego) {
        this.intensidadFuego = nivelFuego;
    }

    /**
     * Obtiene la resistencia del dragon.
     * 
     * @return resistencia del dragon
     */
    public int getResistencia() {
        return resistencia;
    }

    /**
     * Establece la resistencia del dragon.
     * 
     * @param resistencia resistencia del dragon
     */
    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    /**
     * Obtiene el bosque donde habita el dragon.
     * 
     * @return bosque donde habita el dragon
     */
    public Bosque getBosqueHabita() {
        return bosqueHabita;
    }

    /**
     * Establece el bosque donde habita el dragon.
     * 
     * @param bosqueHabita bosque donde habita el dragon
     */
    public void setBosqueHabita(Bosque bosqueHabita) {
        this.bosqueHabita = bosqueHabita;
    }

    /**
     * Constructor por defecto para hibernate
     */
    public Dragon() {
    }

    /**
     * Constructor parametrizado
     * 
     * @param nombre      nombre del dragon
     * @param nivelFuego  nivel de fuego del dragon
     * @param resistencia resistencia del dragon
     * @param bosqueHabita bosque donde habita el dragon
     */
    public Dragon(String nombre, int nivelFuego, int resistencia, Bosque bosqueHabita) {
        this.nombre = nombre;
        this.intensidadFuego = nivelFuego;
        this.resistencia = resistencia;
        this.bosqueHabita = bosqueHabita;
    }

    /**
     * Ataque del dragon
     * 
     * @param monstruo monstruo a atacar
     */
    public void exhalar(Monstruo monstruo) {
        if (monstruo.getVida() < this.intensidadFuego) {
            monstruo.setVida(0);
        } else {
            monstruo.setVida(monstruo.getVida() - this.intensidadFuego);
        }
    }

    /**
     * Mostramos los datos del dragon
     * 
     * @return cadena con los datos del dragon
     */
    @Override
    public String toString() {
        return "Dragon [id=" + id + ", nombre=" + nombre + ", intensidadFuego=" + intensidadFuego + ", resistencia="
                + resistencia + ", bosqueHabita=" + bosqueHabita + "]";
    }

}
