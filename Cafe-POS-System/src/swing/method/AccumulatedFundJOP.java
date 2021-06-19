package swing.method;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//�Է� ��ȣ�� Ʋ���� �ߴ� ��� �˾�â
public class AccumulatedFundJOP extends JOptionPane{
	ArrayList<JPanel> panelR;

	public AccumulatedFundJOP(RoundJTextField textField, ArrayList<JPanel> panelR) {
		this.panelR = panelR;
		initializePanel();
		
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
			showMessageDialog(null, "��ġ�ϴ� ������ �����ϴ�.\nȸ���� �ƴ� ���,\nȸ������� �������ּ���.", 
					"����", JOptionPane.OK_CANCEL_OPTION);
			
		}
	}
	
	// �˾�â �۲� ����
	private void jOptionPaneUI() {
		UIManager.put("OptionPane.messageFont",new Font("���� ���",Font.PLAIN,12));
	}
	//���â �㶧 �����ִ� ȸ�� ���� �ʱ�ȭ
	private void initializePanel() {
		for (JPanel panel : panelR) {
			panel.removeAll();
			
			panel.repaint();
		}
	}

}


