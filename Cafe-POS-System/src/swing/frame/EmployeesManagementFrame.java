package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import action.BackButtonMouseAction;
import action.ChangePageActionForChooseFrame;
import action.EmployeeInfoAddButtonAction;
import action.EmployeeInfoDelButtonAction;
import action.EmployeeInfoUpdateButtonAction;
import action.GetTableInfoForMouseAction;
import jdbc.method.SelectEmployeeInfo;
import swing.method.BackButtonImgScale;
import swing.method.CurrentTimeClock;
import swing.method.LoginEmployeeInfoLabel;
	
public class EmployeesManagementFrame extends DefaultFrame {
	private String grade;
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

	private Color darkGray = new Color(161, 161, 161);
	private Font bold30 = new Font("���� ���", Font.BOLD, 30);
	
	public EmployeesManagementFrame(String grade) {
		this.grade = grade;
		setLayout(new BorderLayout());
		setTitle("Employees Management");

		// -- [CENTER] -- ��� ������ �г� ����
		center = new JPanel(new GridLayout());
		center.setBackground(Color.WHITE);

		// ���� ���� ���̺� ����(DB���� ���� �ҷ�����)
		staff_info = new SelectEmployeeInfo().getEmployeeInfo();
		// ���̺� �۾�ü ����
		staff_info.setFont(new Font("���� ���", Font.PLAIN, 23));
		// ���̺� �÷��� �̵� �Ұ�
		staff_info.getTableHeader().setReorderingAllowed(false);
		// ���̺� ���� ���� ����
		staff_info.setRowHeight(45);
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
		header.setBackground(new Color(0, 66, 56));
		header.setForeground(Color.WHITE);
		// ���̺� ���� �Ѿ�� ��ũ�ѹٷ� �����
		scroll_add_staff_info = new JScrollPane(staff_info);
		// ���̺� ������ �����Ϸ��� getViewport() �� setBackground()���
		scroll_add_staff_info.getViewport().setBackground(Color.WHITE);
		// JScrollPane�׵θ� ���ֱ�
		scroll_add_staff_info.setBorder(BorderFactory.createEmptyBorder());
		
		
		// ���� �г��� �����ʿ� �߰��� �г� ���� -> ������ �г� ������ �����
		right_panel_tab = new JTabbedPane();
		right_panel_tab.setFont(new Font("���� ���", Font.BOLD, 25));
		right_panel_tab.setBackground(Color.WHITE);
		right_panel_tab.addTab("���", enrollTab());
		right_panel_tab.addTab("����", updateTab());
		right_panel_tab.addTab("����", delTab());
		right_panel_tab.setUI(new BasicTabbedPaneUI()); // tab �׵θ� ����

		// -- [CENTER-TOP] --
		top_panel_body = new JPanel(new GridLayout());
		// �ڷ� ���� ��ư
//		JButton back_btn = new JButton("<<");
		JButton back_btn = new BackButtonImgScale().getBackBtn();
		back_btn.setFont(new Font("���� ���", Font.BOLD, 23));
		back_btn.setPreferredSize(new Dimension(100, 70));
		// GridLayout�� ���� ��ư �۾� ���� ����
		back_btn.setHorizontalAlignment(SwingConstants.LEFT);
		back_btn.setBackground(new Color(3, 102, 53));
		back_btn.setForeground(Color.WHITE);
		// ��ư �׵θ� ���ֱ�
		back_btn.setBorderPainted(false);
		// �̹��� �־ MouseListener�� ����.
		back_btn.addMouseListener(new BackButtonMouseAction(this, grade));
		
		top_panel_body.add(back_btn, BorderLayout.WEST);
		// ��� �ý��۽ð�
		JLabel clock = new CurrentTimeClock().setClock();
		clock.setFont(new Font("���� ���", Font.BOLD, 23));
		clock.setHorizontalAlignment(JLabel.CENTER);
		clock.setOpaque(true);
		clock.setBackground(new Color(3, 102, 53));
		clock.setForeground(Color.WHITE);
		top_panel_body.add(clock, BorderLayout.CENTER);
		
		// �����ʿ� �α����� ��� ����
		JPanel empInfo = new JPanel(new GridLayout(2, 1));
		empInfo.setBackground(new Color(3, 102, 53));
		
		JLabel label = new JLabel();
		label.setText("* ȯ���մϴ�. ���� �α��� *");
		label.setFont(new Font("���� ���", Font.PLAIN, 16));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setForeground(Color.WHITE);
		label.setBackground(new Color(3, 102, 53));
		
		JLabel login_name = LoginEmployeeInfoLabel.getLabel();
		login_name.setFont(new Font("���� ���", Font.BOLD, 19));
		login_name.setForeground(Color.WHITE);
		login_name.setHorizontalAlignment(JLabel.CENTER);
		login_name.setOpaque(true);
		login_name.setBackground(new Color(3, 102, 53));
		
		empInfo.add(label);
		empInfo.add(login_name);
		
		top_panel_body.add(empInfo, BorderLayout.EAST);

		
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
		btn.setFont(bold30);
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
			labels.get(i).setFont(bold30);
			// setOpaque(true) �� -> setBackground(Color)ä����
			labels.get(i).setOpaque(true);
			labels.get(i).setBackground(new Color(95, 148, 153));
			labels.get(i).setForeground(Color.WHITE);
			// ������ ����
			labels.get(i).setPreferredSize(new Dimension(200, 80));
			// �� Ƣ����� ����
			labels.get(i).setBorder(new BevelBorder(BevelBorder.RAISED));

			fields.add(new TextField(10));
			fields.get(i).setBackground(darkGray);
			fields.get(i).setForeground(Color.WHITE);
			fields.get(i).setFont(new Font("���� ���", Font.PLAIN, 60));

			right_panel.add(labels.get(i));
			right_panel.add(fields.get(i));
		}
	}

	// [���� ���� ��� ��]
	public JPanel enrollTab() {
		right_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 70));
		right_panel.setBackground(Color.WHITE);
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
		grade.setFont(bold30);
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
		grade_box.setPreferredSize(new Dimension(355, 80));
		grade_box.setBackground(darkGray);
		grade_box.setForeground(Color.WHITE);
		right_panel.add(grade_box);

		btn = makeButton("�����");
		btn.setBackground(new Color(32, 136, 181));
		btn.addActionListener(new EmployeeInfoAddButtonAction(fields, grade_box, staff_info));
		
		right_panel.add(btn, BorderLayout.SOUTH);

		return right_panel;
	}
	
	// [���� ���� ���� ��]
	public JPanel updateTab() {
		right_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 70));
		right_panel.setBackground(Color.WHITE);
		labels = new ArrayList<>();
		fields = new ArrayList<>();
		String[] labels_name = {"���� ���̵�", "�̡�����", "�н�����"};
		
		makeLabelAndField(labels_name);
		
		// ���� ���� �޺� �ڽ������� ���� �߰�
		JLabel grade = new JLabel("��������");
		grade.setHorizontalAlignment(JLabel.CENTER);
		grade.setFont(bold30);
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
		grade_box.setPreferredSize(new Dimension(355, 80));
		grade_box.setBackground(new Color(200, 200, 200));
		grade_box.setForeground(Color.WHITE);
		right_panel.add(grade_box);
		
		btn = makeButton("��������");
		btn.setBackground(new Color(153, 174, 30));
		btn.addActionListener(new EmployeeInfoUpdateButtonAction(fields, grade_box, staff_info));
		
		right_panel.add(btn, BorderLayout.SOUTH);
		
		// ���̺� �� �����ϸ� �� �������� �̺�Ʈ ����
		staff_info.addMouseListener(new GetTableInfoForMouseAction(staff_info, fields));
		
		// ���� ���� �� ���� ��ȣ, �̸� ���� �Ұ�
		fields.get(0).setEditable(false);
		fields.get(1).setEditable(false);
		
		return right_panel;
	}

	// [���� ���� ���� ��]
	public JPanel delTab() {
		right_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 70));
		right_panel.setBackground(Color.WHITE);
		labels = new ArrayList<>();
		fields = new ArrayList<>();
		String[] labels_name = {"���� ���̵�", "�̡�����", "�н�����", "��������"};

		makeLabelAndField(labels_name);
		
		// �ݺ������� �ϴϱ� �ʵ� ������ Ź������ ���� ����.
		fields.get(0).setEditable(false);
		fields.get(1).setEditable(false);
		fields.get(2).setEditable(false);
		fields.get(3).setEditable(false);
		
		btn = makeButton("�衡����");
		btn.setBackground(new Color(202, 64, 27));
		btn.addActionListener(new EmployeeInfoDelButtonAction(fields, staff_info));
		
		right_panel.add(btn, BorderLayout.SOUTH);
		
		staff_info.addMouseListener(new GetTableInfoForMouseAction(staff_info, fields));

		return right_panel;
	}

}