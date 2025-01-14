* Kết quả chạy khi ở website
![Screenshot (12)](https://github.com/user-attachments/assets/4a083862-1afe-4458-ab3c-4fa27b4cb32c)
![Screenshot (14)](https://github.com/user-attachments/assets/72e50f66-8b53-4ab2-84b2-7b0353b6715a)

* Kết quả in ra khi hoàn thành kiểm thử tự động
  ![Screenshot (15)](https://github.com/user-attachments/assets/82513eb2-f453-4029-b314-c8463b4d55af)

* Giải thích code
  1. Gói và các thư viện được sử dụng
   ![image](https://github.com/user-attachments/assets/f19eb4ce-d742-4e6d-9374-68730aa485cd)
        - package com.example.selenium: Xác định gói (package) của lớp này là com.example.selenium.
            + Gói là cách tổ chức các lớp Java thành các nhóm logic.
  ![image](https://github.com/user-attachments/assets/a61f2577-b2e1-4887-8beb-40a3aef79a80)
        - WebDriverManager: Thư viện của bonigarcia dùng để tự động tải và cấu hình driver (ChromeDriver, GeckoDriver, v.v.) mà không cần làm thủ công.

       - org.openqa.selenium:
          + WebDriver: Interface chính đại diện cho trình duyệt.
          + WebElement: Đại diện cho các thành phần (elements) trên trang web.
          + By: Dùng để tìm phần tử trên trang web.
      
      - ChromeDriver: Trình điều khiển (driver) dành cho trình duyệt Google Chrome.
          + Duration: Định nghĩa thời gian chờ (timeout) theo đơn vị seconds, minutes, v.v.
    2. Lớp và phương thức chính
       ![image](https://github.com/user-attachments/assets/c81f542e-21d4-4804-ab94-2e992e0eaf2c)
       + public class SeleniumTest: Lớp chính của chương trình, được đặt tên là SeleniumTest.
       + public static void main(String[] args): Phương thức chính (entry point) để chạy chương trình.
    3. Cấu hình ChromeDriver
        ![Screenshot (18)](https://github.com/user-attachments/assets/233aa983-657a-4b88-8775-8721ae3e8b17)
      + WebDriverManager.chromedriver().setup(): Tự động tải và cấu hình ChromeDriver phù hợp với phiên bản trình duyệt hiện tại.

    4.  Khởi tạo WebDriver
       ![image](https://github.com/user-attachments/assets/4857fd63-9439-4ffd-ab9c-60ca5a221c2b)
        + WebDriver driver = new ChromeDriver(): Khởi tạo đối tượng WebDriver để điều khiển trình duyệt Google Chrome.
        
        + implicitlyWait: Thiết lập thời gian chờ ngầm định là 10 giây để Selenium tìm thấy các phần tử trên trang.

        + maximize(): Mở trình duyệt ở chế độ toàn màn hình.
    5. Điều hướng đến trang web
       ![image](https://github.com/user-attachments/assets/2659c191-6a59-459a-bc88-9ab2b5867edd)
       + driver.get(url): Điều hướng trình duyệt đến URL được cung cấp.
    6. Tìm và thao tác với các phần tử trên trang
        ![image](https://github.com/user-attachments/assets/f69d3f84-5607-4815-be9a-5791ac1bcb4f)
       + findElement(By.id("...")): Tìm phần tử trên trang web bằng id.
       + findElement(By.cssSelector("...")): Tìm phần tử bằng bộ chọn CSS.
       + sendKeys("..."): Nhập văn bản vào phần tử, ví dụ: ô nhập liệu.
       + click(): Nhấn vào nút hoặc phần tử trên trang.
    7. Lấy thông báo đăng nhập thành công
       ![image](https://github.com/user-attachments/assets/bcc69f87-8472-4ff1-a7c1-d1098dec9678)
        +  findElement(By.cssSelector(".flash.success")): Tìm phần tử thông báo có class flash success.
        +  getText(): Lấy nội dung văn bản từ phần tử.
        +  split("×"): Chia chuỗi tại ký tự ×.
        +  trim(): Loại bỏ khoảng trắng thừa trước/sau chuỗi.
        +  System.out.println("..."): In thông báo ra console.
    8. Tạm dừng để quan sát
                            Thread.sleep(10000);
    9. Xử lý ngoại lệ
        } catch (Exception e) {
    e.printStackTrace();
}
    10. Đóng trình duyệt
           finally {
    driver.quit();
}
       + finally: Đảm bảo đoạn mã trong khối này luôn được thực thi, ngay cả khi xảy ra lỗi.
       + driver.quit(): Đóng toàn bộ cửa sổ trình duyệt và hủy session WebDriver.



    
    
  



  


