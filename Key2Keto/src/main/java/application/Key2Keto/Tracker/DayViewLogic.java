package application.Key2Keto.Tracker;

import application.Key2Keto.Account.Account;

public class DayViewLogic {
	private static Account account;
	private static String dayString;
	private static int dayInt;
	
	public static void setUserAccount(Account acct) {
		DayViewLogic.account = acct;
	}

	public static Account getUserAccount() {
		return DayViewLogic.account;
	}
	
	public static void setDay(String day) {
		DayViewLogic.dayString = day;
		setDayInt(day);
	}
	
	public static String getDayString() {
		return DayViewLogic.dayString;
	}
	
	private static void setDayInt(String dayName) {
		int day = 0;
		switch(dayName) {
			case "Sunday":
				day = 0;
				break;
			case "Monday":
				day = 1;
				break;
			case "Tuesday":
				day = 2;
				break;
			case "Wednesday":
				day = 3;
				break;
			case "Thursday":
				day = 4;
				break;
			case "Friday":
				day = 5;
				break;
			case "Saturday":
				day = 5;
				break;
			default:
				System.out.println("This does not exist.");
		}
		DayViewLogic.dayInt = day;
	}
	
	public static int getDayInt() {
		return DayViewLogic.dayInt;
	}
}
