package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import action.ChangePageActionForChooseFrame;
import action.LogoutButtonAction;
import swing.method.LogoutButtonImgScale;

public class ChoosePageFrame extends DefaultFrame {

	private String order_name, grade;

	public ChoosePageFrame(String grade, String order_name) {
		this.grade = grade;
		this.order_name = order_name;

		setTitle("Choose Page");
		// getContentPane() �� ���� �����ؾ� ���氡��
		getContentPane().setBackground(Color.white);
		// new Color(255, 255, 227)

		JButton logout = new LogoutButtonImgScale().getLogoutBtn();
		logout.setBounds(5, 5, 60, 60);
		logout.setBackground(Color.WHITE);
		logout.addMouseListener(new LogoutButtonAction(this));
		add(logout);

		String[] btns_name = { "���� ����", "�Ǹ� ���", "���� ��ȸ", "��� ����" };
		ArrayList<JButton> btns = new ArrayList<>();

		for (int i = 0; i < btns_name.length; i++) {
			btns.add(new JButton(btns_name[i]));
		}

		JLabel logo = new JLabel();
		ImageIcon infoImg = new ImageIcon("./image/logo.png");
		JLabel info = new JLabel(infoImg);
		info.setOpaque(true);
		info.setBounds(475, 150, 500, 300);
		info.setBackground(Color.white);
		info.setHorizontalAlignment(JLabel.LEFT);
		add(info);

		// �ٸ� ���������� �̵��ϴ� �׼� ������
		ChangePageActionForChooseFrame channel = new ChangePageActionForChooseFrame(this, grade, order_name);

		// ==================================================== ���� ���� ��ư
		btns.get(0).setBounds(760, 720, 550, 150);
		btns.get(0).setFont(new Font("���� ���", Font.BOLD, 45));
		btns.get(0).setForeground(Color.white);
		// btns.get(i).setBackground(new Color(53, 84, 0));
		btns.get(0).setBackground(new Color(3, 102, 53));
		btns.get(0).addActionListener(channel);

		add(btns.get(0));

		// ==================================================== �Ǹ� ��� ��ư
		btns.get(1).setBounds(160, 720, 550, 150);
		btns.get(1).setFont(new Font("���� ���", Font.BOLD, 45));
		btns.get(1).setForeground(Color.white);
		// btns.get(i).setBackground(new Color(53, 84, 0));
		btns.get(1).setBackground(new Color(3, 102, 53));
		// ��ư ���� �� ����Ǵ� �׼� �߰�
		btns.get(1).addActionListener(channel);

		add(btns.get(1));

		// ==================================================== ���� ��ȸ ��ư
		btns.get(2).setBounds(760, 520, 550, 150);
		btns.get(2).setFont(new Font("���� ���", Font.BOLD, 45));
		btns.get(2).setForeground(Color.white);
		// btns.get(i).setBackground(new Color(53, 84, 0));
		btns.get(2).setBackground(new Color(3, 102, 53));
		// ��ư ���� �� ����Ǵ� �׼� �߰�
		btns.get(2).addActionListener(channel);

		add(btns.get(2));

		// ==================================================== ���� ���� ��ư
		btns.get(3).setBounds(160, 520, 550, 150);
		btns.get(3).setFont(new Font("���� ���", Font.BOLD, 45));
		btns.get(3).setForeground(Color.white);
		// btns.get(i).setBackground(new Color(53, 84, 0));
		btns.get(3).setBackground(new Color(3, 102, 53));
		// ��ư ���� �� ����Ǵ� �׼� �߰�
		btns.get(3).addActionListener(channel);

		add(btns.get(3));

		this.repaint();
//		setVisible(true);
		// repaint() : AWT�ȿ� �����Ǿ��ֱ� ������ Frame�� ��ӹ����� �ٷ� ��� ����
		// �߰��� ������Ʈ���� �ٽ� ����� ������Ʈ���ش�.
		// (�����ָ� �����ӿ� ���콺�� �÷����� ��ư�� ��, setvisible(true)�� ���� ������ ���ִµ� ���⼭�� �ȵż� repaint��
		// ��)
	}
}
