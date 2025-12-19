package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.controlador.HibernateSingleton;
import com.example.model.Bosque;
import com.example.model.Dragon;
import com.example.model.Monstruo;

/**
 * Clase que gestiona las operaciones de acceso a datos para la entidad Bosque.
 */
public class BosqueDAO {
    SessionFactory hibernateSingleton = HibernateSingleton.getInstance().getSession();

    /**
     * Guarda el bosque en la base de datos.
     */
    public void guardarBosque(Bosque bosque) {
        Transaction tx = null;
        try (Session session = hibernateSingleton.openSession();) {
            tx = session.beginTransaction();
            session.persist(bosque);
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
     * Borrar el bosque en la base de datos.
     */
    public void borrarBosque(Bosque bosque) {
        Transaction tx = null;
        try (Session session = hibernateSingleton.openSession();) {
            tx = session.beginTransaction();
            session.remove(bosque);
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
     * Actualiza el bosque en la base de datos.
     */
    public void actualizarBosque(Bosque bosque) {
        Transaction tx = null;
        try (Session session = hibernateSingleton.openSession();) {
            tx = session.beginTransaction();
            session.merge(bosque);
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
     * Obtiene los bosques de la base de datos
     */
    public List<Bosque> obtenerTodosBosques() {
        List<Bosque> listaBosques = new ArrayList<>();
        Transaction tx = null;
        try (Session session = hibernateSingleton.openSession();) {
            tx = session.beginTransaction();
            listaBosques = session.createQuery("select b from Bosque b", Bosque.class).list();
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
        return listaBosques;
    }

    /**
     * Obtiene los monstruos que no estan asignados a ningun bosque.
     * 
     * @return
     */
    public List<Monstruo> obtenerMonstruosSinBosque() {
        List<Monstruo> listaMonstruos = new ArrayList<>();
        try (Session session = hibernateSingleton.openSession()) {
            listaMonstruos = session
                    .createQuery("select m from Monstruo m where m not in (select mo from Bosque b join b.listaMonstruos mo)",
                            Monstruo.class)
                    .list();
        } catch (Exception e) {
            System.out.println("Error al obtener monstruos sin bosque");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

        return listaMonstruos;
    }

    /**
     * Obtiene los dragones que no estan asignados a ningun bosque.
     * 
     * @return
     */
    public List<Dragon> obtenerDragonesSinBosque() {
        List<Dragon> listaDragones = new ArrayList<>();
        try (Session session = hibernateSingleton.openSession()) {
            listaDragones = session
                    .createQuery("select d from Dragon d where d not in (select dr from Bosque b join b.dragon dr )", Dragon.class)
                    .list();
        } catch (Exception e) {
            System.out.println("Error al obtener dragones sin bosque");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

        return listaDragones;
    }
}
