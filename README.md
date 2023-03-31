# Setup

Install Docker Desktop or Docker CLI with Docker Compose v2 if not installed on the machined. 

Run in terminal under the project directory:
```
docker compose up -d
```

The docker compose is started in detached mode. Please wait for everything to be loaded then access "http://localhost:3000" to view the webpage. 

React frontend container is exposed to host port 3000.

Spring Boot backend container is exposed to host port 8080.

PostgreSQL database container is exposed to host port 5432.