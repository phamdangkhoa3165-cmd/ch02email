package org.example.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.model.business.User;
import org.example.model.data.DBContext;

public class UserDB {

    public static int insert(User user) {
        String sql = "INSERT INTO users (email, first_name, last_name) VALUES (?, ?, ?)";

        // Sử dụng try-with-resources để tự động đóng kết nối sau khi thực thi xong
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Gán dữ liệu từ đối tượng user vào các dấu '?'
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());

            // Thực thi lệnh INSERT (Trả về số dòng thành công, ví dụ 1)
            return ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return 0; // Thất bại
        }
    }
}