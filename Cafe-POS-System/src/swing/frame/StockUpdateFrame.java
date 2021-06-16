package swing.frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import action.AddConfirmBtn;
import action.StockCancelBtn;
import action.UpdateConfirmBtn;

public class StockUpdateFrame extends JFrame {
	
	private JTable table;
	private JTextField count_tf, tf;
	private JLabel idL, nameL, countL, updateL;
	private JButton confirm_btn, cancel_btn;
	private String name;
	private int id, count;

	private Font font = new Font("���� ���", Font.BOLD, 15);
	private Font nomal_font = new Font("���� ���", Font.BOLD, 20);
	
	public StockUpdateFrame(String name, int id, int count, JTable table) {
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200, 200);
		setSize(300, 400);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		setVisible(true);

		// ��
		idL = new JLabel();
		idL.setText("ID     :  " + id);
		idL.setBounds(30, 20, 300, 30);
		idL.setFont(font);
		add(idL);

		nameL = new JLabel("�̸�  :  " + name);
		nameL.setBounds(30, 60, 300, 30);
		nameL.setFont(font);
		add(nameL);

		countL = new JLabel("����  :  " + count);
		countL.setFont(font);
		countL.setBounds(30, 100, 300, 30);
		add(countL);

		updateL = new JLabel("��� ����");
		updateL.setFont(font);
		updateL.setBounds(30, 200, 300, 30);
		add(updateL);
		// ī��Ʈ �ؽ�Ʈ �ʵ�
		count_tf = new JTextField(10);
		count_tf.setBounds(30, 250, 200, 30);
		add(count_tf);

		confirm_btn = new JButton("����");
		confirm_btn.setFont(font);
		confirm_btn.setBounds(30, 300, 65, 30);
		add(confirm_btn);

		cancel_btn = new JButton("���");
		cancel_btn.setFont(font);
		cancel_btn.setBounds(120, 300, 65, 30);
		add(cancel_btn);
		
		cancel_btn.addActionListener(new StockCancelBtn(this));
		confirm_btn.addActionListener(new UpdateConfirmBtn(count_tf, table, this, name));
		
		setVisible(true);
		
	}

}
