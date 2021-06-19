package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import swing.frame.CheckSalesFrame;
import swing.frame.ChoosePageFrame;
import swing.frame.EmployeesManagementFrame;
import swing.frame.OrderFrame;
import swing.frame.StockManagementFrame;

public class ChangePageActionForChooseFrame implements ActionListener {
	
	private JFrame frame;
	
	public ChangePageActionForChooseFrame(JFrame frame) {
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
			new OrderFrame();
			break;
		case "���� ��ȸ":
			new CheckSalesFrame();
			break;
		case "��� ����":
			new StockManagementFrame();
			break;
		}
	}
	
}
