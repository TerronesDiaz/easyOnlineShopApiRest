
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

## API Endpoints

The documentation for the endpoints is available once the REST API is running at http://localhost:8090/doc/swagger-ui/index.html.

## Contributing

If you want to contribute to the project, please follow these steps:

1. Fork the repository.
2. Make your changes in a new branch.
3. Submit a pull request for your changes to be reviewed and integrated into the main project.

## License

This project is under the [MIT License].

Thank you for using and contributing to EasyOnlineShop.
