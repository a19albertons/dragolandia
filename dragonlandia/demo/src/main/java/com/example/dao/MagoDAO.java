package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.controlador.HibernateSingleton;
import com.example.model.Mago;

/**
 * Clase que gestiona las operaciones de acceso a datos para la entidad Mago.
 */
public class MagoDAO {
    SessionFactory hibernateSingleton = HibernateSingleton.getInstance().getSession();

    /**
     * Guarda el mago en la base de datos.
     */
    public void guardarMago(Mago mago) {
        Transaction tx = null;
        try (Session session = hibernateSingleton.openSession();) {
            tx = session.beginTransaction();
            session.persist(mago);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error");
            if (tx != null && tx.isActive()) {
                tx.rollback();
                System.out.println("Se hace rollback de la transacción");
            }
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

    /**
     * Borrar el mago en la base de datos.
     */
    public void borrarMago(Mago mago) {
        Transaction tx = null;
        try (Session session = hibernateSingleton.openSession();) {
            tx = session.beginTransaction();
            session.remove(mago);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error");
            if (tx != null && tx.isActive()) {
                tx.rollback();
                System.out.println("Se hace rollback de la transacción");
            }
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

    /**
     * Actualiza el mago en la base de datos.
     */
    public void actualizarMago(Mago mago) {
        Transaction tx = null;
        try (Session session = hibernateSingleton.openSession();) {
            tx = session.beginTransaction();
            session.merge(mago);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error");
            if (tx != null && tx.isActive()) {
                tx.rollback();
                System.out.println("Se hace rollback de la transacción");
            }
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

    /**
     * Obtiene los magos de la base de datos
     */
    public List<Mago> obtenerTodosMagos() {
        List<Mago> listaMagos = new ArrayList<>();
        Transaction tx = null;
        try (Session session = hibernateSingleton.openSession();) {
            tx = session.beginTransaction();
            listaMagos = session.createQuery("select m from Mago m", Mago.class).list();
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error");
            if (tx != null && tx.isActive()) {
                tx.rollback();
                System.out.println("Se hace rollback de la transacción");
            }
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        return listaMagos;
    }
}
