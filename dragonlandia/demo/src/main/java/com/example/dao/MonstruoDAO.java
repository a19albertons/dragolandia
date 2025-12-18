package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.controlador.HibernateSingleton;
import com.example.model.Monstruo;

/**
 * Clase que gestiona las operaciones de acceso a datos para la entidad Monstruo.
 */
public class MonstruoDAO {
    SessionFactory hibernateSingleton = HibernateSingleton.getInstance().getSession();

    /**
     * Guarda el monstruo en la base de datos.
     */
    public void guardarMonstruo(Monstruo monstruo) {
        Transaction tx = null;
        try (Session session = hibernateSingleton.openSession();) {
            tx = session.beginTransaction();
            session.persist(monstruo);
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
     * Borrar el monstruo en la base de datos.
     */
    public void borrarMonstruo(Monstruo monstruo) {
        Transaction tx = null;
        try (Session session = hibernateSingleton.openSession();) {
            tx = session.beginTransaction();
            session.remove(monstruo);
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
     * Actualiza el monstruo en la base de datos.
     */
    public void actualizarMonstruo(Monstruo monstruo) {
        Transaction tx = null;
        try (Session session = hibernateSingleton.openSession();) {
            tx = session.beginTransaction();
            session.merge(monstruo);
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
     * Obtiene los monstruos de la base de datos
     */
    public List<Monstruo> obtenerTodosMonstruos() {
        List<Monstruo> listaMonstruos = new ArrayList<>();
        Transaction tx = null;
        try (Session session = hibernateSingleton.openSession();) {
            tx = session.beginTransaction();
            listaMonstruos = session.createQuery("select m from Monstruo m", Monstruo.class).list();
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
        return listaMonstruos;
    }
}
