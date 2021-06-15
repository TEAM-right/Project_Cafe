package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import action.ChecksalesSelectButton;
import jdbc.method.TotalInfo;

public class ChecksalesFrame extends DefaultFrame{		
	
	public ChecksalesFrame() {
		// �θ� ������ ���� �� �⺻ ��Ÿ�� ���� �ǽ�
		
		setTitle("�������");

		// ��з� ---------------------------------------------------
		JLabel sortation_txt = new JLabel("�� ��");
		sortation_txt.setBounds(0, 68, 100, 40);
		setJLabelStyle(sortation_txt);
				
		ImageIcon icon_logo = new ImageIcon("./data/Logo1.png");
		Image img_logo = icon_logo.getImage();
		Image cimg_logo = img_logo.getScaledInstance(1500, 68, Image.SCALE_FAST);
		ImageIcon cicon_logo = new ImageIcon(cimg_logo);
		
		JLabel imglb = new JLabel(cicon_logo);
		imglb.setOpaque(true);
		imglb.setBounds(0, 0, 1500, 68);
		
		String combo_arr[] = {"","�� ����", "�� ����", "�� ����"};
		JComboBox<String> select_combo = new JComboBox<String>(combo_arr);
		select_combo.setBounds(100, 68, 1300, 40);
		setJComboBoxStyle(select_combo);
		
		DefaultTableModel model = new TotalInfo().getTotalInfo();
		JTable jt = new JTable(model);
		model.fireTableDataChanged();
		jt.updateUI();
		JScrollPane jscroll = new JScrollPane(jt);
		jscroll.setBounds(0, 110, 500, 650);				
		
		DefaultTableModel total_model = new TotalInfo().getTotalInfoTotal();
		JTable jt2 = new JTable(total_model);
		total_model.fireTableDataChanged();
		jt2.updateUI();
		JScrollPane jscroll2 = new JScrollPane(jt2);
		jscroll2.setBounds(0, 800, 500, 50);					
				
		JButton select_btn = new JButton("��ȸ");			
		select_btn.setBounds(1400, 68, 100, 40);
		setJButtonStyle(select_btn); // �⺻ ��ư ��Ÿ�� ���� �޼ҵ� ȣ��
		select_btn.addActionListener(
				new ChecksalesSelectButton(
						this,select_btn, select_combo, model, jt));		
		// if ((big_combo.getSelectedItem().equals("�� ����")) && (e.getSource() == big_select_btn)) {

		// -----------------------------------------------------------
				

				
				
		getContentPane().add(imglb);
		getContentPane().add(sortation_txt);
		getContentPane().add(select_combo);
		getContentPane().add(select_btn);
		getContentPane().add(jscroll, BorderLayout.CENTER);
		getContentPane().add(jscroll2, BorderLayout.CENTER);
				
		this.repaint();
		
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
