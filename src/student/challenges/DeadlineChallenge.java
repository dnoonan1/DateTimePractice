package student.challenges;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Challenge: Find the deadline 45 days from now.
 * 
 * @author dnoonan1
 */
public class DeadlineChallenge {

    public static void main(String[] args) {
        
        LocalDate today = LocalDate.now();
        LocalDate deadline = today.plusDays(45);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        
        System.out.println("The deadline is " + deadline.format(dtf) + ".");
        
    }
    
}
