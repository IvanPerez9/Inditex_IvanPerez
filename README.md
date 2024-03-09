![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Springboot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)

# Prueba técnica

Entrar dentro de la carpeta "Prueba"
- Prueba redactada en el archivo adjunto como "TestJava2024.txt"
- Código dentro de la carpeta "inditex"

#### Índice

1. [Prueba Técnica](#Prueba-tecnica)
2. [Tecnologías](#Tecnologías)
3. [Iniciar el proyecto](#Iniciar-el-proyecto)
4. [Ejecutar los test](#Ejecutar-los-test)
5. [Detalles](#Detalles-sobre-el-proyecto)

---
## Tecnologías

- Java 21 y Springboot 3.2.3
    - Última LTS de Java y la ultima versión de SpringBoot que no es Snapshoot. Creo que es lo mejor, directamente partir de últimas versiones ya testeadas y que tienen mayor soporte oficial.

- Eclipse - STS 4.21
- Plugins:
    - Jautodoc 1.16.0
    - SonarLint 9.3.0
    - EclEmma Java code coverage 3.1.8
- Mockito
- JUnit 5

---
## Iniciar el proyecto

Clonar el repositorio

```
git clone https://github.com/IvanPerez9/Inditex_IvanPerez.git
```

Importar la carpeta 'inditex' en eclipse o el IDE de preferencia.

Importar dentro de Eclipse:

File -&gt; Import -&gt; Existing Maven projects -&gt; Seleccionar el proyecto, detectará el pom automáticamente

Dentro de eclipse, usar botón derecho 'Run As' o 'Debug As'

![lanzar](https://github.com/IvanPerez9/Inditex_IvanPerez/blob/main/Imagenes/Lanzar.PNG)

---
## Ejecutar los test

Apoyar con el plugin y poder lanzar un 'Coverage as'

![coverage](https://github.com/IvanPerez9/Inditex_IvanPerez/blob/main/Imagenes/CoverageLanzar.png)

También se puede mediante el comando

```
mvn clean install
```

![consola](https://github.com/IvanPerez9/Inditex_IvanPerez/blob/main/Imagenes/Test.PNG)

---
## Detalles sobre el proyecto

- Como ORM uso JPA, ya que me facilita las queries a la BBDD embebida como H2. Se encarga de transformar los objetos java en sentencias SQL.

- Se añade un endpoint más, que es un Get All para mostrar la tabla de PRICES al completo. Es totalmente funcional y se le añaden test adicionales.

- Se saca una colección de postman para probar los endpoint no solo con los test. Colección de Postman para realizar las pruebas:
    -   [Postman](https://github.com/IvanPerez9/Inditex_IvanPerez/tree/main/Postman)

- Como patrón, usando springboot está presente la inyección de dependencias. La inyección de las dependencias las hago mediante constructor, ya que es la recomendada para la mayoría de casos, aunque podría haber sido por campo, ya que el ejemplo es básico.
