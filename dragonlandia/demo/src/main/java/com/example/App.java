package com.example;

import com.example.controlador.Controlador;

/**
 * Clase principal de la aplicación Dragonlandia.
 */
public class App {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.iniciarJuego();
    }
}
