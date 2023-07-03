package com.example.lightcityfloat;

import java.util.Date;

public class Time {

    public static int GameTime() {
        Date date = new Date();
        String hour = date.toString().substring(11, 13);
        int gameTime = (Integer.parseInt(hour)*3)%24;
        return gameTime;
    }

    public static int LastDayPlayed(){
        Date date = new Date();
        String day = date.toString().substring(8, 10);
        // System.out.println(date.toString());
        return Integer.parseInt(day);
    }

    //Sat Jul 01 13:51:46 IRST 2023

}