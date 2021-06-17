package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import action.ChangePageButton;
import action.ChangePageButtonForBackBtn;
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
	private JScrollPane scroll_add_staff_info;
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
		header.setBackground(new Color(163, 148, 132));
		header.setForeground(Color.WHITE);
		// ���̺� ���� �Ѿ�� ��ũ�ѹٷ� �����
		scroll_add_staff_info = new JScrollPane(staff_info);
		// ���̺� ������ �����Ϸ��� getViewport() �� setBackground()���
		scroll_add_staff_info.getViewport().setBackground(Color.WHITE);
		// JScrollPane�׵θ� ���ֱ�
		scroll_add_staff_info.setBorder(BorderFactory.createEmptyBorder());
		
		
		// ���� �г��� �����ʿ� �߰��� �г� ���� -> ������ �г� ������ �����
		right_panel_tab = new JTabbedPane();
		right_panel_tab.setFont(new Font("���� ���", Font.BOLD, 30));
		right_panel_tab.setBackground(new Color(95, 148, 153));
		right_panel_tab.setForeground(Color.WHITE);
		right_panel_tab.addTab("���", enrollTab());
		right_panel_tab.addTab("������", updateTab());
		right_panel_tab.addTab("�衡��", delTab());
		// ?? �̰��ϴϱ� �׵θ� ��������
		right_panel_tab.setUI(new BasicTabbedPaneUI());

		// -- [CENTER-TOP] --
		top_panel_body = new JPanel(new GridLayout());
		// �ڷ� ���� ��ư
		ImageIcon btnImage = new ImageIcon("./image/BackButton.png");
		Image img = btnImage.getImage();
		Image changeImg = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JButton back_btn = new JButton(changeIcon);
		back_btn.setPreferredSize(new Dimension(100, 80));
		back_btn.setFont(new Font("�ü�", Font.BOLD, 30));
		// GridLayout�� ���� ��ư �۾� ���� ����
		back_btn.setHorizontalAlignment(SwingConstants.LEFT);
		back_btn.setBackground(new Color(110, 88, 68));
		back_btn.setForeground(Color.WHITE);
		// ��ư �׵θ� ���ֱ�
		back_btn.setBorderPainted(false);
		// �̹��� �־ MouseListener�� ����.
		back_btn.addMouseListener(new ChangePageButtonForBackBtn(this));
		
		top_panel_body.add(back_btn, BorderLayout.WEST);
		// ��� �ý��۽ð�
		JLabel clock = new CurrentTimeClock().setClock();
		clock.setFont(new Font("���� ���", Font.BOLD, 30));
		clock.setHorizontalAlignment(JLabel.CENTER);
		clock.setOpaque(true);
		clock.setBackground(new Color(110, 88, 68));
		clock.setForeground(Color.WHITE);
		top_panel_body.add(clock, BorderLayout.CENTER);
		
		// �����ʿ� �α����� ��� ���� �߰��� ����
		JLabel login_name = new JLabel("���� ����");
		login_name.setFont(new Font("���� ���", Font.BOLD, 30));
		login_name.setForeground(Color.WHITE);
		login_name.setHorizontalAlignment(JLabel.CENTER);
		login_name.setOpaque(true);
		login_name.setBackground(new Color(110, 88, 68));
		top_panel_body.add(login_name, BorderLayout.EAST);

		
		// [CENTER�� �гε� add]
		// -- [CENTER-LEFT] --
		center.add(scroll_add_staff_info);
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
		btn.setBackground(new Color(232, 114, 36));
		btn.setForeground(Color.WHITE);
		btn.setBorderPainted(false);
		
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
			labels.get(i).setBackground(new Color(95, 148, 153));
			labels.get(i).setForeground(Color.WHITE);
			// ������ ����
			labels.get(i).setPreferredSize(new Dimension(200, 80));
			// �� Ƣ����� ����
			labels.get(i).setBorder(new BevelBorder(BevelBorder.RAISED));

			fields.add(new TextField(12));
			fields.get(i).setFont(new Font("���� ���", Font.PLAIN, 50));
			fields.get(i).setBackground(new Color(161, 161, 161));
			fields.get(i).setForeground(Color.WHITE);

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
		
		JLabel notice = new JLabel("<HTML>�� ȯ���մϴ�. ���� ������ ������ּ���.<br>&nbsp;&nbsp;&nbsp;"
				+ "(���� ���̵�� �ڵ� ���� �˴ϴ�.)</HTML>");
		notice.setFont(new Font("���� ���", Font.BOLD, 18));
		notice.setForeground(Color.DARK_GRAY);
		notice.setPreferredSize(new Dimension(490, 45));
		notice.setHorizontalAlignment(JLabel.CENTER);
		right_panel.add(notice);
		
		makeLabelAndField(labels_name);
		
		// ���� ���� �޺��ڽ������� ���� �߰�
		JLabel grade = new JLabel("��������");
		grade.setHorizontalAlignment(JLabel.CENTER);
		grade.setFont(new Font("���� ���", Font.BOLD, 30));
		grade.setPreferredSize(new Dimension(200, 80));
		grade.setBorder(new BevelBorder(BevelBorder.RAISED));
		grade.setOpaque(true);
		grade.setBackground(new Color(95, 148, 153));
		grade.setForeground(Color.WHITE);
		right_panel.add(grade);
		// ���� �޺��ڽ�
		String[] grade_list = { "BARISTA", "MANAGER" };
		JComboBox<String> grade_box = new JComboBox<>(grade_list);
		grade_box.setFont(new Font("���� ���", Font.PLAIN, 50));
		grade_box.setPreferredSize(new Dimension(360, 80));
		grade_box.setBackground(new Color(161, 161, 161));
		grade_box.setForeground(Color.WHITE);
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
		String[] labels_name = {"���� ���̵�", "�̡�����", "�н�����"};
		
		makeLabelAndField(labels_name);
		
		// ���� ���� �޺� �ڽ������� ���� �߰�
		JLabel grade = new JLabel("��������");
		grade.setHorizontalAlignment(JLabel.CENTER);
		grade.setFont(new Font("���� ���", Font.BOLD, 30));
		grade.setPreferredSize(new Dimension(200, 80));
		grade.setBorder(new BevelBorder(BevelBorder.RAISED));
		grade.setOpaque(true);
		grade.setBackground(new Color(95, 148, 153));
		grade.setForeground(Color.WHITE);
		right_panel.add(grade);
		// ���� �޺��ڽ�
		String[] grade_list = { "BARISTA", "MANAGER" };
		JComboBox<String> grade_box = new JComboBox<>(grade_list);
		grade_box.setFont(new Font("���� ���", Font.PLAIN, 50));
		grade_box.setPreferredSize(new Dimension(360, 80));
		grade_box.setBackground(new Color(161, 161, 161));
		grade_box.setForeground(Color.WHITE);
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
		String[] labels_name = {"���� ���̵�", "�̡�����", "�н�����", "��������"};

		makeLabelAndField(labels_name);
		
		// �ݺ������� ������� ���ϰ� �ϴϱ� Ź������ ���� ����..
		fields.get(0).setEditable(false);
		fields.get(1).setEditable(false);
		fields.get(2).setEditable(false);
		fields.get(3).setEditable(false);
		
		btn = makeButton("�衡����");
		btn.setBackground(new Color(202, 64, 27));
		btn.addActionListener(new EmployeeInfoDelButton(fields, staff_info));
		
		right_panel.add(btn, BorderLayout.SOUTH);
		
		staff_info.addMouseListener(new GetTableInfoForMouse(staff_info, fields));

		return right_panel;
	}

	public static void main(String[] args) {
		new EmployeesManagementFrame();
	}
}