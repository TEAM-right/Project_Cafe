package swing.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.sun.tools.javac.Main;

import action.Login_btn_Listener;
import action.Login_combobox_listener;
import action.Password_tf_Listener;
import jdbc.method.Login_combox_data;


public class Login_Frame extends DefaultFrame {
	
	JPanel panel, login_panel, test_panel;
	JScrollPane scrollPane;
	ImageIcon icon;
	JComboBox combox;
	JPasswordField pwf;
	Font font1 = new Font("���� ���", Font.BOLD, 18);
	Font font2 = new Font("���� ���", Font.BOLD, 30);
	JButton login_btn;
	String cbname, password;
	static int count = 0;
	
	
	public Login_Frame() {
		
		  
		icon = new ImageIcon("./image/Ŀ�ǻ���.jpg");
			
		// ============================================= ���ȭ�� �̹��� ����
		
	
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {

				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		scrollPane = new JScrollPane(panel);
		setContentPane(scrollPane);
		panel.setLayout(null);
			
			
			// ============================================= �α��� �г�
			login_panel = new JPanel();
			login_panel.setBounds(100, 600, 400, 200);
			login_panel.setBackground(new Color(255, 255, 255, 255));
			login_panel.setBorder(new TitledBorder
					(new LineBorder(Color.DARK_GRAY,10),"Log_in")); // �г��� �׵θ�
			
			login_panel.setLayout(null);
			
			
			panel.add(login_panel);
			
			// ============================================= �α��� ��ư
			login_btn = new JButton("LOGIN");
			login_btn.setBackground(new Color (0,0,0));
			login_btn.setFont(font1);
			login_btn.setBounds(130,150,150,30);
			login_btn.setForeground(Color.white);
			
			login_panel.add(login_btn);
			
			// ============================================= �޺� �ڽ�
			
			
			combox = new Login_combox_data().getComboBox();
			
			combox.setBounds(80,30, 250, 35);
			combox.setFont(font1);
			
			login_panel.add(combox);
			
			combox.addActionListener(new Login_combobox_listener(combox));
			// �޹� �� �޾ƿ�
			Login_combobox_listener lcl = new Login_combobox_listener(combox);
			cbname = lcl.cbname;
			

			// ============================================= �ؽ�Ʈ�ʵ�
			pwf = new JPasswordField(5);
			pwf.setBounds(80, 80 , 250, 35);
			pwf.setFont(font1);
			
			login_panel.add(pwf);
			
			
			// �ؽ�Ʈ�ʵ� �� ��������
			password = new String(pwf.getPassword());
			
			
			// passwordfield ���� ������
			pwf.addActionListener(new Password_tf_Listener(cbname, password, this));
			// �α��� ��ư ������
			login_btn.addActionListener(new Login_btn_Listener(login_btn, cbname, password, this));
			
			
			
			
			
			
			setVisible(true);
			
			
			
		 } // login _Frame
			 
		 public static void main(String args[]) {
			new Login_Frame();
			 
		 }
		 
		 


}
