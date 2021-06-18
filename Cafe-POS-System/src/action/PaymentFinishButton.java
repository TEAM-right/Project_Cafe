package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc.method.ReceiptLabel;

// �����Ϸ�� ��������� �� ���̺� ���� ����
public class PaymentFinishButton implements ActionListener{
	DefaultTableModel model;
	JTable table;

	public PaymentFinishButton(JTable table) {
		this.table = table;
		this.model = (DefaultTableModel)table.getModel();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new ReceiptLabel(table);
		model.setNumRows(0);

	}
}
