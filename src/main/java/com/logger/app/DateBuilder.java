package com.logger.app;
import java.util.Date;
import java.util.Calendar;


/**
 * DateBuilder
 */
public class DateBuilder {

    private Date date = new Date();
    Calendar calendar = Calendar.getInstance();

    public String getDate(){

        int day = date.getDate();
        int month = date.getMonth() + 1;
        int year = calendar.get(Calendar.YEAR);
        return day + "." + month + "." + year;
    }

    public String getTime(){

        int hour = date.getHours() + 3;
        int min = date.getMinutes();
        int sec = date.getSeconds();
        return hour + ":" + min + ":" + sec;
    }

}