import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

public class Belot {

    private WebDriver driver;

    @Before
    public void setUp(){

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void TestLogin(){
        driver.get("http://belote.bg");
        String validUsername = "Username";
        String validPassword = "Password";
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.clear();
        usernameField.sendKeys(validUsername);
        passwordField.clear();
        passwordField.sendKeys(validPassword);
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        assertEquals(
                "https://belote.bg/home",
                driver.getCurrentUrl()
        );
        WebElement fullname = driver.findElement(By.className("userName"));
        assertEquals(
                "Username",
                fullname.getText()
        );
    }

    @Test
    public void Test_Change_UserName(){
        this.TestLogin();
        WebElement Profile  = driver.findElement(By.className("Profile-button"));
        Profile.click();
        WebElement Username = driver.findElement(By.className("Username-field"));
        Username.clear();
        Username.sendKeys("NewUserName");
        WebElement Apply = driver.findElement(By.className("Username-Apply"));
        Apply.click();
        WebElement Home = driver.findElement(By.cssSelector("Home-button"));
        Home.click();
        WebElement Send = driver.findElement(By.className("abv-button"));
        Send.click();
        WebElement fullname2 = driver.findElement(By.className("userName"));
        assertEquals(
                "NewUserName",
                fullname2.getText()
        );
    }


    @After
    public void www(){

    }
}
