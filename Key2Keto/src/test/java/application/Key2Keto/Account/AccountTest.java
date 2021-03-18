package application.Key2Keto.Account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountTest
{

	@Test
	void accessorTest()
	{
		//username, password, sex, height, weight, age, diet type
		Account sut = new Account("username123", "password123", "John", "McLastname", "Male", "5'9\"", 190, 24, "Classic");
		
		assertEquals("username123", sut.getUsername());
		assertEquals("password123", sut.getPassword());
		
		assertEquals("John", sut.getFirstName());
		assertEquals("McLastname", sut.getLastName());
		
		assertEquals("Male", sut.getSex());
		assertEquals("5'9\"", sut.getHeight());
		assertEquals(190, sut.getWeight());
		assertEquals(24, sut.getAge());
		
		assertEquals("Classic", sut.getDietType());
	}
	
	@Test
	void mutatorTest()
	{
		Account sut = new Account("", "", "", "", "", "", 0, 0, "");
		
		sut.setUsername("newUsername");
		sut.setPassword("newPassword");
		
		sut.setFirstName("Jennifer");
		sut.setLastName("Lastnameigan");
		
		sut.setSex("Female");
		sut.setHeight("6'0\"");
		sut.setWeight(185);
		sut.setAge(28);
		
		sut.setDietType("Modified");
		
		assertEquals("newUsername", sut.getUsername());
		assertEquals("newPassword", sut.getPassword());
		
		assertEquals("Jennifer", sut.getFirstName());
		assertEquals("Lastnameigan", sut.getLastName());
		
		assertEquals("Female", sut.getSex());
		assertEquals("6'0\"", sut.getHeight());
		assertEquals(185, sut.getWeight());
		assertEquals(28, sut.getAge());
		
		assertEquals("Modified", sut.getDietType());
	}

	@Test
	void canCreateEmptyAccountTest()
	{
		Account sut = new Account();
		
		assertEquals("", sut.getUsername());
		assertEquals("", sut.getPassword());
		
		assertEquals("", sut.getFirstName());
		assertEquals("", sut.getLastName());
		
		assertEquals("", sut.getSex());
		assertEquals("", sut.getHeight());
		assertEquals(0, sut.getWeight());
		assertEquals(0, sut.getAge());
		
		assertEquals("", sut.getDietType());
	}
}
