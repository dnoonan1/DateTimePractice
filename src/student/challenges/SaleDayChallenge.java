package student.challenges;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

/**
 * Challenge: Find the day of the month of all the Wednesdays in April 2015.
 * 
 * @author dnoonan1
 */
public class SaleDayChallenge {

    public static void main(String[] args) {
        
        final int FIRST_OF_MONTH = 1;
        
        int year = 2015;
        Month month = Month.APRIL;
        LocalDate firstDay = LocalDate.of(year, month, FIRST_OF_MONTH);
        LocalDate firstWednesday = firstDay
                .with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        LocalDate day = firstWednesday;
        LocalDate nextWeek;
        
        System.out.printf(
                "In %d, Wednesday falls on the following days in %s: ",
                year, toSentenceCase(month.toString())
        );
        
        boolean stillInApril = true;
        while (stillInApril) {
            nextWeek = day.plusWeeks(1);
            if (nextWeek.getMonth() != Month.APRIL) {
                System.out.println("and " + day.getDayOfMonth() + ".");
                stillInApril = false;
            } else {
                System.out.print(day.getDayOfMonth() + ", ");
            }
            day = nextWeek;
        }
        
    }
    
    private static String toSentenceCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0))
                + str.substring(1).toLowerCase();
    }
    
}
