package jdbc.method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import jdbc.hikari.HikariCP;
import swing.frame.AccumulatedFundFrame;
import swing.method.AccumulatedFundJOP;
import swing.method.RoundJTextField;

//���� Ŭ���� ���� Ŭ����
public class ClickAccumulatedFundTextFile {
	private AccumulatedFundFrame accumulatedFundFrame;
	private RoundJTextField textField;
	private String fieldTesxt;
	private String sql = "SELECT guest_name FROM guest_table";
	private ArrayList<JPanel> panelR;

	public ClickAccumulatedFundTextFile(RoundJTextField textField, ArrayList<JPanel> panelR) {
		this.textField = textField;
		this.panelR = panelR;
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
					new UpdatePointCoupon(fieldTesxt,panelR);
					return;
				}
			}
			//���� ��ġ���� ���� �� �˾�â Ŭ���� �ҷ�����
			new AccumulatedFundJOP(textField, panelR);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//����ǥ�������� ��ȣ�� -(������)�� �߰��ϴ� �޼���
	public void numberComparison() {
		if (Pattern.matches("0\\d{2}\\d{3,4}\\d{4}", fieldTesxt)) {
			//()�� �ϳ��� �׷����� �����.�׷��� $���ڸ� ���� �׷� ������ �������� �߰��Ѵ�
			//replaceAll�� �ؾ��� ���� ��ü�� �ȴ�(���ܰ� �ȶ��).�Ƹ� �׷����� ������ ���� ���� ���� ������ ��
			fieldTesxt = fieldTesxt.replaceAll("(0\\d{2})(\\d{3,4})(\\d{4})","$1-$2-$3");
		}
	}
}


























