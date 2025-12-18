package com.example.controlador;

import java.util.List;

import com.example.dao.MagoDAO;
import com.example.model.BolaFuego;
import com.example.model.BolaNieve;
import com.example.model.Hechizo;
import com.example.model.Intimidacion;
import com.example.model.Mago;
import com.example.model.Rayo;

/**
 * Clase que actua como controlador entre la vista y el modelo para el mago.
 */
public class ControladorMago {
    /**
     * Mago que se usa en la vista
     */
    private Mago mago;

    /**
     * Obtiene el mago.
     * 
     * @return
     */
    public Mago getMago() {
        return mago;
    }

    /**
     * Establece el mago.
     * 
     * @param mago
     */
    public void setMago(Mago mago) {
        this.mago = mago;
    }

    /**
     * Verifica si el mago tiene vida.
     * 
     * @return
     */
    public boolean magoTieneVida() {
        return this.mago.getVida() > 0;
    }

    /**
     * Crea un hechizo basado en el nombre proporcionado.
     * 
     * @param nombreHechizo
     * @return
     */
    public Hechizo crearHechizoPorNombre(String nombreHechizo) {
        switch (nombreHechizo.toLowerCase()) {
            case "bolafuego":
                return new BolaFuego();
            case "bolanieve":
                return new BolaNieve();
            case "rayo":
                return new Rayo();
            case "intimidacion":
                return new Intimidacion();
            default:
                System.out.println("Hechizo desconocido: " + nombreHechizo);
                return null;
        }
    }

    /**
     * Guarda el mago utilizando el MagoDAO.
     */
    public void guardarMago() {
        MagoDAO magoDAO = new MagoDAO();
        magoDAO.guardarMago(this.mago);
    }

    /**
     * Borrar el mago utilizando el MagoDAO.
     */
    public void borrarMago() {
        MagoDAO magoDAO = new MagoDAO();
        magoDAO.borrarMago(this.mago);
    }

    /**
     * Actualiza el mago utilizando el MagoDAO.
     */
    public void actualizarMago() {
        MagoDAO magoDAO = new MagoDAO();
        magoDAO.actualizarMago(this.mago);
    }

    /**
     * Obtiene todos los magos utilizando el MagoDAO.
     * 
     * @return
     */
    public List<Mago> obtenerTodosMagos() {
        MagoDAO magoDAO = new MagoDAO();
        return magoDAO.obtenerTodosMagos();
    }

}