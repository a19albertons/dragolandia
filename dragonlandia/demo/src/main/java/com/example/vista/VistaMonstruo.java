package com.example.vista;

import java.util.Scanner;

import com.example.controlador.Controlador;
import com.example.model.Monstruo;
import com.example.model.TipoMonstruo;

/**
 * Clase que representa la vista del monstruo.
 */
public class VistaMonstruo {

    /**
     * Controlador que maneja la lógica del monstruo
     */
    Controlador controlador;

    /**
     * Scanner para leer la entrada del usuario
     */
    Scanner scanner;

    /**
     * Constructor de la vista del monstruo
     * 
     * @param controlador
     * @param scanner
     */
    public VistaMonstruo(Controlador controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
    }

    public void crearMonstruo() {
        // Crea un monstruo
        System.out.println("Menu que gestiona la creacion de un monstruo");
        // Pide el nombre
        System.out.print("Ingresar el nombre del monstruo:");
        String nombreMonstruo = scanner.nextLine();

        // Pide la vida
        System.out.print("Ingresar la vida del monstruo:");
        int vidaMostruo;
        try {
            vidaMostruo = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Formato numérico incorrecto. Se asigna el valor por defecto 50");
            vidaMostruo = 50;
            System.out.println(e.getMessage());
        }

        // Pide la fuerza
        System.out.print("Ingresar la fuerza del monstruo:");
        int fuerzaMonstruo;
        try {
            fuerzaMonstruo = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Formato numérico incorrecto. Se asigna el valor por defecto 10");
            fuerzaMonstruo = 10;
            System.out.println(e.getMessage());
        }

        // Pide el tipo de monstruo
        TipoMonstruo tipoMonstruo;
        System.out.println("Ingresar el tipo de monstruo (OGRO, TROLL, ESPECTRO):");
        try {
            String tipoInput = scanner.nextLine().toUpperCase();
            tipoMonstruo = TipoMonstruo.valueOf(tipoInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Tipo de monstruo inválido. Se asigna el valor por defecto OGRO");
            tipoMonstruo = TipoMonstruo.OGRO;
            System.out.println(e.getMessage());
        }
        System.out.println();

        // Crear el monstruo
        Monstruo monstruo = new Monstruo(nombreMonstruo, vidaMostruo, tipoMonstruo,
                fuerzaMonstruo);
        controlador.getControladorMonstruo().setMonstruo(monstruo);
        controlador.getControladorMonstruo().guardarMonstruo();
        System.out.println("Monstruo creado exitosamente:");
        // Mostrar los datos del monstruo
        System.out.println("El monstruo tiene los siguiente datos"
                + controlador.getControladorMonstruo().getMonstruo().toString());
    }
}
