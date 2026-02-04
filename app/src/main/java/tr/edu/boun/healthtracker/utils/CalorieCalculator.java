package tr.edu.boun.healthtracker.utils;

public class CalorieCalculator {
    public static double calculateRemaining(double goal, double food, double exercise) {
        return goal - food + exercise;
    }
}
