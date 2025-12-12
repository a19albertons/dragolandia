package com.example.vista;

import java.util.Scanner;

import com.example.controlador.Controlador;
import com.example.model.Bosque;
import com.example.model.Mago;
import com.example.model.Monstruo;
import com.example.model.TipoMonstruo;

public class Vista {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bienvenido a Dragonlandia!");

            // Crear un mago
            System.out.println("Vamos a empezar creando un mago");
            System.out.print("Ingrese el nombre del mago: ");
            String nombreMago = scanner.nextLine();
            System.out.print("Ingrese la vida del mago: ");
            int vidaMago;
            try {
                vidaMago = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Error: Formato numérico incorrecto. Se asigna el valor por defecto 50");
                vidaMago = 50;
                System.out.println(e.getMessage());
            }

            System.out.print("Ingrese el nivel de magia del mago: ");
            int nivelMagiaMago;
            try {
                nivelMagiaMago = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Error: Formato numérico incorrecto. Se asigna el valor por defecto 10");
                nivelMagiaMago = 10;
                System.out.println(e.getMessage());
            }

            controlador.getControladorMago().setMago(new Mago(nombreMago, vidaMago, nivelMagiaMago));
            // Mostrar los datos del mago la forma de indicar que fue exitoso
            System.out.println("El mago tiene los siguiente datos" + controlador.getControladorMago().getMago().toString());

            System.out.print("Vamos a crear un monstruo");
            String nombreMonstruo = scanner.nextLine();

            System.out.print("Ingresar la vida del monstruo:");
            int vidaMostruo;
            try {
                vidaMostruo = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Formato numérico incorrecto. Se asigna el valor por defecto 50");
                vidaMostruo = 50;
                System.out.println(e.getMessage());
            }

            System.out.print("Ingresar la fuerza del monstruo:");
            int fuerzaMonstruo;
            try {
                fuerzaMonstruo = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Formato numérico incorrecto. Se asigna el valor por defecto 10");
                fuerzaMonstruo = 10;
                System.out.println(e.getMessage());
            }
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
            controlador.getControladorMonstruo().setMonstruo(new Monstruo(nombreMonstruo, vidaMostruo, tipoMonstruo, fuerzaMonstruo));
            System.out.println("Monstruo creado exitosamente:");
            // Mostrar los datos del monstruo
            System.out.println("El monstruo tiene los siguiente datos" + controlador.getControladorMonstruo().getMonstruo().toString());

            // Crear un bosque
            System.out.println("Vamos a crear un bosque");
            System.out.print("Ingrese el nombre del bosque: ");
            String nombreBosque = scanner.nextLine();
            System.out.print("Ingrese el nivel de peligro del bosque: ");
            int nivelPeligroBosque;
            try {
                nivelPeligroBosque = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Formato numérico incorrecto. Se asigna el valor por defecto 5");
                nivelPeligroBosque = 5;
                System.out.println(e.getMessage());
            }
            // Asociar el monstruo jefe al bosque
            System.out.println("El monstruo jefe del bosque sera el monstruo creado anteriormente.");

            controlador.getControladorBosque().setBosque(new Bosque(nombreBosque, nivelPeligroBosque, controlador.getControladorMonstruo().getMonstruo()));
            System.out.println("Bosque creado exitosamente:");

            // Mostrar los datos del monstruo jefe del bosque
            System.out.println("El bosque tiene los siguiente datos:" + controlador.getControladorBosque().getBosque().toString());
            // Empieza la batalla
            System.out.println("Empieza la batalla entre el mago y el monstruo jefe del bosque!");
            while (controlador.getControladorMago().magoTieneVida() && controlador.getControladorMonstruo().monstruoTieneVida()) {
                // El mago lanza un hechizo al monstruo
                controlador.getControladorMago().getMago().lanzarHechizo(controlador.getControladorMonstruo().getMonstruo());
                System.out.println("El mago lanza un hechizo al monstruo. Vida del monstruo: " + controlador.getControladorMonstruo().getMonstruo().getVida());
                Thread.sleep(1000);
                // El monstruo ataca al mago
                if (controlador.getControladorMonstruo().monstruoTieneVida()) {
                    controlador.getControladorMonstruo().getMonstruo().atacar(controlador.getControladorMago().getMago());
                    System.out.println("El monstruo ataca al mago. Vida del mago: " + controlador.getControladorMago().getMago().getVida());
                }
                // Le da dinamismo a la batalla
                Thread.sleep(1000);
            }
            if (controlador.compararVida()) {
                System.out.println("El mago ha ganado la batalla y domina el bosque!");
            } else {
                System.out.println("El monstruo ha ganado la batalla y domina el bosque!");
            }

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