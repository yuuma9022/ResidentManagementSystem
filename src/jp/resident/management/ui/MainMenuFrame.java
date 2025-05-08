package jp.resident.management.ui;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MainMenuFrame  extends JFrame {
	
	public MainMenuFrame() {
    	setTitle("業務内容選択画面");
    	setSize(600, 600);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLocationRelativeTo(null); // 画面中央
    	setVisible(true);
	}
}
