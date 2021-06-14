package swing.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import javafx.scene.layout.Border;
import jdbc.hikari.HikariCP;
import jdbc.method.SelectDrinkInfo;
import jdbc.method.SelectEtcInfo;
import jdbc.method.SelectProductInfo;
import jdbc.method.SelectRtdInfo;
import swing.frame.DefaultFrame;

public class ReceiptView{
	String sql = "SELECT m_type_id FROM receipt_table ORDER BY receipt_id";

	Random ran = new Random();
	SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
	SimpleDateFormat f2 = new SimpleDateFormat("yyyyMMdd");
	
	int sum = 0;
	public ReceiptView() {
		printReceipt();
	}
	
	public void printReceipt() {	
		try (
				Connection conn = HikariCP.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();

		) {
			System.out.println("����������������������������������   ����������	 ��������������������������������");
			System.out.println("��[�����]������Ŀ�ǰ���ȿ����		     		��");
			System.out.println("��[�����]��123-45-67890		     		��");
			System.out.println("��[��   ��]������Ư���� ������ ���ﵿ 826-27 11, 12��		��");
			System.out.println("��[��ǥ��]��������		[TEL]��010-1234-5678	��");
			System.out.printf("��[������]��%s\t%11s%s��\n", f1.format(Calendar.getInstance().getTime()), "[������]", "�̽¿�");
			System.out.printf("��[������]��%s-%d-%d				��\n", f2.format(Calendar.getInstance().getTime()), 01, 01);
			System.out.println("��===============================================��");
			System.out.printf("��\t%s\t\t%7s\t%5s\t%11s\t��\n", "��  ǰ  ��", "��  ��", "��  ��", "��  ��");
			System.out.println("��-----------------------------------------------��");
			while (rs.next()) {
				if (rs.getInt(1) <= 110) {
					sum += new SelectDrinkInfo().getSum();
				} else if (rs.getInt(1) <= 130) {
					sum += new SelectEtcInfo().getSum();
				} else if (rs.getInt(1) <= 200) {
					sum += new SelectProductInfo().getSum();
				} else if (rs.getInt(1) == 210){
					sum += new SelectRtdInfo().getSum();
				}
			}
			System.out.println("��-----------------------------------------------��");
			System.out.printf("��%s\t\t\t\t%8d��\n", "��  ��  ��  ��", sum);
			System.out.println("��-----------------------------------------------��");
			System.out.printf("��%s\t\t\t\t%8d��\n", "�ΰ���  ������ǰ����", sum);
			System.out.printf("��%s\t\t\t\t%8.0f��\n", "��          ��          �� ", sum * 0.1);
			System.out.println("��-----------------------------------------------��");
			System.out.printf("��%s\t\t\t\t%8d��\n", "��  ��  ��  ��", sum);
			System.out.printf("��%s\t\t\t\t%8d��\n", "��  ��  ��  ��", sum);
			System.out.printf("��%s\t\t\t\t%8d��\n", "��  ��  ��  ��", 0);
			System.out.println("��-----------------------------------------------��");
			System.out.println("��\t\t\t\t\t\t��");
			System.out.printf("��%s\t\t\t\t%8d��\n", "��  ��  ī  ��", sum);
			System.out.println("��-----------------------------------------------��");
			System.out.printf("��%s : %s\t\t\t\t\t��\n", "��  ��  ��  ��", "�Ͻú�");
			System.out.printf("��%s :\t\t\t\t%8d��\n", "��  ��  ��  ��", sum);
			System.out.printf("��%s : %8d\t\t\t\t��\n", "��  ��  ��  ȣ", ran.nextInt(89999999) + 10000000);
			System.out.printf("��%s : %s\t\t��\n", "��  ��  ��  ��", f1.format(Calendar.getInstance().getTime()));
			System.out.println("��������������������������������������������������������������������������������������������������");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	
	
	public static void main(String[] args) {
		new ReceiptView();
	}
}