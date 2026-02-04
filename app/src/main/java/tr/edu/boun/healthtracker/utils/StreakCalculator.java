package tr.edu.boun.healthtracker.utils;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class StreakCalculator {
    public static int calculateStreak(List<Long> dates) {
        return calculateStreak(dates, System.currentTimeMillis());
    }

    public static int calculateStreak(List<Long> dates, long referenceDate) {
        if (dates == null || dates.isEmpty()) return 0;

        Calendar cal = Calendar.getInstance();
        TreeSet<Long> uniqueDayTimestamps = new TreeSet<>(Collections.reverseOrder());

        for (Long date : dates) {
            cal.setTimeInMillis(date);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            uniqueDayTimestamps.add(cal.getTimeInMillis());
        }

        int streak = 0;

        cal.setTimeInMillis(referenceDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long checkDay = cal.getTimeInMillis();

        if (uniqueDayTimestamps.contains(checkDay)) {
            streak++;
        } else {
            // Check yesterday
            cal.add(Calendar.DAY_OF_YEAR, -1);
            checkDay = cal.getTimeInMillis();
            if (uniqueDayTimestamps.contains(checkDay)) {
                streak++;
            } else {
                return 0;
            }
        }

        // Continue counting backwards
        while (true) {
            cal.setTimeInMillis(checkDay);
            cal.add(Calendar.DAY_OF_YEAR, -1);
            checkDay = cal.getTimeInMillis();
            if (uniqueDayTimestamps.contains(checkDay)) {
                streak++;
            } else {
                break;
            }
        }

        return streak;
    }
}
