# Human readable duration formatter

This is a simple application with a Spring Boot backend (Gradle) and a React frontend.

## How to run
- Clone the repository
- Run the application from your IDE or using the command line:
```./gradlew bootRun```
- To run tests, use the command:
```./gradlew test```
- The backend will start on port 8080 by default
- Navigate to the ui folder and run:
```yarn install or npm install```
- Start the frontend with:
```yarn dev or npm run dev```
- Open your browser and go to: http://localhost:5173
- Test the Backend with curl
```curl --location --request POST 'localhost:8080/api/v1/time/format?seconds=3662'```

