package com.example.vista;

import java.util.List;
import java.util.Scanner;

import com.example.controlador.Controlador;
import com.example.model.Dragon;

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

    public void crearDragon() {
        // Crea un dragon
        System.out.println("Menu que gestiona la creacion de un dragon");
        // Pide el nombre
        System.out.print("Ingresar el nombre del dragon:");
        String nombreDragon = scanner.nextLine();

        // Pide la intensidad de fuego
        System.out.print("Ingresar la intensidad de fuego del dragon:");
        int intensidadFuego;
        try {
            intensidadFuego = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Formato numérico incorrecto. Se asigna el valor por defecto 10");
            intensidadFuego = 10;
            System.out.println(e.getMessage());
        }

        // Pide la resistencia
        System.out.print("Ingresar la resistencia del dragon:");
        int resistencia;
        try {
            resistencia = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Formato numérico incorrecto. Se asigna el valor por defecto 50");
            resistencia = 50;
            System.out.println(e.getMessage());
        }

        // Crear y guardar dragon
        Dragon dragon = new Dragon(nombreDragon, intensidadFuego, resistencia);
        controlador.getControladorDragon().setDragon(dragon);
        controlador.getControladorDragon().guardarDragon();
        System.out.println("Dragon creado exitosamente:");
        System.out.println("El dragon tiene los siguiente datos"
                + controlador.getControladorDragon().getDragon().toString());
    }

    /**
     * Muestra todos los dragones del sistema
     */
    public void listarDragones() {
        System.out.println("Listado de dragones disponibles:");
        List<Dragon> listaDragones = controlador.getControladorDragon().obtenerTodosDragones();
        for (Dragon d : listaDragones) {
            System.out.println(d.toString());
        }
    }

    /**
     * Borra un dragon seleccionado por el usuario
     */
    public void borrarDragon() {
        System.out.println("Menu que gestiona el borrado de un dragon");
        System.out.println("Selecciones un dragon del listado siguiente:");
        List<Dragon> listaDragones = controlador.getControladorDragon().obtenerTodosDragones();
        for (int i = 0; i < listaDragones.size(); i++) {
            System.out.println(i + ": " + listaDragones.get(i).toString());
        }

        int indiceDragon;
        try {
            indiceDragon = Integer.parseInt(scanner.nextLine());
            controlador.getControladorDragon().setDragon(listaDragones.get(indiceDragon));
            controlador.getControladorDragon().borrarDragon();
            System.out.println("Dragon borrado exitosamente.");
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Error: Formato numérico incorrecto o índice fuera de rango. No se puede borrar el dragon.");
            System.out.println(e.getMessage());
        }
    }

} 
