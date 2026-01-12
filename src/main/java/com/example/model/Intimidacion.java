package com.example.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

/**
 * Clase que representa un hechizo de Intimidación.
 */
@Entity
@DiscriminatorValue("INTIMIDACION")
public class Intimidacion extends Hechizo {

    /**
     * Aplica el efecto de Intimidación a una lista de monstruos.
     */
    @Override
    public void efecto(List<Monstruo> objetivos) {
        for (Monstruo monstruo : objetivos) {
            monstruo.setFuerza(monstruo.getFuerza()/2);
        }
    }

    
}
