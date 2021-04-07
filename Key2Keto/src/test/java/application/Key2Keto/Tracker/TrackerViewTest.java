package application.Key2Keto.Tracker;

import application.Key2Keto.Tracker.TrackerView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class TrackerViewTest extends ApplicationTest{
	TrackerView sut;
	
	@Override
	public void start(Stage stage) {
		
		sut = new TrackerView();
		
		Scene trackerScene = new Scene(sut);
		stage.setScene(trackerScene);
		stage.show();	
	}
	
	@Test
	public void testSundayButton() {
		clickOn(sut.getButtonsToTest().get(0));
		assertEquals("Sunday", sut.getViewForTest().getDayOfWeek());
	}
	
	@Test
	public void testMondayButton() {
		clickOn(sut.getButtonsToTest().get(1));
		assertEquals("Monday", sut.getViewForTest().getDayOfWeek());
	}
	
	@Test
	public void testSTuesdayButton() {
		clickOn(sut.getButtonsToTest().get(2));
		assertEquals("Tuesday", sut.getViewForTest().getDayOfWeek());
	}
	
	@Test
	public void testWednesdayButton() {
		clickOn(sut.getButtonsToTest().get(3));
		assertEquals("Wednesday", sut.getViewForTest().getDayOfWeek());
	}
	
	@Test
	public void testThursdayButton() {
		clickOn(sut.getButtonsToTest().get(4));
		assertEquals("Thursday", sut.getViewForTest().getDayOfWeek());
	}
	
	@Test
	public void testFridayButton() {
		clickOn(sut.getButtonsToTest().get(5));
		assertEquals("Friday", sut.getViewForTest().getDayOfWeek());
	}
	
	@Test
	public void testSaturdayButton() {
		clickOn(sut.getButtonsToTest().get(6));
		assertEquals("Saturday", sut.getViewForTest().getDayOfWeek());
	}
}
