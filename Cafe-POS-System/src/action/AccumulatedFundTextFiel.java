package action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import swing.method.RoundJTextField;

//�ؽ�Ʈ�ʵ� Ŭ���� ������ �ִ� "��ȭ��ȣ�� �Է��ϼ���" �ؽ�Ʈ�� ������� ����� Ŭ����
public class AccumulatedFundTextFiel extends MouseAdapter {
	private RoundJTextField textField;

	public AccumulatedFundTextFiel(RoundJTextField textField) {
		this.textField = textField;
	}

	public void mouseClicked(MouseEvent e) {
		String fieldDefaultText = "��ȭ��ȣ�� �Է��ϼ���";
		if (textField.getText().equals(fieldDefaultText)) {
			textField.setText(null);
		} else {
			return;
		}
	}

}
