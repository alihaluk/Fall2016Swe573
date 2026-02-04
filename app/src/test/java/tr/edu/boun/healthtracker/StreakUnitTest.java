package tr.edu.boun.healthtracker;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import tr.edu.boun.healthtracker.utils.StreakCalculator;
import static org.junit.Assert.*;

public class StreakUnitTest {

    private long getDayMillis(int daysAgo) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -daysAgo);
        return cal.getTimeInMillis();
    }

    @Test
    public void streak_empty() {
        assertEquals(0, StreakCalculator.calculateStreak(new ArrayList<Long>()));
    }

    @Test
    public void streak_today_only() {
        List<Long> dates = new ArrayList<>();
        dates.add(getDayMillis(0));
        assertEquals(1, StreakCalculator.calculateStreak(dates));
    }

    @Test
    public void streak_yesterday_only() {
        List<Long> dates = new ArrayList<>();
        dates.add(getDayMillis(1));
        assertEquals(1, StreakCalculator.calculateStreak(dates));
    }

    @Test
    public void streak_broken_today_yesterday_missing() {
        List<Long> dates = new ArrayList<>();
        dates.add(getDayMillis(2));
        assertEquals(0, StreakCalculator.calculateStreak(dates));
    }

    @Test
    public void streak_today_yesterday() {
        List<Long> dates = new ArrayList<>();
        dates.add(getDayMillis(0));
        dates.add(getDayMillis(1));
        assertEquals(2, StreakCalculator.calculateStreak(dates));
    }

    @Test
    public void streak_multiple_days() {
        List<Long> dates = new ArrayList<>();
        dates.add(getDayMillis(0));
        dates.add(getDayMillis(1));
        dates.add(getDayMillis(2));
        dates.add(getDayMillis(3));
        assertEquals(4, StreakCalculator.calculateStreak(dates));
    }

    @Test
    public void streak_gap() {
        List<Long> dates = new ArrayList<>();
        dates.add(getDayMillis(0));
        dates.add(getDayMillis(1));
        // Day 2 missing
        dates.add(getDayMillis(3));
        assertEquals(2, StreakCalculator.calculateStreak(dates));
    }

    @Test
    public void streak_duplicate_entries_same_day() {
        List<Long> dates = new ArrayList<>();
        dates.add(getDayMillis(0));
        dates.add(getDayMillis(0));
        dates.add(getDayMillis(1));
        assertEquals(2, StreakCalculator.calculateStreak(dates));
    }
}
