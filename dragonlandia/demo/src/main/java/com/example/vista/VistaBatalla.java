package com.example.vista;

import java.util.Scanner;

import com.example.controlador.Controlador;

public class VistaBatalla {

    /**
     * Controlador que maneja la lógica de la batalla
     */
    Controlador controlador;

    /**
     * Scanner para leer la entrada del usuario
     */
    Scanner scanner;

    /**
     * Constructor de la vista de la batalla
     * 
     * @param controlador
     * @param scanner
     */
    public VistaBatalla(Controlador controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
    }

} 
