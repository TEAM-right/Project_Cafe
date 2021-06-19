
package jdbc.method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import jdbc.hikari.HikariCP;
import swing.frame.AccumulatedFundFrame;
import swing.frame.AccumulatedResultsFrame;

//��ȭ��ȣ�� ��ġ���� �� ������ ����Ʈ ���� �������� DB�� ������Ʈ ��Ű�� Ŭ����
public class UpdatePointCoupon {
	private String fieldTesxt, phoneNum;
	private String sql = "SELECT guest_point,coupon FROM guest_table WHERE guest_name = ?";
	private String updateSql = "UPDATE guest_table SET guest_point = ?,coupon = ? "
			+ "WHERE guest_name = ?";	
	int point, coupon;
	String name;
	AccumulatedFundFrame accumulatedFundFrame;
	private ArrayList<JPanel> panelR;
	
	public UpdatePointCoupon(String fieldTesxt, ArrayList<JPanel> panelR, String grade, String order_name) {
		this.panelR = panelR;
		phoneNum = fieldTesxt;
		
		getPointCoupon();
		//�����̶� ����Ʈ DB�� ������Ʈ��Ű��(try �ٱ��ʿ��� �ҷ����� �ٸ� sql���� ������ �� ����)
		DBUpdate();
		new AccumulatedResultsFrame(phoneNum, point, coupon, panelR, grade, order_name);
	}
	
	private void getPointCoupon() {
		try (
				Connection conn = HikariCP.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
								
			){
			pstmt.setString(1, phoneNum);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				point = rs.getInt(1);
				coupon = rs.getInt(2);
				
				//���������ϱ� point 1�� �÷��ֱ�(���⼭ �ؾ��� point�� ����� ���� ��)
				point++;
			}
			//point�� 10�� �Ǹ� �������� ��ȯ�ϱ�(�׸��� point�� 0���� �����)
			if (point >= 10) {
				coupon += point/10;
				point = 0;
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void DBUpdate() {
		try (
				Connection conn = HikariCP.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(updateSql);
				
				){

			pstmt.setInt(1, point);
			pstmt.setInt(2, coupon);
			pstmt.setString(3, phoneNum);
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}




