package Bai4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Ánh xạ nhiều URL vào cùng một Servlet bằng cách truyền một mảng { } vào value
@WebServlet(value = {
        "/crud/create",
        "/crud/update",
        "/crud/delete",
        "/crud/edit/2024"
})
public class CrudServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Cấu hình hiển thị tiếng Việt không lỗi font
        resp.setContentType("text/html;charset=UTF-8");

        // Lấy địa chỉ URL cụ thể mà người dùng vừa truy cập
        String path = req.getServletPath();

        // Chuỗi thông báo sẽ xuất ra màn hình
        String message = "";

        // Kiểm tra và đưa ra thông báo tương ứng cho từng URL
        switch (path) {
            case "/crud/create":
                message = "<h3>Bạn đã yêu cầu chức năng: THÊM MỚI (Create)</h3>";
                break;
            case "/crud/update":
                message = "<h3>Bạn đã yêu cầu chức năng: CẬP NHẬT (Update)</h3>";
                break;
            case "/crud/delete":
                message = "<h3>Bạn đã yêu cầu chức năng: XÓA (Delete)</h3>";
                break;
            case "/crud/edit/2024":
                message = "<h3>Bạn đã yêu cầu chức năng: CHỈNH SỬA NĂM 2024 (Edit 2024)</h3>";
                break;
            default:
                message = "<h3>Địa chỉ không hợp lệ!</h3>";
                break;
        }

        // Xuất thông báo ra trình duyệt
        resp.getWriter().println(message);
    }
}
