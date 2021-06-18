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

import swing.frame.StockUpdateFrame;

public class StockUpdateBtnListener implements ActionListener {

	private JTable table;
	private String name;
	String id;
	private int count;
	
	private Font nomal_font = new Font("���� ���", Font.BOLD, 20);

	public StockUpdateBtnListener(JTable table) {
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow(); // ������ ���� �� ��ȣ ���
		TableModel model = table.getModel();
	
		if (row == -1) {
			UIManager.put("OptionPane.messageFont", nomal_font);
			JOptionPane.showMessageDialog(null, "���� ����", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
		} else {
			id = (String) model.getValueAt(row, 0);
			name = (String) model.getValueAt(row, 1);
			count = (int) model.getValueAt(row, 2);
			
			new StockUpdateFrame(name, id, count, table);
		}
	}
}