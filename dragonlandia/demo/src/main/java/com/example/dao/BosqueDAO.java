package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import com.example.model.Bosque;
import com.example.model.Dragon;
import com.example.model.Monstruo;
import com.example.util.HibernateSingleton;

/**
 * Clase que gestiona las operaciones de acceso a datos para la entidad Bosque.
 */
public class BosqueDAO {
    HibernateSingleton hibernateSingleton = HibernateSingleton.getInstance();

    /**
     * Guarda el bosque en la base de datos.
     */
    public void guardarBosque(Bosque bosque) {
        EntityManager em = hibernateSingleton.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(bosque);
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
     * Borrar el bosque en la base de datos.
     */
    public void borrarBosque(Bosque bosque) {
        EntityManager em = hibernateSingleton.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(bosque);
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
     * Actualiza el bosque en la base de datos.
     */
    public void actualizarBosque(Bosque bosque) {
        EntityManager em = hibernateSingleton.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(bosque);
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
     * Obtiene los bosques de la base de datos
     */
    public List<Bosque> obtenerTodosBosques() {
        List<Bosque> listaBosques = new ArrayList<>();
        EntityManager em = hibernateSingleton.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            listaBosques = em.createQuery("select b from Bosque b", Bosque.class).getResultList();
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
        return listaBosques;
    }

    /**
     * Obtiene un bosque por id
     */
    public Bosque obtenerBosque(int id) {
        Bosque bosque = null;
        EntityManager em = hibernateSingleton.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            bosque = em.createQuery("select b from Bosque b where b.id = :id", Bosque.class)
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
        return bosque;
    }

    /**
     * Obtiene los monstruos que no estan asignados a ningun bosque.
     * 
     * @return
     */
    public List<Monstruo> obtenerMonstruosSinBosque() {
        List<Monstruo> listaMonstruos = new ArrayList<>();
        EntityManager em = hibernateSingleton.getEntityManager();
        try {
            listaMonstruos = em
                    .createQuery("select m from Monstruo m where m not in (select mo from Bosque b join b.listaMonstruos mo)",
                            Monstruo.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error al obtener monstruos sin bosque");
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
     * Obtiene los dragones que no estan asignados a ningun bosque.
     * 
     * @return
     */
    public List<Dragon> obtenerDragonesSinBosque() {
        List<Dragon> listaDragones = new ArrayList<>();
        EntityManager em = hibernateSingleton.getEntityManager();
        try {
            listaDragones = em
                    .createQuery("select d from Dragon d where d not in (select dr from Bosque b join b.dragon dr )", Dragon.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error al obtener dragones sin bosque");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }

        return listaDragones;
    }
}
