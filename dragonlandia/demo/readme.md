# Dragolandia

## Introduccion
Tarea de Cristina donde debemos crear una aplicación Java en VSCode, Maven e Hibernate donde implementamos una aplicación con 3 clases (bosque, mago y monstruo). Cuyo flujo de ejecución es el siguiente:
1. Pedirle datos sobre el mago, monstruo y bosque al usuario
2. Iniciar una batalla entre el mago y el monstruo en el bosque e indicar quien gana.

## Analisis
### Diagrama de clases

``` code: mermaid
---
config:
  look: classic
  theme: mc
---
classDiagram
class Mago{
    -int id
    -String nombre
    -int vida
    -int nivelMagia

    +lanzarHechizo(Monstruo monstruo) : void
    +lanzarHechizo(Monstruo monstruo, Hechizo hechizo) : void
}
class Monstruo{
    -int id
    -String nombre
    -int vida
    -TipoMonstruo tipo
    -int fuerza

    +atacar(Mago mago) : void
}
class Bosque{
    -int id
    -String nombre
    -int nivelPeligro
    -Monstruo monstruo
    -List<Monstruo> listaMonstruos

    +mostrarJefe(Monstruo monstruo) : void
    +cambiarJefe(Monstruo monstruo) : void
}

class ControladorMago{
    -Mago mago
}

class ControladorMonstruo{
    -Monstruo monstruo
}
class ControladorBosque{
    -Bosque bosque
}

class Controlador {
    -ControladorMago ControladorMago
    -ControladorMonstruo ControladorMonstruo
    -ControladorBosque ControladorBosque
}

class Hechizo {
    + Efecto(List<Monstruo> monstruo) : void
}
class BolaFuego {
    + Efecto(List<Monstruo> monstruo) : void
}
class RayoHielo {
    + Efecto(List<Monstruo> monstruo) : void
}
class BolaNieve {
    + Efecto(List<Monstruo> monstruo) : void
}
class Intimidacion {
    + Efecto(List<Monstruo> monstruo) : void
}




Mago <|-- ControladorMago
Monstruo <|-- ControladorMonstruo
Bosque <|-- ControladorBosque
ControladorBosque <|-- Controlador
ControladorMago <|-- Controlador
ControladorMonstruo <|-- Controlador
BolaFuego <|-- Hechizo
RayoHielo <|-- Hechizo
BolaNieve <|-- Hechizo
Intimidacion <|-- Hechizo
Hechizo <|-- Mago
``` 
## Diseño
### Diagrama entidad relacion

``` code: mermaid
erDiagram
    MAGO {
        int id PK
        String nombre
        int vida
        int nivelMagia
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
        int monstruo_id FK
    }

    BOSQUE ||--o{ MONSTRUO : contiene
```



### Pendiente de implementar
1:n bosque - monstruo
singleton para sessiones
Un Dragón habita en un Bosque.