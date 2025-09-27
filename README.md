# Student Management REST API

This project is a simple RESTful API for managing students and courses, built with Java and the Spring Boot framework.
It uses Google Firebase Firestore as its NoSQL database for data storage.

## Features

* Full CRUD (Create, Read, Update, Delete) functionality for **Students**.
* Full CRUD (Create, Read, Update, Delete) functionality for **Courses**.
* Layered architecture (Controller, Service, Repository).
* RESTful API design principles.

## Technologies Used

* **Java 21**
* **Spring Boot**
* **Apache Maven**
* **Firebase Firestore** (via Firebase Admin SDK)
* **Lombok**

## Prerequisites

Before you begin, ensure you have the following installed on your system:

* Java Development Kit (JDK) 21.
* Apache Maven.
* A Google Firebase account and an active project.

## Setup and Installation

Follow these steps to get the application running locally.

### 1. Clone the Repository

Clone this project from your GitHub repository to your local machine.

```sh
git clone https://github.com/KovinthKrishna/Student-Management
cd Student-Management
```

### 2. Firebase Configuration

This application requires a Firebase service account key to communicate with your Firestore database.

1. Go to your **[Firebase Console](https://console.firebase.google.com/)**.
2. Navigate to **Project settings** \> **Service accounts**.
3. Click **"Generate new private key"** to download your service account JSON file.
4. Rename the downloaded file to `serviceAccountKey.json`.
5. Place this file inside the `src/main/resources/` directory of the project.

### 3. Build the Project

Use Maven to build the project and download all dependencies.

```sh
mvn clean install
```

### 4. Run the Application

You can now run the Spring Boot application using the Maven plugin.

```sh
mvn spring-boot:run
```

The application will start and be accessible at `http://localhost:8080`.

## API Documentation

### Student APIs

| Method   | Endpoint               | Description                  |
|:---------|:-----------------------|:-----------------------------|
| `POST`   | `/student`             | Creates a new student.       |
| `GET`    | `/students`            | Retrieves all students.      |
| `GET`    | `/student/{studentId}` | Retrieves a single student.  |
| `PUT`    | `/student`             | Updates an existing student. |
| `DELETE` | `/student/{studentId}` | Deletes a student.           |

### Course APIs

| Method   | Endpoint             | Description                 |
|:---------|:---------------------|:----------------------------|
| `POST`   | `/course`            | Creates a new course.       |
| `GET`    | `/courses`           | Retrieves all courses.      |
| `GET`    | `/course/{courseId}` | Retrieves a single course.  |
| `PUT`    | `/course`            | Updates an existing course. |
| `DELETE` | `/course/{courseId}` | Deletes a course.           |

## Postman Collection

For easy testing, a Postman collection has been included in the root of the project. You can import the
`Student_Management_API.postman_collection.json` file into Postman to get all the API requests set up.

Sample requests and responses are included in `Sample requests and responses.pdf`