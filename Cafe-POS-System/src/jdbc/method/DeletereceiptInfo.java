package jdbc.method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.hikari.HikariCP;

// �����Ϸ� �� ������ ���̺� ����  Delete �� ������ Drop �� ������ Create
public class DeletereceiptInfo {
	private String sql = "DELETE FROM receipt_table";
	
	public DeletereceiptInfo() {
		try (
				Connection conn = HikariCP.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.executeUpdate();
			new DropSequenceReceiptInfo();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}