package com.example.vista;

import java.util.List;
import java.util.Scanner;

import com.example.controlador.Controlador;
import com.example.model.Bosque;
import com.example.model.Mago;
import com.example.model.Hechizo; 

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

    /**
     * Inicia una batalla automática entre un mago y el monstruo jefe de un bosque.
     * Es la version V1 de la batalla.
     */
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

    /**
     * Inicia una batalla manual donde el usuario decide la accion del mago.
     * Es la version V2 de la batalla.
     */
    public void iniciarBatallaManual() {
        // Selección de mago (copiado de la versión automática)
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

        // Selección de bosque (copiado de la versión automática)
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

        // Empieza la batalla manual
        System.out.println("Empieza la batalla manual entre el mago y el monstruo jefe del bosque!");
        while (controlador.getControladorMago().magoTieneVida()
                && controlador.getControladorMonstruo().monstruoTieneVida()) {
            System.out.println();
            System.out.println("Turno del mago. Vida mago: " + controlador.getControladorMago().getMago().getVida()
                    + " - Vida monstruo: " + controlador.getControladorMonstruo().getMonstruo().getVida());
            System.out.println("Elige una accion: 1) Ataque normal  2) Usar hechizo");
            String opcion = scanner.nextLine();
            if ("1".equals(opcion)) {
                controlador.getControladorMago().getMago()
                        .lanzarHechizo(controlador.getControladorMonstruo().getMonstruo());
                System.out.println("Atacas al monstruo. Vida del monstruo: "
                        + controlador.getControladorMonstruo().getMonstruo().getVida());
            } else if ("2".equals(opcion)) {
                Mago mago = controlador.getControladorMago().getMago();
                if (mago.getConjuros() == null || mago.getConjuros().isEmpty()) {
                    System.out.println("No tienes hechizos. Se realiza un ataque normal en su lugar.");
                    mago.lanzarHechizo(controlador.getControladorMonstruo().getMonstruo());
                } else {
                    System.out.println("Elige hechizo:");
                    List<Hechizo> conjuros = mago.getConjuros();
                    for (int i = 0; i < conjuros.size(); i++) {
                        System.out.println(i + ": " + conjuros.get(i).getClass().getSimpleName());
                    }
                    try {
                        int idx = Integer.parseInt(scanner.nextLine());
                        Hechizo hechizo = conjuros.get(idx);
                        hechizo.efecto(java.util.Arrays.asList(controlador.getControladorMonstruo().getMonstruo()));
                        System.out.println("Lanzas " + hechizo.getClass().getSimpleName() + ". Vida del monstruo: "
                                + controlador.getControladorMonstruo().getMonstruo().getVida());
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        System.out.println("Selección inválida. Se pierde un punto de vida por confusión.");
                        controlador.getControladorMago().getMago()
                                .setVida(controlador.getControladorMago().getMago().getVida() - 1);
                    } catch (Exception e) {
                        System.out.println("Error al aplicar el hechizo: " + e.getMessage());
                    }
                }
            } else {
                System.out.println("Opción no válida, se realiza ataque normal por defecto.");
                controlador.getControladorMago().getMago()
                        .lanzarHechizo(controlador.getControladorMonstruo().getMonstruo());
            }

            // Pausa corta
            try {
                Thread.sleep(500);
            } catch (IllegalArgumentException | InterruptedException e) {
                System.out.println("Error en la pausa de la batalla.");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }

            // El monstruo ataca al mago
            if (controlador.getControladorMonstruo().monstruoTieneVida()) {
                controlador.getControladorMonstruo().getMonstruo()
                        .atacar(controlador.getControladorMago().getMago());
                System.out.println("El monstruo ataca al mago. Vida del mago: "
                        + controlador.getControladorMago().getMago().getVida());
            }

        }

        if (controlador.compararVida()) {
            System.out.println("El mago ha ganado la batalla y domina el bosque!");
        } else {
            System.out.println("El monstruo ha ganado la batalla y domina el bosque!");
        }
    }

} 
