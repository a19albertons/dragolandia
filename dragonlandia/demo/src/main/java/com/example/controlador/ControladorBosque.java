package com.example.controlador;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.BosqueDAO;
import com.example.model.Bosque;
import com.example.model.Monstruo;

/**
 * Clase que actua como controlador entre la vista y el modelo para el bosque.
 */
public class ControladorBosque {
    /**
     * Bosque que se usa en la vista
     */
    private Bosque bosque;

    /**
     * Obtiene el bosque.
     * 
     * @return
     */
    public Bosque getBosque() {
        return bosque;
    }

    /**
     * Establece el bosque.
     * 
     * @param bosque
     */
    public void setBosque(Bosque bosque) {
        this.bosque = bosque;
    }

    /**
     * Constructor del controlador del bosque.
     */
    public ControladorBosque() {
    }

    /**
     * Guarda el bosque utilizando el BosqueDAO.
     */
    public void guardarBosque() {
        BosqueDAO bosqueDAO = new BosqueDAO();
        bosqueDAO.guardarBosque(this.bosque);
    }

    /**
     * Borrar el bosque utilizando el BosqueDAO.
     */
    public void borrarBosque() {
        BosqueDAO bosqueDAO = new BosqueDAO();
        bosqueDAO.borrarBosque(this.bosque);
    }

    /**
     * Actualiza el bosque utilizando el BosqueDAO.
     */
    public void actualizarBosque() {
        BosqueDAO bosqueDAO = new BosqueDAO();
        bosqueDAO.actualizarBosque(this.bosque);
    }

    /**
     * Obtiene todos los bosques utilizando el BosqueDAO.
     * 
     * @return
     */
    public List<Bosque> obtenerTodosBosques() {
        BosqueDAO bosqueDAO = new BosqueDAO();
        return bosqueDAO.obtenerTodosBosques();
    }

    /**
     * Obtiene los monstruos que no estan asignados a ningun bosque.
     * 
     * @return
     */
    public List<Monstruo> obtenerMonstruosSinBosque() {
        BosqueDAO bosqueDAO = new BosqueDAO();
        return bosqueDAO.obtenerMonstruosSinBosque();
    }

    public List<Monstruo> generarLista(String seleccion) {
        List<Monstruo> listaMonstruos = this.obtenerMonstruosSinBosque();
        String[] indices = seleccion.split(",");
        List<Monstruo> devolver = new ArrayList<>();
        for (String indice : indices) {
            try {
                int idx = Integer.parseInt(indice.trim());
                devolver.add(listaMonstruos.get(idx));
            } catch (NumberFormatException| IndexOutOfBoundsException e) {
                System.out.println("Indice invalido: " + indice);
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
        return devolver;

    }

}
