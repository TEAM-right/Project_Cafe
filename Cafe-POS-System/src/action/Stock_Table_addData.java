package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc.hikari.HikariCP;

public class Stock_Table_addData implements MouseListener {
	private String colNames[] = {"���̵�", "ǰ ��", "��� ����"};
	private DefaultTableModel model = new DefaultTableModel(colNames, 0);
	private JTable table;
	private String select_sql;
	
	public DefaultTableModel getStockTable() {
		return model;
	}
	
	
	private void Select_addData() {
		select_sql = 
				"select stock_id, stock_name, stock_count from stock_table";
		
		try (
				Connection conn = HikariCP.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(select_sql);
				ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()) {
				model.addRow(new Object[] {rs.getString("STOCK_ID"), rs.getString("STOCK_NAME"),
						rs.getString("STOCK_COUNT")
				});
				
			} // while
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
	}
	


	@Override
	public void mouseClicked(MouseEvent e) { 	// ���õ� ��ġ�� ���� ���
		table = (JTable)e.getSource();
		int row = table.getSelectedRow();		//���õ� ��
		int col = table.getSelectedColumn();	// ���õ� ��
		
		System.out.println(model.getValueAt(row, col));
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}

	
}
				
