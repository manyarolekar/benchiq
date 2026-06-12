# BenchIQ - AI Bench Management System

An intelligent bench management system that uses AI to match benched employees to open projects.

## Live Demo
- **Frontend Dashboard:** https://benchiq-sand.vercel.app/dashboard.html
- **Backend API:** https://benchiq-production.up.railway.app

## Tech Stack
- **Backend:** Java, Spring Boot, MySQL
- **Frontend:** HTML, CSS, JavaScript
- **AI Matching:** Custom skill-based matching algorithm
- **Deployment:** Railway (backend), Vercel (frontend)

## Features
- View all benched employees
- View open projects
- AI-powered employee-project matching
- Auto-allocation of best fit employees
- Bench alerts and notifications

## API Endpoints
- GET /api/employees
- GET /api/projects
- GET /api/projects/open
- GET /api/ai/match/{projectId}
- POST /api/ai/allocate/{projectId}
- GET /api/ai/bench-alerts
