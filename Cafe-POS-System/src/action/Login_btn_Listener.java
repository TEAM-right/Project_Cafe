package action;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import jdbc.hikari.HikariCP;
import swing.frame.DefaultFrame;


public class Login_btn_Listener  implements ActionListener {
	private JFrame frame;
	private JButton login_btn;
	private String cbname;
	private String sql = "SELECT * FROM employees_table WHERE employee_name = '" + cbname + "'";
	private String password;
	private Font font1 = new Font("���� ���", Font.BOLD, 18);
	private int exit_count = 0 ;
	
	public Login_btn_Listener (JButton login_btn, String cbname, String password, JFrame frame) {
		this.login_btn = login_btn;
		this.cbname = cbname;
		this.password = password;
		this.frame = frame;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try (
				Connection conn = HikariCP.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()) {
				System.out.println(rs.getString(3)); 
				if(password.equals(rs.getString(3))) {
					System.out.println("�α��� ����");
					System.out.println("���� ��й�ȣ = " + password);
					frame.setVisible(false);
					//new OrderView().setVisible(true);
					break;
					
				} else {
					exit_count++;
					if(exit_count == 3) {
						UIManager.put("OptionPane.messageFont", font1);
						JOptionPane.showMessageDialog(null, "3ȸ �̻� Ʋ�����Ƿ� ���� �����մϴ� ^o^" , "SYSTEM", JOptionPane.CANCEL_OPTION);
						System.exit(0);
					}
					UIManager.put("OptionPane.messageFont", font1);
					JOptionPane.showMessageDialog(null, "��й�ȣ�� " + exit_count + "ȸ Ʋ�Ƚ��ϴ� \n     " + (3 - exit_count ) + "ȸ ����", "���ǻ���", JOptionPane.WARNING_MESSAGE);
					break;
					
					
				}
				
				
			}
	
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		
		}
	}
}
