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
import javax.swing.event.AncestorListener;

import action.AccumulatedFundButton;
import action.AccumulatedFundTextFiel;
import action.ExitAccumulatedResults;
import action.SignUp;
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
		getContentPane().setBackground(new Color(222,222,222));
		
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
		num_panel.setBackground(new Color(222,222,222));
		
		//��ȣ,����Ʈ,���� �ʵ� �����ʿ� �߰�
		JPanel phone_panelL = new JPanel();
		JPanel point_panelL = new JPanel();
		JPanel coupon_panelL = new JPanel();
		
		panelL_style(phone_panelL);
		panelL_style(point_panelL);
		point_panelL.setBounds(360, 100, 70, 60);
		panelL_style(coupon_panelL);
		coupon_panelL.setBounds(360, 170, 70, 60);
		
		//������ �ʵ�鿡 �� �߰�
		JLabel phone_label = new JLabel("Phone");
		JLabel point_label = new JLabel("Point");
		JLabel coupon_label = new JLabel("Coupon");
		
		right_label_style(phone_label);
		right_label_style(point_label);
		right_label_style(coupon_label);
		coupon_label.setBounds(5, 0, 250, 70);
		
		phone_panelL.add(phone_label);
		point_panelL.add(point_label);
		coupon_panelL.add(coupon_label);
		
		//�����ʿ� ȸ������ ���� �г� �߰�
		ArrayList<JPanel> panelR = new ArrayList();
		
		for (int i = 0; i < 3; i++) {
			panelR.add(new JPanel());
			JPanel panel = panelR.get(i);
			panelR_style(panel);
		
		}
		panelR.get(1).setBounds(435,100,200,60);
		panelR.get(2).setBounds(435,170,200,60);
		
		//ȸ�����,������ ��ư �߰�
		JButton register = new JButton("ȸ�����");
		JButton exit = new JButton("������");
		
		register_exit_style(register);
		register_exit_style(exit);
		
		register.setBounds(400, 402, 100, 37);
		exit.setBounds(515, 402, 95, 37);
	
		ArrayList<JButton> numBtns = new ArrayList<>();
		StringBuilder phoneNum = new StringBuilder();  
		//�ؽ�Ʈ �ʵ忡�� �Է� �޴� ���ڸ� �̾ �ޱ� ���� ��Ʈ������ �غ�

		//(�׼�)======================================================================
		//������ ��ư �׼�
		exit.addActionListener(new ExitAccumulatedResults());
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
				numBtns.get(i).setBackground(new Color(95,148,153));
				numBtns.get(i).setForeground(Color.white);  //��ư ���ڻ� ����
			}else {
				numBtns.add(new JButton(Integer.toString(i + 1)));
				num_button_style(numBtns,i);
			}
			//��ư Ŭ���� �Ͼ�� �׼�
			numBtns.get(i).addMouseListener(new AccumulatedFundButton(this, textField, numBtns, phoneNum, panelR));
		}
		
		//ȸ����� ��ư �׼�
		register.addMouseListener(new SignUp(textField, panelR));
		
		//(�����ӿ� �߰��ϸ鼭 ������)========================================================
		//��ȣ�гο� ��ȣ ��ư�� �߰�
		for (JButton btn : numBtns) {
			num_panel.add(btn);	
		}
		
		//�����ӿ� �г��̶� �ؽ�Ʈ�ʵ� �߰�
		for (JPanel panel : panelR) {
			add(panel);
		}
		add(register);
		add(exit);
		add(phone_panelL);
		add(point_panelL);
		add(coupon_panelL);
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
	//ȸ�����,������ ��ư ��Ÿ��
	private void register_exit_style(JButton btn) {
		btn.setFont(new Font("���� ���",Font.PLAIN,16));
		btn.setForeground(Color.white);
		btn.setBackground(new Color(0,66,56));
		btn.setBorderPainted(false);
	}
    //phone,point,coupon �г�
	private void panelL_style(JPanel panel) {
		panel.setBounds(360,30,70,60);
		panel.setLayout(null);
		panel.setBackground(new Color(95,148,153));
	}
	//ȸ�� ���� �г�
	private void panelR_style(JPanel panel) {
		panel.setBounds(435,30,200,60);
		panel.setLayout(null);
		panel.setBackground(new Color(255,255,255));
	}
	//�� ��Ÿ��
	private void right_label_style(JLabel label) {
		label.setBounds(10, 0, 250, 70);
		label.setForeground(Color.white);
		label.setFont(new Font("Yu Gothic Light",Font.BOLD,17));
	}
	public JFrame getAccumulatedFundFrame() {
		return this;
	}
	public static void main(String[] args) {
		new AccumulatedFundFrame();	
	}
}
