package com.example.controlador;

/**
 * Clase que actua como controlador entre la vista y el modelo.
 */
public class Controlador {
    /**
     * Controlador del mago
     */
    private ControladorMago controladorMago;
    /**
     * Controlador del monstruo
     */
    private ControladorMonstruo controladorMonstruo;
    /**
     * Controlador del dragón
     */
    private ControladorDragon controladorDragon;
    /**
     * Controlador del bosque
     */
    private ControladorBosque controladorBosque;
    /**
     * Controlador de la batalla
     */
    private ControladorBatalla controladorBatalla;
    
    /**
     * Constructor por defecto que inicializa los subcontroladores del mago,
     * monstruo y bosque.
     */
    public Controlador() {
        this.controladorMago = new ControladorMago();
        this.controladorMonstruo = new ControladorMonstruo();
        this.controladorDragon = new ControladorDragon();
        this.controladorBosque = new ControladorBosque();
        this.controladorBatalla = new ControladorBatalla();
    }

    /**
     * Obtiene el controlador del mago.
     * 
     * @return
     */
    public ControladorMago getControladorMago() {
        return controladorMago;
    }

    /**
     * Establece el controlador del mago.
     * 
     * @param controladorMago
     */
    public void setControladorMago(ControladorMago controladorMago) {
        this.controladorMago = controladorMago;
    }

    /**
     * Obtiene el controlador del monstruo.
     * 
     * @return
     */
    public ControladorMonstruo getControladorMonstruo() {
        return controladorMonstruo;
    }

    /**
     * Establece el controlador del monstruo.
     * 
     * @param controladorMonstruo
     */
    public void setControladorMonstruo(ControladorMonstruo controladorMonstruo) {
        this.controladorMonstruo = controladorMonstruo;
    }

    /**
     * Obtiene el controlador del bosque.
     * 
     * @return
     */
    public ControladorBosque getControladorBosque() {
        return controladorBosque;
    }

    /**
     * Establece el controlador del bosque.
     * 
     * @param controladorBosque
     */
    public void setControladorBosque(ControladorBosque controladorBosque) {
        this.controladorBosque = controladorBosque;
    }

    /**
     * Obtiene el controlador del dragón.
     * @return
     */
    public ControladorDragon getControladorDragon() {
        return controladorDragon;
    }

    /**
     * Establece el controlador del dragón.
     * @param controladorDragon
     */
    public void setControladorDragon(ControladorDragon controladorDragon) {
        this.controladorDragon = controladorDragon;
    }

    /**
     * Obtiene el controlador de la batalla.
     * 
     * @return
     */
    public ControladorBatalla getControladorBatalla() {
        return controladorBatalla;
    }

    /**
     * Establece el controlador de la batalla.
     * 
     * @param controladorBatalla
     */
    public void setControladorBatalla(ControladorBatalla controladorBatalla) {
        this.controladorBatalla = controladorBatalla;
    }

    /**
     * Compara la vida del mago y el monstruo.
     * 
     * @return true si el mago tiene más vida que el monstruo, false de lo
     *         contrario.
     */
    public boolean compararVida() {
        return this.controladorMago.getMago().getVida() > this.controladorMonstruo.getMonstruo().getVida();
    }

}
