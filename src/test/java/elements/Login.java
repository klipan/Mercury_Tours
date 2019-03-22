package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    public static String baseURL = "http://newtours.demoaut.com/";
    public static String signOn = "//*[@alt='Sign-In']";
    public static String regForm = "//*/td[2]/table//p/font/a[@href='mercuryregister.php']";
    public static String signOnUserName = "[name='email']";
    public static String signOnPassword = "[name='password']";
    public static String confirmPass = "[name='confirmPassword']";
    public static String submit = "[type='image']";
    public static String signIn = "//*/a[@href='mercurysignon.php']";
    public static String username = "[name=userName]";
    public static String password = "[name=password]";
}
