package com.example.vista;

import java.util.List;
import java.util.Scanner;

import com.example.controlador.Controlador;
import com.example.model.Bosque;
import com.example.model.Dragon;
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

        int indiceMonstruo;
        Monstruo monstruoJefe;
        try {
            System.out.print("Ingrese el índice del monstruo jefe del bosque: ");
            indiceMonstruo = Integer.parseInt(scanner.nextLine());
            monstruoJefe = listaMonstruos.get(indiceMonstruo);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println(
                    "Error: Formato numérico incorrecto o índice fuera de rango. Se selecciona el primer monstruo por defecto.");
            indiceMonstruo = 0;
            monstruoJefe = listaMonstruos.get(indiceMonstruo);
            System.out.println(e.getMessage());
        }

        // Añadir dragon
        List<Dragon> listaDragones = controlador.getControladorBosque().obtenerDragonesSinBosque();
        System.out.println("Seleccione el listado de dragones:");
        for (int i = 0; i < listaDragones.size(); i++) {
            System.out.println(i + ": " + listaDragones.get(i).toString());
        }
        int indiceDragon;
        Dragon dragonAsignado;
        try {
            System.out.print("Ingrese el índice del dragon asignado al bosque: ");
            indiceDragon = Integer.parseInt(scanner.nextLine());
            dragonAsignado = listaDragones.get(indiceDragon);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println(
                    "Error: Formato numérico incorrecto o índice fuera de rango. Se selecciona el primer dragon por defecto.");
            indiceDragon = 0;
            dragonAsignado = listaDragones.get(indiceDragon);
            System.out.println(e.getMessage());
        }

        // Crear y guardar bosque
        Bosque bosque = new Bosque(nombreBosque, nivelPeligroBosque, monstruoJefe, listaMonstruos, dragonAsignado);
        controlador.getControladorBosque().setBosque(bosque);
        controlador.getControladorBosque().guardarBosque();
        System.out.println("Bosque creado exitosamente:");

        // Mostrar los datos del monstruo jefe del bosque
        System.out.println(
                "El bosque tiene los siguiente datos:" +
                        controlador.getControladorBosque().getBosque().toString());

    }

    /**
     * Muestra todos los bosques del sistema
     */
    public void listarBosques() {
        System.out.println("Listado de bosques disponibles:");
        List<Bosque> listaBosques = controlador.getControladorBosque().obtenerTodosBosques();
        for (Bosque b : listaBosques) {
            System.out.println(b.toString());
        }
    }

    /**
     * Borra un bosque seleccionado por el usuario
     */
    public void borrarBosque() {
        System.out.println("Menu que gestiona el borrado de un bosque");
        System.out.println("Selecciones un bosque del listado siguiente:");
        List<Bosque> listaBosques = controlador.getControladorBosque().obtenerTodosBosques();
        for (int i = 0; i < listaBosques.size(); i++) {
            System.out.println(i + ": " + listaBosques.get(i).toString());
        }

        int indiceBosque;
        try {
            indiceBosque = Integer.parseInt(scanner.nextLine());
            controlador.getControladorBosque().setBosque(listaBosques.get(indiceBosque));
            controlador.getControladorBosque().borrarBosque();
            System.out.println("Bosque borrado exitosamente.");
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println(
                    "Error: Formato numérico incorrecto o índice fuera de rango. No se puede borrar el bosque.");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Permite añadir un monstruo a un bosque existente
     */
    public void anadirMonstruo() {
        boolean errorCritico = false;
        System.out.println("Menu que gestiona la adicion de un monstruo a un bosque");

        // Seleccionar bosque
        System.out.println("Seleccione un bosque del listado siguiente a añadir el monstruo:");
        List<Bosque> listaBosques = controlador.getControladorBosque().obtenerTodosBosques();
        for (int i = 0; i < listaBosques.size(); i++) {
            System.out.println(i + ": " + listaBosques.get(i).toString());
        }
        int indiceBosque;
        Bosque bosqueSeleccionado = null;
        try {
            indiceBosque = Integer.parseInt(scanner.nextLine());
            controlador.getControladorBosque().setBosque(listaBosques.get(indiceBosque));
            bosqueSeleccionado = listaBosques.get(indiceBosque);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println(
                    "Error: Formato numérico incorrecto o índice fuera de rango. No se puede añadir el monstruo.");
            System.out.println(e.getMessage());
            errorCritico = true;
        }

        // Seleecionar monstruo a añadir
        if (errorCritico != true) {
            System.out.println("Seleccione un monstruo del listado siguiente a añadir al bosque:");
            List<Monstruo> listaMonstruos = controlador.getControladorBosque().obtenerMonstruosSinBosque();
            for (int i = 0; i < listaMonstruos.size(); i++) {
                System.out.println(i + ": " + listaMonstruos.get(i).toString());
            }
            int indiceMonstruo;
            Monstruo monstruoSeleccionado;
            try {
                indiceMonstruo = Integer.parseInt(scanner.nextLine());
                monstruoSeleccionado = listaMonstruos.get(indiceMonstruo);
                controlador.getControladorBosque().anadirMonstruoABosque(bosqueSeleccionado, monstruoSeleccionado);
                System.out.println("Monstruo añadido exitosamente al bosque.");
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println(
                        "Error: Formato numérico incorrecto o índice fuera de rango. No se puede añadir el monstruo.");
                System.out.println(e.getMessage());
                errorCritico = true;
            }
        }

        // Actualizar bosque
        if (errorCritico != true) {
            try {
                controlador.getControladorBosque().setBosque(bosqueSeleccionado);
                controlador.getControladorBosque().actualizarBosque();
                System.out.println("Monstruo añadido exitosamente.");
            } catch (Exception e) {
                System.out.println("Error al actualizar el bosque con el nuevo monstruo.");
                System.out.println(e.getMessage());
            }

        }
    }

    public void cambiarJefeMonstruo() {
        boolean errorCritico = false;
        System.out.println("Menu que gestiona el cambio del monstruo jefe de un bosque");
        // Seleccionar bosque
        System.out.println("Seleccione un bosque del listado siguiente para cambiar el monstruo jefe:");
        List<Bosque> listaBosques = controlador.getControladorBosque().obtenerTodosBosques();
        for (int i = 0; i < listaBosques.size(); i++) {
            System.out.println(i + ": " + listaBosques.get(i).toString());
        }
        int indiceBosque;
        Bosque bosqueSeleccionado = null;
        try {
            indiceBosque = Integer.parseInt(scanner.nextLine());
            controlador.getControladorBosque().setBosque(listaBosques.get(indiceBosque));
            bosqueSeleccionado = listaBosques.get(indiceBosque);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println(
                    "Error: Formato numérico incorrecto o índice fuera de rango. No se puede cambiar el monstruo jefe.");
            System.out.println(e.getMessage());
            errorCritico = true;
        }

        // Seleccionar nuevo monstruo jefe
        if (errorCritico != true) {
            System.out.println("Seleccione un monstruo del listado siguiente para ser el nuevo monstruo jefe:");
            List<Monstruo> listaMonstruos = controlador.getControladorBosque().obtenerMonstruosBosque();
            for (int i = 0; i < listaMonstruos.size(); i++) {
                System.out.println(i + ": " + listaMonstruos.get(i).toString());
            }
            int indiceMonstruo;
            Monstruo nuevoMonstruoJefe;
            try {
                indiceMonstruo = Integer.parseInt(scanner.nextLine());
                nuevoMonstruoJefe = listaMonstruos.get(indiceMonstruo);
                controlador.getControladorBosque().cambiarMonstruoJefe(bosqueSeleccionado, nuevoMonstruoJefe);
                System.out.println("Monstruo jefe cambiado exitosamente.");
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println(
                        "Error: Formato numérico incorrecto o índice fuera de rango. No se puede cambiar el monstruo jefe.");
                System.out.println(e.getMessage());
                errorCritico = true;
            }
        }
        // Actualizar bosque
        if (errorCritico != true) {
            try {
                controlador.getControladorBosque().setBosque(bosqueSeleccionado);
                controlador.getControladorBosque().actualizarBosque();
                System.out.println("Monstruo jefe cambiado exitosamente.");
            } catch (Exception e) {
                System.out.println("Error al actualizar el bosque con el nuevo monstruo jefe.");
                System.out.println(e.getMessage());
            }
        }
    }

}
