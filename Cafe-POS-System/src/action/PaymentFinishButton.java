package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jdbc.method.DeletereceiptInfo;
import jdbc.method.DropSequenceReceiptInfo;
import swing.view.ReceiptView;

// �����Ϸ�� ��������� �� ���̺� ���� ����, ������ ����, ������ ����
public class PaymentFinishButton implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new ReceiptView();		
		new DeletereceiptInfo();
	}
}