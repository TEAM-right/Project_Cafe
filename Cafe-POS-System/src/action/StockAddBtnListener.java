package action;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import jdbc.hikari.HikariCP;
import tool.RoundJTextField;

public class StockAddBtnListener implements ActionListener {
	
	private JFrame addFrame;
	private JTextField name, count;
	private JLabel nameL, countL;
	private JButton confirm_btn, cancel_btn;
	private JTable table;
	
	private Font font = new Font("���� ���", Font.BOLD, 15);
	
	public StockAddBtnListener(JTable table) {
		this.table = table;
	}
	
	private JFrame AddTableData() {
		addFrame = new JFrame("ADD STOCK");
		addFrame.setLayout(null);
		addFrame.setLocation(200,200);
		addFrame.setSize(500, 200);
		addFrame.setResizable(false);
		addFrame.getContentPane().setBackground(Color.white);
		addFrame.setVisible(true);
		
		//��
		nameL = new JLabel("�̸�");
		nameL.setBounds(100, 20, 100, 30);
		nameL.setFont(font);
		addFrame.add(nameL);
		
		countL = new JLabel("����");
		countL.setFont(font);
		countL.setBounds(100, 60, 100, 30);
		addFrame.add(countL);
		
		// �̸� �ؽ�Ʈ �ʵ�
		name = new JTextField(10);
		name.setBounds(140, 20, 300, 30);
		addFrame.add(name);
		
		// ī��Ʈ �ؽ�Ʈ �ʵ�
		count = new JTextField(10);
		count.setBounds(140, 60, 300, 30);
		addFrame.add(count);

		confirm_btn = new JButton("�߰�");
		confirm_btn.setFont(font);
		confirm_btn.setBounds(295, 110, 65, 30);
		addFrame.add(confirm_btn);
		
		cancel_btn = new JButton("���");
		cancel_btn.setFont(font);
		cancel_btn.setBounds(375, 110, 65, 30);
		addFrame.add(cancel_btn);
		
		confirm_btn.addActionListener(new AddConfirmBtn(name, count, table, addFrame));
		cancel_btn.addActionListener(new StockCancelBtn(addFrame));
		
		return addFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AddTableData();
		
		
	}
}
