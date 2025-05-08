package jp.resident.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {
    	
    	new jp.resident.management.ui.LoginFrame();
    }
}
    	
    	
    	
    	
////    	以下、DB接続確認用コード
//        // 接続情報
//    	String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
//        String user = "root";
//        String password = "Ts82758275";
//
//
//try (Connection conn = DriverManager.getConnection(url, user, password)) {
//    System.out.println("✅ MySQLに接続成功！");
//
//    // 1. SELECT（初期状態）
//    System.out.println("\n🔍 現在の住民一覧:");
//    showResidents(conn);
//
//    // 2. INSERT
//    System.out.println("\n📝 新規住民を追加します...");
//    insertResident(conn, 2, "佐藤");
//
//    // 3. SELECT（追加後確認）
//    System.out.println("\n🔍 追加後の住民一覧:");
//    showResidents(conn);
//
//    // 4. DELETE
//    System.out.println("\n🗑 id2を削除します...");
//    deleteResidentByName(conn, 2);
//
//    // 5. SELECT（削除後確認）
//    System.out.println("\n🔍 削除後の住民一覧:");
//    showResidents(conn);
//
//} catch (SQLException e) {
//    e.printStackTrace();
//}
//}
//
//// SELECT
//private static void showResidents(Connection conn) throws SQLException {
//String sql = "SELECT id, name FROM one";
//try (Statement stmt = conn.createStatement();
//     ResultSet rs = stmt.executeQuery(sql)) {
//    while (rs.next()) {
//        System.out.printf("ID: %d / 氏名: %s\n",
//                rs.getInt("id"),
//                rs.getString("name"));
//    }
//}
//}
//
//// INSERT
//private static void insertResident(Connection conn,int id, String name) throws SQLException {
//String sql = "INSERT INTO one (id, name) VALUES (?, ?)";
//try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
//    pstmt.setInt(1, id);
//    pstmt.setString(2, name);
//    pstmt.executeUpdate();
//}
//}
//
//// DELETE
//private static void deleteResidentByName(Connection conn, int id) throws SQLException {
//String sql = "DELETE FROM one WHERE id = ?";
//try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
//    pstmt.setInt(1, id);
//    pstmt.executeUpdate();
//}
//}
//}
