package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertTrue;

public class Stepdefs {
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("^login is selected$")
    public void login_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();          
    }
    
    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_correct_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^correct username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }
    
    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        pageHasContent("Ohtu Application main page");
    }
    
    @Then("^user is not logged in and error message is given$")
    public void user_is_not_logged_in_and_error_message_is_given() throws Throwable {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }     
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }

    @When("^nonexistent username \"([^\"]*)\" is given$")
    public void nonexistentUsernameIsGiven(String username) throws Throwable {
        logInWith(username, "testpassword");
    }

    @Given("^new user is selected$")
    public void newUserIsSelected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }

    @Then("^user \"([^\"]*)\" is not created and error \"([^\"]*)\" is reported$")
    public void userIsNotCreatedAndErrorIsReported(String username, String message) throws Throwable {
        pageHasContent(message);
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys("testpassword!");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("testpassword!");
        element = driver.findElement(By.name("signup"));
        element.submit();
        pageHasContent("is already taken");
    }

    @When("^valid username \"([^\"]*)\" and valid password \"([^\"]*)\" are given$")
    public void validUsernameAndValidPasswordAreGiven(String username, String password) throws Throwable {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }

    @Then("^user is created and message \"([^\"]*)\" is shown$")
    public void userIsCreatedAndMessageIsShown(String message) throws Throwable {
        this.pageHasContent(message);
    }

    @When("^invalid username \"([^\"]*)\" and valid password \"([^\"]*)\" are given$")
    public void invalidUsernameAndValidPasswordAreGiven(String username, String password) throws Throwable {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }

    @When("^valid  username \"([^\"]*)\" and invalid password \"([^\"]*)\" are given$")
    public void validUsernameAndInvalidPasswordAreGiven(String username, String password) throws Throwable {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }

    @Given("^user \"([^\"]*)\" is created$")
    public void userIsCreated(String name) throws Throwable {
        this.newUserIsSelected();
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(name);
        element = driver.findElement(By.name("password"));
        element.sendKeys("tester12");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("tester12");
        element = driver.findElement(By.name("signup"));
        element.submit();
    }

    @And("^invalid password confirmation \"([^\"]*)\" is given$")
    public void invalidPasswordConfirmationIsGiven(String confirm) throws Throwable {
        this.newUserIsSelected();
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(confirm);
        element = driver.findElement(By.name("password"));
        element.sendKeys("tester12");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(confirm);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }
}
