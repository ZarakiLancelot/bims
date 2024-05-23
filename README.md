# Book Inventory Management System

El sistema de gestión de inventario de libros es un proyecto en Java diseñado para ayudar a las librerías o bibliotecas a gestionar su inventario de libros de manera eficiente. El sistema proporciona funcionalidades para agregar, eliminar, actualizar y buscar libros en el inventario. Utiliza colecciones, conjuntos y mapas de Java para organizar y manipular los datos de los libros.

## Características

1. **Clase Book**: Define una clase `Book` con atributos como título, autor, ISBN, género, precio, cantidad, etc.
2. **Gestión de Inventario**: Implementa funcionalidades para agregar nuevos libros al inventario, eliminar libros, actualizar información de libros y recuperar detalles de libros.
3. **ISBN Único**: Asegura que cada libro en el inventario tenga un ISBN único para prevenir duplicados.
4. **Funcionalidad de Búsqueda**: Permite a los usuarios buscar libros por título, autor, género o ISBN.
5. **Clasificación de Géneros**: Clasifica libros en diferentes géneros (e.g., ficción, no ficción, misterio, romance) usando `EnumSet`.
6. **Información de Precios**: Almacena información de precios para cada libro.
7. **Gestión de Cantidad**: Realiza un seguimiento de la cantidad de cada libro en el inventario y actualiza la cantidad cuando se venden o reponen libros.
8. **Interfaz de Línea de Comandos (CLI)**: Proporciona una interfaz de línea de comandos simple para interactuar con el sistema, permitiendo a los usuarios realizar diversas operaciones en el inventario.

## Implementación

### Clases Principales

- `Book.java`: Representa un libro con sus atributos y métodos correspondientes.
- `BookInventory.java`: Gestiona el inventario de libros utilizando colecciones de Java.
- `Main.java`: Proporciona una interfaz de línea de comandos para interactuar con el sistema.
- `Genre.java`: Define una enumeración para los diferentes géneros de libros.

### Estructura del Proyecto

```bash
BookInventoryManagementSystem/
├── src/
│ └── com/
│ |  └── edwineinsen/
│ |    ├── Book.java
│ |    ├── BookInventory.java
│ |    ├── Genre.java
│ └── Main.java
└── out/
```


### Funcionalidades de la CLI

- **Agregar Libro**: Permite agregar un nuevo libro al inventario.
- **Eliminar Libro**: Permite eliminar un libro del inventario utilizando su ISBN.
- **Actualizar Libro**: Permite actualizar la información de un libro existente.
- **Buscar Libro**: Permite buscar libros por título, autor, género o ISBN.
- **Mostrar Inventario**: Muestra todos los libros en el inventario.
- **Vender Libro**: Permite vender una cantidad específica de un libro.
- **Reponer Libro**: Permite reponer una cantidad específica de un libro.

## Cómo Ejecutar el Proyecto

### Prerrequisitos

- [Java Development Kit (JDK) 8 o superior](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

### Configuración del Proyecto

1. Clona el repositorio en tu máquina local.
2. Abre IntelliJ IDEA y selecciona `File` -> `Open` y elige el directorio del proyecto.
3. Asegúrate de que el JDK esté configurado correctamente en `File` -> `Project Structure` -> `Project Settings` -> `Project`.
4. Configura la clase principal para ejecutar:
    - Ve a `Run` -> `Edit Configurations`.
    - Haz clic en el botón `+` y selecciona `Application`.
    - Ponle un nombre a la configuración.
    - En el campo `Main class`, escribe `com.edwineinsen.Main`.
    - Haz clic en `OK`.
5. Haz clic en el botón de `Run` (triángulo verde) en la esquina superior derecha de IntelliJ IDEA o presiona `Shift + F10`.

## Uso del Sistema

Sigue las instrucciones en la CLI para agregar, eliminar, actualizar, buscar, vender, reponer y mostrar libros en el inventario. La interfaz es interactiva y te pedirá los detalles necesarios para cada operación.

## Contribuir

Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza los cambios necesarios y haz commit (`git commit -am 'Agrega nueva funcionalidad'`).
4. Sube los cambios a tu rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para obtener más detalles.
