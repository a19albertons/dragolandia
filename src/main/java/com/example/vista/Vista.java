package com.example.vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.controlador.Controlador;
import com.example.model.Bosque;
import com.example.model.Dragon;
import com.example.model.Mago;
import com.example.model.Monstruo;

/**
 * Clase principal de la vista que interactúa con el usuario.
 */
public class Vista {
    /**
     * Controlador que maneja la lógica del juego
     */
    Controlador controlador;
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
    public Vista(Controlador controlador) {
        this.controlador = controlador;
        this.vistaMago = new VistaMago(controlador, scanner);
        this.vistaMonstruo = new VistaMonstruo(controlador, scanner);
        this.vistaDragon = new VistaDragon(controlador, scanner);
        this.vistaBosque = new VistaBosque(controlador, scanner);
        this.vistaBatalla = new VistaBatalla(controlador, scanner);

    }

    /**
     * Muestra un mensaje de bienvenida al usuario.
     */
    public void bienvenida() {
        System.out.println("Bienvenido a Dragonlandia!");
    }

    /**
     * Muestra el menú principal y maneja las opciones del usuario.
     */
    public void menu() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("Menu Principal:");
            System.out.println("1. Crear Mago");
            System.out.println("2. Listar Magos");
            System.out.println("3. Borrar Mago");
            System.out.println("4. Crear Monstruo");
            System.out.println("5. Listar Monstruos");
            System.out.println("6. Borrar Monstruo");
            System.out.println("7. Crear Dragon");
            System.out.println("8. Listar Dragones");
            System.out.println("9. Borrar Dragon");
            System.out.println("10. Crear Bosque");
            System.out.println("11. Listar Bosques");
            System.out.println("12. Borrar Bosque");
            System.out.println("13. Añadir Monstruo a Bosque");
            System.out.println("14. Cambiar Monstruo Jefe");
            System.out.println("15. Iniciar Batalla Automatica (V1)");
            System.out.println("16. Iniciar Batalla Manual (V2)");
            System.out.println("17. Iniciar Batalla Avanzada (V3)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Formato numérico incorrecto. Intente de nuevo.");
                System.out.println(e.getMessage());
                continue;
            }

            try {
                switch (opcion) {
                    case 1:
                        vistaMago.crearMago();
                        break;
                    case 2:
                        vistaMago.listarMagos();
                        break;
                    case 3:
                        vistaMago.borrarMago();
                        break;
                    case 4:
                        vistaMonstruo.crearMonstruo();
                        break;
                    case 5:
                        vistaMonstruo.listarMonstruos();
                        break;
                    case 6:
                        vistaMonstruo.borrarMonstruo();
                        break;
                    case 7:
                        vistaDragon.crearDragon();
                        break;
                    case 8:
                        vistaDragon.listarDragones();
                        break;
                    case 9:
                        vistaDragon.borrarDragon();
                        break;
                    case 10:
                        vistaBosque.crearBosque();
                        break;
                    case 11:
                        vistaBosque.listarBosques();
                        break;
                    case 12:
                        vistaBosque.borrarBosque();
                        break;
                    case 13:
                        vistaBosque.anadirMonstruo();
                        break;
                    case 14:
                        vistaBosque.cambiarJefeMonstruo();
                        break;
                    case 15:
                        vistaBatalla.iniciarBatallaAutomatica();
                        break;
                    case 16:
                        vistaBatalla.iniciarBatallaManual();
                        break;
                    case 17:
                        // Crear 2 magos (minimo), 3 monstruos (minimo), 1 dragon y 1 bosque
                        // Crear magos
                        String continuar = "continuar";
                        List<Mago> listaMagos = new ArrayList<>();
                        while (continuar.equals("continuar")) {
                            listaMagos.add(vistaMago.crearMagoV2());    
                            if (listaMagos.size()>=2) {
                                System.out.println("¿Desea crear otro mago? (escriba 'continuar' para seguir o cualquier otra cosa para terminar)");
                                continuar = scanner.nextLine();
                            }
                        }
                        // Crear monstruos
                        continuar = "continuar";
                        List<Monstruo> listaMonstruos = new ArrayList<>();
                        while (continuar.equals("continuar")) {
                            listaMonstruos.add(vistaMonstruo.crearMonstruoV2());    
                            if (listaMonstruos.size()>=3) {
                                System.out.println("¿Desea crear otro monstruo? (escriba 'continuar' para seguir o cualquier otra cosa para terminar)");
                                continuar = scanner.nextLine();
                            }
                        }
                        // Crear dragon
                        Dragon dragon = vistaDragon.crearDragonV2();

                        // Crear bosque con el dragon, listado monstruos y pregunta por un monstruo jefe
                        Bosque bosque = vistaBosque.crearBosqueV2(dragon, listaMonstruos);

                        // Guardar todo lo creado en la base de datos
                        controlador.getControladorMago().guardarListaMagos(listaMagos);
                        controlador.getControladorMonstruo().guardarListaMonstruos(listaMonstruos);
                        controlador.getControladorDragon().guardarDragon(dragon);
                        controlador.getControladorBosque().guardarBosque(bosque);
                        
                        vistaBatalla.iniciarBatallaAvanzada(listaMagos, bosque);
                        break;
                    case 0:
                        System.out.println("Saliendo del juego. ¡Hasta luego!");
                        break;  
                    default:
                        System.out.println("Opcion no valida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error en la ejecución inesperado de la opcion " + opcion);
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
                // Muestra todo el error en cascada para investigar en que linea especifica de nuestro codigo ha fallado puede ser util en este caso
                e.printStackTrace();
            }

        }
    }

}