package com.library.LibMgmt2025.util;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class UtilData {
    //Generate respective IDs

    public static String generateBookId(){
        return "B-"+ UUID.randomUUID();
    }
    public static String generateMemberId(){
        return "M-"+ UUID.randomUUID();
    }
    public static String generateStaffId(){
        return "S-"+ UUID.randomUUID();
    }
    public static String generateLendingId(){
        return "L-"+ UUID.randomUUID();
    }
    //Generate last updated date and time
    public static LocalDate generateTodayDate(){
        return LocalDate.now();
    }
    public static Time generatecurrentTime(){
        return Time.valueOf(LocalTime.now());
    }
    //Generate return date of a lending
    public static LocalDate generateBookReturnDate(){
        return LocalDate.now().plusDays(7);
    }
  }
