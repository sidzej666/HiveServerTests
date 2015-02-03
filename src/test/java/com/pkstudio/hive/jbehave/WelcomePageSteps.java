package com.pkstudio.hive.jbehave;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@Steps
public class WelcomePageSteps {
	
	private String name;
	private WebDriver driver = new FirefoxDriver();
	
	@When("I enter the welcome page providing <name> as a name")
	public void welcomePage(@Named("name") String name) {
		driver.get("http://localhost:8080/hiveServer/hello/" + name);
		this.name = name;
	}
	
	@Then("the message should be <message>")
	public void theMessageShouldBe(@Named("message") String message) {
		WebElement element = driver.findElement(By.id("greetings"));
		assertThat(element.getText(), is(message));
	}
}
