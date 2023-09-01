package com.sprintqa.class50;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Example using Selenium WebDriver to interact and test TextAreas.
 * 
 * Use this site https://www.seleniumeasy.com/test/input-form-demo.html for
 * testing.
 */
class UsingTextAreaWithSeleniumExample {
	WebDriver webDriver;
	String url = "https://www.seleniumeasy.com/test/input-form-demo.html";

	/**
	 * Remember to configure your System path so the application can find your
	 * ChromeDriver binary files.
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() {
		// Setup the System path to the Selenium Chrome Binary file
		// Use System.getProperty("user.dir") to get the system path for the project.
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/webdrivers/mac/chromedriver");

		// Instantiate WebDriver to use ChromeDriver.
		webDriver = new ChromeDriver();
	}

	/**
	 * Make sure when your done running your tests that you close the window/tab and
	 * then exit out of the browser window.
	 * 
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		webDriver.close();
		webDriver.quit();
	}

	/**
	 * Enter in text into a TextArea on a form.
	 * 
	 * @throws InterruptedException
	 */
	@Test
	void textAreaTest() throws InterruptedException {
		// Define our String variables and default text
		// We are using the newline tag "\n" to add text to multiple line in the text
		// area.
		String inputTextAreaText = "line1\nline2";
		String actualTextAreaText = "";

		// Open up your Chrome browser to the starting web page.
		webDriver.get(url);

		// Maximize the Chrome browser to fill the screen.
		webDriver.manage().window().maximize();

		// Look up page elements using WebDriver findElement() method.
		WebElement projectDescriptionTextArea = webDriver.findElement(By.name("comment"));

		// Populate text area
		projectDescriptionTextArea.sendKeys("line1\nline2");

		// Why wont this work?
		actualTextAreaText = projectDescriptionTextArea.getText();

		// But this will?
		// Values inputed in form fields are stores in the attribute value
		actualTextAreaText = projectDescriptionTextArea.getAttribute("value");

		// Validate text is displayed
		assertEquals(inputTextAreaText, actualTextAreaText);

	}

}
