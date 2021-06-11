package jdbc.method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc.hikari.HikariCP;

public class SelectEmployeeInfo {
	
	private String sql = "SELECT * FROM employees_table ORDER BY employee_id";
	private DefaultTableModel model;
	private JTable table;
	private String[] title = {"���� ��ȣ", "�̡�����", "�н�����", "��������"};
	private String[][] data = new String[0][0];
	
	public JTable getEmployeeInfo() {
		inputData();
		selectDB();
		
		return table;
	}
	
	private void inputData() {
		// isCellEditable() @Override�ؼ� ����Ŭ�� ���� ����
		model = new DefaultTableModel(data, title) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		// ����� �����͸� �ݿ�
		model.fireTableDataChanged();
		table.updateUI();
	}
	
	private void selectDB() {
		try (
				Connection conn = HikariCP.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		) {
			
			while (rs.next()) {
				String[] row = {Integer.toString(rs.getInt(1)), rs.getString(2), 
						rs.getString(3), rs.getString(4)};
				model.addRow(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
