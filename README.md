# BenchIQ — AI-Powered Bench Management System

An intelligent bench management system built with Spring Boot and MySQL that uses AI matching algorithms to automatically allocate benched employees to open projects.

## 🚀 Features

- **AI Matching Engine** — scores employees against projects based on skills, experience, and bench duration
- **Auto-Allocation** — one-click allocation of the best-fit employee to a project
- **Bench Alerts** — flags employees benched for 30+ days with CRITICAL / HIGH / MEDIUM urgency
- **REST API** — full CRUD for employees and projects
- **Live Dashboard** — real-time HTML dashboard with stats, match scores, and allocation history

## 🛠️ Tech Stack

- **Backend** — Java, Spring Boot 3.5, Spring Data JPA, Hibernate
- **Database** — MySQL (via XAMPP)
- **AI Engine** — custom skill-matching algorithm with weighted scoring
- **Frontend** — HTML, CSS, JavaScript (no framework)

## 📊 How the AI Matching Works

Each employee is scored out of 100 against a project:
- **Skill match** — +20 per matching skill
- **Experience** — +20 if meets minimum requirement  
- **Bench duration** — +10 if benched 60+ days, +5 if 30+ days

Employees are ranked and the top match is auto-allocated.

## 🏃 How to Run

1. Start XAMPP → Start MySQL
2. Open project in VS Code
3. Run `.\mvnw spring-boot:run`
4. Open `dashboard.html` in browser

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/employees` | Add employee |
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/benched` | Get benched employees |
| POST | `/api/projects` | Add project |
| GET | `/api/projects/open` | Get open projects |
| GET | `/api/ai/match/{id}` | AI match for project |
| POST | `/api/ai/allocate/{id}` | Auto-allocate best fit |
| GET | `/api/ai/bench-alerts` | Get bench alerts |

## 👩‍💻 Author

**Manya Rolekar** — [GitHub](https://github.com/manyarolekar) · [LinkedIn](https://linkedin.com/in/manyarolekar)