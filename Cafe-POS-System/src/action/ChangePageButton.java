package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import swing.frame.ChoosePageFrame;
import swing.frame.EmployeesManagementFrame;

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
		case "<HTML>����<br>����</HTML>":
			new EmployeesManagementFrame();
			break;
		case "<HTML>�Ǹ�<br>���</HTML>":
			break;
		case "<HTML>����<br>��ȸ</HTML>":
			break;
		case "<HTML>���<br>����</HTML>":
			break;
		case "<<":
			new ChoosePageFrame();
			break;
		}
	}
	
}
