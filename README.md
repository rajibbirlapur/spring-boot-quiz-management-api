# 📝 Quiz Application – Spring Boot REST API

A backend Quiz Application built using Spring Boot following layered architecture and RESTful API design principles.

This application allows users to:

- Manage Questions (CRUD operations)
- Create quizzes by category
- Fetch quiz questions
- Submit quiz responses
- Calculate and return quiz results

This project demonstrates strong backend development skills using Java and Spring Boot.

---

## 🚀 Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL / H2 Database
- Maven

---

## 🧱 Architecture

The project follows a layered architecture:

Controller → Service Interface → Service Implementation → Repository → Database

### Layers:

- Controller Layer – Handles HTTP requests
- Service Layer – Contains business logic
- Repository Layer – Communicates with database
- Model Layer – Entity classes
- Global Exception Handling (if implemented)

---

## 📂 Project Structure

com.learning.quizapp

- controller
  - QuestionController
  - QuizController

- service
  - QuestionService
  - QuizService
  - Service Implementations

- model
  - Question
  - Quiz
  - QuestionWrapper
  - Response

- repository
  - QuestionRepository
  - QuizRepository

- exception (if implemented)
  - GlobalExceptionHandler

- QuizAppApplication

---

# 🔗 Base URLs

```
http://localhost:8080/question
http://localhost:8080/quiz
```

---

# 📌 Question APIs

---

## 1️⃣ Get All Questions

GET `/question/allquestion`

Response:
- 200 OK
- Returns list of all questions

---

## 2️⃣ Get Questions By Category

GET `/question/category/{category}`

Example:
```
GET /question/category/Java
```

---

## 3️⃣ Get Question By ID

GET `/question/questionid/{id}`

Example:
```
GET /question/questionid/1
```

---

## 4️⃣ Add New Question

POST `/question/addquestion`

Request Body:

```json
{
  "questionTitle": "What is Java?",
  "option1": "Programming Language",
  "option2": "Database",
  "option3": "Operating System",
  "option4": "Browser",
  "rightAnswer": "Programming Language",
  "difficultyLevel": "Easy",
  "category": "Java"
}
```

Response:
- Question added successfully

---

## 5️⃣ Update Question

PUT `/question/updatequestion/{id}`

---

## 6️⃣ Delete Question

DELETE `/question/deletequestion/{id}`

---

# 📌 Quiz APIs

---

## 1️⃣ Create Quiz

POST `/quiz/create?category=Java&numQ=5&title=JavaBasics`

Parameters:
- category – Question category
- numQ – Number of questions
- title – Quiz title

Response:
- Quiz created successfully

---

## 2️⃣ Get Quiz Questions

GET `/quiz/get/{id}`

Returns:
- List of QuestionWrapper (Questions without correct answers)

---

## 3️⃣ Submit Quiz

POST `/quiz/submit/{id}`

Request Body:

```json
[
  {
    "questionId": 1,
    "response": "Programming Language"
  },
  {
    "questionId": 2,
    "response": "JVM"
  }
]
```

Response:
- Returns total score (Integer)

---

# ⚙️ How to Run the Project

### 1️⃣ Clone Repository

```
git clone https://github.com/your-username/quiz-application.git
```

### 2️⃣ Configure Database

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/quizdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Run Application

```
mvn spring-boot:run
```

Application will start at:

```
http://localhost:8080
```

---

# 🌟 Key Features Demonstrated

✔ RESTful API Development  
✔ Layered Architecture  
✔ Business Logic Separation  
✔ CRUD Operations  
✔ Dynamic Quiz Creation  
✔ Result Calculation Logic  
✔ Clean Code Structure  

---

# 🎯 Why This Project?

This project demonstrates:

- Strong understanding of Spring Boot
- Backend API development skills
- Real-world business logic implementation
- Database integration using JPA
- Clean and maintainable code practices

Suitable for:
- Java Backend Developer roles
- Spring Boot Developer
- Internship positions

---

## 🚀 Future Enhancements

- Spring Security (JWT Authentication)
- Timer-based quiz submission
- User registration & login
- Leaderboard system
- Swagger API documentation
- Unit & Integration testing

---

## 👨‍💻 Author

Your Name  
GitHub: https://github.com/rajibbirlapur

