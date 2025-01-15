package com.example.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class kiemthuSelenium {
    public static void main(String[] args) {
        // Cấu hình ChromeDriver tự động
        WebDriverManager.chromedriver().setup();

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            // Kiểm thử các kịch bản đăng nhập
            testValidLogin(driver); // Đăng nhập hợp lệ
            testInvalidUsername(driver); // Tên người dùng sai
            testInvalidPassword(driver); // Mật khẩu sai
            testEmptyUsername(driver); // Trường tên người dùng rỗng
            testEmptyPassword(driver); // Trường mật khẩu rỗng
            testEmptyFields(driver); // Cả hai trường rỗng
            // Tạm dừng 5 giây để quan sát
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }

    // Kiểm thử đăng nhập hợp lệ
    public static void testValidLogin(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/login");
        // Chờ 2 giây sau khi chuyển đến trang login
        sleep(2000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button.radius"));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        loginButton.click();

        // Chờ 2 giây sau khi nhấn đăng nhập
        sleep(2000);

        WebElement successMessage = driver.findElement(By.cssSelector(".flash.success"));
        String message = successMessage.getText().split("×")[0].trim();
        System.out.println("Valid Login Test: " + message);
    }

    // Kiểm thử đăng nhập với tên người dùng sai
    public static void testInvalidUsername(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/login");
        // Chờ 2 giây sau khi chuyển đến trang login
        sleep(2000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button.radius"));

        username.sendKeys("wrongusername");
        password.sendKeys("SuperSecretPassword!");
        loginButton.click();

        // Chờ 2 giây sau khi nhấn đăng nhập
        sleep(2000);

        WebElement errorMessage = driver.findElement(By.cssSelector(".flash.error"));
        String message = errorMessage.getText().split("×")[0].trim();
        System.out.println("Invalid Username Test: " + message);
    }

    // Kiểm thử đăng nhập với mật khẩu sai
    public static void testInvalidPassword(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/login");
        // Chờ 2 giây sau khi chuyển đến trang login
        sleep(2000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button.radius"));

        username.sendKeys("tomsmith");
        password.sendKeys("WrongPassword!");
        loginButton.click();

        // Chờ 2 giây sau khi nhấn đăng nhập
        sleep(2000);

        WebElement errorMessage = driver.findElement(By.cssSelector(".flash.error"));
        String message = errorMessage.getText().split("×")[0].trim();
        System.out.println("Invalid Password Test: " + message);
    }

    // Kiểm thử đăng nhập với trường tên người dùng rỗng
    public static void testEmptyUsername(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/login");
        // Chờ 2 giây sau khi chuyển đến trang login
        sleep(2000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button.radius"));

        username.sendKeys("");
        password.sendKeys("SuperSecretPassword!");
        loginButton.click();

        // Chờ 2 giây sau khi nhấn đăng nhập
        sleep(2000);

        WebElement errorMessage = driver.findElement(By.cssSelector(".flash.error"));
        String message = errorMessage.getText().split("×")[0].trim();
        System.out.println("Empty Username Test: " + message);
    }

    // Kiểm thử đăng nhập với mật khẩu rỗng
    public static void testEmptyPassword(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/login");
        // Chờ 2 giây sau khi chuyển đến trang login
        sleep(2000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button.radius"));

        username.sendKeys("tomsmith");
        password.sendKeys("");
        loginButton.click();

        // Chờ 2 giây sau khi nhấn đăng nhập
        sleep(2000);

        WebElement errorMessage = driver.findElement(By.cssSelector(".flash.error"));
        String message = errorMessage.getText().split("×")[0].trim();
        System.out.println("Empty Password Test: " + message);
    }

    // Kiểm thử đăng nhập với cả hai trường rỗng
    public static void testEmptyFields(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/login");
        // Chờ 2 giây sau khi chuyển đến trang login
        sleep(2000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button.radius"));

        username.sendKeys("");
        password.sendKeys("");
        loginButton.click();

        // Chờ 2 giây sau khi nhấn đăng nhập
        sleep(2000);

        WebElement errorMessage = driver.findElement(By.cssSelector(".flash.error"));
        String message = errorMessage.getText().split("×")[0].trim();
        System.out.println("Empty Fields Test: " + message);
    }

    // Phương thức phụ để thực hiện việc tạm dừng chương trình
    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds); // Chờ trong thời gian đã định (ms)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
