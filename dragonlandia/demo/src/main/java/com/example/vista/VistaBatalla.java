package com.example.vista;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.example.controlador.Controlador;
import com.example.model.Bosque;
import com.example.model.Mago;
import com.example.model.Monstruo;
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
            System.out.println(
                    "Error: Formato numérico incorrecto o índice fuera de rango. Se selecciona el primer mago por defecto.");
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
            System.out.println(
                    "Error: Formato numérico incorrecto o índice fuera de rango. Se selecciona el primer bosque por defecto.");
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
            System.out.println(
                    "Error: Formato numérico incorrecto o índice fuera de rango. Se selecciona el primer mago por defecto.");
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
            System.out.println(
                    "Error: Formato numérico incorrecto o índice fuera de rango. Se selecciona el primer bosque por defecto.");
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

    /**
     * Inicia una batalla donde se crean varias cosas.
     * Es la version V3 de la batalla.
     * 
     * @param bosque
     * @param listaMagos
     */
    public void iniciarBatallaAvanzada(List<Mago> listaMagos, Bosque bosque) {

        // Selección de bosque (copiado de la versión automática)
        controlador.getControladorBosque().setBosque(bosque);
        controlador.getControladorMonstruo()
                .setMonstruo(controlador.getControladorBosque().getBosque().getMonstruoJefe());

        // Empieza la batalla avanzada
        Boolean magos = true;
        Boolean monstruos = true;
        Boolean finalizar = false;
        System.out.println("Empieza la batalla avanzada entre los magos y el monstruo jefe del bosque!");
        while (magos && monstruos) {
            // Cada mago ataca a un monstruo
            for (Mago mago : listaMagos.stream().filter(m -> m.getVida() > 0).toList()) {
                controlador.getControladorMago().setMago(mago);
                System.out.println("Ataca el mago: " + mago.getNombre());
                // Listar monstruos bosque
                List<Monstruo> listaMonstruos = controlador.getControladorBosque().obtenerMonstruosBosque();
                for (int i = 0; i < listaMonstruos.size(); i++) {
                    if (listaMonstruos.get(i).getVida() > 0) {
                        System.out.println(i + ": " + listaMonstruos.get(i).getNombre());
                    }
                }
                // Seleccionar monstruo
                System.out.println("Seleccione el monstruo a atacar:");
                int indiceMonstruo;
                try {
                    indiceMonstruo = Integer.parseInt(scanner.nextLine());
                    controlador.getControladorMonstruo().setMonstruo(listaMonstruos.get(indiceMonstruo));
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println(
                            "Error: Formato numérico incorrecto o índice fuera de rango. Se selecciona el primer monstruo por defecto.");
                    indiceMonstruo = 0;
                    controlador.getControladorMonstruo().setMonstruo(listaMonstruos.get(indiceMonstruo));
                    System.out.println(e.getMessage());
                }
                // Mago ataca al monstruo
                System.out.println("Elige una accion: 1) Ataque normal  2) Usar hechizo");
                String opcion = scanner.nextLine();
                if ("1".equals(opcion)) {
                    controlador.getControladorMago().getMago()
                            .lanzarHechizo(controlador.getControladorMonstruo().getMonstruo());
                    System.out.println("Atacas al monstruo. Vida del monstruo: "
                            + controlador.getControladorMonstruo().getMonstruo().getVida());
                } else if ("2".equals(opcion)) {
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
                // Comprobamos si quedan monstruos vivos
                if (controlador.getControladorBosque().obtenerMonstruosBosque().stream()
                        .allMatch(m -> m.getVida() <= 0)) {
                    finalizar = true;
                    monstruos = false;
                    break;
                }

                // Comprobamos el monstruo jefe
                if (controlador.getControladorBosque().getBosque().getMonstruoJefe().getVida() <= 0) {
                    // Escoger otro monstruo con vida
                    controlador.getControladorBosque().getBosque().getListaMonstruos().stream()
                            .filter(m -> m.getVida() > 0)
                            .findFirst()
                            .ifPresent(m -> controlador.getControladorBosque().getBosque().cambiarJefe(m));
                    System.out.println("El monstruo jefe ha sido derrotado! Nuevo monstruo jefe: "
                            + controlador.getControladorBosque().getBosque().getMonstruoJefe().getNombre());
                }
            }
            // Cada monstruo ataca a un mago
            if (finalizar) {
                continue;
            }
            List<Monstruo> listaMonstruos = controlador.getControladorBosque().obtenerMonstruosBosque();
            for (Monstruo monstruo : listaMonstruos.stream().filter(m -> m.getVida() > 0).toList()) {
                controlador.getControladorMonstruo().setMonstruo(monstruo);
                System.out.println("Ahora ataca " + monstruo.getNombre());
                // Escoger mago a atacar
                Mago magoSeleccionado = null;
                Random rand = new Random();
                if (listaMagos.stream().filter(m -> m.getVida() > 0).count() >= 2) {
                    magoSeleccionado = listaMagos.get(rand.nextInt(listaMagos.size()));
                } else {
                    magoSeleccionado = listaMagos.stream().filter(m -> m.getVida() > 0).findFirst().get();
                }

                controlador.getControladorMago().setMago(magoSeleccionado);
                // Monstruo ataca al mago
                controlador.getControladorMonstruo().getMonstruo()
                        .atacar(controlador.getControladorMago().getMago());
                System.out.println("Ataca al mago: " + controlador.getControladorMago().getMago().getNombre());
                // Comprobamos si quedan magos vivos
                if (listaMagos.stream().allMatch(m -> m.getVida() <= 0)) {
                    finalizar = true;
                    magos = false;
                    break;
                }
            }
            if (finalizar) {
                continue;
            }
            // Dragon ataca al monstruo jefe
            System.out.println("El dragon ataca al monstruo jefe!");
            controlador.getControladorMonstruo().setMonstruo(
                    controlador.getControladorBosque().getBosque().getMonstruoJefe());
            controlador.getControladorBosque().getBosque().getDragon()
                    .exhalar(controlador.getControladorMonstruo().getMonstruo());
            // Comprobamos el monstruo jefe
            if (controlador.getControladorBosque().getBosque().getMonstruoJefe().getVida() <= 0) {
                // Escoger otro monstruo con vida, si hay
                List<Monstruo> monstruosVivos = controlador.getControladorBosque().getBosque().getListaMonstruos()
                        .stream()
                        .filter(m -> m.getVida() > 0)
                        .toList();
                if (monstruosVivos.isEmpty()) {
                    finalizar = true;
                    monstruos = false;
                } else {
                    controlador.getControladorBosque().getBosque().cambiarJefe(monstruosVivos.get(0));
                    System.out.println("El monstruo jefe ha sido derrotado! Nuevo monstruo jefe: "
                            + controlador.getControladorBosque().getBosque().getMonstruoJefe().getNombre());
                }
            }

            // Información sobre el estado de la batalla
            System.out.println("Estado de la batalla:");
            System.out.println("Magos:");
            for (Mago mago : listaMagos) {
                System.out.println(mago.getNombre() + " - Vida: " + mago.getVida());
            }
            System.out.println("Monstruos en el bosque:");
            for (Monstruo monstruo : controlador.getControladorBosque().obtenerMonstruosBosque()) {
                System.out.println(monstruo.getNombre() + " - Vida: " + monstruo.getVida());
            }
            System.out.println("Monstruo jefe actual: "
                    + controlador.getControladorBosque().getBosque().getMonstruoJefe().getNombre());

            // Verificar si estan vivos los magos y monstruos
            if (listaMagos.stream().allMatch(m -> m.getVida() <= 0)) {
                magos = false;
            }
            if (controlador.getControladorBosque().obtenerMonstruosBosque().stream().allMatch(m -> m.getVida() <= 0)) {
                monstruos = false;
            }

        }

        // Final
        if (magos == true) {
            System.out.println("Los magos han ganado la batalla y dominan el bosque!");
        } else {
            System.out.println("El monstruo ha ganado la batalla y domina el bosque!");
        }
    }

}
