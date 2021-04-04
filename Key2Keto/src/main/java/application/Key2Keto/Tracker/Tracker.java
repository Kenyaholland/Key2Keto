package application.Key2Keto.Tracker;

import java.util.ArrayList;

public class Tracker {
	String dayOfWeek;
	double hoursOfSleep;
	double waterIntake;
	ArrayList<String> goals;
	
	public Tracker(String dayOfWeek){
		this.dayOfWeek = dayOfWeek;
		this.hoursOfSleep = 0.0;
		this.waterIntake = 0.0;
		this.goals = new ArrayList<String>();
	}
	
	public void setHoursOfSleep(double hours) {
		this.hoursOfSleep = hours;
	}
	
	public void setWaterIntake(double water) {
		this.waterIntake = water;
	}
	
	public double getHoursOfSleep() {
		return this.hoursOfSleep;
	}
	
	public double getWaterIntake() {
		return this.waterIntake;
	}
	
	public String getDayOfWeek() {
		return this.dayOfWeek;
	}
	
	public void addGoal(String goal) {
		this.goals.add(goal);
	}
	
	public ArrayList getGoals() {
		return this.goals;
	}
}
