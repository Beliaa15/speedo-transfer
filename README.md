# Speedo Transfer

Speedo Transfer is a mobile application designed to provide seamless and efficient money transfer services. Built with Android and Kotlin, this app leverages modern development frameworks like Jetpack Compose to deliver a smooth and intuitive user experience.

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
- [Installation](#installation)
- [Usage](#usage)
- [API Integration](#api-integration)
- [Contributing](#contributing)
- [Contact](#contact)

## Features

- User authentication with secure login and logout functionality
- Token management using SharedPreferences
- Fetch and display user details securely
- Manage user state using ViewModel and StateFlow
- Error handling for API requests, including handling 401 Unauthorized errors
- Built with Jetpack Compose for modern, reactive UI

## Getting Started

To get a local copy of this project up and running, follow these steps.

### Prerequisites

- Android Studio (latest version recommended)
- Kotlin 1.5 or higher
- Gradle 7.0 or higher

### Installation

1. **Clone the repository:**

    bash
    git clone https://github.com/Beliaa15/speedo-transfer.git
    cd speedo-transfer
    

2. **Open the project in Android Studio:**

    - Start Android Studio.
    - Click on "Open an existing Android Studio project".
    - Select the cloned directory.

3. **Build the project:**

    - Ensure that you have the latest Android SDK and tools installed.
    - Click "Build" > "Make Project" or use `Ctrl+F9` to compile the project.

4. **Run the application:**

    - Connect an Android device or start an emulator.
    - Click "Run" > "Run 'app'" or use `Shift+F10`.

## Usage

1. **Login:** Enter your email and password to log in.
2. **Token Management:** The app securely saves tokens in SharedPreferences for authentication.
3. **Fetch User Details:** After logging in, fetch and display user details.
4. **Logout:** Securely log out by clearing the token and user data.

## API Integration

Speedo Transfer interacts with a backend API for authentication and user management. Below are key details about the API:

- **Base URL:** [API_BASE_URL]
- **Endpoints:**
  - **Login:** `/login` - Authenticates the user and returns a token.
  - **Get User:** `/user/{id}` - Fetches user details using the provided token.
  - **Logout:** `/logout` - Clears the current session.

> **Note:** Replace `[API_BASE_URL]` with the actual API base URL used in your project.

### Handling Errors

- **401 Unauthorized:** The app handles 401 errors by prompting the user to log in again and clearing invalid tokens.

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a pull request.


## Contact

For questions or support, please reach out to:

- **Name:** Mohamed Hesham
- **Email:** mhfaa152002@gmail.com
- **GitHub:** [Beliaa15](https://github.com/Beliaa15)

- **Name:** Mohaned Emad
- **Email:** mohanedemad11@gmail.com
- **GitHub:** [mohaned-emad](https://github.com/mohaned-emad)

---

Thank you for using Speedo Transfer! If you find this project helpful, please star the repository and consider contributing!
