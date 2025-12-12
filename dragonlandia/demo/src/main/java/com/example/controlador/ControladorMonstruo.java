package com.example.controlador;

import com.example.model.Monstruo;

/**
 * Clase que actua como controlador entre la vista y el modelo para el monstruo.
 */
public class ControladorMonstruo {

    /**
     * Monstruo que se usa en la vista
     */
    private Monstruo monstruo;

    /**
     * Obtiene el monstruo.
     * 
     * @return
     */
    public Monstruo getMonstruo() {
        return monstruo;
    }

    /**
     * Establece el monstruo.
     * 
     * @param monstruo
     */
    public void setMonstruo(Monstruo monstruo) {
        this.monstruo = monstruo;
    }

    /**
     * Verifica si el monstruo tiene vida.
     * 
     * @return
     */
    public boolean monstruoTieneVida() {
        return this.monstruo.getVida() > 0;
    }


}
