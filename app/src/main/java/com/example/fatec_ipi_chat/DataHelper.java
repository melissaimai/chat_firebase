package com.example.fatec_ipi_chat;

import java.text.SimpleDateFormat;
import java.util.Date;

class DataHelper {

    private static SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

    public static String format (Date date){
        return sdf.format(date);
    }
}
