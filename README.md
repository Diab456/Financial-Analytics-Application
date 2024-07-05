# Financial Analytics Application

## Overview
This project is a Financial Analytics Application that leverages Java with Spring Boot for backend services and Python with Flask for financial data analysis. The application fetches financial data from an external API, processes it, and presents the results through a user interface.

## Features
- Fetch and store financial data
- Analyze financial data using Python
- RESTful APIs for data management and analysis
- Integration with PostgreSQL for data persistence

## Technologies Used
- **Java**: Backend logic and REST API implementation
- **Spring Boot**: Framework for building the backend services
- **Python**: Financial data analysis
- **Flask**: Framework for the analysis service
- **PostgreSQL**: Database for data storage
- **Maven**: Dependency management
- **JUnit**: Testing framework
- **GitHub**: Version control

## Project Structure
financial-analytics-application/
├── finanalyzr/
│ ├── src/
│ │ ├── main/
│ │ │ ├── java/
│ │ │ │ ├── com/example/finanalyzr/
│ │ │ │ │ ├── controller/
│ │ │ │ │ ├── model/
│ │ │ │ │ ├── repository/
│ │ │ │ │ ├── service/
│ │ │ │ │ ├── FinanalyzrApplication.java
│ │ │ ├── resources/
│ │ │ │ ├── application.properties
│ │ ├── test/
│ │ │ ├── java/
│ │ │ │ ├── com/example/finanalyzr/
│ │ │ │ │ ├── FinanalyzrApplicationTests.java
├── flask_service/
│ ├── app.py
│ ├── requirements.txt
├── README.md
├── pom.xml



## Setup Instructions

### Prerequisites
- Java 17
- Maven
- PostgreSQL
- Python 3.x
- Flask

### Backend (Spring Boot)
1. Clone the repository:
    ```sh
    git clone https://github.com/your-username/financial-analytics-application.git
    cd financial-analytics-application/finanalyzr
    ```

2. Configure PostgreSQL in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/finanalyzr
    spring.datasource.username=your_db_username
    spring.datasource.password=your_db_password
    ```

3. Build and run the Spring Boot application:
    ```sh
    mvn clean install
    mvn spring-boot:run
    ```

### Analysis Service (Flask)
1. Navigate to the Flask service directory:
    ```sh
    cd flask_service
    ```

2. Create a virtual environment and activate it:
    ```sh
    python -m venv venv
    source venv/bin/activate  # On Windows use `venv\Scripts\activate`
    ```

3. Install the required dependencies:
    ```sh
    pip install -r requirements.txt
    ```

4. Run the Flask application:
    ```sh
    flask run
    ```

### API Endpoints

#### Spring Boot Endpoints
- **Get all financial data**
  ```http
  
#### Acknowledgements

- Spring Boot
-  Flask
-  PostgreSQL
-  Maven
-  JUnit




