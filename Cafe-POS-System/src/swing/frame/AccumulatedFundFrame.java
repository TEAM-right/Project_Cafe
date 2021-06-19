package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ColorConvertOp;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import action.AccumulatedFundButton;
import action.AccumulatedFundTextFiel;
import swing.method.RoundJTextField;


public class AccumulatedFundFrame extends DefaultFrame{
	
	/*
	 * setSize(), setPreferredSize() �Ѵ� ũ�⸦ �������ִ� �޼���.
	 * ������ layout���� ������ �Ҷ��� setPreferredSize(new Dimension(x,y))�� ����Ѵ�.
	 * 
	 * */
	
	public AccumulatedFundFrame() {
	
		//(������)====================================================================
		
		//�⺻ ������ ����
		setTitle("���� ȭ��");
		setSize(680,520);
		setLocation(500,100);
		setResizable(false);
		getContentPane().setBackground(new Color(243, 235, 207));
		
		//�Է� �ʵ� ����, �۾� ����
		Font font = new Font("���� ���", Font.PLAIN, 18);
		RoundJTextField textField = new RoundJTextField(30);
		textField.setFont(font);
		textField.setBounds(58,30,260,65);
		textField.setForeground(new Color(160, 160, 160));
		textField.setText("��ȭ��ȣ�� �Է��ϼ���");  
		
		//��ȣ ��ư�� �� �г� �߰�
		JPanel num_panel = new JPanel();
		num_panel.setBounds(36,120,300,330);
		num_panel.setLayout(new GridLayout(4,3,8,8));
		num_panel.setBackground(new Color(245, 235, 208));
		
		//��ȣ,����Ʈ,���� �ʵ� �����ʿ� �߰�
		JPanel phone_panel = new JPanel();
		JPanel point_panel = new JPanel();
		JPanel coupon_panel = new JPanel();
		right_panel_style(phone_panel);
		right_panel_style(point_panel);
		point_panel.setBounds(380, 100, 250, 60);
		right_panel_style(coupon_panel);
		coupon_panel.setBounds(380, 170, 250, 60);
		
		//������ �ʵ�鿡 �� �߰�
		JLabel phone_label = new JLabel("Phone");
		JLabel point_label = new JLabel("Point");
		JLabel coupon_label = new JLabel("Coupon");
		
		phone_label.setBounds(10, 0, 250, 70);
		phone_label.setForeground(new Color(181,181,181));
		phone_label.setFont(new Font("Yu Gothic Light",Font.BOLD,17));
		
		phone_panel.add(phone_label);
		point_panel.add(point_label);
		coupon_panel.add(coupon_label);
		
	
		ArrayList<JButton> numBtns = new ArrayList<>();
		StringBuilder phoneNum = new StringBuilder();  
		//�ؽ�Ʈ �ʵ忡�� �Է� �޴� ���ڸ� �̾ �ޱ� ���� ��Ʈ������ �غ�
		
		
		//(�׼�)======================================================================
		
		//�ؽ�Ʈ�ʵ�׼� �ҷ�����
		textField.addMouseListener(new AccumulatedFundTextFiel(textField));
		//�ؽ�Ʈ�ʵ� ��Ȱ��ȭ ���Ѽ� Ű����� �Է� ���ϰ� ����.
		textField.setEditable(false); 
		
		//numBtns�� �ε��� 9,10,11�� ��,0,�������� ���� ���� or ������ �´� ��Ÿ�Ϸ� �ٽ� ����.
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
				numBtns.get(i).setForeground(Color.white);  //��ư ���ڻ� ����
			}else {
				numBtns.add(new JButton(Integer.toString(i + 1)));
				num_button_style(numBtns,i);
			}
			
			//��ư Ŭ���� �Ͼ�� �׼�
			numBtns.get(i).addMouseListener(new AccumulatedFundButton(this,textField, numBtns, phoneNum));
		
		}
		
		
		//(�����ӿ� �߰��ϸ鼭 ������)========================================================
		
		//��ȣ�гο� ��ȣ ��ư�� �߰�
		for (JButton btn : numBtns) {
			num_panel.add(btn);	
		}
		
		//�����ӿ� �г��̶� �ؽ�Ʈ�ʵ� �߰�
		////////////////////////////////////////////
		add(phone_panel);
		add(point_panel);
		add(coupon_panel);
		add(num_panel);
		add(textField);

		setVisible(true);
		repaint();
	}
	
	//��ư ��Ÿ�� �޼���
	private void num_button_style(ArrayList<JButton> numBtns, int num) {
		numBtns.get(num).setFont(new Font("���� ���",Font.PLAIN,20));
		numBtns.get(num).setBackground(new Color(255,255,255));
		numBtns.get(num).setForeground(Color.GRAY);
		numBtns.get(num).setBorderPainted(false);
		
	}
	
	private void right_panel_style(JPanel panel) {
		panel.setBounds(380,30,250,60);
		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 255));
	}

	public JFrame getAccumulatedFundFrame() {
		return this;
	}
	
	public static void main(String[] args) {
		new AccumulatedFundFrame();
		
	}

}
