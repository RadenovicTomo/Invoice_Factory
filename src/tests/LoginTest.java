package tests;

import org.testng.annotations.Test;

import pages.LoginPage;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends InitTest {

	LoginPage login;

	@Test(priority = 0)
	public void allCapsPassword() {
		driver.get("http://app.invoice-factory.source-code.rs/login");
		login = new LoginPage(driver);
		assertTrue(login.isLoginBtnAt());
		login.fillInInput("tomoradenovic@gmail.com", "QWE123");
		login.fillInInput("tomoradenovic@gmail.com", "QWE123");
		login.submit();
		assertTrue(login.isInvalidCredentialsDisplayed());
	}

	@Test(priority = 1)
	public void allCapsEmailandPassword() {
		login = new LoginPage(driver);
		assertTrue(login.isLoginBtnAt());
		login.fillInInput("TOMORADENOVIC@GMAIL.COM", "QWE123");
		login.fillInInput("TOMORADENOVIC@GMAIL.COM", "QWE123");
		login.submit();
		assertTrue(login.isInvalidCredentialsDisplayed());

	}

	@Test(priority = 2)
	public void invalidEmail() {
		login = new LoginPage(driver);
		assertTrue(login.isLoginBtnAt());
		login.fillInInput("12345", "qwe123");
		login.fillInInput("12345", "qwe123");
		login.submit();
		assertTrue(login.isEmailErrorMsgPresent());
	}

	@Test(priority = 3)
	public void emptyEmail() {
		login = new LoginPage(driver);
		assertTrue(login.isLoginBtnAt());
		login.fillInInput(" ", "qwe123");
		login.fillInInput(" ", "qwe123");
		login.submit();
		assertTrue(login.isEmailErrorMsgPresent());
		assertTrue(login.isEmailandPassErrorMsgPresent());
	}

	@Test(priority = 4)
	public void emptyPassword() {
		login = new LoginPage(driver);
		assertTrue(login.isLoginBtnAt());
		login.fillInInput("tomoradenovic@gmail.com", " ");
		login.fillInInput("tomoradenovic@gmail.com", " ");
		login.submit();
		assertTrue(login.isEmailandPassErrorMsgPresent());
	}

	@Test(priority = 5)
	public void passShorterThanSixChars() {
		login = new LoginPage(driver);
		assertTrue(login.isLoginBtnAt());
		login.fillInInput("tomoradenovic@gmail.com", "qwe12");
		login.fillInInput("tomoradenovic@gmail.com", "qwe12");
		login.submit();
		assertTrue(login.isLessThanSixChars());

	}

	@Test(priority = 6)
	public void passLongerThanTwentyChars() {
		login = new LoginPage(driver);
		assertTrue(login.isLoginBtnAt());
		login.fillInInput("tomoradenovic@gmail.com", "keyboardoard500000000000");
		login.fillInInput("tomoradenovic@gmail.com", "keyboardoard500000000000");
		login.submit();
		assertTrue(login.isMoreThanTwentyChars());
	}

	@Test(priority = 7)
	public void allCapsEmail() {
		driver.get("http://app.invoice-factory.source-code.rs/login");
		login = new LoginPage(driver);
		assertTrue(login.isLoginBtnAt());
		login.fillInInput("TOMORADENOVIC@GMAIL.COM", "qwe123");
		login.fillInInput("TOMORADENOVIC@GMAIL.COM", "qwe123");
		login.submit();
		assertTrue(login.isInvalidCredentialsDisplayed());
	}

}
