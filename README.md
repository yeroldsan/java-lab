# java-lab

This repository demonstrates a series of tests and their corresponding solution code, following a Test-Driven Development (TDD) approach.

## Project Structure

The project is organized into two main directories: src/main for the solution code and src/test for the test cases.

```
src
├── main
│   └── java
│       └── com
│           └── example
│               ├── Object.java
│               └── Math.java
└── test
    └── java
        └── com
            └── example
                ├── ObjectTest.java
                └── MathTests.java
```

## Development Approach

This project followed a Test-Driven Development (TDD) approach. This means the tests were wrote first and then the code to pass these tests was implemented. This ensures that our code meets the specified requirements and is well-tested from the outset.

### How to Run the Tests

1. Ensure you have JDK and Gradle installed.
2. Clone this repository.
3. Run the tests using the command: 
```sh 
gradle test
```
Each file test can be run individually by adding the test name as follows: 
```sh
gradle test --tests TestName
```
