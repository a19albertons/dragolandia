package com.example.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

/**
 * Clase que representa una Bola de Fuego como hechizo.
 */
@Entity
@DiscriminatorValue("BOLA_FUEGO")
public class BolaFuego extends Hechizo {

    /**
     * Aplica el efecto de la Bola de Fuego a una lista de monstruos.
     */
    @Override
    public void efecto(List<Monstruo> objetivos) {
        for (Monstruo monstruo : objetivos) {
            monstruo.setVida(monstruo.getVida() - 50);
        }
    }
    
}
