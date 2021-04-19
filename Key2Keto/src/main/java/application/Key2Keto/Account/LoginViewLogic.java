package application.Key2Keto.Account;

public class LoginViewLogic
{
	private static String errorMessage;
	
	public static boolean checkFormProperlyFilled(String usernameString, String passwordString)
	{
		if(usernameString.equals(""))
		{
			errorMessage = "Username field must not be empty";
			return false;
		}
		
		else if(passwordString.equals(""))
		{
			errorMessage = "Password field must not be empty";
			return false;
		}
		
		else
		{
			return true;
		}
	}
	
	public static String getErrorMessage()
	{
		return errorMessage;
	}
}
