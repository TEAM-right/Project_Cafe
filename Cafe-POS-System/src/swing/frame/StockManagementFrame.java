package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import action.ChangePageActionForChooseFrame;
import action.CurrentTimeClock;
import action.StockAddBtnListener;
import action.StockDeleteBtnListener;
import action.StockGetTableVal;
import action.StockTableAddData;
import action.StockUpdateBtnListener;

public class StockManagementFrame extends DefaultFrame {

	private JPanel topPanel;
	private JPanel center;
	private JPanel right_panel;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel title_label;
	private JButton add_btn, update_btn, delete_btn, null_btn;
	private DefaultTableCellRenderer dtcr_center, dtcr_right;

	Font bigger_font = new Font("���� ���", Font.BOLD, 40);
	Font big_font = new Font("���� ���", Font.BOLD, 30);
	Font nomal_font = new Font("���� ���", Font.PLAIN, 15);
	Font small_font = new Font("���� ���", Font.BOLD, 15);

	public StockManagementFrame() {
		setLayout(new BorderLayout());
		setTitle("Stock Management");

		// [TOP]
		topPanel = new JPanel(new GridLayout(1, 3));
		// �ڷ� ���� ��ư
		JButton back_btn = new JButton("<<");
		back_btn.setPreferredSize(new Dimension(100, 70));
		back_btn.setFont(new Font("�ü�", Font.BOLD, 30));
		back_btn.setBackground(new Color(3, 102, 53));
		back_btn.setForeground(Color.WHITE);
		back_btn.setBorderPainted(false);
		topPanel.add(back_btn, BorderLayout.WEST);
		back_btn.setHorizontalAlignment(SwingConstants.LEFT);
		back_btn.addActionListener(new ChangePageActionForChooseFrame(this));

		// ��� �ý��۽ð�
		JLabel clock = new CurrentTimeClock().setClock();
		clock.setFont(new Font("���� ���", Font.BOLD, 25));
		clock.setHorizontalAlignment(JLabel.CENTER);
		clock.setOpaque(true);
		clock.setBackground(new Color(3, 102, 53));
		clock.setForeground(Color.WHITE);
		topPanel.add(clock, BorderLayout.CENTER);
		// �����ʿ� �α����� ��� ���� �߰��� ����
		JLabel login_name = new JLabel("���� ����");
		login_name.setFont(new Font("���� ���", Font.BOLD, 30));
		login_name.setForeground(Color.WHITE);
		login_name.setHorizontalAlignment(JLabel.CENTER);
		login_name.setOpaque(true);
		login_name.setBackground(new Color(3, 102, 53));
		topPanel.add(login_name, BorderLayout.EAST);

		// [CENTER]
		center = new JPanel(new BorderLayout());
		center.setBackground(Color.WHITE);
		// ���̺� ����
		table = new StockTableAddData().getStockTable();
		// ============================================== ���̺�
		// ���̺� ����
		table.setOpaque(true);
		table.setRowHeight(40);
		// ��ũ�ѹ� ũ�� ����
		// ���̺� �����ġ ����
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1000, 500));
		scrollPane.setLocation(20, 20);
		scrollPane.setSize(1160, 610);
		scrollPane.setBorder(BorderFactory.createEmptyBorder()); // ���̺� �׵θ� ����

		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.getTableHeader().setFont(new Font("���� ���", Font.BOLD, 25));
		table.getTableHeader().setReorderingAllowed(false); // ���̺� ��� �̵� �ȵǰ� �ϱ�
		table.getTableHeader().setBackground(new Color(0, 66, 56));// �÷��� ������ ����
		table.getTableHeader().setForeground(Color.WHITE);
		table.setRowHeight(40);

		String[] header = new StockTableAddData().give_header();

		table.getColumn(header[0]).setPreferredWidth(160); // �÷��� ���� �����ε� ��� �÷��� ���̺��� ���̿� '����' �°� �����ؾ���
		table.getColumn(header[1]).setPreferredWidth(900);
		table.getColumn(header[2]).setPreferredWidth(160);
		table.setFont(nomal_font);

		dtcr_center = new DefaultTableCellRenderer();
		dtcr_right = new DefaultTableCellRenderer();

		dtcr_center.setHorizontalAlignment(SwingConstants.CENTER); // dtcr_center�� ��ġ�� center�� ����
		dtcr_right.setHorizontalAlignment(SwingConstants.RIGHT);

		TableColumnModel ts = table.getColumnModel(); // ������ ���̺��� columnModel�� ������
		ts.getColumn(0).setCellRenderer(dtcr_center);// product_id �÷��� ���� ����
		ts.getColumn(1).setCellRenderer(dtcr_center);
		ts.getColumn(2).setCellRenderer(dtcr_center);

		table.addMouseListener(new StockGetTableVal(table));

		// [CENTER-TOP]
		// ======================================================= title label
//		title_label = new JLabel("  ��� ��Ȳ");
//		title_label.setBackground(Color.BLACK);
//		title_label.setFont(bigger_font);

		// [CENTER-RIGHT]
		// ======================================================= ��ư �з�
		// CENTER-RIGHT�� ��ư �߰��� �� ����
		right_panel = new JPanel(new GridLayout(4, 1));
		null_btn = new JButton("");
		add_btn = new JButton("ADD");
		update_btn = new JButton("UPDATE");
		delete_btn = new JButton("DELETE");

		// ======================================================= null_btn
		null_btn.setPreferredSize(new Dimension(250, 100));
		null_btn.setEnabled(false);
		null_btn.setBorderPainted(false);
		null_btn.setBackground(Color.WHITE);
		// ======================================================= all_btn
		add_btn.setFont(new Font("���� ���", Font.BOLD, 40));
		add_btn.setPreferredSize(new Dimension(250, 100));
		add_btn.setBackground(new Color(53, 84, 0));
		add_btn.setForeground(Color.WHITE);
		add_btn.addActionListener(new StockAddBtnListener(table));
		// ==================================== ���� (update) ��ư
		update_btn.setFont(new Font("���� ���", Font.BOLD, 40));
		update_btn.setPreferredSize(new Dimension(250, 100));
		update_btn.addActionListener(new StockUpdateBtnListener(table));
		update_btn.setBackground(new Color(95, 148, 153));
		update_btn.setForeground(Color.WHITE);
		// ==================================== delete ��ư
		delete_btn.setFont(new Font("���� ���", Font.BOLD, 40));
		delete_btn.setPreferredSize(new Dimension(250, 100));
		delete_btn.addActionListener(new StockDeleteBtnListener(table));
		delete_btn.setBackground(new Color(232, 114, 36));
		delete_btn.setForeground(Color.WHITE);

		right_panel.add(null_btn);
		right_panel.add(add_btn);
		right_panel.add(update_btn);
		right_panel.add(delete_btn);

//		center.add(title_label, BorderLayout.NORTH);
		center.add(scrollPane, BorderLayout.CENTER);
		center.add(right_panel, BorderLayout.EAST);

		add(topPanel, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);

		setVisible(true);
	}

	public static void main(String[] args) {
		new StockManagementFrame();
	}

}
