package com.example.controlador;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// La clase Database define el método `getInstance` que permite
// a los clientes acceder a la misma instancia de una conexión
// a la base de datos en todo el programa.
class HibernateSingleton {
    // Campo estático para almacenar la instancia única.
    private static HibernateSingleton instance;
    private SessionFactory session;

    // El constructor es privado para evitar llamadas directas con `new`.
    private HibernateSingleton() {
        this.session = new Configuration().configure().buildSessionFactory();

        
    }

    // Método estático que controla el acceso a la instancia del Singleton.
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

    public SessionFactory getSession() {
        return session;
    }

    
}