package com.example.vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.controlador.Controlador;
import com.example.model.Hechizo;
import com.example.model.Mago;

public class VistaMago {
    /**
     * Controlador que maneja la lógica del mago
     */
    Controlador controlador;
    /**
     * Scanner para leer la entrada del usuario
     */
    Scanner scanner;

    /**
     * Constructor de la vista del mago
     * 
     * @param controlador
     * @param scanner
     */
    public VistaMago(Controlador controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
    }

    public void crearMago() {
        // Crear un mago
        System.out.println("Menu que gestiona la creacion de un mago");
        // Pide el nombre
        System.out.print("Ingrese el nombre del mago: ");
        String nombreMago = scanner.nextLine();
        // Pide la vida
        System.out.print("Ingrese la vida del mago: ");
        int vidaMago;
        try {
            vidaMago = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Error: Formato numérico incorrecto. Se asigna el valor por defecto 50");
            vidaMago = 50;
            System.out.println(e.getMessage());
        }
        // Pide el nivel de magia
        System.out.print("Ingrese el nivel de magia del mago: ");
        int nivelMagiaMago;
        try {
            nivelMagiaMago = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Error: Formato numérico incorrecto. Se asigna el valor por defecto 10");
            nivelMagiaMago = 10;
            System.out.println(e.getMessage());
        }
        // Pide los hechizos
        List<Hechizo> hechizos = new ArrayList<>();
        System.out.println("Escoge los hechizos del mago:");
        System.out.println("BolaFuego, BolaNieve, Rayo, Intimidacion");
        System.out.println("Provea la respuesta separada por comas: ");
        String hechizosInput = scanner.nextLine();
        String[] hechizosArray = hechizosInput.split(",");
        for (String hechizoNombre : hechizosArray) {
            hechizoNombre = hechizoNombre.trim();
            Hechizo hechizo = controlador.getControladorMago().crearHechizoPorNombre(hechizoNombre);
            if (hechizo != null) {
                hechizos.add(hechizo);
            }
        }
        // Crear el mago
        Mago mago = new Mago(nombreMago, vidaMago, nivelMagiaMago, hechizos);
        controlador.getControladorMago().setMago(mago);
        controlador.getControladorMago().guardarMago();

        // Mostrar los datos del mago la forma de indicar que fue exitoso
        System.out.println(
                "El mago tiene los siguiente datos" + controlador.getControladorMago().getMago().toString());
    }
}
