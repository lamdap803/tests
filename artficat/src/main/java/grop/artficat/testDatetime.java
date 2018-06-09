package grop.artficat;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class testDatetime {

	
	public static void main(String[] args) {

        String now = "07:05:45PM";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm:ssa", Locale.ENGLISH);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        LocalTime formatDateTime = LocalTime.parse(now, formatter);

        System.out.println("Before : " + now);

        System.out.println("After : " + formatDateTime);

        //System.out.println("After : " + formatDateTime.format(formatter));
        //System.out.println("After : " + formatDateTime.format(formatter2));
    }
}
