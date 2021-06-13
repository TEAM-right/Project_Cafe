package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import action.ChangePageButton;
import action.CurrentTimeClock;
import action.EmployeeInfoAddButton;
import action.EmployeeInfoDelButton;
import action.EmployeeInfoUpdateButton;
import action.GetTableInfoForMouse;
import jdbc.method.SelectEmployeeInfo;

public class EmployeesManagementFrame extends DefaultFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel center;
	private JTable staff_info;
	private JScrollPane scorll_add_staff_info;
	private JTabbedPane right_panel_tab;
	private JPanel top_panel_body;
	private JPanel right_panel;
	private ArrayList<JLabel> labels;
	private ArrayList<TextField> fields;
	private JButton btn;

	public EmployeesManagementFrame() {
		setLayout(new BorderLayout());
		setTitle("Employees Management");

		// -- [CENTER] -- ��� ������ �г� ����
		center = new JPanel(new GridLayout());

		// ���� ���� ���̺� ����(DB���� ���� �ҷ�����)
		staff_info = new SelectEmployeeInfo().getEmployeeInfo();
		// ���̺� �۾�ü ����
		staff_info.setFont(new Font("���� ���", Font.PLAIN, 25));
		// ���̺� �÷��� �̵� �Ұ�
		staff_info.getTableHeader().setReorderingAllowed(false);
		// ���̺� ���� ���� ����
		staff_info.setRowHeight(50);
		// ���̺� ����� �����ϱ�
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = staff_info.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		// ���̺� ��� ����, �۾�ü, ���� ����
		JTableHeader header = staff_info.getTableHeader();
		header.setPreferredSize(new Dimension(100, 50));
		header.setFont(new Font("���� ���", Font.BOLD, 25));
		header.setBackground(new Color(161, 192, 90));
		// ���̺� ���� �Ѿ�� ��ũ�ѹٷ� �����
		scorll_add_staff_info = new JScrollPane(staff_info);
		
		
		// ���� �г��� �����ʿ� �߰��� �г� ���� -> ������ �г� ������ �����
		right_panel_tab = new JTabbedPane();
		right_panel_tab.setFont(new Font("���� ���", Font.BOLD, 30));
		right_panel_tab.setBackground(new Color(161, 192, 90));
		right_panel_tab.addTab("���", enrollTab());
		right_panel_tab.addTab("������", updateTab());
		right_panel_tab.addTab("�衡��", delTab());

		// -- [CENTER-TOP] --
		top_panel_body = new JPanel(new GridLayout());
		// �ڷ� ���� ��ư
		JButton back_btn = new JButton("<<");
		back_btn.setPreferredSize(new Dimension(100, 80));
		back_btn.setFont(new Font("�ü�", Font.BOLD, 30));
		back_btn.setBackground(new Color(0, 60, 0));
		back_btn.setForeground(Color.WHITE);
		back_btn.addActionListener(new ChangePageButton(this));
		
		top_panel_body.add(back_btn, BorderLayout.WEST);
		// ��� �ý��۽ð�
		JLabel clock = new CurrentTimeClock().setClock();
		clock.setFont(new Font("���� ���", Font.BOLD, 30));
		clock.setHorizontalAlignment(JLabel.CENTER);
		clock.setOpaque(true);
		clock.setBackground(new Color(64, 128, 128));
		clock.setForeground(Color.WHITE);
		top_panel_body.add(clock, BorderLayout.CENTER);
		// �����ʿ� �α����� ��� ���� �߰��� ����
		JLabel login_name = new JLabel("����");
		login_name.setFont(new Font("���� ���", Font.PLAIN, 30));
		login_name.setHorizontalAlignment(JLabel.CENTER);
		login_name.setOpaque(true);
		login_name.setBackground(Color.cyan);
		top_panel_body.add(login_name, BorderLayout.EAST);

		
		// [CENTER�� �гε� add]
		// -- [CENTER-LEFT] --
		center.add(scorll_add_staff_info);
		// -- [CENTER-RIGHT] --
		center.add(right_panel_tab);

		// Frame�� �г� ��ġ �����ϸ鼭 �߰�
		add(top_panel_body, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);

		setVisible(true);
	}
	
	public JButton makeButton(String btn_name) {
		btn = new JButton(btn_name);
		btn.setPreferredSize(new Dimension(200, 80));
		btn.setFont(new Font("���� ���", Font.BOLD, 30));
		btn.setBackground(new Color(161, 192, 90));
		
		return btn;
	}
	
	public void makeLabelAndField(String[] labels_name) {
		for (int i = 0; i < labels_name.length; i++) {
			labels.add(new JLabel(labels_name[i]));
			// �� ��� ����
			labels.get(i).setHorizontalAlignment(JLabel.CENTER);
			labels.get(i).setFont(new Font("���� ���", Font.BOLD, 30));
			// setOpaque(true) �� -> setBackground(Color)ä����
			labels.get(i).setOpaque(true);
			labels.get(i).setBackground(new Color(161, 192, 90));
			// ������ ����
			labels.get(i).setPreferredSize(new Dimension(200, 80));
			// �� Ƣ����� ����
			labels.get(i).setBorder(new BevelBorder(BevelBorder.RAISED));

			fields.add(new TextField(20));
			fields.get(i).setFont(new Font("���� ���", Font.PLAIN, 30));

			right_panel.add(labels.get(i));
			right_panel.add(fields.get(i));
		}
	}

	// [���� ���� ��� ��]
	public JPanel enrollTab() {
		right_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 50));
		labels = new ArrayList<>();
		fields = new ArrayList<>();
		String[] labels_name = {"�̡�����", "�н�����"};

		makeLabelAndField(labels_name);
		
		// ���� ���� �޺��ڽ������� ���� �߰�
		JLabel grade = new JLabel("��������");
		grade.setHorizontalAlignment(JLabel.CENTER);
		grade.setFont(new Font("���� ���", Font.BOLD, 30));
		grade.setPreferredSize(new Dimension(200, 80));
		grade.setBorder(new BevelBorder(BevelBorder.RAISED));
		grade.setOpaque(true);
		grade.setBackground(new Color(161, 192, 90));
		right_panel.add(grade);
		// ���� �޺��ڽ�
		String[] grade_list = { "BARISTA", "MANAGER" };
		JComboBox<String> grade_box = new JComboBox<>(grade_list);
		grade_box.setFont(new Font("���� ���", Font.PLAIN, 30));
		grade_box.setPreferredSize(new Dimension(365, 80));
		grade_box.setBackground(Color.white);
		right_panel.add(grade_box);

		btn = makeButton("�����");
		btn.addActionListener(new EmployeeInfoAddButton(fields, grade_box, staff_info));
		
		right_panel.add(btn, BorderLayout.SOUTH);

		return right_panel;
	}
	
	// [���� ���� ���� ��]
	public JPanel updateTab() {
		right_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 50));
		labels = new ArrayList<>();
		fields = new ArrayList<>();
		String[] labels_name = {"���� ��ȣ", "�̡�����", "�н�����"};
		
		makeLabelAndField(labels_name);
		
		// ���� ���� �޺� �ڽ������� ���� �߰�
		JLabel grade = new JLabel("��������");
		grade.setHorizontalAlignment(JLabel.CENTER);
		grade.setFont(new Font("���� ���", Font.BOLD, 30));
		grade.setPreferredSize(new Dimension(200, 80));
		grade.setBorder(new BevelBorder(BevelBorder.RAISED));
		grade.setOpaque(true);
		grade.setBackground(new Color(161, 192, 90));
		right_panel.add(grade);
		// ���� �޺��ڽ�
		String[] grade_list = { "BARISTA", "MANAGER" };
		JComboBox<String> grade_box = new JComboBox<>(grade_list);
		grade_box.setFont(new Font("���� ���", Font.PLAIN, 30));
		grade_box.setPreferredSize(new Dimension(365, 80));
		right_panel.add(grade_box);
		
		btn = makeButton("��������");
		btn.addActionListener(new EmployeeInfoUpdateButton(fields, grade_box, staff_info));
		
		right_panel.add(btn, BorderLayout.SOUTH);
		
		// ���̺� �� �����ϸ� �� �������� �̺�Ʈ ����
		staff_info.addMouseListener(new GetTableInfoForMouse(staff_info, fields));
		
		// ���� ���� �� ���� ��ȣ, �̸� ���� �Ұ�
		fields.get(0).setEditable(false);
		fields.get(1).setEditable(false);
		
		return right_panel;
	}

	// [���� ���� ���� ��]
	public JPanel delTab() {
		right_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 50));
		labels = new ArrayList<>();
		fields = new ArrayList<>();
		String[] labels_name = {"���� ��ȣ", "�̡�����", "�н�����", "��������"};

		makeLabelAndField(labels_name);
		
		for (int i = 0; i < labels_name.length; i++) {
			fields.get(i).setEnabled(false);
		}
		
		btn = makeButton("�衡����");
		btn.addActionListener(new EmployeeInfoDelButton(fields));
		
		right_panel.add(btn, BorderLayout.SOUTH);
		
		staff_info.addMouseListener(new GetTableInfoForMouse(staff_info, fields));

		return right_panel;
	}

	public static void main(String[] args) {
		new EmployeesManagementFrame();
	}
}