# Spring IoT Message

This project demonstrates a Spring Boot application designed to handle IoT sensor data. It includes two main modules:

- **sensor-data-iot-server**: A server application that receives and processes sensor data.
- **sensor-data-iot-simulator**: A simulator that generates and sends mock sensor data to the server.

## Features

- **Spring Boot**: Leverages the Spring Boot framework for rapid application development and dependency management.
- **Data Processing**: Processes incoming sensor data for further analysis or storage.

## Getting Started

### Prerequisites

- **Java 11** or higher
- **Maven 3.6.0** or higher
- **RabbitMQ**: Ensure RabbitMQ is installed and running on your local machine.

### Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/acbueno/spring-iot-message.git
   
2. **Navigate to the project directory:**
   ```bash
  cd spring-iot-message
  
3. **Build the project using Maven:**
   ```bash
   mvn clean install
Running the Applications

5. **Start the Server Application:**
6. **Start the Simulator Application:**
  
```bash
  mvn spring-boot:run
 ```
## Acknowledgments
  - **Spring Boot**
  - **RabbitMQ**
  

