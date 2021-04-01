package application.Key2Keto.Tracker;

public class Tracker {
	double hoursOfSleep;
	double waterIntake;
	
	public Tracker(){
		this.hoursOfSleep = -1;
		this.waterIntake = -1;
	}
	
	public void setHoursOfleep(double hours) {
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
}
