package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import swing.method.RoundJTextField;

public class AccumulatedButton extends MouseAdapter implements ActionListener {

	RoundJTextField textField;
	ArrayList<JButton> numBtns;
	String btnNum, grade, order_name;
	// �������ؽ�Ʈ�ʵ帮���� �����ڿ��� �ؽ�Ʈ�ʵ� �Ű������� �ޱ�
	public AccumulatedButton(RoundJTextField textField, ArrayList<JButton> numBtns, String grade, String order_name) {
		this.textField = textField;
		this.numBtns = numBtns;
		this.grade = grade;
		this.order_name = order_name;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		btnNum = ((JButton) e.getSource()).getText();
		System.out.println(btnNum);
	}

}
