package jdbc.method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc.hikari.HikariCP;

// ���ǿ��� TotalInfo to = new TotalInfo();

// a���� �����ʿ��� to.get~~~~ = ����

// 

public class TotalInfo {
	
	private String sql = "select order_total, order_date from order_table";
	private DefaultTableModel model;
	private JTable table; 
	private	String header[] = {"��¥", "�ǸŰǼ�", "�Ǹűݾ�"};
	private String[][] data = new String[0][0];
	
	public JTable getTotalInfo() {
		in_Order();
		select_Order();
		return table;
	}
	
	private void in_Order() {
		model = new DefaultTableModel(data, header);
		table = new JTable(model);
	}
	
	private void select_Order() {
		try (
				Connection conn = HikariCP.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		) {
			
			while (rs.next()) {
				String[] row  = new String[3];
				row[0] = rs.getString("order_date");
				row[1] = rs.getString("");
				row[2] = rs.getString("order_total");
				model.addRow(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
