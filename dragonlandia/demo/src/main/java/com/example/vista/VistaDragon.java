package com.example.vista;

import java.util.Scanner;

import com.example.controlador.Controlador;

public class VistaDragon {

    /**
     * Controlador que maneja la lógica del dragón
     */
    Controlador controlador;

    /**
     * Scanner para leer la entrada del usuario
     */
    Scanner scanner;

    /**
     * Constructor de la vista del dragón
     * 
     * @param controlador
     * @param scanner
     */
    public VistaDragon(Controlador controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
    }

} 
