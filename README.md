Overview

The Online Quiz System is a web-based application designed to manage quizzes, questions, responses, and attempts. It allows users to participate in quizzes, record their responses, and track their performance.

Features

User authentication and authorization

Quiz creation and management

Question and options management

Quiz response recording

Performance tracking via quiz attempts

Tech Stack

Backend: Spring Boot, Java, ModelMapper

Database: MySQL

Frontend: React.js

Build Tool: Maven

Project Structure

src
 ├── main
 │    ├── java
 │    │    ├── com.quizsystem
 │    │    │    ├── controller
 │    │    │    ├── dto
 │    │    │    ├── entity
 │    │    │    ├── repository
 │    │    │    ├── service
 │    │    │    └── exception
 │    └── resources
 │         ├── application.properties
 └── test

ER Diagram

The system includes the following entities with relationships:

Quiz (One-to-Many) → QuizResponse

QuizResponse (Many-to-One) → QuizAttempt

QuizAttempt (Many-to-One) → User

Question (One-to-Many) → QuestionOption

QuestionOption (Many-to-One) → Question

Important Endpoints

QuizController

POST /api/quizzes/create - Create a quiz

GET /api/quizzes/{id} - Get quiz by ID

GET /api/quizzes/all - Get all quizzes

PUT /api/quizzes/update/{id} - Update quiz

DELETE /api/quizzes/delete/{id} - Delete quiz

QuizResponseController

POST /api/quizResponses/create - Create a quiz response

GET /api/quizResponses/{id} - Get quiz response by ID

GET /api/quizResponses/all - Get all quiz responses

PUT /api/quizResponses/update/{id} - Update quiz response

DELETE /api/quizResponses/delete/{id} - Delete quiz response

QuizAttemptController

POST /api/quizAttempts/create - Create a quiz attempt

GET /api/quizAttempts/{id} - Get quiz attempt by ID

GET /api/quizAttempts/all - Get all quiz attempts

PUT /api/quizAttempts/update/{id} - Update quiz attempt

DELETE /api/quizAttempts/delete/{id} - Delete quiz attempt

QuestionController

POST /api/questions/create - Create a question

GET /api/questions/{id} - Get question by ID

GET /api/questions/all - Get all questions

PUT /api/questions/update/{id} - Update question

DELETE /api/questions/delete/{id} - Delete question

QuestionOptionController

POST /api/questionOptions/create - Create a question option

GET /api/questionOptions/{id} - Get question option by ID

GET /api/questionOptions/all - Get all question options

PUT /api/questionOptions/update/{id} - Update question option

DELETE /api/questionOptions/delete/{id} - Delete question option

Setup Instructions

Clone the repository.

Navigate to the project directory.

Configure application.properties with the database connection.

Run mvn clean install to build the project.

Start the application using your IDE or mvn spring-boot:run.

Access the API via Postman or integrate it with the React frontend.

Sample Data

To quickly test the application, use the following sample data:

{
  "quizTitle": "Java Basics",
  "questions": [
    {
      "questionText": "What is Java?",
      "options": [
        { "optionText": "Programming Language", "correct": true },
        { "optionText": "Database", "correct": false }
      ]
    }
  ]
}

Notes

Ensure the database is running before starting the application.

Use Postman to test endpoints during development.

Future Enhancements

Implement user roles (admin, participant)

Add timer functionality for quizzes

Enhance UI/UX of the frontend
