
# Denomination Calculator Backend

A Spring Boot Application to support the calculation of Euro denominations for entered amount through the web interface [denomination-calculator](https://github.com/ananddsouza/denomination-calculator).

Further details and description of this project can be found [here](https://github.com/ananddsouza/denomination-calculator?tab=readme-ov-file#details).

## Installation

To run this project, dependencies of the project must be installed using the following command.

`mvn install`

## Development server

Run `mvn spring-boot:run` command for a dev server or the project can be directly run from the `DenominationCalculatorApplication.java` class through an IDE.

After the spring boot project is initialised and active, the application will be live at `http://localhost:8080/`.


## API Endpoint

Since our project provides an endpoint `/api/denominations` to calculate Euro denominations, the following url is used to execute the same.

URL:

`http://localhost:8080/api/denominations`

Request:

`{
"currentAmount": 23.34,
"isCalculateOnServer": true,
"previousAmount": 0
}`