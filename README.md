# Postal Code Distance API

## Overview

This is a RESTful service that calculates the straight-line geographic distance between two UK postal codes. It uses the Haversine formula to compute the distance based on latitude and longitude.

## Features

- Look up latitude and longitude for given UK postal codes.
- Compute the distance between two postal codes in kilometers.
- Returns results in JSON format.
- Uses a CSV file for postal code data.

## Technologies Used

- Java 17+
- Spring Boot
- Maven
- JUnit for unit testing

## Setup Instructions

### Prerequisites

- Java 17 or higher installed
- Maven installed
- Git installed

### Cloning the Repository

```sh
git clone https://github.com/anasfurdaus/postal-code-distance-api.git
cd postal-code-distance-api
```

### Running the Application

1. Ensure that the `postcodes.csv` file is placed in `src/main/resources/`.
2. Build and run the project using Maven:
   ```sh
   mvn spring-boot:run
   ```
3. The application should be available at `http://localhost:8080`.

### API Endpoints

#### Calculate Distance Between Two Postal Codes

**Request:**

```http
GET /distance/{postalCode1}/{postalCode2}
```

**Example:**

```http
GET http://localhost:8080/distance/B34/IP10
```

**Response:**

```json
{
    "postalCode1": {
        "postalCode": "B34",
        "latitude": 52.4964133,
        "longitude": -1.7817039
    },
    "postalCode2": {
        "postalCode": "IP10",
        "latitude": 52.0189774,
        "longitude": 1.2699895
    },
    "distance": 214.3,
    "unit": "km",
}
```



### Running Tests

Run the unit tests with:

```sh
mvn test
```

## Future Improvements

- Support for updating postal code data via REST endpoints.
- Implement authentication for API access.
- Improve request logging for analytics.

## Author

Anas

## License

This project is licensed under the MIT License.

