package action;

import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import swing.frame.RoundJTextField;
import swing.frame.accumulatedFundFrame;

public class accumulatedTextFieldLisner extends MouseAdapter{
	
	RoundJTextField textField;
	
	//�������ؽ�Ʈ�ʵ帮���� �����ڿ��� �ؽ�Ʈ�ʵ� �Ű������� �ޱ�
	public accumulatedTextFieldLisner(RoundJTextField textField) {
		this.textField = textField;
	}	
	
	public void mouseClicked(MouseEvent e) { 
		//�ؽ�Ʈ�ʵ� Ŭ���� ������ �ִ� "��ȭ��ȣ�� �Է��ϼ���" �ؽ�Ʈ�� ������� ����.
		textField.setText(null); 
	}
	
}







