/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdk8.api;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

/**
 *
 * @author dnoonan1
 */
public class BirthdayFinder {
    
    public static void main(String[] args) {
        
        LocalDate birthday = LocalDate.of(1952, Month.SEPTEMBER, 23);
        Year today = Year.now();
        Year twentyFiveYearsFromNow = today.plusYears(25);
        LocalDate birthday25 = birthday.with(twentyFive);
        
    }
    
}
