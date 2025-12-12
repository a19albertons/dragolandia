package com.example.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

/**
 * Clase que representa un Rayo como hechizo.
 */
@Entity
@DiscriminatorValue("RAYO")
public class Rayo extends Hechizo {

    /**
     * Aplica el efecto del Rayo a una lista de monstruos.
     */
    @Override
    public void efecto(List<Monstruo> objetivos) {
        if (objetivos.size() == 1) {
            Monstruo monstruo = objetivos.get(0);
            monstruo.setVida(monstruo.getVida() - 100);
        }
        else {
            throw new IllegalArgumentException("El hechizo Rayo solo puede aplicarse a un objetivo.");
        }
    }
    
}
