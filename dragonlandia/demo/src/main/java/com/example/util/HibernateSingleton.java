package com.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

// Singleton que expone un EntityManagerFactory y proporciona EntityManagers.
public class HibernateSingleton {
    private static HibernateSingleton instance;
    private EntityManagerFactory emf;

    /**
     * Constructor privado para evitar instanciación externa.
     */
    private HibernateSingleton() {
        // Usa la unidad de persistencia definida en `persistence.xml`
        this.emf = Persistence.createEntityManagerFactory("dragolandiaServizo");
    
    }

    /**
     * Obtiene la instancia única de HibernateSingleton.
     * @return
     */
    public static HibernateSingleton getInstance() {
        if (instance == null) {
            synchronized (HibernateSingleton.class) {
                if (instance == null) {
                    instance = new HibernateSingleton();
                }
            }
        }
        return instance;
    }

    /**
     * Obtiene un nuevo EntityManager.
     * @return
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /** 
     * Cierra el EntityManagerFactory cuando ya no es necesario.
     */
    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
