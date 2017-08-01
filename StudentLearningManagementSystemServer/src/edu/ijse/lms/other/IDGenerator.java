/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.other;

import java.text.NumberFormat;

/**
 *
 * @author Pahansith
 */
public class IDGenerator {
    public static String getNextId(String currentId,String prefix){
        if(currentId != null){
            String[] split = currentId.split(prefix);
            NumberFormat instance = NumberFormat.getInstance();
            instance.setMinimumIntegerDigits(3);
            instance.setGroupingUsed(false);
            int newNum = Integer.parseInt(split[1])+1;
            String format = instance.format(newNum);
            return prefix+format;
        }else{
            return prefix+"001";
        }
        
    }
}