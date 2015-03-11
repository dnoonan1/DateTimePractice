/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdk8.api;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 *
 * @author dnoonan1
 */
public class SaturdayCounter {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate lastSaturday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY));

        int numSaturdays = 0;
        while (lastSaturday.getYear() > 0) {
            lastSaturday = lastSaturday.minusWeeks(1);
            numSaturdays++;
        }
        
        System.out.println("Number of Saturdays = " + numSaturdays);
        
    }
    
}
