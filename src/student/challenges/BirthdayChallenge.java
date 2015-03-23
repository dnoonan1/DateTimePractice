package student.challenges;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Challenge: Find Jim's birthday 25 years from now.
 * 
 * @author dnoonan1
 */
public class BirthdayChallenge {
    
    public static void main(String[] args) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        
        int thisYear = Year.now().getValue();
        LocalDate jimsBirthday25YearsFromNow = LocalDate
                // September 23rd of this year
                .of(thisYear, Month.SEPTEMBER, 23)
                // 25 years from now
                .plusYears(25);
        
        System.out.println("Jim's birthday 25 years from now is "
                + jimsBirthday25YearsFromNow.format(dtf) + ".");
        
    }
    
}
