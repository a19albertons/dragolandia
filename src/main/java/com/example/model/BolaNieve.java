package com.example.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

/**
 * Clase que representa una Bola de Nieve como hechizo.
 */
@Entity
@DiscriminatorValue("BOLA_NIEVE")
public class BolaNieve extends Hechizo{

    /**
     * Aplica el efecto de la Bola de Nieve a una lista de monstruos.
     */
    @Override
    public void efecto(List<Monstruo> objetivos) {
        if (objetivos.size() == 1) {
            Monstruo monstruo = objetivos.get(0);
            monstruo.setVida(0);
        }
        else {
            throw new IllegalArgumentException("El hechizo Bola de Nieve solo puede aplicarse a un objetivo.");
            
        }
    }
    
}
