package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.controlador.HibernateSingleton;
import com.example.model.Dragon;

/**
 * Clase que gestiona las operaciones de acceso a datos para la entidad Dragon.
 */
public class DragonDAO {
    SessionFactory hibernateSingleton = HibernateSingleton.getInstance().getSession();

    /**
     * Guarda el dragon en la base de datos.
     */
    public void guardarDragon(Dragon dragon) {
        Transaction tx = null;
        try (Session session = hibernateSingleton.openSession();) {
            tx = session.beginTransaction();
            session.persist(dragon);
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
     * Borrar el dragon en la base de datos.
     */
    public void borrarDragon(Dragon dragon) {
        Transaction tx = null;
        try (Session session = hibernateSingleton.openSession();) {
            tx = session.beginTransaction();
            session.remove(dragon);
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
     * Actualiza el dragon en la base de datos.
     */
    public void actualizarDragon(Dragon dragon) {
        Transaction tx = null;
        try (Session session = hibernateSingleton.openSession();) {
            tx = session.beginTransaction();
            session.merge(dragon);
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
     * Obtiene los dragones de la base de datos
     */
    public List<Dragon> obtenerTodosDragones() {
        List<Dragon> listaDragones = new ArrayList<>();
        Transaction tx = null;
        try (Session session = hibernateSingleton.openSession();) {
            tx = session.beginTransaction();
            listaDragones = session.createQuery("select d from Dragon d", Dragon.class).list();
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
        return listaDragones;
    }
}
