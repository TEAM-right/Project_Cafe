package action;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import swing.frame.DefaultFrame;

public class StockAddBtnListener implements ActionListener {

	private JFrame addFrame;
	private JTextField name, count;
	private JLabel nameL, countL;
	private JButton confirm_btn, cancel_btn;
	private JTable table;
	private Color y_color = new Color(163, 148, 132);
	private Font font = new Font("���� ���", Font.BOLD, 15);

	public StockAddBtnListener(JTable table) {
		this.table = table;
	}

	private JFrame AddTableData() {
		addFrame = new DefaultFrame();
		addFrame.setTitle("Add Stock");
		addFrame.setLayout(null);
		addFrame.setLocation(1000, 400);
		addFrame.setSize(400, 200);
		addFrame.setResizable(false);
		addFrame.getContentPane().setBackground(Color.white);
		addFrame.setVisible(true);

		// ��
		nameL = new JLabel("�̸�");
		nameL.setBounds(20, -30, 100, 130);
		nameL.setFont(font);
		addFrame.add(nameL);

		countL = new JLabel("����");
		countL.setFont(font);
		countL.setBounds(20, 60, 100, 30);
		addFrame.add(countL);

		// �̸� �ؽ�Ʈ �ʵ�
		name = new JTextField(10);
		name.setBounds(60, 20, 300, 30);
		addFrame.add(name);

		// ī��Ʈ �ؽ�Ʈ �ʵ�
		count = new JTextField(10);
		count.setBounds(60, 60, 300, 30);
		addFrame.add(count);
		
		confirm_btn = new JButton("�߰�");
		confirm_btn.setFont(font);
		confirm_btn.setBounds(215, 110, 65, 30);
		confirm_btn.setBackground(new Color(3, 102, 53));
		confirm_btn.setForeground(Color.WHITE);
		addFrame.add(confirm_btn);

		cancel_btn = new JButton("���");
		cancel_btn.setFont(font);
		cancel_btn.setBounds(295, 110, 65, 30);
		cancel_btn.setBackground(new Color(3, 102, 53));
		cancel_btn.setForeground(Color.WHITE);
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
