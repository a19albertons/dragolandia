package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import com.example.model.Monstruo;
import com.example.util.HibernateSingleton;

/**
 * Clase que gestiona las operaciones de acceso a datos para la entidad
 * Monstruo.
 */
public class MonstruoDAO {
    HibernateSingleton hibernateSingleton = HibernateSingleton.getInstance();

    /**
     * Guarda el monstruo en la base de datos.
     * 
     * @param monstruo monstruo a guardar
     */
    public void guardarMonstruo(Monstruo monstruo) {
        EntityManager em = hibernateSingleton.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(monstruo);
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
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    /**
     * Borrar el monstruo en la base de datos.
     * 
     * @param monstruo monstruo a borrar
     */
    public void borrarMonstruo(Monstruo monstruo) {
        EntityManager em = hibernateSingleton.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(monstruo);
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
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    /**
     * Actualiza el monstruo en la base de datos.
     * 
     * @param monstruo monstruo a actualizar
     */
    public void actualizarMonstruo(Monstruo monstruo) {
        EntityManager em = hibernateSingleton.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(monstruo);
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
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    /**
     * Obtiene los monstruos de la base de datos
     * 
     * @return lista de monstruos obtenida
     */
    public List<Monstruo> obtenerTodosMonstruos() {
        List<Monstruo> listaMonstruos = new ArrayList<>();
        EntityManager em = hibernateSingleton.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            listaMonstruos = em.createQuery("select m from Monstruo m", Monstruo.class).getResultList();
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
            if (em.isOpen()) {
                em.close();
            }
        }
        return listaMonstruos;
    }

    /**
     * Obtiene un monstruo por id
     * 
     * @param id
     * @return monstruo obtenido
     */
    public Monstruo obtenerMonstruo(int id) {
        Monstruo monstruo = null;
        EntityManager em = hibernateSingleton.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            monstruo = em.createQuery("select m from Monstruo m where m.id = :id", Monstruo.class)
                    .setParameter("id", id)
                    .getSingleResult();
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
            if (em.isOpen()) {
                em.close();
            }
        }
        return monstruo;
    }
}
