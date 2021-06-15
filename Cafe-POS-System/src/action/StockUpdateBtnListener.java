package action;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StockUpdateBtnListener implements ActionListener {

	private JFrame addFrame;
	private JTextField count_tf;
	private JLabel idL, nameL, countL, updateL;
	private JButton confirm_btn, cancel_btn;
	private JTable table;
	private String name;
	private int id, count;

	private Font font = new Font("���� ���", Font.BOLD, 15);
	private Font nomal_font = new Font("���� ���", Font.BOLD, 20);

	public StockUpdateBtnListener(JTable table, int id, String name, int count) {
		this.table = table;
		this.id = id;
		this.name = name;
		this.count = count;
	}

	private JFrame AddTableData() {

		
		UIManager.put("OptionPane.messageFont", nomal_font);
		JOptionPane.showMessageDialog(null, "������ ǰ���� ������ �ּ���", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);

		int row = table.getSelectedRow(); // ������ ���� �� ��ȣ ���
		TableModel model = table.getModel();

		id = (int) model.getValueAt(row, 0);
		name = (String) model.getValueAt(row, 1);
		count = (int) model.getValueAt(row, 2);

		System.out.println("����?" + name);
		System.out.println("����?" + id);
		System.out.println("����?" + count);

		addFrame = new JFrame("UPDATE STOCK");
		addFrame.setLayout(null);
		addFrame.setLocation(200, 200);
		addFrame.setSize(300, 400);
		addFrame.setResizable(false);
		addFrame.getContentPane().setBackground(Color.white);
		addFrame.setVisible(true);

		// ��
		idL = new JLabel();
		idL.setText("ID     :  " + id);
		idL.setBounds(30, 20, 100, 30);
		idL.setFont(font);
		addFrame.add(idL);

		nameL = new JLabel("�̸�  :  " + name);
		nameL.setBounds(30, 60, 100, 30);
		nameL.setFont(font);
		addFrame.add(nameL);

		countL = new JLabel("����  :  " + count);
		countL.setFont(font);
		countL.setBounds(30, 100, 100, 30);
		addFrame.add(countL);

		updateL = new JLabel("��� ����");
		updateL.setFont(font);
		updateL.setBounds(30, 200, 100, 30);
		addFrame.add(updateL);

		// ī��Ʈ �ؽ�Ʈ �ʵ�
		count_tf = new JTextField(10);
		count_tf.setBounds(30, 250, 200, 30);
		addFrame.add(count_tf);

		confirm_btn = new JButton("����");
		confirm_btn.setFont(font);
		confirm_btn.setBounds(30, 300, 65, 30);
		addFrame.add(confirm_btn);

		cancel_btn = new JButton("���");
		cancel_btn.setFont(font);
		cancel_btn.setBounds(120, 300, 65, 30);
		addFrame.add(cancel_btn);

		cancel_btn.addActionListener(new AddCancelBtn(addFrame));

		table.addMouseListener(new StockGetTableVal(table));

		return addFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AddTableData();

	}
}
