package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.ColorConvertOp;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class accumulatedFundFrame extends DefaultFrame{
	
	/*
	 * setSize(), setPreferredSize() �Ѵ� ũ�⸦ �������ִ� �޼���.
	 * ������ layout���� ������ �Ҷ��� setPreferredSize(new Dimension(x,y))�� ����Ѵ�.
	 * 
	 * */
	
	public accumulatedFundFrame() {
	
		//�⺻ ������ ����
		setTitle("���� ȭ��");
		setSize(450,610);
		setLocation(700,300);
		setResizable(false);
		getContentPane().setBackground(new Color(245, 235, 208));
		
		//�Է� �ʵ� ����, �۾� ����
		Font font = new Font("���� ���", Font.PLAIN, 18);
		RoundJTextField textField = new RoundJTextField(30);
		textField.setFont(font);
		textField.setBounds(95,70,250,70);
		textField.setForeground(new Color(180, 180, 180));
		
		//��ȣ ��ư�� �� �г� �߰�
		JPanel num_panel = new JPanel();
		num_panel.setPreferredSize(new Dimension(350,400));
		num_panel.setBounds(70,170,300,330);
		num_panel.setLayout(new GridLayout(4,3,8,8));
		num_panel.setBackground(new Color(245, 235, 208));
		
		
		//��ȣ ��ư ����
		ArrayList<JButton> numBtns = new ArrayList<>();
		
		
		for (int i = 0; i < 12; i++) {
			if (i == 10) {
				numBtns.add(new JButton("0"));
				num_button_style(numBtns,i);
			}else if (i == 9){
				numBtns.add(new JButton("��"));
				num_button_style(numBtns,i);
				numBtns.get(i).setFont(new Font("�ü�ü",Font.BOLD,30));
				
			}else if (i == 11) {
				numBtns.add(new JButton("����"));
				num_button_style(numBtns,i);
				numBtns.get(i).setBackground(new Color(115,185,112));
				numBtns.get(i).setForeground(Color.white);
				
			}else {
				numBtns.add(new JButton(Integer.toString(i + 1)));
				num_button_style(numBtns,i);
			}
		}
		
		for (JButton btn : numBtns) {
			num_panel.add(btn);	
		}
		
		
		textField.setText("��ȭ��ȣ�� �Է��ϼ���");  //���콺�� �ö��� �� �׼����� ���� ���ֱ�,���ڻ� ���ϰ� �ٲٱ�
		
		
		add(num_panel);
		add(textField);

		setVisible(true);
		repaint();
	}
	
	//��ư ��Ÿ�� �޼���
	void num_button_style(ArrayList<JButton> numBtns, int num) {
		numBtns.get(num).setFont(new Font("���� ���",Font.PLAIN,20));
		numBtns.get(num).setBackground(new Color(255,255,255));
		numBtns.get(num).setForeground(Color.GRAY);
		numBtns.get(num).setBorderPainted(false);
		
	}
	
	public static void main(String[] args) {
		new accumulatedFundFrame();
		
	}

}
