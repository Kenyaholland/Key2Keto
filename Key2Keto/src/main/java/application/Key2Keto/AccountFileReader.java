package application.Key2Keto;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import application.Key2Keto.Account.Account;
import application.Key2Keto.Interfaces.FileReaderInterface;
import application.Key2Keto.Tracker.Tracker;

public class AccountFileReader implements FileReaderInterface
{
	private Account loadedAccount;
	
	public AccountFileReader(String fileName)
	{
		loadedAccount = new Account();
		readFile(fileName);
	}
	
	public void readFile(String fileName)
	{
		File accountFile = new File(fileName);
		Scanner fileScanner = null;
		
		try
		{
			fileScanner = new Scanner(accountFile);
			fileScanner.useDelimiter(",|\n");
			
			loadedAccount.setUsername(fileScanner.next());
			loadedAccount.setPassword(fileScanner.next());
			
			loadedAccount.setFirstName(fileScanner.next());
			loadedAccount.setLastName(fileScanner.next());
			
			loadedAccount.setSex(fileScanner.next());
			loadedAccount.setHeight(fileScanner.next());
			loadedAccount.setWeight(Integer.parseInt(fileScanner.next()));
			loadedAccount.setAge(Integer.parseInt(fileScanner.next()));
			
			loadedAccount.setDietType(fileScanner.nextLine());
			
			if(fileScanner.next().equals("Trackers"))
			{
				while(fileScanner.hasNext())
				{
					if(fileScanner.next().equals("Recipes"))
					{
						break;
					}
					
					//reading day
					for(int i = 0; i < 7; i++)
					{
						while(fileScanner.hasNext())
						{
							fileScanner.next(); //don't need day string; exists in file for readability
							String nextString = fileScanner.nextLine();
							
							if(nextString.matches("[+-]?([0-9]*[.])?[0-9]+,[+-]?([0-9]*[.])?[0-9]+")) //if the next string is a double, then the goals are done
							{
								String[] splitString = nextString.split(",");
								
								loadedAccount.getTrackers().get(i).setHoursOfSleep(Double.parseDouble(splitString[0]));
								loadedAccount.getTrackers().get(i).setWaterIntake(Double.parseDouble(splitString[1]));
								break;
							}
							
							else
							{
								loadedAccount.getTrackers().get(i).addGoal(nextString);
							}
						}
					}
					
					/*
					Tracker newTracker = new Tracker(fileScanner.next());
					
					while(fileScanner.hasNext())
					{
						String nextString = fileScanner.next();
						
						if(nextString.matches("[+-]?([0-9]*[.])?[0-9]+")) //if the next string is a double, then the goals are done
						{
							newTracker.setHoursOfSleep(Double.parseDouble(nextString));
							newTracker.setWaterIntake(Double.parseDouble(fileScanner.next()));
							break;
						}
						
						else
						{
							newTracker.addGoal(nextString);
						}
					}
					
					loadedAccount.
					*/
				}
			}
		}
		
		catch(IOException io)
		{
			System.out.println("Error reading account file");
		}
		
		finally
		{
			fileScanner.close();
		}
		
		
	}
	
	public Account getLoadedAccount()
	{
		return loadedAccount;
	}
}
