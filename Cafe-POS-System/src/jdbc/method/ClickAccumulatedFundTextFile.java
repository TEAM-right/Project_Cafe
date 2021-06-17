package jdbc.method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


import jdbc.hikari.HikariCP;
import swing.frame.AccumulatedFundFrame;
import swing.method.RoundJTextField;

//���� Ŭ���� ���� Ŭ����
public class ClickAccumulatedFundTextFile {
	private AccumulatedFundFrame accumulatedFundFrame;
	private RoundJTextField textField;
	private String fieldTesxt;
	private String sql = "SELECT guest_name FROM guest_table";

	public ClickAccumulatedFundTextFile(RoundJTextField textField, AccumulatedFundFrame accumulatedFundFrame) {
		this.accumulatedFundFrame = accumulatedFundFrame;
		this.textField = textField;
		fieldTesxt = textField.getText();
		selectDB();
	}
	
	private void selectDB() {
		numberComparison();
		
		try (
				Connection conn = HikariCP.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();	
			){
			while (rs.next()) {
				if(rs.getString(1).equals(fieldTesxt)) {
					new UpdatePointCoupon(fieldTesxt, accumulatedFundFrame);
					return;
				}
			}
			//���� ��ġ���� ���� �� �˾�â Ŭ���� �ҷ�����
			new AccumulatedFundJOptionPane(textField);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//����ǥ�������� ��ȣ�� -(������)�� �߰��ϴ� �޼���
	private void numberComparison() {
		if (Pattern.matches("0\\d{2}\\d{3,4}\\d{4}", fieldTesxt)) {
			//()�� �ϳ��� �׷����� �����.�׷��� $���ڸ� ���� �׷� ������ �������� �߰��Ѵ�
			//replaceAll�� �ؾ��� ���� ��ü�� �ȴ�(���ܰ� �ȶ��).�Ƹ� �׷����� ������ ���� ���� ���� ������ ��
			fieldTesxt = fieldTesxt.replaceAll("(0\\d{2})(\\d{3,4})(\\d{4})","$1-$2-$3");
		}
	}
}


























