# Ludo Game Android

Production-ready native Android Ludo game application with online multiplayer, offline AI, and AdMob monetization.

## Features
- Online multiplayer with Firebase Realtime Database sync
- Offline mode with AI opponents (Easy/Medium/Hard)
- Local multiplayer (2-4 players)
- Full rules-aware game engine (dice, token movement, validations)
- Firebase Auth-ready user flow (guest + Google sign-in stubs)
- Room local persistence layer
- AdMob integration helpers (banner/interstitial/rewarded test IDs)
- MVVM + Clean Architecture + Hilt
- Dark/Light theme support
- Daily rewards and leaderboard scaffolding

## Project Structure
The repository includes the requested modular package structure under:
`app/src/main/java/com/ludogame/android/` and `app/src/main/res/`.

## Setup
1. Install Android Studio Hedgehog+ and Android SDK 34.
2. Add a valid `google-services.json` inside `app/`.
3. Configure Firebase Auth/Realtime DB/Analytics/Crashlytics in Firebase Console.
4. Configure your AdMob app ID and production ad unit IDs before release.
5. Build from Android Studio or Gradle:
   - `./gradlew assembleDebug`
   - `./gradlew test`

## Notes
- `app/src/main/firebase-security-rules-placeholder.rules` contains placeholder Firebase security rules.
- Update `Constants.BASE_URL` when backend APIs are available.
- ProGuard configuration is enabled for release builds.
