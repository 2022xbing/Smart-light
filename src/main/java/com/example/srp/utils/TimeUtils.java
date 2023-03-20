package com.example.srp.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat sdf_2 = new SimpleDateFormat("yyyy-MM-dd");
    public static final int TenMin = 10;
    public static final int OneHour = 60;
    public static final int FiveMin = 5;
    public static final int OneDay = 24 * 60;

    public static long getMs(int min) {
        return (long) min * 60 * 1000;
    }

    public static Timestamp StringToTimestamp(String date) {
        try {
            Date date1 = sdf.parse(date);
            return new Timestamp(date1.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String TimestampToString(Timestamp timestamp) {
        return sdf.format(timestamp);
    }

    public static String DateToString(Date date) {
        return sdf_2.format(date);
    }

    public static Timestamp getBefMin(Timestamp endTime, int Min) {
        return new Timestamp(endTime.getTime() - getMs(Min));
    }

    public static Timestamp getAftMin(Timestamp startTime, int Min) {return new Timestamp(startTime.getTime() + getMs(Min));}
}
