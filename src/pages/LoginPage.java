package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObject {

	@FindBy(id = "login-form-email")
	WebElement email;

	@FindBy(id = "login-pass")
	WebElement password;

	@FindBy(id = "login-form-btn")
	WebElement LogInBtn;

	@FindBy(className = "body-2")
	WebElement invalidCredentials;

	@FindBy(className = "v-messages__message")
	List<WebElement> errorMsg;

	@FindBy(className = "v-messages__message")
	List<WebElement> errorMsgCharSize;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void fillInInput(String user, String pass) {
		email.clear();
		email.clear();
		email.sendKeys(user);

		password.clear();
		password.clear();
		password.sendKeys(pass);
	}

	public void submit() {
		wait.until(ExpectedConditions.visibilityOf(LogInBtn));
		LogInBtn.click();
	}

	public boolean isLoginBtnAt() {
		wait.until(ExpectedConditions.visibilityOf(LogInBtn));
		wait.until(ExpectedConditions.elementToBeClickable(LogInBtn));
		return LogInBtn.isDisplayed();
	}

	public boolean isInvalidCredentialsDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(invalidCredentials));
		return invalidCredentials.isDisplayed();
	}

	public boolean isEmailErrorMsgPresent() {
		wait.until(ExpectedConditions.visibilityOfAllElements(errorMsg));
		return errorMsg.get(0).isDisplayed();
	}

	public boolean isEmailandPassErrorMsgPresent() {
		wait.until(ExpectedConditions.visibilityOfAllElements(errorMsg));
		return errorMsg.get(0).isDisplayed();
	}

	public boolean isLessThanSixChars() {
		wait.until(ExpectedConditions.visibilityOfAllElements(errorMsgCharSize));
		return errorMsgCharSize.get(0).isDisplayed();
	}

	public boolean isMoreThanTwentyChars() {
		wait.until(ExpectedConditions.visibilityOfAllElements(errorMsgCharSize));
		return errorMsgCharSize.get(0).isDisplayed();
	}
}
