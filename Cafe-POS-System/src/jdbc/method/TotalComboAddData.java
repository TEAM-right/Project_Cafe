package jdbc.method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import jdbc.hikari.HikariCP;

public class TotalComboAddData {
	private String sql = "SELECT * FROM employees_table";
	private JComboBox day_combo, month_combo, year_combo, combox;
	
	
	public TotalComboAddData(JComboBox day_combo,JComboBox month_combo,JComboBox year_combo) {
		
	}
	
	public JComboBox getComboBox() {
		ComboBox_addData();
		return combox;
	}
	
	
	private void ComboBox_addData() {
		combox = new JComboBox();
		combox.addItem("ID�� �����ϼ���");
		
		try (
				Connection conn = HikariCP.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()) {
				combox.addItem(rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
}
