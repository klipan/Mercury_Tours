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
import elements.*;

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
        driver.get(Login.baseURL);
        Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
        driver.findElement(By.xpath(Login.signOn)).click();
        driver.findElement(By.xpath(Login.regForm)).click();
        driver.findElement(By.cssSelector(Login.signOnUserName)).sendKeys(BaseHelper.username);
        driver.findElement(By.cssSelector(Login.signOnPassword)).sendKeys(BaseHelper.password);
        driver.findElement(By.cssSelector(Login.confirmPass)).sendKeys(BaseHelper.password);
        driver.findElement(By.cssSelector(Login.submit)).click();
        driver.findElement(By.xpath(Login.signIn)).click();
        driver.findElement(By.cssSelector(Login.username)).sendKeys(BaseHelper.username);
        driver.findElement(By.cssSelector(Login.password)).sendKeys(BaseHelper.password);
        driver.findElement(By.cssSelector(Login.submit)).click();
        Assert.assertTrue(driver.getTitle().equals("Find a Flight: Mercury Tours:"));

        Select passangers = new Select(driver.findElement(By.cssSelector(FlightFinder.passengers)));
        passangers.selectByVisibleText(FlightFinder.numOfPass);
        Assert.assertEquals(FlightFinder.numOfPass, passangers.getFirstSelectedOption().getText());

        Select departing = new Select(driver.findElement(By.cssSelector(FlightFinder.departing)));
        departing.selectByVisibleText(FlightFinder.depCity);
        Assert.assertEquals(FlightFinder.depCity, departing.getFirstSelectedOption().getText());

        Select dep_month = new Select(driver.findElement(By.cssSelector(FlightFinder.dep_month)));
        dep_month.selectByVisibleText(FlightFinder.depMonth);
        Assert.assertEquals(FlightFinder.depMonth, dep_month.getFirstSelectedOption().getText());

        Select dep_date = new Select(driver.findElement(By.cssSelector(FlightFinder.dep_date)));
        dep_date.selectByVisibleText(FlightFinder.depDay);
        Assert.assertEquals(FlightFinder.depDay, dep_date.getFirstSelectedOption().getText());

        Select arrival = new Select(driver.findElement(By.cssSelector(FlightFinder.arrival)));
        arrival.selectByVisibleText(FlightFinder.depToCity);
        Assert.assertEquals(FlightFinder.depToCity, arrival.getFirstSelectedOption().getText());

        Select ret_month = new Select(driver.findElement(By.cssSelector(FlightFinder.ret_month)));
        ret_month.selectByVisibleText(FlightFinder.returnMonth);
        Assert.assertEquals(FlightFinder.returnMonth, ret_month.getFirstSelectedOption().getText());

        Select ret_date = new Select(driver.findElement(By.cssSelector(FlightFinder.ret_date)));
        ret_date.selectByVisibleText(FlightFinder.returnDay);
        Assert.assertEquals(FlightFinder.returnDay, ret_date.getFirstSelectedOption().getText());

        WebElement plane_class = driver.findElement(By.cssSelector(FlightFinder.firstClass));
        plane_class.click();
        Assert.assertTrue(plane_class.isSelected());

        Select airline = new Select(driver.findElement(By.cssSelector(FlightFinder.airline)));
        airline.selectByVisibleText(FlightFinder.airlineName);
        Assert.assertEquals(FlightFinder.airlineName, airline.getFirstSelectedOption().getText());

        driver.findElement(By.cssSelector(Login.submit)).click();
        Assert.assertTrue(driver.getTitle().equals("Select a Flight: Mercury Tours"));

        WebElement dep_flight = driver.findElement(By.xpath(SelectFlightAndPassangers.dep_flight));
        dep_flight.click();
        Assert.assertTrue(dep_flight.isSelected());

        WebElement ret_flight = driver.findElement(By.xpath(SelectFlightAndPassangers.ret_flight));
        ret_flight.click();
        Assert.assertTrue(ret_flight.isSelected());

        driver.findElement(By.cssSelector(Login.submit)).click();
        Assert.assertTrue(driver.getTitle().equals("Book a Flight: Mercury Tours"));

        driver.findElement(By.cssSelector(SelectFlightAndPassangers.passanger1)).sendKeys(SelectFlightAndPassangers.passanger1Name);
        driver.findElement(By.cssSelector(SelectFlightAndPassangers.pass1LastName)).sendKeys(SelectFlightAndPassangers.LastName1);
        driver.findElement(By.cssSelector(SelectFlightAndPassangers.creditCard)).sendKeys(SelectFlightAndPassangers.creditCardNum);
        driver.findElement(By.cssSelector(SelectFlightAndPassangers.passanger2)).sendKeys(SelectFlightAndPassangers.passanger2Name);
        driver.findElement(By.cssSelector(SelectFlightAndPassangers.pass2LastName)).sendKeys(SelectFlightAndPassangers.LastName2);
        driver.findElement(By.cssSelector(Login.submit)).click();

        Assert.assertTrue(driver.getTitle().equals("Flight Confirmation: Mercury Tours"));
        Assert.assertTrue((driver.findElement(By.cssSelector(SelectFlightAndPassangers.title)).getText()).equals("Your itinerary has been booked!"));

        driver.findElement(By.xpath(SelectFlightAndPassangers.LogOut)).click();
        driver.quit();

    }

    @AfterTest
    public void over() {
        System.out.println("Test is over. Maskarada!!");
    }
}
