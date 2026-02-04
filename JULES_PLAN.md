# JULES_PLAN

## Mission
Move the project from "Alpha" to "Beta Version".
Focus on the "Core Gameplay Loop" (start, play, win/loss condition).

## Current Status (Alpha)
- Basic Health Tracker features: Login, Profile, Add Food (USDA API), Add Exercise (Static DB).
- **Core Loop Missing Persistence**: Food and Exercise entries are added to the list but lost on app restart.
- **Win/Loss Condition**: Implicit (Green/Red remaining calories), but no explicit feedback or persistent tracking.

## Plan for Beta
1.  **Persistence (The "Play" phase)**
    -   Implement local database storage for daily logs (Food/Exercise).
    -   Load logs on startup.
    -   Save logs when added.

2.  **Gamification / Win-Loss**
    -   Make the Win/Loss condition more explicit (e.g., Toast/Status update).
    -   (Optional) Track streaks or daily success.

3.  **Testing**
    -   Add unit tests for the core logic (calorie calculation).

## Execution Steps
1.  **Database Upgrade**: Add `TABLE_LOG` to `DB.java` and `DBOpenHelper.java`.
2.  **Persist Gameplay**: Update `MainActivity.java` to save/load logs.
3.  **Win/Loss Feedback**: Improve `MainActivity.java` UI feedback.
4.  **Tests**: Add logic tests.
