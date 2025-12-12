package com.example.controlador;

import com.example.model.Bosque;

/**
 * Clase que actua como controlador entre la vista y el modelo para el bosque.
 */
public class ControladorBosque {
    /**
     * Bosque que se usa en la vista
     */
    private Bosque bosque;

    /**
     * Obtiene el bosque.
     * 
     * @return
     */
    public Bosque getBosque() {
        return bosque;
    }

    /**
     * Establece el bosque.
     * 
     * @param bosque
     */
    public void setBosque(Bosque bosque) {
        this.bosque = bosque;
    }

}
