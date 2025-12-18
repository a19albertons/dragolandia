package com.example.vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.controlador.Controlador;
import com.example.model.Bosque;
import com.example.model.Hechizo;
import com.example.model.Mago;
import com.example.model.Monstruo;
import com.example.model.TipoMonstruo;

/**
 * Clase principal de la vista que interactúa con el usuario.
 */
public class Vista {
    /**
     * Controlador que maneja la lógica del juego
     */
    Controlador controlador = new Controlador();
    /**
     * Scanner para leer la entrada del usuario
     */
    Scanner scanner = new Scanner(System.in);
    /**
     * Vista de Mago
     */
    private VistaMago vistaMago;

    /**
     * Vista del Monstruo
     */
    private VistaMonstruo vistaMonstruo;
    /**
     * Vista del Dragon
     */
    private VistaDragon vistaDragon;

    /**
     * Vista del Bosque
     */
    private VistaBosque vistaBosque;

    /**
     * Vista de la Batalla
     */
    private VistaBatalla vistaBatalla;

    /**
     * Constructor de la vista
     */
    public Vista() {
        this.vistaMago = new VistaMago(controlador, scanner);
        this.vistaMonstruo = new VistaMonstruo(controlador, scanner);
        this.vistaDragon = new VistaDragon(controlador, scanner);
        this.vistaBosque = new VistaBosque(controlador, scanner);
        this.vistaBatalla = new VistaBatalla(controlador, scanner);

    }

    public void bienvenida() {
        System.out.println("Bienvenido a Dragonlandia!");
    }

    public static void main(String[] args) {

        try {





        } catch (NumberFormatException nfe) {
            // Indicaciones sobre la causa/origen del error de formato numérico
            System.out.println("Error: Formato numérico incorrecto.");
            System.out.println(nfe.getMessage());
        } catch (Exception e) {
            // Indicaciones sobre la causa/origen del error generales
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
    }

}