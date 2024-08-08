# Java TDD Examples

This repository demonstrates a series of tests using JUnit 5 and their corresponding solution code, following a Test-Driven Development (TDD) approach.

## Project Overview

### Project Structure

This project is organized into a standard Gradle directory structure, with two main directories:

* `src/main/java`: contains the solution code for exercises, organized by programming topic (e.g., OOP, collections)
* `src/test/java`: contains the corresponding test cases for each exercise, also organized by programming topic

The following example illustrates the directory structure for the OOP and collections topics:

```
app
└── src
    ├── main
    │   └── java
    │       └── org
    │           ├── oop
    │           │   ├── Object.java
    │           │   └── ...
    │           └── collections
    │               └── ...
    └── test
        └── java
            └── org
                ├── oop
                │   ├── ObjectTest.java
                │   └── ...
                └── collections
                    └── ...
```

### Development Approach

This project followed a Test-Driven Development (TDD) approach, which involves writing tests before implementing code. By doing so, we ensured that our code meets the specified requirements, is well-tested, and is less prone to errors and bugs.

### Continuous Integration

This repository uses a GitHub Action to run all tests automatically on every push to the main branch. This ensures that the code remains stable and functional, and provides an additional layer of confidence for users.

## Getting Started

### Tests Coverage

The tests in this repository cover a range of programming topics using Java, including Object-Oriented Programming (OOP) and collections among others. Each test class is designed to test a specific piece of functionality. These are organized into separate packages for each topic, making it easy to find and run specific tests.

### Dependencies

Following dependencies are in use:

- [JUnit 5](https://junit.org/junit5): A popular testing framework for Java
- [Gradle](https://gradle.org/): A build tool for managing dependencies and running tests

### Running the Tests

1. Ensure you have JDK 21 or later and Gradle 8.9 installed.
2. Clone this repository.
3. Run the tests using the command: 
```sh 
gradle test
```
This will run all the tests in the repository. If you prefer to run a specific test file, you can do so by adding the test class name:
```sh
gradle test --tests TestClassName
```
