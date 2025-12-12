package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase que representa un Monstruo en el sistema.
 */
@Entity
@Table(name = "monstruos")
public class Monstruo {
    /**
     * Identificado unico del monstruo autoincremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Nombre del monstruo
     */
    private String nombre;
    /**
     * Vida del monstruo
     */
    private int vida;
    /**
     * Tipo del monstruo
     */
    
    private TipoMonstruo tipo;
    /**
     * Fuerza del monstruo
     */
    private int fuerza;

    /**
     * Obtiene el ID del monstruo.
     * 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del monstruo.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del monstruo.
     * 
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del monstruo.
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la vida del monstruo.
     * 
     * @return
     */
    public int getVida() {
        return vida;
    }

    /**
     * Establece la vida del monstruo.
     * 
     * @param vida
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * Obtiene el tipo del monstruo.
     * 
     * @return
     */
    public TipoMonstruo getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo del monstruo.
     * 
     * @param tipo
     */
    public void setTipo(TipoMonstruo tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la fuerza del monstruo.
     * 
     * @return
     */
    public int getFuerza() {
        return fuerza;
    }

    /**
     * Establece la fuerza del monstruo.
     * 
     * @param fuerza
     */
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    /**
     * constructor vacio para el hibernatte
     */
    public Monstruo() {
    }

    /**
     * Constructor con parametros para añadir el objeto a la bd o hacer pruebas
     * 
     * @param nombre
     * @param vida
     * @param tipo tener en cuenta el enum TipoMonstruo
     * @param fuerza
     */
    public Monstruo(String nombre, int vida, TipoMonstruo tipo, int fuerza) {
        this.nombre = nombre;
        this.vida = vida;
        this.tipo = tipo;
        this.fuerza = fuerza;
    }

    /**
     * Metodo para que el monstruo ataque a un mago
     * 
     * @param mago
     */
    public void atacar(Mago mago) {
        mago.setVida(mago.getVida() - this.fuerza);
    }

    /**
     * Devuelve una string con los datos del monstruo
     */
    @Override
    public String toString() {
        return "Monstruo [id=" + id + ", nombre=" + nombre + ", vida=" + vida + ", tipo=" + tipo + ", fuerza=" + fuerza
                + "]";
    }

}
