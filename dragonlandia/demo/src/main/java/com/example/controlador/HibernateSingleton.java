package com.example.controlador;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

// Singleton que expone un EntityManagerFactory y proporciona EntityManagers.
public class HibernateSingleton {
    private static HibernateSingleton instance;
    private EntityManagerFactory emf;

    private HibernateSingleton() {
        // Usa la unidad de persistencia definida en `persistence.xml`
        this.emf = Persistence.createEntityManagerFactory("dragolandiaServizo");
    
    }

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

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
