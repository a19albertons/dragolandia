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
     * @param mago mago a establecer
     */
    public void setMago(Mago mago) {
        this.mago = mago;
    }

    /**
     * Verifica si el mago tiene vida.
     * 
     * @return true si el mago tiene vida, false en caso contrario
     */
    public boolean magoTieneVida() {
        return this.mago.getVida() > 0;
    }

    /**
     * Crea un hechizo basado en el nombre proporcionado.
     * 
     * @param nombreHechizo nombre del hechizo a crear
     * @return el hechizo creado
     */
    public Hechizo crearHechizoPorNombre(String nombreHechizo) {
        Hechizo devolver = null;
        switch (nombreHechizo.toLowerCase()) {
            case "bolafuego":
                devolver = new BolaFuego();
                break;
            case "bolanieve":
                devolver = new BolaNieve();
                break;
            case "rayo":
                devolver = new Rayo();
                break;
            case "intimidacion":
                devolver = new Intimidacion();
                break;
            default:
                System.out.println("Hechizo desconocido: " + nombreHechizo);
                devolver = null;
        }
        return devolver;
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
     * @return lista de todos los magos
     */
    public List<Mago> obtenerTodosMagos() {
        MagoDAO magoDAO = new MagoDAO();
        return magoDAO.obtenerTodosMagos();
    }

    /**
     * Guarda una lista de magos en la base de datos.
     * 
     * @param listaMagos lista de magos a guardar
     */
    public void guardarListaMagos(List<Mago> listaMagos) {
        MagoDAO magoDAO = new MagoDAO();
        for (Mago mago : listaMagos) {
            magoDAO.guardarMago(mago);
        }
    }

}