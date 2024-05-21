# Lingochat

Lingochat is an AI-powered language learning app that helps users learn a new language through interactive conversations. The app provides features like speech recognition for pronunciation practice, grammar correction, vocabulary suggestions, and personalized learning paths based on user progress.

## Features

- **Speech Recognition**: Recognize and transcribe user speech using Google Cloud Speech-to-Text API.
- **Grammar Correction**: Identify and suggest corrections for grammar mistakes using LanguageTool API.
- **Vocabulary Suggestions**: Provide word of the day and vocabulary suggestions using Wordnik API.
- **Personalized Learning Paths**: Offer customized language learning paths based on user input using Duolingo API.

## Getting Started

### Prerequisites

- Android Studio
- Google Cloud account
- Firebase account
- API keys for Google Cloud Speech-to-Text, LanguageTool, Wordnik, and Duolingo

### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/param-10/lingochat-1.git
    cd lingochat
    ```

2. **Open the project in Android Studio.**

3. **Set up Firebase:**
    - Add your `google-services.json` file to the `app` directory.
    - Follow the [Firebase setup instructions](https://firebase.google.com/docs/android/setup) to configure Firebase.

4. **Add API Keys:**
    - Store your API keys in a secure manner, such as using environment variables or a secure vault.
    - Update your API calls in the code to use these keys.

### Building and Running

1. **Build the project:**
    - Open Android Studio and sync the project with Gradle files.
    - Build the project to ensure all dependencies are resolved.

2. **Run the app:**
    - Connect an Android device or start an emulator.
    - Run the app from Android Studio.

## Usage

### Home Screen

- **Login Button**: Navigate to the login screen.
- **Create Account Button**: Navigate to the create account screen.

### Create Account

- Enter email and password to create a new account using Firebase Authentication.
- Navigate to the login screen if the account is created successfully.

### Login

- Enter email and password to log in using Firebase Authentication.
- Navigate to the conversation screen upon successful login.

### Conversation Screen

- **Speech Recognition Button**: Start recognizing and transcribing speech.
- **Mic Button**: Use the mic button to capture speech input.
- View recognized text and get grammar corrections, vocabulary suggestions, and personalized learning paths.

## APIs Used

- **Google Cloud Speech-to-Text API**: For speech recognition.
- **LanguageTool API**: For grammar correction.
- **Wordnik API**: For vocabulary suggestions.
- **Duolingo API**: For personalized learning paths.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgments

- [Google Cloud](https://cloud.google.com/)
- [Firebase](https://firebase.google.com/)
- [LanguageTool](https://languagetool.org/)
- [Wordnik](https://www.wordnik.com/)
- [Duolingo](https://www.duolingo.com/)

## Status

This project is currently in progress. New features and improvements are being added regularly.
