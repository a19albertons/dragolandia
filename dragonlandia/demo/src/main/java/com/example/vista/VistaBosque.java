package com.example.vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.controlador.Controlador;
import com.example.model.Bosque;
import com.example.model.Monstruo;

public class VistaBosque {

    /**
     * Controlador que maneja la lógica del bosque
     */
    Controlador controlador;

    /**
     * Scanner para leer la entrada del usuario
     */
    Scanner scanner;

    /**
     * Constructor de la vista del bosque
     * 
     * @param controlador
     * @param scanner
     */
    public VistaBosque(Controlador controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
    }

    public void crearBosque() {
        // Crear un bosque
        System.out.println("Menu que gestiona la creacion de un bosque");

        // Pide el nombre
        System.out.print("Ingrese el nombre del bosque: ");
        String nombreBosque = scanner.nextLine();

        // Pide el nivel de peligro
        System.out.print("Ingrese el nivel de peligro del bosque: ");
        int nivelPeligroBosque;
        try {
            nivelPeligroBosque = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Formato numérico incorrecto. Se asigna el valor por defecto 5");
            nivelPeligroBosque = 5;
            System.out.println(e.getMessage());
        }
        

        // Indica los monstruos disponibles para ser jefe del bosque
        List<Monstruo> listaMonstruos = controlador.getControladorBosque().obtenerMonstruosSinBosque();
        System.out.println("Seleccione el listado de monstruos:");
        for (int i = 0; i < listaMonstruos.size(); i++) {
            System.out.println(i + ": " + listaMonstruos.get(i).toString());
        }

        String opcion = scanner.nextLine();
        
        listaMonstruos.add(controlador.getControladorMonstruo().getMonstruo());
        Bosque bosque = new Bosque(nombreBosque, nivelPeligroBosque,
                controlador.getControladorMonstruo().getMonstruo(), listaMonstruos, null);
        controlador.getControladorBosque().setBosque(bosque);
        controlador.getControladorBosque().guardarBosque();
        System.out.println("Bosque creado exitosamente:");

        // Mostrar los datos del monstruo jefe del bosque
        System.out.println(
                "El bosque tiene los siguiente datos:" +
                        controlador.getControladorBosque().getBosque().toString());
        // Empieza la batalla
        System.out.println("Empieza la batalla entre el mago y el monstruo jefe del bosque!");
        while (controlador.getControladorMago().magoTieneVida()
                && controlador.getControladorMonstruo().monstruoTieneVida()) {
            // El mago lanza un hechizo al monstruo
            controlador.getControladorMago().getMago()
                    .lanzarHechizo(controlador.getControladorMonstruo().getMonstruo());
            System.out.println("El mago lanza un hechizo al monstruo. Vida del monstruo:"
                    + controlador.getControladorMonstruo().getMonstruo().getVida());
            try {
                Thread.sleep(1000);
            } catch (IllegalArgumentException | InterruptedException e) {
                System.out.println("Error en la pausa de la batalla.");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            } // El monstruo ataca al mago
            if (controlador.getControladorMonstruo().monstruoTieneVida()) {
                controlador.getControladorMonstruo().getMonstruo()
                        .atacar(controlador.getControladorMago().getMago());
                System.out.println("El monstruo ataca al mago. Vida del mago: "
                        + controlador.getControladorMago().getMago().getVida());
            }
            // Le da dinamismo a la batalla
            try {
                Thread.sleep(1000);
            } catch (IllegalArgumentException | InterruptedException e) {
                System.out.println("Error en la pausa de la batalla.");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
        if (controlador.compararVida()) {
            System.out.println("El mago ha ganado la batalla y domina el bosque!");
        } else {
            System.out.println("El monstruo ha ganado la batalla y domina el bosque!");
        }
    }

}
