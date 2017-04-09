package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:4567");
        
        //sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        //sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        //sleep(2);
        element.submit();

        driver.get("http://localhost:4567");

        //sleep(2);

        element = driver.findElement(By.linkText("login"));
        element.click();

        //sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("eri");
        element = driver.findElement(By.name("login"));

        //sleep(2);
        element.submit();

        driver.get("http://localhost:4567");

        //sleep(2);

         element = driver.findElement(By.linkText("login"));
        element.click();

        //sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekkaaaaaa");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        //sleep(2);
        element.submit();


        driver.get("http://localhost:4567");

        //sleep(2);


        element = driver.findElement(By.linkText("register new user"));
        element.click();

        //sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka2");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep2");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep2");
        element = driver.findElement(By.name("signup"));
        //sleep(2);
        element.submit();

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        element = driver.findElement(By.linkText("logout"));
        element.click();
        //sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
