package application.Key2Keto.Account;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccountViewTest extends ApplicationTest
{
	AccountView accountView;
	
	@Override
	public void start(Stage stage)
	{
		accountView = new AccountView(new Account("", "", "", "", "", "", 0, 0, ""));
		Scene accountScene = new Scene(accountView);
		
		stage.setScene(accountScene);
		stage.show();
	}
	
	@Test
	public void validUsernameInputGoesThroughTest()
	{
		clickOn(accountView.getButtonsForTests().get(0));
		clickOn(accountView.getNewVariableTextFieldForTests());
		write("newusername123");
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("newusername123", accountView.getCurrentVariableLabelsForTests().get(0).getText());
	}
}
