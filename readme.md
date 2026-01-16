# Dragolandia

## Introduccion

Tarea de Cristina donde debemos crear una aplicación Java en VSCode, Maven e Hibernate donde implementamos una aplicación con 3 clases (bosque, mago, monstruo y dragon). Cuyo flujo de ejecución es el siguiente en su version final:
1. En el menu escoger la opcion 17 Iniciar batalla avanzada
2. Crear magos
3. Crear monstruos
4. Crear dragon
5. Crear bosque
6. Manejar los magos durante la batalla
7. Ver si has perdido o ganado

## Analisis
### Diagrama de clases

``` mermaid
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

``` mermaid
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

    DRAGON {
        int id PK
        String nombre
        int intensidadFuego
        int resistencia
    }

    %% Relaciones (expresadas textualmente)
    MAGO ||--o{ HECHIZOS : tiene

    BOSQUE ||--o{ MONSTRUO : tiene

    BOSQUE }o--|| MONSTRUO : "monstruo_jefe (FK)"
    BOSQUE }o--|| DRAGON : "dragon (FK)" 
```

## Pom.xml explicacion

Tiene 4 dependencias
- Junit viene por defecto con el proyecto sirve para pruebas unitarias
- mysql es el conector que sirve para interactuar con la base de datos mysql
- jakarta persistence sirve para usar las anotaciones de JPA
- hibernate interactua con la base de datos usando JPA


## Amplicacion

- El dragon pueda ser atacado por los monstruos que habitan en el bosque.
- Que el uso de hechizos cueste puntos de magia al mago (nuevo atributo).
- Que los tipos de monstruos tengan resistencias o debilidades frente a ciertos tipos de hechizos.
- Que el monstruo jefe tenga habilidades especiales.

## Manual usuario

[Manual de usuario Dragolandia](manualUsuario.md)

## Imagenes de la bd
[Imagenes bd](imagenes_bd.pdf)