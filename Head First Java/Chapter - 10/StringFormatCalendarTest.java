


import java.util.Date;
import java.util.Calendar;


class StringFormatCalendarTest {

	public static void main(String[] args) {

		String s1 = String.format("My favorite number is %,d", 10000000);
		System.out.println(s1);

		String s2 = String.format("%,.2f", 121364.2334543);
		System.out.println(s2);

		String s3 = String.format("Decimal : %d, Hexadecimal : %<x, Octal : %<o", 4523);
		System.out.println(s3);

		String s4 = String.format("Current : %tc", new Date());
		System.out.println(s4);

		String s5 = String.format("Current Time : %tr, Current Week : %<tA, Current Month : %<tB, Current Day : %<td", new Date());
		System.out.println(s5);

		// Date class is now deprecated
		// Overtaken by more versatile Calendar Class

		// Calendar is an abstract class so it can't be instantiated 

		Calendar cal = Calendar.getInstance();

		// This returns an instance of one of Calendar's subclass based on Calendar type prefrences
		// Usually it returns Calendar.GregorianCalender instance

		System.out.println(cal.getClass());

		//Getting time

		System.out.println(cal.getTime());
 
		// Setting Time

		cal.set(1997, 7, 29, 15, 0);

		// Epoch
		// cal.set(1970, 0, 1, 5, 30);

		System.out.println(cal.getTime());

		//Milisecond elasped from epoch
		System.out.println(cal.getTimeInMillis());


		//Fields

		System.out.println("DATE : " + cal.get(Calendar.DATE)); 

		//OR
		//System.out.println(cal.get(Calendar.DAY_OF_MONTH));

		System.out.println("MONTH : " + cal.get(Calendar.MONTH));

		System.out.println("YEAR : " + cal.get(Calendar.YEAR));

		System.out.println("HOUR : " + cal.get(Calendar.HOUR));
		//FOR 24HOUR FORMAT
		//System.out.println(cal.get(Calendar.HOUR_OF_DAY));

		System.out.println("MINUTE : " + cal.get(Calendar.MINUTE));

		//ADD

		long day = cal.getTimeInMillis();

		day += 1000 * 60 * 60 * 24;

		// day + 24 hours worth of miliseconds

		cal.setTimeInMillis(day);

		System.out.println(cal.getTime());

		cal.add(Calendar.DATE, 15);

		System.out.println(cal.getTime());

		cal.roll(Calendar.DATE, 20);
		//ADD WITHOUT CHANGING MONTH

		System.out.println(cal.getTime());

		cal.set(Calendar.DATE, 15);

		System.out.println(cal.getTime());


	}



}
