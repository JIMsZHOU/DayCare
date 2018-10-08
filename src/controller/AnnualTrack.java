package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AnnualTrack {
    private static long datetoDays(Date beginDate, Date endDate) {
        return (endDate.getTime()-beginDate.getTime())/(1000*60*60*24);
    }
}
