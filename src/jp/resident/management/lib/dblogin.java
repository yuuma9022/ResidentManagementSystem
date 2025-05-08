package jp.resident.management.lib;

import java.sql.*;

public class dblogin {

    // DBに照合してログインできるか確認するメソッド
    public static boolean authenticate(String inputUser, String inputPass) {
        String dbUser = "root";
        String dbPass = "Ts82758275";
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            String sql = "SELECT * FROM employers WHERE user = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, inputUser);
                stmt.setString(2, inputPass);

                ResultSet rs = stmt.executeQuery();
                return rs.next(); // 認証成功 → true, 失敗 → false
            }
        } catch (SQLException e) {
            e.printStackTrace(); // ログ出力（本番ならロギング推奨）
            return false; // エラー時もログイン失敗扱い
        }
    }
}
