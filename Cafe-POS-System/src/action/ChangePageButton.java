package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import swing.frame.CheckSalesFrame;
import swing.frame.ChoosePageFrame;
import swing.frame.EmployeesManagementFrame;
import swing.frame.RoundedButton;
import swing.frame.StockManagementFrame;

public class ChangePageButton implements ActionListener {
	
	JFrame frame;
	
	public ChangePageButton(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btnName = ((JButton)e.getSource()).getText();
		frame.dispose();
		
		switch (btnName) {
		case "���� ����":
			new EmployeesManagementFrame();
			break;
		case "�Ǹ� ���":
			break;
		case "���� ��ȸ":
			new CheckSalesFrame();
			break;
		case "��� ����":
			new StockManagementFrame();
			break;
		case "<<":
			new ChoosePageFrame();
			break;
		}
	}
	
}
