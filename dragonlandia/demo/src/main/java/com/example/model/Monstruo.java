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
     * @return id del monstruo
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del monstruo.
     * 
     * @param id id del monstruo
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del monstruo.
     * 
     * @return nombre del monstruo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del monstruo.
     * 
     * @param nombre nombre del monstruo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la vida del monstruo.
     * 
     * @return vida del monstruo
     */
    public int getVida() {
        return vida;
    }

    /**
     * Establece la vida del monstruo.
     * 
     * @param vida vida del monstruo
     */
    public void setVida(int vida) {
        if (vida < 0) {
            throw new IllegalArgumentException("La vida no puede ser negativa");    
        }
        this.vida = vida;
    }

    /**
     * Obtiene el tipo del monstruo.
     * 
     * @return tipo del monstruo
     */
    public TipoMonstruo getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo del monstruo.
     * 
     * @param tipo tipo del monstruo
     */
    public void setTipo(TipoMonstruo tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la fuerza del monstruo.
     * 
     * @return fuerza del monstruo
     */
    public int getFuerza() {
        return fuerza;
    }

    /**
     * Establece la fuerza del monstruo.
     * 
     * @param fuerza fuerza del monstruo
     */
    public void setFuerza(int fuerza) {
        if (fuerza < 0) {
            throw new IllegalArgumentException("La fuerza no puede ser negativa");
        }
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
     * @param nombre nombre del monstruo
     * @param vida vida del monstruo
     * @param tipo tener en cuenta el enum TipoMonstruo
     * @param fuerza fuerza del monstruo
     */
    public Monstruo(String nombre, int vida, TipoMonstruo tipo, int fuerza) {
        this.nombre = nombre;
        setVida(vida);
        this.tipo = tipo;
        setFuerza(fuerza);
    }

    /**
     * Metodo para que el monstruo ataque a un mago
     * 
     * @param mago mago al que ataca el monstruo
     */
    public void atacar(Mago mago) {
        mago.setVida(mago.getVida() - this.fuerza);
    }

    /**
     * Devuelve una string con los datos del monstruo
     * 
     * @return cadena con los datos del monstruo
     */
    @Override
    public String toString() {
        return "Monstruo [id=" + id + ", nombre=" + nombre + ", vida=" + vida + ", tipo=" + tipo + ", fuerza=" + fuerza
                + "]";
    }

}
