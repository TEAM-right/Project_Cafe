package jdbc.method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc.hikari.HikariCP;

// ���ǿ��� TotalInfo to = new TotalInfo();

// a���� �����ʿ��� to.get~~~~ = ����

// 

public class TotalInfo {
	
	private String sql = "SELECT TO_CHAR(order_time, 'yy'), COUNT(order_total), SUM(order_total)"
			+ "FROM order_table "
			+ "GROUP BY TO_CHAR(order_time, 'yy') "
			+ "ORDER BY TO_CHAR(order_time, 'yy')";
	/*
	 * "SELECT TO_CHAR(order_time, ?), COUNT(order_total), SUM(order_total) "
			+ "FROM order_table "
			+ "GROUP BY TO_CHAR(order_time, ?) "
			+ "ORDER BY TO_CHAR(order_time, ?)"
	 */
	private DefaultTableModel model, total_model;
	private JTable table; 
	private	String[] header = {"��¥", "�ǸŰǼ�", "�Ǹűݾ�"};
	private	String[] total_header = {"���", "�ǸŰǼ� �հ�", "�Ǹűݾ� �Ѿ�"};	
	private Object[][] data = new String[0][0];
	private String date;
	private int result = 0;
	private int count = 0;
	
	// if ((big_combo.getSelectedItem().equals("�� ����")) && (e.getSource() == big_select_btn))
	public DefaultTableModel getTotalInfo() {
		in_Order();
		//select_Order();
		return model;
	}
	public DefaultTableModel getTotalInfoTotal() {
		in_Order_total();
		//select_Order();
		return total_model;
	}
	
	private void in_Order() {
		model = new DefaultTableModel(data, header);
		
	}
	
	private void in_Order_total() {
		total_model = new DefaultTableModel(data, total_header);
		
	}
	    
	private void select_Order() {
		try (
				Connection conn = HikariCP.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()) {
				date = rs.getString(1);
				count = rs.getInt(2);
				result = rs.getInt(3);
				Object[] row = {date,count,result};
				model.addRow(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
