package jdbc.method;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import swing.frame.ReceiptDefaultFrame;

public class ReceiptLabel extends ReceiptDefaultFrame {
	Random ran;
	TextArea area;
	String order_name;
	int receiptNumber;
	JTable table;
	StringBuilder str_menu;
	int sum;
	private SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private SimpleDateFormat f2 = new SimpleDateFormat("yyyyMMdd");
	private String html, totalVat, vat, totalPrice;
	
	public ReceiptLabel(JTable table) {
		new ReceiptUpNumber();
		receiptNumber = new selectReceiptNumber().getReceiptNumber();
		ran = new Random();
		sum = new GetMenuInfo(table).getSum();
		str_menu = new GetMenuInfo(table).getMenuInfo();
		this.table = table;
		order_name = new RoadEmployeeName().getEmployeeName();
		totalVat = String.format("%s\t\t\t\t\t\t\t%11d\n", "�ΰ���  ������ǰ����", sum);
		vat = String.format("%s\t\t\t\t\t\t%11d\n", "��          ��          �� ", (int)(sum * 0.1));
		totalPrice = String.format("%s\t\t\t\t\t\t\t\t%11d\n", "�� �� �� ��", sum);
		html = "\t\t\t\t  ����������\n"
				+ "[�����]������Ŀ�ǰ���ȿ����\n"
				+ "[�����]��123-45-67890\n"
				+ "[��   ��]������Ư���� ������ ���ﵿ 826-27 11, 12��\n"
				+ "[��ǥ��]��������\t\t\t\t\t[T  E  L] 031-123-4678	\n"
				+ "[������]��" + f1.format(Calendar.getInstance().getTime()) + "\t\t\t[������] " + order_name + "\n"
				+ "[������]��" + f2.format(Calendar.getInstance().getTime()) + "A-" + receiptNumber + "\n"
				+ "=====================================================================\n"
				+ "\t\t��  ǰ  ��\t\t��  ��\t\t��  ��\t\t      ��  ��\n"
				+ "---------------------------------------------------------------------\n"
				+ str_menu
				+ "---------------------------------------------------------------------\n"
				+ totalPrice
				+ "---------------------------------------------------------------------\n"
				+ totalVat
				+ vat
				+ "---------------------------------------------------------------------\n"
				+ "��  ��  ��  �� : �� �� ��\n"
				+ "��  ��  ��  �� : " + sum + "\n"
				+ "��  ��  ��  ȣ : " + ran.nextInt(89999999) + 10000000 + "\n"
				+ "��  ��  ��  �� : " + f1.format(Calendar.getInstance().getTime());
		
		add(new ReceiptTextArea(html));
//		new InsertOrderTable(sum);
		if (receiptNumber == 99) {
			new DeletereceiptInfo();
		}
	}
}
