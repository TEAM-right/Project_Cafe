package action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import swing.method.RoundJTextField;

public class AccumulatedTextFiel extends MouseAdapter {

	RoundJTextField textField;

	public AccumulatedTextFiel(RoundJTextField textField) {
		this.textField = textField;
	}

	// �ؽ�Ʈ�ʵ� Ŭ���� ������ �ִ� "��ȭ��ȣ�� �Է��ϼ���" �ؽ�Ʈ�� ������� ����.
	public void mouseClicked(MouseEvent e) {
		textField.setText(null);
	}

}
