package com.frog.platform.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

    /**
     * @param date
     * @return String "yyyy-MM-dd"
     */
    public static String dateToString(Date date){
        if(date==null){
            return "";
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(date);
        return s;
    }
}
