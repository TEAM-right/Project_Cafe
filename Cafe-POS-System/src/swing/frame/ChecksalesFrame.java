package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc.method.TotalInfo;

public class ChecksalesFrame extends JFrame{		
	
	static DefaultTableModel model;
	
	
	public static void main(String[] args) {
		
		// �θ� ������ ���� �� �⺻ ��Ÿ�� ���� �ǽ�
		JFrame frm = new JFrame("�ֹ� ���� ���α׷�");
		setJFrameStyle(frm);

		// ��з� ---------------------------------------------------
		JLabel big_txt = new JLabel("�ڱ��С�");
		big_txt.setBounds(0, 0, 100, 50);
		setJLabelStyle(big_txt);
		
		String big_arr[] = {"�� ����", "�� ����", "�� ����", "�� ����"};
		JComboBox<String> big_combo = new JComboBox<String>(big_arr);
		big_combo.setBounds(100, 0, 1300, 50);
		setJComboBoxStyle(big_combo);
		
		JButton big_select_btn = new JButton("������");			
		big_select_btn.setBounds(1400, 0, 100, 50);
		setJButtonStyle(big_select_btn); // �⺻ ��ư ��Ÿ�� ���� �޼ҵ� ȣ��
		
		big_select_btn.addActionListener(new ActionListener() {
		// if ((big_combo.getSelectedItem().equals("�� ����")) && (e.getSource() == big_select_btn)) {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				
			}
		});
		// -----------------------------------------------------------
		

		
		JTable jt = new TotalInfo().getTotalInfo();
		jt.setBounds(0, 110, 1500, 850);					
		
	
		frm.getContentPane().add(big_txt);
		frm.getContentPane().add(big_combo);
		frm.getContentPane().add(big_select_btn);
		frm.getContentPane().add(jt, BorderLayout.CENTER);
		
		
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
		txt.setOpaque(true); // setBackground �����ϱ� ���� ���� ����
		txt.setBackground(Color.GRAY); // ��׶��� ���� ����
		txt.setForeground(Color.magenta); // �ؽ�Ʈ ���� ����
		txt.setFont(new Font("�ü�ü", 3, 20)); // ��Ʈ ����
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
		btn.setFont(new Font("�ü�ü", Font.BOLD, 20)); // ��Ʈ ����
		btn.setHorizontalAlignment(JLabel.CENTER); // �ؽ�Ʈ ���� ǥ�� ����
	}


}
