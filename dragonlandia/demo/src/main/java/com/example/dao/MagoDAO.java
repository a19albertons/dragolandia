package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import com.example.controlador.HibernateSingleton;
import com.example.model.Mago;

/**
 * Clase que gestiona las operaciones de acceso a datos para la entidad Mago.
 */
public class MagoDAO {
    HibernateSingleton hibernateSingleton = HibernateSingleton.getInstance();

    /**
     * Guarda el mago en la base de datos.
     */
    public void guardarMago(Mago mago) {
        EntityManager em = hibernateSingleton.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(mago);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error");
            if (tx != null && tx.isActive()) {
                tx.rollback();
                System.out.println("Se hace rollback de la transacción");
            }
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    /**
     * Borrar el mago en la base de datos.
     */
    public void borrarMago(Mago mago) {
        EntityManager em = hibernateSingleton.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(mago);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error");
            if (tx != null && tx.isActive()) {
                tx.rollback();
                System.out.println("Se hace rollback de la transacción");
            }
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    /**
     * Actualiza el mago en la base de datos.
     */
    public void actualizarMago(Mago mago) {
        EntityManager em = hibernateSingleton.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(mago);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error");
            if (tx != null && tx.isActive()) {
                tx.rollback();
                System.out.println("Se hace rollback de la transacción");
            }
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    /**
     * Obtiene los magos de la base de datos
     */
    public List<Mago> obtenerTodosMagos() {
        List<Mago> listaMagos = new ArrayList<>();
        EntityManager em = hibernateSingleton.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            listaMagos = em.createQuery("select m from Mago m", Mago.class).getResultList();
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error");
            if (tx != null && tx.isActive()) {
                tx.rollback();
                System.out.println("Se hace rollback de la transacción");
            }
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        } finally {
            if (em.isOpen()) em.close();
        }
        return listaMagos;
    }
}
