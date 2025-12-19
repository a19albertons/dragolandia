package com.example.vista;

import java.util.List;
import java.util.Scanner;

import com.example.controlador.Controlador;
import com.example.model.Bosque;
import com.example.model.Mago;

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

    public void iniciarBatallaAutomatica() {
        // Escoger mago
        System.out.println("Seleccione el mago para la batalla:");
        List<Mago> listaMagos = controlador.getControladorMago().obtenerTodosMagos();
        for (int i = 0; i < listaMagos.size(); i++) {
            System.out.println(i + ": " + listaMagos.get(i).toString());
        }
        int indiceMago;
        try {
            indiceMago = Integer.parseInt(scanner.nextLine());
            controlador.getControladorMago().setMago(listaMagos.get(indiceMago));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Error: Formato numérico incorrecto o índice fuera de rango. Se selecciona el primer mago por defecto.");
            indiceMago = 0;
            controlador.getControladorMago().setMago(listaMagos.get(indiceMago));
            System.out.println(e.getMessage());
        }

        // Escoger bosque
        System.out.println("Seleccione el bosque para la batalla:");
        List<Bosque> listaBosques = controlador.getControladorBosque().obtenerTodosBosques();
        for (int i = 0; i < listaBosques.size(); i++) {
            System.out.println(i + ": " + listaBosques.get(i).toString());
        }
        int indiceBosque;
        try {
            indiceBosque = Integer.parseInt(scanner.nextLine());
            controlador.getControladorBosque().setBosque(listaBosques.get(indiceBosque));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Error: Formato numérico incorrecto o índice fuera de rango. Se selecciona el primer bosque por defecto.");
            indiceBosque = 0;
            controlador.getControladorBosque().setBosque(listaBosques.get(indiceBosque));
            System.out.println(e.getMessage());
        }

        // Establece el monstruo jefe del bosque como el monstruo a enfrentar
        controlador.getControladorMonstruo()
                .setMonstruo(controlador.getControladorBosque().getBosque().getMonstruoJefe());

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
