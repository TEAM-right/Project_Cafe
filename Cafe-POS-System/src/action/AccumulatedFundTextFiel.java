package action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import swing.method.RoundJTextField;

//�ؽ�Ʈ�ʵ� Ŭ���� ������ �ִ� "��ȭ��ȣ�� �Է��ϼ���" �ؽ�Ʈ�� ������� ����� Ŭ����
public class AccumulatedFundTextFiel extends MouseAdapter {
	private RoundJTextField textField;
	private String order_name, grade;
	public AccumulatedFundTextFiel(RoundJTextField textField, String grade, String order_name) {
		this.grade = grade;
		this.order_name = order_name;
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
