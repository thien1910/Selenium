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
            // Điều hướng đến trang đăng nhập
            driver.get("https://the-internet.herokuapp.com/login");

            // Tìm và nhập thông tin đăng nhập
            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.cssSelector("button.radius"));

            username.sendKeys("tomsmith");
            password.sendKeys("SuperSecretPassword!");
            loginButton.click();

            // Tìm phần tử thông báo thành công
            WebElement successMessage = driver.findElement(By.cssSelector(".flash.success"));

            // Loại bỏ ký tự '×' và chỉ lấy nội dung thông báo chính
            String message = successMessage.getText().split("×")[0].trim();

            // In kết quả ra console
            System.out.println("Login Test: " + message);

            // Tạm dừng 10 giây để quan sát
            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}
