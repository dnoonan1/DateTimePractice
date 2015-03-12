/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdk8.api;

import java.time.LocalDateTime;

/**
 *
 * @author dnoonan1
 */
public class DaysFromNow {

    public static void main(String[] args) {
        
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime dueDate = today.plusDays(45);
        
        System.out.println("Due date is " + dueDate + ".");
        
    }
    
}
