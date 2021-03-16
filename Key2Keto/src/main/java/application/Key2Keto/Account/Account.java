package application.Key2Keto.Account;

public class Account
{
	private String username;
	private String password;
	
	private String firstName;
	private String lastName;
	
	private String sex;
	private String height;
	private int weight;
	private int age;
	
	private String dietType;
	
	public Account()
	{
		username = "";
		password = "";
		
		firstName = "";
		lastName = "";
		
		sex = "";
		height = "";
		weight = 0;
		age = 0;
		
		dietType = "";
	}
	
	public Account(String username, String password, String firstName, String lastName, String sex, String height, int weight, int age, String dietType)
	{
		this.username = username;
		this.password = password;
		
		this.firstName = firstName;
		this.lastName = lastName;
		
		
		this.sex = sex;
		this.height = height;
		this.weight = weight;
		this.age = age;
		
		this.dietType = dietType;
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public String getSex()
	{
		return this.sex;
	}
	
	public String getHeight()
	{
		return this.height;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public String getDietType()
	{
		return this.dietType;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	
	public void setHeight(String height)
	{
		this.height = height;
	}
	
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void setDietType(String dietType)
	{
		this.dietType = dietType;
	}
}
