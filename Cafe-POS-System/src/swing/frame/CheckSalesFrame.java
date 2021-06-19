package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import action.BackButtonMouseAction;
import action.ChangePageActionForChooseFrame;
import action.CheckSalesSelectButton;
import jdbc.method.TotalComboAddData;
import jdbc.method.TotalInfo;
import swing.method.BackButtonImgScale;
import swing.method.CurrentTimeClock;
import swing.method.LoginEmployeeInfoLabel;

public class CheckSalesFrame extends DefaultFrame {

	private JPanel center;
	private JPanel center_top;
	private JPanel top_panel_body;
	private String order_name, grade;
	public CheckSalesFrame(String grade, String order_name) {
		this.order_name = order_name;
		this.grade = grade;
		setLayout(new BorderLayout());
		setTitle("���� ��ȸ");

		center = new JPanel(new BorderLayout());
		center_top = new JPanel(new GridLayout());

		JLabel sortation_txt = new JLabel("��������");
		setJLabelStyle(sortation_txt);

		JComboBox year_combo = new TotalComboAddData().year_getComboBox();
		setJComboBoxStyle(year_combo);

		JComboBox month_combo = new TotalComboAddData().month_getComboBox();
		setJComboBoxStyle(month_combo);

		// �Ϲ� ���� ��ȸ
		DefaultTableModel model = new TotalInfo().getTotalInfo();
		JTable jt = new JTable(model);
		model.fireTableDataChanged();
		JScrollPane jscroll = new JScrollPane(jt);

		// JScrollPane�׵θ� ���ֱ�
		jscroll.setBorder(BorderFactory.createEmptyBorder());
		jscroll.getViewport().setBackground(Color.WHITE);
		setJTableStyle(jt);

		// �� ���� ��ȸ
		DefaultTableModel total_model = new TotalInfo().getTotalInfoTotal();
		JTable jt2 = new JTable(total_model);
		total_model.fireTableDataChanged();
		JScrollPane jscroll2 = new JScrollPane(jt2);
		jscroll2.setBorder(BorderFactory.createEmptyBorder());
		setJTableStyle(jt2);
		jt2.setRowHeight(80);
		jt2.setFont(new Font("���� ���", Font.BOLD, 35));
		jt2.setPreferredScrollableViewportSize(new Dimension(200, 80));
		jscroll2.getViewport().setBackground(Color.WHITE);

		JButton select_btn = new JButton("������ȸ");
		setJButtonStyle(select_btn); // �⺻ ��ư ��Ÿ�� ���� �޼ҵ� ȣ��
		select_btn.addActionListener(
				new CheckSalesSelectButton(this, select_btn, model, total_model, jt, jt2, year_combo, month_combo));
		select_btn.setBackground(new Color(200, 50, 0));

		center_top.add(sortation_txt);
		center_top.add(year_combo);
		center_top.add(month_combo);
		center_top.add(select_btn);

		center.add(center_top, BorderLayout.NORTH);
		center.add(jscroll);

		// -- [CENTER-TOP] --
		top_panel_body = new JPanel(new GridLayout());

		// �ڷ� ���� ��ư
//		JButton back_btn = new JButton("<<");
		JButton back_btn = new BackButtonImgScale().getBackBtn();
		back_btn.setPreferredSize(new Dimension(100, 70));
		back_btn.setFont(new Font("�ü�", Font.BOLD, 23));
		back_btn.addMouseListener(new BackButtonMouseAction(this, grade, order_name));

		// GridLayout�� ���� ��ư �۾� ���� ����
		back_btn.setHorizontalAlignment(SwingConstants.LEFT);
		back_btn.setBackground(new Color(3, 102, 53));
		back_btn.setForeground(Color.WHITE);

		// ��ư �׵θ� ���ֱ�
		back_btn.setBorderPainted(false);
		back_btn.addActionListener(new ChangePageActionForChooseFrame(this, grade, order_name));
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

		add(top_panel_body, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(jscroll2, BorderLayout.SOUTH);

		setVisible(true);
	}

	// JLabel �⺻ ��Ÿ�� ���� �޼���
	public static void setJLabelStyle(JLabel txt) {
		txt.setPreferredSize(new Dimension(200, 50));
		txt.setOpaque(true); // setBackground �����ϱ� ���� ���� ����
		txt.setBackground(new Color(175, 162, 38)); // ��׶��� ���� ����
		txt.setForeground(Color.WHITE); // �ؽ�Ʈ ���� ����
		txt.setFont(new Font("���� ���", Font.BOLD, 30)); // ��Ʈ ����
		txt.setHorizontalAlignment(JLabel.CENTER); // �ؽ�Ʈ ���� ǥ�� ����
	}

	// JComboBox �⺻ ��Ÿ�� ���� �޼���
	public static void setJComboBoxStyle(JComboBox<String> combo) {
		combo.setBackground(Color.LIGHT_GRAY); // ��׶��� ���� ����
		combo.setForeground(Color.WHITE); // �ؽ�Ʈ ���� ����
		combo.setFont(new Font("���� ���", Font.BOLD, 20)); // ��Ʈ ����
	}

	// JButton �⺻ ��Ÿ�� ���� �޼���
	public static void setJButtonStyle(JButton btn) {
		btn.setPreferredSize(new Dimension(200, 50));
		btn.setBackground(new Color(255, 224, 140)); // ��׶��� ���� ����
		btn.setForeground(Color.WHITE); // �ؽ�Ʈ ���� ����
		btn.setFont(new Font("���� ���", Font.BOLD, 30)); // ��Ʈ ����
		btn.setHorizontalAlignment(JLabel.CENTER); // �ؽ�Ʈ ���� ǥ�� ����
	}

	// JTable �⺻ ��Ÿ�� ���� �޼���
	public static void setJTableStyle(JTable table) {
		// ���̺� ��� ũ�� ����
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(100, 40));
		header.setFont(new Font("���� ���", Font.BOLD, 25));
		header.setBackground(new Color(0, 66, 56));
		header.setForeground(Color.WHITE);

		// �÷� �̵� �Ұ�
		table.getTableHeader().setReorderingAllowed(false);

		// �� �۾� Ű���
		table.setFont(new Font("���� ���", Font.PLAIN, 15));

		// �� ���� ����
		table.setRowHeight(25);

		// ���̺� �÷� ��� ����
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}
}
