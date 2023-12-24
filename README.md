
# EasyOnlineShop API REST

Bienvenido al repositorio de EasyOnlineShop, una API REST construida con Spring Boot 3, Maven y Java 17.

## Prerrequisitos

Antes de comenzar, asegúrese de tener instalado lo siguiente:
- JDK 17
- Maven
- MySQL

## Cómo hacer Fork y Clonar el Repositorio

Para contribuir o usar este proyecto en su entorno local, puede hacer fork de este repositorio y luego clonarlo usando el siguiente comando:

```bash
git clone https://github.com/TerronesDiaz/easyOnlineShopApiRest.git
```

## Configuración de la Base de Datos

Antes de ejecutar la aplicación, cree una base de datos MySQL llamada `easyOnlineShop` o configure las propiedades de conexión de la base de datos en `src/main/resources/application.properties` como prefiera:

```
spring.datasource.url=jdbc:mysql://localhost:3306/easyOnlineShop?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
```

## Cómo Ejecutar la Aplicación

Si el proyecto incluye Maven Wrapper, puede ejecutar la aplicación sin necesidad de tener Maven instalado. En su terminal, utilice el siguiente comando:

```bash
./mvnw spring-boot:run
```

En Windows, si está utilizando CMD, puede necesitar omitir `./` antes del comando.

La aplicación se iniciará y estará disponible en `http://localhost:8090`.

## Endpoints de la API

La documentación de los endpoints está disponible una vez ejecutada la API REST en http://localhost:8090/doc/swagger-ui/index.html.

## Contribuir

Si desea contribuir al proyecto, por favor siga estos pasos:

1. Haga fork del repositorio.
2. Realice sus cambios en una nueva rama.
3. Envíe un pull request para que sus cambios sean revisados e integrados en el proyecto principal.

## Licencia

Este proyecto está bajo la [Licencia MIT].

Gracias por usar y contribuir a EasyOnlineShop.
