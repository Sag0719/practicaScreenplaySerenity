# Proyecto de Pruebas de Clientes - RestAPI

Este proyecto contiene un conjunto de pruebas automatizadas para interactuar con una API de clientes. Las pruebas están diseñadas para asegurar que las operaciones CRUD (Crear, Actualizar, Eliminar) se realicen correctamente en el sistema.

## Requisitos

- Java 11 o superior
- Gradle 6.0 o superior

## Estructura del Proyecto

El proyecto está basado en Serenity BDD y Cucumber para las pruebas automatizadas, utilizando Gradle como herramienta de construcción.
La API es una API online creada en MockAPI.io

### Tareas principales

- **POST**: Crear un cliente en el sistema.
- **PUT**: Actualizar la información de un cliente existente.
- **DELETE**: Eliminar un cliente del sistema.

## Ejecución de los Tests

**Nota:** Los tests deben ejecutarse en el siguiente orden manualmente (ejecutar uno por uno):

CreateClientStepDefinition
UpdateClientStepDefinition
DeleteClientStepDefinition
Esto es necesario ya que el test de actualización (PUT) depende de que el cliente haya sido creado previamente, y el test de eliminación (DELETE) depende de que el cliente haya sido actualizado.

### Dependencias
Las dependencias principales de este proyecto incluyen:

Serenity BDD: Framework para pruebas de aceptación automatizadas.
Cucumber: Para definir los escenarios de prueba en Gherkin.
Rest Assured: Para interactuar con la API REST.
Gradle: Herramienta de construcción.
