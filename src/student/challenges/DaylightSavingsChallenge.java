package student.challenges;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * Challenge: Find the time of this year's end of Daylight Savings in the 
 * Chicago time zone.
 * 
 * @author dnoonan1
 */
public class DaylightSavingsChallenge {
    
    public static void main(String[] args) {
        
        /*
          According to the National Institute of Science and tecnology, since
          2007, daylight savings (DS)
        
            - begins at 2:00 a.m. on the second Sunday of March and
            - ends at 2:00 a.m. on the first Sunday of November

          (Source: http://www.nist.gov/pml/div688/dst.cfm)
        */
        
        final int DAYLIGHT_SAVINGS_HOUR = 2;
        final int FIRST_OF_MONTH = 1;
        
        int currentYear = Year.now().getValue();
        ZoneId chicagoTimeZone = ZoneId.of("America/Chicago");
        LocalTime daylightSavingsTimeOfDay;
        LocalDate secondSundayOfMarch, firstSundayOfNovember;
        ZonedDateTime daylightSavingsStart, daylightSavingsEnd;
        DateTimeFormatter dateTimeFormatter, dateFormatter, timeFormatter;
        
        dateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
        dateFormatter = DateTimeFormatter.ofPattern("MMMM d");
        timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
        
        // 2:00am, time when DS begins/ends
        daylightSavingsTimeOfDay = LocalTime.of(DAYLIGHT_SAVINGS_HOUR, 0); 
        
        // Second Sunday of March, date when DS begins
        secondSundayOfMarch = LocalDate
                .of(currentYear, Month.MARCH, FIRST_OF_MONTH)
                .with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY))
                .plusWeeks(1);
        
        // First Sunday of November, date when DS ends
        firstSundayOfNovember = LocalDate
                .of(currentYear, Month.NOVEMBER, FIRST_OF_MONTH)
                .with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
        
        // DS start (with time zone)
        daylightSavingsStart = ZonedDateTime
                .of(secondSundayOfMarch,
                    daylightSavingsTimeOfDay,
                    chicagoTimeZone);
                //.minusHours(1);
        
        // DS end (with time zone)
        daylightSavingsEnd = ZonedDateTime
                .of(firstSundayOfNovember,
                    daylightSavingsTimeOfDay,
                    chicagoTimeZone);
        
        // Print out results in one format
        System.out.println(
            String.format(
                "Year: %d\n"
              + "Daylight Savings Start: %s\n"
              + "Daylight Savings End:   %s\n",
                currentYear,
                daylightSavingsStart.format(dateTimeFormatter),
                daylightSavingsEnd.format(dateTimeFormatter)
            )
        );
        /*
          The above displays 3:00am (not 2:00am) for DS start. Technically, for  
          the ZonedDateTime class there is no 2:00am since the clocks 
          immediately jump to 3:00am at that time. Even using the constructor
        
            daylightSavingsStart = ZonedDateTime
                    .of(currentYear, 3, dayOfMonth,
                        2, 0, 0, 0,
                        chicagoTimeZone);
                    // year, month, day of month,
                    // hour, minute, second, nanosecond,
                    // time zone
        
          (with the hour set explicitly to 2) still displays 3:00am, not 2:00am.
        */
        
        // Print out results in another format
        System.out.println(
            String.format(
                "In the year %d, daylight savings "
              + "begins on %s at %s "
              + "and ends on %s at %s.",
                currentYear,
                secondSundayOfMarch.format(dateFormatter),
                daylightSavingsTimeOfDay.format(timeFormatter),
                firstSundayOfNovember.format(dateFormatter),
                daylightSavingsTimeOfDay.format(timeFormatter)
            )
        );
        
    }
       
}
