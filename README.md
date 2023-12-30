
# EasyOnlineShop REST API

Welcome to the EasyOnlineShop repository, a REST API built with Spring Boot 3, Maven, and Java 17.

## Prerequisites

Before you begin, make sure you have installed:
- JDK 17
- Maven
- MySQL

## How to Fork and Clone the Repository

To contribute or use this project in your local environment, you can fork this repository and then clone it using the following command:

```bash
git clone https://github.com/TerronesDiaz/easyOnlineShopApiRest.git
```

## Database Configuration

Before running the application, create a MySQL database named `easyOnlineShop` or configure the database connection properties in `src/main/resources/application.properties` as you prefer:

```
spring.datasource.url=jdbc:mysql://localhost:3306/easyOnlineShop?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
```

## How to Run the Application

If the project includes Maven Wrapper, you can run the application without needing Maven installed. In your terminal, use the following command:

```bash
./mvnw spring-boot:run
```

On Windows, if you are using CMD, you might need to omit `./` before the command.

The application will start and be available at `http://localhost:8090`.

## API Endpoints Documentation

The documentation for the endpoints is available once the REST API is running at http://localhost:8090/public/doc/swagger-ui/index.html.

## Accessing Protected EndPoints using Swagger
To access the protected EndPoints, you first need to register or log in to obtain the token from the response of these public EndPoints:

![img_2.png](/media/png/img_2.png)

Then, you need to click on the lock button that says 'Authorize' if you want to use the token for all requests, or on the gray lock button if you only wish to apply it to a specific EndPoint. This will allow you to access the other requests that are not public and avoid the 403 error.

![img_1.png](/media/png/img_1.png)

## Contributing

If you want to contribute to the project, please follow these steps:

1. Fork the repository.
2. Make your changes in a new branch.
3. Submit a pull request for your changes to be reviewed and integrated into the main project.

## License

This project is under the [MIT License].

Thank you for using and contributing to EasyOnlineShop.
