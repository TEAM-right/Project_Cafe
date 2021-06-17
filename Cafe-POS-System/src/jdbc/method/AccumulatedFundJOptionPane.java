package jdbc.method;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import swing.frame.RoundJTextField;

//�Է� ��ȣ�� Ʋ���� �ߴ� ��� �˾�â
public class AccumulatedFundJOptionPane extends JOptionPane{

	public AccumulatedFundJOptionPane(RoundJTextField textField) {
		
		// �˾�â �� ����ϰ� �����
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		// ��ȣ �Է��� ���� ���� ���� ���� �������� ����
		if(textField.getText().equals("��ȭ��ȣ�� �Է��ϼ���")) {
			jOptionPaneUI();
			showMessageDialog(null, "��ȣ�� �Է����ּ���", 
					"����", JOptionPane.OK_CANCEL_OPTION);
		}else {
			jOptionPaneUI();    
			showMessageDialog(null, "��ġ�ϴ� ������ �����ϴ�", 
					"����", JOptionPane.OK_CANCEL_OPTION);
		}
	}
	
	// �˾�â �۲� ����
	private void jOptionPaneUI() {
		UIManager.put("OptionPane.messageFont",new Font("���� ���",Font.PLAIN,12));
	}

}


