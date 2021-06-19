package action;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import jdbc.hikari.HikariCP;
import swing.frame.CheckSalesFrame;
import swing.frame.ChoosePageFrame;
import swing.frame.EmployeesManagementFrame;
import swing.frame.OrderFrame;
import swing.frame.StockManagementFrame;

public class ChangePageActionForChooseFrame implements ActionListener {
	private JFrame frame;
	private String grade;
	public ChangePageActionForChooseFrame(JFrame frame, String grade) {
		this.frame = frame;
		this.grade = grade;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String btnName = ((JButton)e.getSource()).getText();
		switch (btnName) {
		case "���� ����":
			if (grade.equals("MANAGER")) {
				frame.dispose();
				new EmployeesManagementFrame(grade);	
			} else {
				UIManager.put("OptionPane.messageFont", new Font("���� ���", Font.BOLD, 45));
				JOptionPane.showMessageDialog(null, "�Ը�� �����Դϴ�. ���ư�����", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
			}
			break;
		case "�Ǹ� ���":
			frame.dispose();
			new OrderFrame(grade);
			break;
		case "���� ��ȸ":
			frame.dispose();
			new CheckSalesFrame(grade);
			break;
		case "��� ����":
			frame.dispose();
			new StockManagementFrame(grade);
			break;
		}
	}
	
}
