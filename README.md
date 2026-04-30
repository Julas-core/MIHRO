# MIHRO

MIHRO is an Ethiopian-focused online learning Android app built with Kotlin, Jetpack Compose, and Firebase-ready authentication and progress syncing.

## Features

- Email login and sign up
- Local demo mode when Firebase keys are still placeholders
- Ethiopian-themed home experience
- Courses for math, physics, biology, chemistry, Python, Java, C++, Dart, Kotlin, web development, English, and entrepreneurship
- Lessons, quizzes, progress tracking, and certificates
- Contact page with email and Telegram links

## Firebase setup

1. Open `firebase.properties`.
2. Replace the placeholder values with your Firebase Android app values.
3. Enable Email/Password authentication in Firebase Authentication.
4. Create a Cloud Firestore database.

Suggested Firestore structure:

- `users/{uid}` for learner profile
- `users/{uid}/progress/{courseId}` for progress and certificate state

## Run

1. Open the `MIHRO` folder in Android Studio.
2. Let Gradle sync.
3. Run the app on an emulator or Android device.

If Firebase is not configured yet, the app still works in local demo mode so you can test the full flow immediately.
