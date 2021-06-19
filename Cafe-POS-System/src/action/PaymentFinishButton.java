package action;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import swing.frame.OrderFrame;
import swing.method.ReceiptLabel;

// �����Ϸ�� ��������� �� ���̺� ���� ����
public class PaymentFinishButton implements ActionListener {

	private DefaultTableModel model;
	private JTable table;
	private Frame frame;
	private String grade, order_name;

	public PaymentFinishButton(JFrame frame, JTable table, String grade, String order_name) {
		this.grade = grade;
		this.order_name = order_name;
		this.frame = frame;
		this.table = table;
		this.model = (DefaultTableModel) table.getModel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new ReceiptLabel(table, grade, order_name);
		model.setRowCount(0);

		OrderFrame.GettableInfo().removeAll(OrderFrame.GettableInfo());
		OrderFrame.GetMenuHash().clear();
		OrderFrame.getTotalmoney().setText(String.valueOf(0));

		frame.dispose();
	}
}
