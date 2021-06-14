package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc.method.TotalInfo;

public class ChecksalesFrame extends JFrame{		
	
	public ChecksalesFrame() {
		// �θ� ������ ���� �� �⺻ ��Ÿ�� ���� �ǽ�
		JFrame frm = new JFrame("�ֹ� ���� ���α׷�");
		setJFrameStyle(frm);

		// ��з� ---------------------------------------------------
		JLabel big_txt = new JLabel("�� ��");
		big_txt.setBounds(0, 68, 100, 40);
		setJLabelStyle(big_txt);
				
		ImageIcon icon_logo = new ImageIcon("./data/Logo1.png");
		Image img_logo = icon_logo.getImage();
		Image cimg_logo = img_logo.getScaledInstance(1500, 68, Image.SCALE_FAST);
		ImageIcon cicon_logo = new ImageIcon(cimg_logo);
		
		JLabel imglb = new JLabel(cicon_logo);
		
		imglb.setOpaque(true);
		imglb.setBounds(0, 0, 1500, 68);
		
		String big_arr[] = {"�� ����", "�� ����", "�� ����", "�� ����"};
		JComboBox<String> big_combo = new JComboBox<String>(big_arr);
		big_combo.setBounds(100, 68, 1300, 40);
		setJComboBoxStyle(big_combo);
				
		JButton big_select_btn = new JButton("��ȸ");			
		big_select_btn.setBounds(1400, 68, 100, 40);
		setJButtonStyle(big_select_btn); // �⺻ ��ư ��Ÿ�� ���� �޼ҵ� ȣ��
				
		// if ((big_combo.getSelectedItem().equals("�� ����")) && (e.getSource() == big_select_btn)) {

		// -----------------------------------------------------------
				

				
		JTable jt = new TotalInfo().getTotalInfo();
		JScrollPane jscroll = new JScrollPane(jt);
		jscroll.setBounds(0, 110, 500, 650);					
				
		frm.getContentPane().add(imglb);
		frm.getContentPane().add(big_txt);
		frm.getContentPane().add(big_combo);
		frm.getContentPane().add(big_select_btn);
		frm.getContentPane().add(jscroll, BorderLayout.CENTER);
				
				
		frm.setVisible(true);
				
	}
				
			
	// JFrame �θ� �⺻ ��Ÿ�� ���� �޼ҵ�
	public static void setJFrameStyle(JFrame frame) {
		frame.setSize(1500, 1000); // �θ� ������ ũ�� ���� (����, ����) �� ���� ����
		frame.setBackground(Color.BLACK); // �θ� �������� ȭ�� ����� ��ġ		 
		frame.setLocationRelativeTo(null); // �θ� �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ���� 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �θ� ������ â ũ�� ���� �ǽ�				
		frame.setResizable(false); // �θ� ���̾ƿ� ����		 
		frame.getContentPane().setLayout(null);
	}	
			
	// JLabel �⺻ ��Ÿ�� ���� �޼ҵ�
	public static void setJLabelStyle(JLabel txt) {		
				
		Color color = new Color(0x1E821E);
		txt.setOpaque(true); // setBackground �����ϱ� ���� ���� ����
		txt.setBackground(color); // ��׶��� ���� ����
		txt.setForeground(Color.white); // �ؽ�Ʈ ���� ����
		txt.setFont(new Font("�߰��", Font.BOLD, 25)); // ��Ʈ ����
		txt.setHorizontalAlignment(JLabel.CENTER); // �ؽ�Ʈ ���� ǥ�� ����
	}
			
	// JComboBox �⺻ ��Ÿ�� ���� �޼ҵ�
	public static void setJComboBoxStyle(JComboBox combo) {							
		combo.setBackground(Color.LIGHT_GRAY); // ��׶��� ���� ����
		combo.setForeground(Color.WHITE); // �ؽ�Ʈ ���� ����
		combo.setFont(new Font("�ü�ü", Font.BOLD, 20)); // ��Ʈ ����		
	}
			
	// JButton �⺻ ��Ÿ�� ���� �޼ҵ�
	public static void setJButtonStyle(JButton btn) {
		btn.setBackground(Color.DARK_GRAY); // ��׶��� ���� ����
		btn.setForeground(Color.pink); // �ؽ�Ʈ ���� ����
		btn.setFont(new Font("��ȸ", Font.BOLD, 20)); // ��Ʈ ����
		btn.setHorizontalAlignment(JLabel.CENTER); // �ؽ�Ʈ ���� ǥ�� ����
	}
	
	public static void main(String[] args) {
		new ChecksalesFrame();
		
	}
}
