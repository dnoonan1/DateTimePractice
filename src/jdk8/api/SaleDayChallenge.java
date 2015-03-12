package jdk8.api;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

/**
 *
 * @author dnoonan1
 */
public class SaleDayChallenge {

    public static void main(String[] args) {
        
        LocalDate firstDay = LocalDate.of(2015, Month.APRIL, 1);
        LocalDate firstWednesday = firstDay.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        
        LocalDate day = firstWednesday;
        
        while (day.getMonth() == Month.APRIL) {
            System.out.println(day.getDayOfMonth());
            day = day.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        }
        
    }
    
}
