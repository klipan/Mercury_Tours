package cetera;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class trojkom_protiv_droge {

    WebDriver driver;

    @BeforeTest
    public void cetera() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\klipan\\Desktop\\Programi\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Dobrodosli drugovi");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.get("http://newtours.demoaut.com/");
        Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
        driver.findElement(By.xpath("//*[@alt='Sign-In']")).click();
        driver.findElement(By.xpath("//*/td[2]/table//p/font/a[@href='mercuryregister.php']")).click();
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("reci_ne_drogama");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("trojka");
        driver.findElement(By.cssSelector("[name='confirmPassword']")).sendKeys("trojka");
        driver.findElement(By.cssSelector("[type='image']")).click();
        driver.findElement(By.xpath("//*/a[@href='mercurysignon.php']")).click();
        driver.findElement(By.cssSelector("[name=userName]")).sendKeys("reci_ne_drogama");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("trojka");
        driver.findElement(By.cssSelector("[type='image']")).click();
        Assert.assertTrue(driver.getTitle().equals("Find a Flight: Mercury Tours:"));

        Select passangers = new Select(driver.findElement(By.cssSelector("[name=passCount]")));
        passangers.selectByVisibleText("2");
        Assert.assertEquals("2 ", passangers.getFirstSelectedOption().getText());

        Select departing = new Select(driver.findElement(By.cssSelector("[name=fromPort]")));
        departing.selectByVisibleText("Zurich");
        Assert.assertEquals("Zurich", departing.getFirstSelectedOption().getText());

        Select dep_month = new Select(driver.findElement(By.cssSelector("[name=fromMonth]")));
        dep_month.selectByVisibleText("September");
        Assert.assertEquals("September", dep_month.getFirstSelectedOption().getText());

        Select dep_date = new Select(driver.findElement(By.cssSelector("[name=fromDay]")));
        dep_date.selectByVisibleText("15");
        Assert.assertEquals("15", dep_date.getFirstSelectedOption().getText());

        Select arrival = new Select(driver.findElement(By.cssSelector("[name=toPort]")));
        arrival.selectByVisibleText("San Francisco");
        Assert.assertEquals("San Francisco", arrival.getFirstSelectedOption().getText());

        Select ret_month = new Select(driver.findElement(By.cssSelector("[name=toMonth]")));
        ret_month.selectByVisibleText("December");
        Assert.assertEquals("December", ret_month.getFirstSelectedOption().getText());

        Select ret_date = new Select(driver.findElement(By.cssSelector("[name=toDay]")));
        ret_date.selectByVisibleText("18");
        Assert.assertEquals("18", ret_date.getFirstSelectedOption().getText());

        WebElement plane_class = driver.findElement(By.cssSelector("[value=First]"));
        plane_class.click();
        Assert.assertTrue(plane_class.isSelected());

        Select airline = new Select(driver.findElement(By.cssSelector("[name=airline]")));
        airline.selectByVisibleText("Blue Skies Airlines");
        Assert.assertEquals("Blue Skies Airlines", airline.getFirstSelectedOption().getText());

        driver.findElement(By.cssSelector("[type=image]")).click();
        Assert.assertTrue(driver.getTitle().equals("Select a Flight: Mercury Tours"));

        WebElement dep_flight = driver.findElement(By.xpath("//*[contains(@value,'361')]"));
        dep_flight.click();
        Assert.assertTrue(dep_flight.isSelected());

        WebElement ret_flight = driver.findElement(By.xpath("//*[contains(@value,'631')]"));
        ret_flight.click();
        Assert.assertTrue(ret_flight.isSelected());

        driver.findElement(By.cssSelector("[type=image]")).click();
        Assert.assertTrue(driver.getTitle().equals("Book a Flight: Mercury Tours"));

        driver.findElement(By.cssSelector("[name=passFirst0]")).sendKeys("Lazar");
        driver.findElement(By.cssSelector("[name=passLast0]")).sendKeys("Raskovic");
        driver.findElement(By.cssSelector("[name=creditnumber]")).sendKeys("001234567");
        driver.findElement(By.cssSelector("[name=passFirst1]")).sendKeys("Nikola");
        driver.findElement(By.cssSelector("[name=passLast1]")).sendKeys("Klipa");
        driver.findElement(By.cssSelector("[type=image]")).click();

        Assert.assertTrue(driver.getTitle().equals("Flight Confirmation: Mercury Tours"));
        Assert.assertTrue((driver.findElement(By.cssSelector("[size=\"\\+1\"]")).getText()).equals("Your itinerary has been booked!"));

        driver.findElement(By.xpath("//*/img[@src='/images/forms/Logout.gif']")).click();
        driver.quit();

    }

    @AfterTest
    public void over() {
        System.out.println("Test is over. Maskarada!!");
    }
}
