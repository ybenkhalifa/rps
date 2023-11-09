# Rock-Paper-Scissors Maven Project

This is a Maven project for a simple Rock-Paper-Scissors game implemented in Java. The project consists of the following packages and classes:

- `controller`: Contains the `GameController` class, which controls the game logic and user interactions.
- `launcher`: Contains the `AppLauncher` class, which serves as the entry point for starting the game application.
- `model`: Contains the `GameModel` class, which represents the game logic for Rock-Paper-Scissors.
- `test.model`: Contains JUnit tests for the `GameModel` class.
- `test.view`: Contains JUnit tests for the `GameView` class.
- `view`: Contains the `GameView` class, which represents the graphical user interface (GUI) for the game.

## Project Structure

- `src/main/java`: Contains the main Java source code.
  - `controller`: Contains the `GameController` class.
  - `launcher`: Contains the `AppLauncher` class.
  - `model`: Contains the `GameModel` class.
  - `view`: Contains the `GameView` class.
- `src/test/java`: Contains the JUnit test classes.
  - `test.model`: Contains JUnit tests for the `GameModel` class.
  - `test.view`: Contains JUnit tests for the `GameView` class.
- `src/main/resources`: Contains resources used in the application, such as images.
- `pom.xml`: The Maven project configuration file.

## How to Run

To run the Rock-Paper-Scissors game application, follow these steps:

1. **Ensure Maven is Installed**:
   Make sure you have Maven installed on your system.

2. **Navigate to the Project Root**:
   Open a terminal and navigate to the root directory of your project.

3. **Build the Project with Maven**:
   Run the following command to build the project:

   ```bash
   mvn clean install
   
   
## Running JUnit Tests
1. cd /path/to/your/project
2. mvn test


Maven will execute the tests and display the results in the terminal. You will see output indicating whether each test passed or failed.

Example output:

[INFO] T E S T S
[INFO] -------------------------------------------------------
[INFO] Running test.model.GameModelTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.062 s -- in test.model.GameModelTest
[INFO] Running test.view.GameViewTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.218 s -- in test.view.GameViewTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 9, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] BUILD SUCCESS
[INFO]
