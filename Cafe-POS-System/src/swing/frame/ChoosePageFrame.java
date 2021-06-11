package swing.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import action.ChangePageButton;

public class ChoosePageFrame extends DefaultFrame {
	
	public ChoosePageFrame() {
		setTitle("Choose Page");
		setBackground(new Color(188, 218, 186));
		
		String[] btns_name = {"<HTML>����<br>����</HTML>", "<HTML>�Ǹ�<br>���</HTML>", "<HTML>����<br>��ȸ</HTML>", "<HTML>���<br>����</HTML>"};
		ArrayList<JButton> btns = new ArrayList<>();
		
		for (int i = 0; i < btns_name.length; i++) {
			btns.add(new JButton(btns_name[i]));
		}
		
		// �ٸ� ���������� �̵��ϴ� �׼� ������
		ChangePageButton channel = new ChangePageButton(this);
		
		for (int i = 0; i < btns_name.length; i++) {
			btns.get(i).setBounds(250 * (i + 1), 300, 230, 300);
			btns.get(i).setFont(new Font("���� ���", Font.BOLD|Font.ITALIC, 50));
			btns.get(i).setForeground(Color.WHITE);
			btns.get(i).setBackground(new Color(53, 84, 0));
			btns.get(i).setBackground(new Color(53, 84, 0));
			// ��ư ���� �� ����Ǵ� �׼� �߰�
			btns.get(i).addActionListener(channel);
			
			add(btns.get(i));
		}
		this.repaint();
		// repaint() : AWT�ȿ� �����Ǿ��ֱ� ������ Frame�� ��ӹ����� �ٷ� ��� ����
		// �߰��� ������Ʈ���� �ٽ� ����� ������Ʈ���ش�. 
		// (�����ָ� �����ӿ� ���콺�� �÷����� ��ư�� ��, setvisible(true)�� ���� ������ ���ִµ� ���⼭�� �ȵż� repaint�� ��)
	}
	
	public static void main(String[] args) {
		new ChoosePageFrame();
	}
	
}
