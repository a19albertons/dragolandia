# Dragolandia

## Introduccion
Tarea de Cristina donde debemos crear una aplicación Java en VSCode, Maven e Hibernate donde implementamos una aplicación con 3 clases (bosque, mago y monstruo). Cuyo flujo de ejecución es el siguiente:
1. Pedirle datos sobre el mago, monstruo y bosque al usuario
2. Iniciar una batalla entre el mago y el monstruo en el bosque e indicar quien gana.

## Analisis
### Diagrama de clases

``` Mermaid
classDiagram
class Mago {
  -int id
  -String nombre
  -int vida
  -int nivelMagia
  -List<Hechizo> conjuros
  +lanzarHechizo(Monstruo) : void
  +lanzarHechizo(Monstruo, Hechizo) : void
}

class Monstruo {
  -int id
  -String nombre
  -int vida
  -TipoMonstruo tipo
  -int fuerza
  +atacar(Mago) : void
}

class Bosque {
  -int id
  -String nombre
  -int nivelPeligro
  -Monstruo monstruoJefe
  -List<Monstruo> listaMonstruos
  -Dragon dragon
  +mostrarJefe() : void
  +cambiarJefe(Monstruo) : void
  +addMonstruo(Monstruo) : void
}

class Dragon {
  -int id
  -String nombre
  -int intensidadFuego
  -int resistencia
  +exhalar(Monstruo) : void
}

class Hechizo {
  <<abstract>>
  -int id
  +efecto(List<Monstruo>) : void
}

class BolaFuego
class Rayo
class BolaNieve
class Intimidacion

Mago --> Hechizo : 1..*
Bosque --> Monstruo : 1..*
Bosque --> Monstruo : 1 [monstruoJefe]
Bosque --> Dragon : 1
Hechizo <|-- BolaFuego
Hechizo <|-- Rayo
Hechizo <|-- BolaNieve
Hechizo <|-- Intimidacion
``` 
## Diseño
### Diagrama entidad relacion

``` Mermaid
erDiagram
    MAGO {
        int id PK
        String nombre
        int vida
        int nivelMagia
    }
    HECHIZOS {
        int id PK
        String tipo       
    }
    MAGO_HECHIZOS {
        int mago_id FK
        int hechizo_id FK
    }

    MONSTRUO {
        int id PK
        String nombre
        int vida
        String tipo
        int fuerza
    }

    BOSQUE {
        int id PK
        String nombre
        int nivelPeligro
        int monstruo_jefe_id FK
        int dragon_id FK
    }
    BOSQUE_MONSTRUOS {
        int bosque_id FK
        int monstruo_id FK
    }

    DRAGON {
        int id PK
        String nombre
        int intensidadFuego
        int resistencia
    }

    %% Relaciones (expresadas textualmente)
    MAGO ||--o{ MAGO_HECHIZOS : tiene
    HECHIZOS ||--o{ MAGO_HECHIZOS : pertenece_a

    BOSQUE ||--o{ BOSQUE_MONSTRUOS : tiene
    MONSTRUO ||--o{ BOSQUE_MONSTRUOS : habita_en

    BOSQUE }o--|| MONSTRUO : "monstruo_jefe (FK)"
    BOSQUE }o--|| DRAGON : "dragon (FK)" 
```
