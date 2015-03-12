/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdk8.api;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import static java.util.Calendar.MARCH;
import java.util.Set;

/**
 *
 * @author dnoonan1
 */
public class DaylightSavingsChallenge {
    
    public static void main(String[] args) {
        
        ZoneId zone = ZoneId.of("America/Chicago");
        //ZonedDateTime day = ZonedDateTime.now();
        
        ZonedDateTime day = ZonedDateTime.of(2015, 3,
            1, 0, 0, 0, 0, zone);
        
        while (zone.getRules().isDaylightSavings(day.toInstant())) {
            day = day.plusDays(1);
        }
        
        System.out.println(day);
    }
    
    
}
