package com.example;

import com.example.controlador.Controlador;

/**
 * Clase principal de la aplicación Dragonlandia.
 */
public class App {
    /**
     * Método principal que inicia la aplicación.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.iniciarJuego();
    }
}
