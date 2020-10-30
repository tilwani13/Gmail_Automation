package Framework.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Gmail {

    public static void main(String[] args) throws InterruptedException {


        String path =System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path+"//chromedriver_win32 (1)_86//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://stackoverflow.com/users/login");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.gmail.com");
        //driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");
        //driver.get("https://stackoverflow.com/users/signup");
        //sleep(3);
        //driver.findElement(By.xpath("//*[@id='openid-buttons']/button[1]")).click();
        //Send email address
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("User/Sender Email ID");
        driver.findElement(By.xpath("//div[@id='identifierNext']")).click();

        //send password
        WebElement passwordButton = driver.findElement(By.xpath("//input[@name='password']"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(passwordButton));
        passwordButton.sendKeys("User Password");
        driver.findElement(By.xpath("//div[@id='passwordNext']")).click();

        //Click on compose button
        driver.findElement(By.xpath("//div[text()='Compose']")).click();

        //Enter the sender mail id
        driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("tilwani13@gmail.com");
        //Enter subject to the mail
        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Selenium script");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf']")).sendKeys("Selenium script to send mail");
        driver.findElement(By.xpath("//*[@id=\":bw\"]")).sendKeys("Selenium script to send mail for gmail compose function");

        //Attach the full path of file
        String path1 =path+"\\src\\main\\java\\Framework\\selenium\\Attachment.txt";
        driver.findElement(By.xpath("//input[@name='Filedata']")).sendKeys(path1);
        driver.findElement(By.xpath("//div[text()='Send']")).click();



    }
}
