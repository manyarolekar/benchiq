# BenchIQ  AI-Powered Bench Management System

## Problem Statement

In IT service companies, employees are frequently placed "on the bench" � meaning they are between projects and not actively billable. Managing this bench efficiently is a critical challenge. Manually identifying which benched employee best fits an open project is time-consuming, error-prone, and often leads to skill mismatches, delayed project staffing, and increased costs.

**BenchIQ** solves this by automating the entire bench management process using AI-powered skill matching and intelligent allocation.

---

## What Does This Project Do?

BenchIQ is a full-stack web application that helps IT managers:

1. **Track benched employees**  See all employees currently on the bench, their skills, experience, and how long they have been unallocated.
2. **Manage open projects**  View all projects that need staffing, along with required skills and experience level.
3. **AI-powered matching** Automatically find the best-fit employees for any open project based on skill overlap and experience.
4. **Auto-allocation**  Instantly allocate the best matching employee to a project with one click.
5. **Bench alerts**  Get notified about employees who have been on the bench too long, helping prevent talent underutilization.

---

## Live Demo

- **Frontend Dashboard:** https://benchiq-sand.vercel.app/dashboard.html
- **Backend API:** https://benchiq-production.up.railway.app

---

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Java 21, Spring Boot 3 |
| Database | MySQL (hosted on Railway) |
| Frontend | HTML5, CSS3, JavaScript |
| AI Matching | Custom skill-based scoring algorithm |
| Backend Hosting | Railway |
| Frontend Hosting | Vercel |
| Version Control | GitHub |

---

## System Architecture

```text
                    ┌─────────────────────┐
                    │      Frontend       │
                    │ HTML • CSS • JS     │
                    │ Hosted on Vercel    │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │    Spring Boot      │
                    │   REST Backend      │
                    │ Hosted on Railway   │
                    └──────────┬──────────┘
                               │
          ┌────────────────────┼────────────────────┐
          │                    │                    │
          ▼                    ▼                    ▼
 ┌────────────────┐  ┌────────────────┐  ┌────────────────┐
 │ Employee Mgmt  │  │ Project Mgmt   │  │ AI Matching    │
 │ Service        │  │ Service        │  │ Engine         │
 └────────────────┘  └────────────────┘  └────────────────┘
          │                    │                    │
          └────────────────────┴────────────────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │       MySQL         │
                    │ Database (Railway)  │
                    └─────────────────────┘
```

---

## Features

- Dashboard overview with total employees, benched count, allocated count, and open projects
- Full employee management  add, view, and track bench status
- Full project management add and track open projects
- AI matching engine that scores employees against project requirements
- One-click auto-allocation of the best fit employee
- Bench alert system for long-bench employees
- REST API backend with CORS support for frontend integration

---

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/employees | Get all employees |
| POST | /api/employees | Add a new employee |
| GET | /api/projects | Get all projects |
| POST | /api/projects | Add a new project |
| GET | /api/projects/open | Get all open projects |
| GET | /api/ai/match/{projectId} | Get AI-matched employees for a project |
| POST | /api/ai/allocate/{projectId} | Auto-allocate best fit employee |
| GET | /api/ai/bench-alerts | Get bench alert notifications |

---

## How the AI Matching Works

The matching engine compares the required skills of a project against the skills of each benched employee. It calculates a match score based on:
- Number of matching skills
- Years of experience vs required experience

Employees are ranked by score and the highest scoring candidate is recommended or auto-allocated.

---

## Project Structure

\\\
src/
  main/
    java/com/benchsystem/benchmanager/
      controller/    REST API controllers
      model/         Employee, Project, Allocation entities
      repository/    JPA repositories
      service/       AI matching logic
    resources/
      static/        Frontend dashboard (HTML/CSS/JS)
      application.properties
\\\

---

## Developed By

Manya Rolekar
