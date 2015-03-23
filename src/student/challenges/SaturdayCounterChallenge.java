package student.challenges;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * Challenge: count the number of Saturdays from the year AD 1 until now.
 * 
 * @author dnoonan1
 */
public class SaturdayCounterChallenge {

    public static void main(String[] args) {
        
        LocalDate today = LocalDate.now();
        LocalDate lastSaturday = today
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY));

        int numSaturdays = 1; // count today or the previous Saturday
        while (lastSaturday.getYear() > 0) {
            lastSaturday = lastSaturday.minusWeeks(1);
            numSaturdays++;
        }
        
        System.out.println("The number of Saturdays from the year A.D. 1 until "
                + "today is " + numSaturdays + ".");
        
    }
    
}
