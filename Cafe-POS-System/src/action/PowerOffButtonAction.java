package action;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class PowerOffButtonAction implements ActionListener {

	private JFrame frame;
	
	public PowerOffButtonAction(JFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		UIManager.put("OptionPane.messageFont", new Font("���� ���", Font.PLAIN, 12));
		int result = JOptionPane.showConfirmDialog(null, "�ý����� �����Ͻðڽ��ϱ�?", "SYSTEM", JOptionPane.YES_NO_OPTION);
		
		if (result == JOptionPane.YES_OPTION) {
			frame.dispose();
		}
		
	}
	
}
