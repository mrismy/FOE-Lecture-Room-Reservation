# FoE Room Reservation System

The **FoE Room Reservation System** is a comprehensive full-stack solution for managing and booking lecture halls and seminar rooms at the Faculty of Engineering. It consists of a modern, responsive frontend and a robust backend API.

## Project Structure

This monorepo contains two main applications:

- **[Frontend](./FoE-Frontend-main)** (`FoE-Frontend-main`): A React + TypeScript web application built with Vite and Tailwind CSS.
- **[Backend](./FoE-Backend-main)** (`FoE-Backend-main`): A Spring Boot (Java) REST API facilitating data persistence, authentication, and business logic.

## Key Features

- **Full Stack Architecture**: Separated frontend and backend for scalability.
- **Secure Authentication**: Google OAuth integration with JWT-based session management.
- **Room Management**: Admin capabilities to create, update, and delete room resources.
- **Booking System**: Real-time checking availability and booking capabilities for users.
- **Role-Based Access**: Distinct features for Staff, and Admins.

## Technology Stack

| Component | Technology | Description |
| :--- | :--- | :--- |
| **Frontend** | React 18, TypeScript | UI Library and Logic |
| | Vite | Build Tool |
| | Tailwind CSS, MUI | Styling & Components |
| **Backend** | Java, Spring Boot | Server & API |
| | MySQL | Relational Database |
| | Maven | Dependency Management |

## Getting Started

To run the full system, you need to start both the backend and frontend servers.

### 1. Setup Backend
Navigate to the backend directory and start the Spring Boot application.
```bash
cd FoE-Backend-main
./mvnw spring-boot:run
```
_Ensure your MySQL database is running and configured in `src/main/resources/application.properties`._

### 2. Setup Frontend
Open a new terminal, navigate to the frontend directory, and start the vite server.
```bash
cd FoE-Frontend-main
npm install
npm run dev
```

### 3. Access the App
Open your browser and navigate to:
- **Frontend App**: `http://localhost:5173`
- **Backend API **: `http://localhost:8080/
