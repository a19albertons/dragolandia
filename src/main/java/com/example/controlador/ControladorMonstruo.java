package com.example.controlador;

import java.util.List;

import com.example.dao.MonstruoDAO;
import com.example.model.Monstruo;

/**
 * Clase que actua como controlador entre la vista y el modelo para el monstruo.
 */
public class ControladorMonstruo {

    /**
     * Monstruo que se usa en la vista
     */
    private Monstruo monstruo;

    /**
     * Obtiene el monstruo.
     * 
     * @return monstruo obtenido
     */
    public Monstruo getMonstruo() {
        return monstruo;
    }

    /**
     * Establece el monstruo.
     * 
     * @param monstruo monstruo a establecer
     */
    public void setMonstruo(Monstruo monstruo) {
        this.monstruo = monstruo;
    }

    /**
     * Verifica si el monstruo tiene vida.
     * 
     * @return true si el monstruo tiene vida, false en caso contrario
     */
    public boolean monstruoTieneVida() {
        return this.monstruo.getVida() > 0;
    }

    /**
     * Guarda el monstruo utilizando el MonstruoDAO.
     */
    public void guardarMonstruo() {
        MonstruoDAO monstruoDAO = new MonstruoDAO();
        monstruoDAO.guardarMonstruo(this.monstruo);
    }

    /**
     * Borrar el monstruo utilizando el MonstruoDAO.
     */
    public void borrarMonstruo() {
        MonstruoDAO monstruoDAO = new MonstruoDAO();
        monstruoDAO.borrarMonstruo(this.monstruo);
    }

    /**
     * Actualiza el monstruo utilizando el MonstruoDAO.
     */
    public void actualizarMonstruo() {
        MonstruoDAO monstruoDAO = new MonstruoDAO();
        monstruoDAO.actualizarMonstruo(this.monstruo);
    }

    /**
     * Obtiene todos los monstruos utilizando el MonstruoDAO.
     * 
     * @return lista de todos los monstruos
     */
    public List<Monstruo> obtenerTodosMonstruos() {
        MonstruoDAO monstruoDAO = new MonstruoDAO();
        return monstruoDAO.obtenerTodosMonstruos();
    }

    /**
     * Guarda una lista de monstruos utilizando el MonstruoDAO.
     * 
     * @param listaMonstruos lista de monstruos a guardar
     */
    public void guardarListaMonstruos(List<Monstruo> listaMonstruos) {
        MonstruoDAO monstruoDAO = new MonstruoDAO();
        for (Monstruo monstruo : listaMonstruos) {
            monstruoDAO.guardarMonstruo(monstruo);
        }
    }

}
