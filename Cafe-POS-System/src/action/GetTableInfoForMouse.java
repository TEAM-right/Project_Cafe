package action;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GetTableInfoForMouse implements MouseListener {

	private JTable table;
	private ArrayList<TextField> fields;
	private String employee_id;
	private String employee_name;
	private String employee_password;
	private String employee_grade;
	
	public GetTableInfoForMouse(JTable table, ArrayList<TextField> fields) {
		this.table = table;
		this.fields = fields;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		
		employee_id = (String)table.getModel().getValueAt(row, 0);
		employee_name = (String)table.getModel().getValueAt(row, 1);
		employee_password = (String)table.getModel().getValueAt(row, 2);
		employee_grade = (String)table.getModel().getValueAt(row, 3);
		
		if (fields.size() == 2) {
			fields.get(0).setText(employee_name);
			fields.get(0).setFont(new Font("���� ���", Font.PLAIN, 30));
			fields.get(0).update(null);
			fields.get(1).setText(employee_password);
			fields.get(1).setFont(new Font("���� ���", Font.PLAIN, 30));
		}
		// ���� ���� ���, ���� ���� ��� ����
		if (fields.size() == 3) {
			fields.get(0).setText(employee_id);
			fields.get(1).setText(employee_name);
			fields.get(2).setText(employee_password);
		} else if (fields.size() == 4) {
			fields.get(0).setText(employee_id);
			fields.get(1).setText(employee_name);
			fields.get(2).setText(employee_password);
			fields.get(3).setText(employee_grade);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
}
