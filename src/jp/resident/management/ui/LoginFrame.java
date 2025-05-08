package jp.resident.management.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    
    JPanel panel = new JPanel();
    JLabel userLabel = new JLabel("ユーザー名:");
    JLabel passLabel = new JLabel("パスワード:");
	JButton loginButton = new JButton("ログイン");
	JPanel innerPanel = new JPanel();
	JLabel errorLabel = new JLabel("");
	
    public LoginFrame() {
    	setTitle("ログイン画面");
    	setSize(600, 600);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLocationRelativeTo(null); // 画面中央

    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    	// ユーザー入力欄など
    	userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    	usernameField = new JTextField();
    	usernameField.setMaximumSize(new Dimension(150, 50));
    	usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

    	passLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    	passwordField = new JPasswordField();
    	passwordField.setMaximumSize(new Dimension(150, 50));
    	passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

    	loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    	// ボタン押下時に attemptLogin() を呼び出す
    	loginButton.addActionListener(e -> {
    	    String user = usernameField.getText();
    	    String pass = new String(passwordField.getPassword());

    	    if (validateInput(user, pass)) {
    	        attemptLogin();
    	    }
    	});
    	
    	// エラーメッセージラベル設定
    	errorLabel.setText("");
    	errorLabel.setForeground(Color.RED);
    	errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    	

    	// 一時パネルでコンポーネントをまとめて配置（高さ計算しやすくする）
    	innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
    	innerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    	innerPanel.add(errorLabel);
    	innerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // エラーとユーザー欄の間に余白
    	innerPanel.add(userLabel);
    	innerPanel.add(usernameField);
    	innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    	innerPanel.add(passLabel);
    	innerPanel.add(passwordField);
    	innerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    	innerPanel.add(loginButton);


    	// フレームの高さを取得して中央に余白を入れる（後で調整）
    	panel.add(Box.createVerticalGlue()); // 上余白
    	panel.add(innerPanel);
    	panel.add(Box.createVerticalGlue()); // 下余白
    	
    	add(panel);

    	setVisible(true);

    }
    
    //入力内容チェック
    private boolean validateInput(String user, String pass) {
    if (user.length() > 15) {
        errorLabel.setText("ユーザー名は15文字以内で入力してください");
        usernameField.requestFocusInWindow();
        return false;
    }
    if (!user.matches("[a-zA-Z0-9]+")) {
        errorLabel.setText("ユーザー名は半角英数字のみです");
        usernameField.requestFocusInWindow();
        return false;
    }
    if (pass.length() < 4) {
        errorLabel.setText("パスワードは4文字以上入力してください");
        passwordField.requestFocusInWindow();
        return false;
    }
    return true;
}

    private void attemptLogin() {
        String inputUser = usernameField.getText();
        String inputPass = new String(passwordField.getPassword());

        new jp.resident.management.lib.dblogin();
        boolean success = false;
		try {
			success = jp.resident.management.lib.dblogin.authenticate(inputUser, inputPass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (success) {
            dispose();
            new MainMenuFrame();
        } else {
            errorLabel.setText("ユーザー名またはパスワードが違います");
            usernameField.requestFocusInWindow();
            userLabel.setForeground(Color.RED);
            passLabel.setForeground(Color.RED);
        }
    }
}