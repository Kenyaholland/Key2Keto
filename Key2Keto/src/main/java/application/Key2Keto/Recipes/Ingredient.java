package application.Key2Keto.Recipes;

public class Ingredient {
	private String name="";
	private String serveSize ="";
	
	public Ingredient(String name, String serveSize){
		this.name = name;
		this.serveSize = serveSize;
	}
	
	public String toString() {
		return this.serveSize+ " "+this.name;
	}
}
