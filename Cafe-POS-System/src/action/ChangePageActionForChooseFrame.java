package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import swing.frame.CheckSalesFrame;
import swing.frame.ChoosePageFrame;
import swing.frame.EmployeesManagementFrame;
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
		case "<HTML>����<br>����</HTML>":
			new EmployeesManagementFrame();
			break;
		case "<HTML>�Ǹ�<br>���</HTML>":
			new OrderFrame;
			break;
		case "<HTML>����<br>��ȸ</HTML>":
			new CheckSalesFrame();
			break;
		case "<HTML>���<br>����</HTML>":
			new StockManagementFrame();
			break;
		case "<<":
			new ChoosePageFrame();
			break;
		}
	}
	
}
