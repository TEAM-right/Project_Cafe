package test;

public class test_table1 {

}

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import tool.RoundJTextField;
import tool.RoundedButton;

public class Stock_Frame extends DefaultFrame {
	
	JPanel main_panel, table_panel, table_panel2;
	JLabel title_label;
	JScrollPane scrollPane;
	RoundedButton all_btn, drink_btn, product_btn, rtd_btn, exit_btn;
	JButton find_btn;
	JComboBox cate_combox;
	RoundJTextField find_tf;
	JTable table;
	JTableHeader table_header;
	Container contentPane;
	DefaultTableModel table_model;
	DefaultTableCellRenderer dtcr_center, dtcr_right; // cell ��ġ ������ ����
	
	
	Font bigger_font = new Font("���� ���", Font.BOLD, 50);
	Font big_font = new Font("���� ���", Font.BOLD, 30);
	Font nomal_font = new Font("���� ���", Font.BOLD, 20);
	Font small_font = new Font("���� ���", Font.BOLD, 15);
	
	
	public Stock_Frame() {
	
		// ====================================================== main panel
		main_panel = new JPanel();
		scrollPane = new JScrollPane(main_panel);
		main_panel.setBackground(new Color(208, 227, 166));
		main_panel.setLayout(null);
		setContentPane(main_panel);
		
		
		// ======================================================= title label
		title_label = new JLabel("  ��� ��Ȳ");
		title_label.setBounds(50, 20, 300, 100);
		title_label.setBackground(Color.black);
		title_label.setLayout(null);
		title_label.setFont(bigger_font);
		title_label.setBorder(new TitledBorder(new LineBorder(new Color(107, 153, 0),5 ), null));
		
		main_panel.add(title_label);
		
		// ======================================================= table panel
		table_panel = new JPanel();
		scrollPane = new JScrollPane(table_panel);
		table_panel.setBackground(Color.white);
		table_panel.setBounds(50 , 250, 1200, 650);
		table_panel.setBorder(new TitledBorder(new LineBorder(Color.orange, 10), "STOCK_TABLE"));
		table_panel.setLayout(null);
		
		main_panel.add(table_panel);
		
		
		// ======================================================= ��ư �з�
		all_btn = new RoundedButton("ALL");
		drink_btn = new RoundedButton("DRINK");
		product_btn = new RoundedButton("FOOD");
		rtd_btn = new RoundedButton("RTD");
		exit_btn = new RoundedButton("EXIT");
		
		// ======================================================= all_btn
		all_btn.setFont(big_font);
		all_btn.setBounds(1270, 250, 200, 100);
		
		main_panel.add(all_btn);
		
		// ==================================== ��ǰ(product) ��ư
		product_btn.setFont(big_font);
		product_btn.setBounds(1270, 370, 200, 100);
				
		main_panel.add(product_btn);
				
		// ==================================== RTD ��ư
		rtd_btn.setFont(big_font);
		rtd_btn.setBounds(1270, 490, 200, 100);
		
		main_panel.add(rtd_btn);
		
		// ==================================== drink ��ư
		drink_btn.setFont(big_font);
		drink_btn.setBounds(1270, 610, 200, 100);
				
		main_panel.add(drink_btn);
		
		
		// ==================================== EXIT (�ڷΰ���) ��ư
		exit_btn.setFont(big_font);
		exit_btn.setBounds(1270, 800, 200, 100);
		exit_btn.setBackground(new Color(184, 41, 41));
		exit_btn.setForeground(Color.black);
		
		main_panel.add(exit_btn);
		
		// ============================================== �˻� �ؽ�Ʈ�ʵ�
		find_tf = new RoundJTextField(10);
		find_tf.setFont(nomal_font);
		find_tf.setBounds(880, 200, 300, 40);
		
		main_panel.add(find_tf);
		
		// ============================================== �˻� ��ư
		ImageIcon image = new ImageIcon("./image/������.jpeg");
		find_btn = new JButton(image);
		find_btn.setBounds(1190, 200, 60, 40);
		
		
		main_panel.add(find_btn);
		
		// ============================================== ���̺� ������ �ֱ� ����� (��������)
		
		String header[] = {"PRODUCT_ID","PRODUCT_NAME","STOCK"};
		String contents[][] = {
				{"1","�Ƹ޸�ī��","220"},
				{"2","ó��ó��","120"},
				{"3","����������","210"}
		};
		
		table_model = new DefaultTableModel(contents, header);
		table = new JTable(table_model);
		
		
		
		
		
		// ============================================== ���̺�
		
		table_panel.setPreferredSize(new Dimension(430, 400));
		table = new JTable(table_model);
		JScrollPane table_scrollpane = new JScrollPane(table);
		
		scrollPane.setLocation(20, 20);
		scrollPane.setSize(1160, 610);
		table.setFont(nomal_font);
		table.setRowHeight(40);	// ���̺� �� ���� ����
		
		table.getTableHeader().setReorderingAllowed(false); // ���̺� ��� �̵� �ȵǰ� �ϱ�
		table.getTableHeader().setBackground(Color.pink);// �÷��� ������ ����
		table.getTableHeader().setFont(small_font);
		table.getTableHeader().setForeground(Color.black);;
		
		// ------------------------------------------------------- ���̺� ������ ���������� ������ �ȵǰ� �ϱ�
//		table.setModel(new DefaultTableModel() {
//			public boolean isCellEditable(int row, int column) {
//				if(column == 2) { // column == 2�� stock�̹Ƿ� stock�� ������ �����ϰ� �� 
//					return true; // ���� ����
//				} else {
//				return false; // �Ұ���
//			}
//		}
//		});
		table.getColumn(header[0]).setPreferredWidth(100); // �÷��� ���� �����ε� ��� �÷��� ���̺��� ���̿� '����' �°� �����ؾ���
		table.getColumn(header[1]).setPreferredWidth(900); 
		table.getColumn(header[2]).setPreferredWidth(110);
		
		// ------------------------------------------------------- �÷� ����
		dtcr_center = new DefaultTableCellRenderer();
		dtcr_right = new DefaultTableCellRenderer();
		
		dtcr_center.setHorizontalAlignment(SwingConstants.CENTER); // dtcr_center�� ��ġ�� center�� ����
		dtcr_right.setHorizontalAlignment(SwingConstants.RIGHT);
		
		TableColumnModel ts = table.getColumnModel(); // ������ ���̺��� columnModel�� ������
		ts.getColumn(0).setCellRenderer(dtcr_center);// product_id �÷��� ���� ����
		ts.getColumn(1).setCellRenderer(dtcr_center);
		ts.getColumn(2).setCellRenderer(dtcr_center);
		
		//table_panel.add(table);
		table_panel.add(table_scrollpane);
		//table_panel.add(table);
		
		//���̺��� ������ �� ��������
		//table.getColumn(header[2]).getCellEditor();
		
		
		
		repaint();
		setVisible(true);
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new Stock_Frame();
	}

}























