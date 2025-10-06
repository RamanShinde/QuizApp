# 🧠 Online Quiz Application — Backend API

This repository contains a backend implementation of an **Online Quiz Application**, built using **Java**, **Spring Boot**, and **MySQL**. It provides a RESTful API for creating quizzes, adding questions with multiple options, submitting answers, and calculating scores. The project emphasizes clean architecture, robust validation, and centralized exception handling.

---

## 📌 Features

- Create quizzes with custom questions and options  
- Submit answers and receive score feedback  
- Validation on all DTOs using Jakarta annotations  
- Global exception handling for clean error responses  
- Modular architecture with DTOs, entities, services, and controllers

---

## 🛠️ Tech Stack

- Java 17  
- Spring Boot 3  
- MySQL  
- Jakarta Validation  
- Lombok  
- Postman (for testing)  
- GitHub (for version control)
- Maven

---

##  How to Run Locally

### 1. Clone the repository
```bash
git clone https://github.com/RamanShinde/QuizApp.git
cd QuizApp/QuizApplication
```

### 2. Set up MySQL
- Create a database named `quiz_app`
- Update your `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quiz_app
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build and run the app
```bash
./mvnw spring-boot:run
```
Or if using Maven directly:
```bash
mvn spring-boot:run
```

---

##  API Endpoints

### Create Quiz
`POST /api/Quiz/create`
```json
{ "quizName": "Java Basics" }
```

### Add Question
`POST /api/Quiz/{quizId}/addQuestion`
```json
{
  "question": "What is the default value of int in Java?",
  "options": [
    { "text": "0", "correct": true },
    { "text": "null", "correct": false },
    { "text": "undefined", "correct": false },
    { "text": "NaN", "correct": false }
  ]
}
```

### Submit Quiz
# API-`POST /api/Quiz/submit`
```json
{
  "quizId": 1,
  "answers": [
    { "questionId": 101, "selectedOptionId": 1001 },
    { "questionId": 102, "selectedOptionId": 1005 }
  ]
}
```

### Get Questions
 # API -`GET /api/Quiz/{quizId}/questions`

### Search Quiz by Name
# API-`GET /api/Quiz/get/{quizName}`

### Submit Quiz
`POST /api/Quiz/submit`

Submits answers for a quiz and returns the score based on correct selections.

#### 📦 Sample Request
```json
{
  "quizId": 1,
  "answers": [
    {
      "questionId": 1,
      "selectedOptionId": 4
    },
    {
      "questionId": 2,
      "selectedOptionId": 5
    }
  ]
}
```

#### 📦 Sample Response
```json
{
  "score": 2,
  "total": 2
}
```

####  Notes
- `score` represents the number of correct answers submitted.
- `total` is the total number of questions in the quiz.
- Each question is evaluated based on whether the selected option is marked as correct.
- If one selected option is correct, the score will be `1`.  
- In the example above, both selected options are correct — so the score returned is `2`.


---

## 🧪 How to Test

- Use **Postman** to send requests to the endpoints above.
- All validation errors will return clean messages like:
```json
{
  "error": "quizName: Quiz name must not be blank"
}
```

---

## 🧠 Design Choices & Assumptions

- Used `@Valid` and `@ControllerAdvice` for centralized validation and error handling  
- DTOs are separated from entities to maintain clean architecture  
- Quiz scoring is based on matching selected option with correct flag  
- Assumes each question has exactly one correct option  

---

## 🙌 Author

**Raman Shinde**  
Java Full Stack Developer  
📍 Pune, India  
🔗 [LinkedIn](https://www.linkedin.com/in/raman-shinde/)

---
