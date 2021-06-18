package action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import jdbc.method.ClickAccumulatedFundTextFile;
import swing.frame.AccumulatedFundFrame;
import swing.method.RoundJTextField;

public class AccumulatedFundButton extends MouseAdapter {
	private AccumulatedFundFrame accumulatedFundFrame;
	private RoundJTextField textField;
	private ArrayList<JButton> numBtns;
	private String btnNum;
	private StringBuilder phoneNum;

	// �������ؽ�Ʈ�ʵ帮���� �����ڿ��� �ؽ�Ʈ�ʵ� �Ű������� �ޱ�
	public AccumulatedFundButton(AccumulatedFundFrame accumulatedFundFrame, RoundJTextField textField,
			ArrayList<JButton> numBtns, StringBuilder phoneNum) {
		this.accumulatedFundFrame = accumulatedFundFrame;
		this.textField = textField;
		this.numBtns = numBtns;
		this.phoneNum = phoneNum;
	}

	@Override // mouseReleased�� ����ؾ��� ��ư���� �ߴ���
	public void mouseReleased(MouseEvent e) {
		btnNum = ((JButton) e.getSource()).getText();
		int phoneLeng = phoneNum.length() - 1;

		// 0 ~ 9���� �׸��� ��,���� ���ڸ� ���ϱ� ���� for�� ������ ��.
		for (int i = 0; i < numBtns.size(); i++) {
			String strNum = Integer.toString(i);

			// ��Ʈ�������� �����ؼ� �̾���Բ��ϱ�
			if (btnNum.equals(strNum)) {
				phoneNum.append(strNum);
				textField.setText(phoneNum.toString());
			} else if (btnNum.equals("��")) {
				// �ϳ��� ����� �� ���� �ε����� ���� üũ�Ź����� StringIndexOutOfBoundsException������ �� �׷��� ����ó��.
				// ���� ������ ���� ����.
				try {
					phoneNum.deleteCharAt(phoneLeng);
					textField.setText(phoneNum.toString());
				} catch (Exception e1) {
					return;
				}

				// �ؽ�Ʈ �ʵ忡 �Է��ߴ� ��ȣ�� ���� ����ÿ� �⺻ ���� ������ ����
				int fieldGetTextLeng = textField.getText().length();
				if (fieldGetTextLeng == 0) {
					textField.setText("��ȭ��ȣ�� �Է��ϼ���");
				}

			} else if (btnNum.equals("����")) {
				new ClickAccumulatedFundTextFile(textField, accumulatedFundFrame);
				break; // ������ ������ ��(break���ϸ� �ؽ�Ʈ�ʵ� �� ������ ��)
			}

		}

	}

}
