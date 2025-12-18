package com.example.controlador;

import java.util.List;

import com.example.dao.DragonDAO;
import com.example.model.Dragon;

/**
 * Clase que actua como controlador entre la vista y el modelo para el dragon.
 */
public class ControladorDragon {
    /**
     * Dragon que se usa en la vista
     */
    private Dragon dragon;

    /**
     * Obtiene el dragon.
     * 
     * @return
     */
    public Dragon getDragon() {
        return dragon;
    }

    /**
     * Establece el dragon.
     * 
     * @param dragon
     */
    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    /**
     * Guarda el dragon utilizando el DragonDAO.
     */
    public void guardarDragon() {
        DragonDAO dragonDAO = new DragonDAO();
        dragonDAO.guardarDragon(this.dragon);
    }

    /**
     * Borrar el dragon utilizando el DragonDAO.
     */
    public void borrarDragon() {
        DragonDAO dragonDAO = new DragonDAO();
        dragonDAO.borrarDragon(this.dragon);
    }

    /**
     * Actualiza el dragon utilizando el DragonDAO.
     */
    public void actualizarDragon() {
        DragonDAO dragonDAO = new DragonDAO();
        dragonDAO.actualizarDragon(this.dragon);
    }

    /**
     * Obtiene todos los dragones utilizando el DragonDAO.
     * 
     * @return
     */
    public List<Dragon> obtenerTodosDragones() {
        DragonDAO dragonDAO = new DragonDAO();
        return dragonDAO.obtenerTodosDragones();
    }

}
