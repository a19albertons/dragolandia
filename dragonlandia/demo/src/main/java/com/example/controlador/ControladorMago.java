package com.example.controlador;

import com.example.model.Mago;

/**
 * Clase que actua como controlador entre la vista y el modelo para el mago.
 */
public class ControladorMago {
    /**
     * Mago que se usa en la vista
     */
    private Mago mago;

    /**
     * Obtiene el mago.
     * 
     * @return
     */
    public Mago getMago() {
        return mago;
    }

    /**
     * Establece el mago.
     * 
     * @param mago
     */
    public void setMago(Mago mago) {
        this.mago = mago;
    }

    /**
     * Verifica si el mago tiene vida.
     * 
     * @return
     */
    public boolean magoTieneVida() {
        return this.mago.getVida() > 0;
    }

}
