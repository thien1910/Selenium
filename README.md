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

     6. Điều hướng đến trang web
      
       ![image](https://github.com/user-attachments/assets/2659c191-6a59-459a-bc88-9ab2b5867edd)
      
       + driver.get(url): Điều hướng trình duyệt đến URL được cung cấp.
    
    7. Tìm và thao tác với các phần tử trên trang

        ![image](https://github.com/user-attachments/assets/f69d3f84-5607-4815-be9a-5791ac1bcb4f)

       + findElement(By.id("...")): Tìm phần tử trên trang web bằng id.
       + findElement(By.cssSelector("...")): Tìm phần tử bằng bộ chọn CSS.
       + sendKeys("..."): Nhập văn bản vào phần tử, ví dụ: ô nhập liệu.
       + click(): Nhấn vào nút hoặc phần tử trên trang.

     9. Lấy thông báo đăng nhập thành công

  ![image](https://github.com/user-attachments/assets/bcc69f87-8472-4ff1-a7c1-d1098dec9678)
        +  findElement(By.cssSelector(".flash.success")): Tìm phần tử thông báo có class flash success.
        +  getText(): Lấy nội dung văn bản từ phần tử.
        +  split("×"): Chia chuỗi tại ký tự ×.
        +  trim(): Loại bỏ khoảng trắng thừa trước/sau chuỗi.
        +  System.out.println("..."): In thông báo ra console.
    
    11. Tạm dừng để quan sát
                            Thread.sleep(10000);
   
    12. Xử lý ngoại lệ
        } catch (Exception e) {
    e.printStackTrace();
}
    
    13. Đóng trình duyệt
           finally {
    driver.quit();
}
       + finally: Đảm bảo đoạn mã trong khối này luôn được thực thi, ngay cả khi xảy ra lỗi.
       + driver.quit(): Đóng toàn bộ cửa sổ trình duyệt và hủy session WebDriver.

* Hướng dẫn chi tiết về cách cài đặt, cấu hình và chạy dự án, cũng như mục tiêu và phạm vi của dự án.
1. Mục tiêu và Phạm vi Dự án
+ Mục tiêu:
    - Kiểm thử tự động hóa các tính năng của trang web.
    - Mục tiêu chính là tự động đăng nhập vào một trang web, kiểm tra thông báo sau khi đăng nhập và in kết quả ra console.
    - Selenium sẽ được sử dụng để mô phỏng các thao tác người dùng như nhập liệu và click vào các phần tử.
+ Phạm vi:
    - Tạo một dự án Java với Selenium để thực hiện kiểm thử tự động trên trang web.
    - Kiểm thử đăng nhập vào trang web mẫu (https://the-internet.herokuapp.com/login).
    - Tạo các bước kiểm thử như nhập tên người dùng, mật khẩu và xác minh thông báo đăng nhập thành công.
2. Cài đặt Dự án trên IntelliJ IDEA
Bước 1: Cài đặt IntelliJ IDEA
Bước 2: Tạo Dự án Mới
     - Mở IntelliJ IDEA và chọn Create New Project.
     - Chọn Java và Maven (hoặc Gradle nếu bạn quen với Gradle), chọn phiên bản JDK.
     - Đặt tên dự án và chọn thư mục lưu dự án.
Bước 3: Thêm Thư viện Selenium và WebDriverManager vào pom.xml
Bước 4: Cài đặt Thư viện
3. Viết Mã Kiểm Thử với Selenium
4. Chạy Dự Án
5. Kiểm thử và Ghi nhận kết quả
  - Mục tiêu Kiểm Thử:
     + Kiểm tra tính năng đăng nhập: Đảm bảo người dùng có thể đăng nhập vào trang web với thông tin hợp lệ.
     + Kiểm tra thông báo sau khi đăng nhập thành công: Xác minh rằng thông báo "You logged into a secure area!" xuất hiện và không có lỗi.
  - Phạm vi Kiểm Thử:
     + Dự án này chỉ tập trung vào kiểm thử đăng nhập và không kiểm thử các tính năng khác của trang web.
     + Kiểm thử chỉ được thực hiện trên trình duyệt Google Chrome.

    
    
  



  


