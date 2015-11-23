package com.lh.leonard.kiwisporttracker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Leonard on 19/06/2015.
 */
public class Date {

    /**
     * Called when the activity is first created.
     */

    // three fields
    public String formattedDate;

    // the Bicycle class has
    // one constructor
    public Date() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mmaa");
        formattedDate = df.format(c.getTime());
    }

    public String getDate() {
        return "New Zealand Local Time: " + formattedDate;
    }
}