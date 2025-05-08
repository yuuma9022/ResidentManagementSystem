package jp.resident.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("ログイン画面");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 画面中央

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        panel.add(new JLabel("ユーザー名:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("パスワード:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("ログイン");
        loginButton.addActionListener(e -> attemptLogin());
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    private void attemptLogin() {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        // DB接続情報（最初は固定でOK）
        String url = "jdbc:mysql://localhost:3306/your_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            JOptionPane.showMessageDialog(this, "✅ ログイン成功！");
            dispose(); // この画面を閉じて
            // 次の画面へ（仮でSystem.outに出力）
            System.out.println("→ メニュー画面へ遷移...");
            // new MainMenuFrame(); ← 後で実装
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "❌ ログイン失敗：" + ex.getMessage(), "エラー", JOptionPane.ERROR_MESSAGE);
        }
    }
}
