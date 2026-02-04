package tr.edu.boun.healthtracker;

import org.junit.Test;
import tr.edu.boun.healthtracker.utils.CalorieCalculator;
import static org.junit.Assert.*;

public class LogicUnitTest {
    @Test
    public void calorie_calculation_isCorrect() {
        double goal = 2000.0;
        double food = 500.0;
        double exercise = 200.0;
        double expected = 2000.0 - 500.0 + 200.0; // 1700
        assertEquals(expected, CalorieCalculator.calculateRemaining(goal, food, exercise), 0.001);
    }

    @Test
    public void calorie_calculation_negative() {
        double goal = 2000.0;
        double food = 2500.0;
        double exercise = 0.0;
        double expected = -500.0;
        assertEquals(expected, CalorieCalculator.calculateRemaining(goal, food, exercise), 0.001);
    }
}
