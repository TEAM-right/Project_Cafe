package swing.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import action.BackButtonMouseActionForOrderFrame;
import action.MenuButtonAction;
import action.MenuListNextButton;
import action.MenuListPrevButton;
import action.MenuMinusButton;
import action.MenuOptionButtonAction;
import action.MenuPlusButton;
import action.PaymentFinishButton;
import action.TableAllDelete;
import jdbc.model.MenuButton;
import jdbc.model.MenuButtonData;
import jdbc.model.OptionButton;
import swing.method.BackButtonImgScale;
import swing.method.CurrentTimeClock;
import swing.method.LoginEmployeeInfoLabel;
import swing.view.DrinkView;
import swing.view.OptionView;
import swing.view.ProductView;
import swing.view.RtdView;

public class OrderFrame extends DefaultFrame {
	private String grade;
	private JPanel center;
	private JPanel top;
	private JTable table;
	private JScrollPane scrollPane;
	private JTabbedPane menu;
	private JTabbedPane drinks;
	private JTabbedPane products;
	private JTabbedPane rtds;
	private JTabbedPane option;
	private ArrayList<String> name;
	private ArrayList<Integer> price;
	private ArrayList<MenuButton> btns;
	private JPanel menuPanelBase;
	private JPanel menuPanelBase_center;
	private JPanel menuPanelBase_south;
	private ArrayList<JPanel> menuPanels;
	private static DefaultTableModel model;
	private static int tablemoney = 0;
	private static int totalPrice;
	private static ArrayList<MenuButtonData> tableInfo;
	private static JLabel totalmoney = new JLabel("");
	private static Map<String, Integer> MenuHash = new HashMap<>();

	static {
		tableInfo = new ArrayList<MenuButtonData>();
	}

	public static JLabel getTotalmoney() {
		return totalmoney;
	}

	public static DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public static void setTotalmoney(JLabel totalmoney) {
		OrderFrame.totalmoney = totalmoney;
	}

	public static int getTablemoney() {
		return tablemoney;
	}

	public static void setTablemoney(int tablemoney) {
		OrderFrame.tablemoney = tablemoney;
	}

	public static Map<String, Integer> GetMenuHash() {
		return MenuHash;
	}

	public static ArrayList<MenuButtonData> GettableInfo() {
		return tableInfo;
	}

	public OrderFrame(String grade, String order_name) {
		this.grade = grade;
		setLayout(new BorderLayout());
		setTitle("Point Of Sale");

		// [CENTER] �г� ����
		center = new JPanel(new GridLayout());
		center.setBackground(Color.WHITE);

		// [TOP] �г� ����
		top = new JPanel(new GridLayout(1, 3));

		JButton payment = new JButton("����");
		payment.setFont(new Font("���� ���", Font.BOLD, 30));
		payment.setBackground(new Color(3, 102, 53));
		payment.setForeground(Color.WHITE);

		// table �� �� �հ� ��
		JLabel total = new JLabel("�� �հ�");
		total.setFont(new Font("���� ���", Font.BOLD, 30));
		total.setHorizontalAlignment(JLabel.CENTER);
		totalmoney.setFont(new Font("���� ���", Font.PLAIN, 30));
		totalmoney.setHorizontalAlignment(JLabel.CENTER);

		// �ڷΰ��� ��ư
//		JButton choosepage = new JButton("<<");
		JButton choosepage = new BackButtonImgScale().getBackBtn();
		choosepage.setOpaque(true);
		choosepage.setBackground(new Color(3, 102, 53));
		choosepage.setBorderPainted(false);
		choosepage.setHorizontalAlignment(JButton.LEFT);
		choosepage.setForeground(Color.WHITE);
		top.add(choosepage);

		// infoTime
		JLabel infoTime = new CurrentTimeClock().setClock();
		infoTime.setFont(new Font("���� ���", Font.BOLD, 23));
		infoTime.setBounds(260, 10, 540, 80);
		infoTime.setHorizontalAlignment(JLabel.CENTER);
		infoTime.setOpaque(true);
		infoTime.setBackground(new Color(3, 102, 53));
		infoTime.setForeground(Color.WHITE);
		top.add(infoTime);

		// info
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
		
		top.add(empInfo);

		// ============================================== Menu Plus, Minus, Size ��ư ����
		JPanel plusMinus = new JPanel(new GridLayout(1, 2));
		JPanel size = new JPanel(new GridLayout(1, 3));
		JButton plusBtn = new JButton("+");
		plusBtn.setFont(new Font("���� ���", Font.BOLD, 40));
		plusBtn.setBackground(Color.WHITE);
		JButton MinusBtn = new JButton("-");
		MinusBtn.setFont(new Font("���� ���", Font.BOLD, 40));
		MinusBtn.setBackground(Color.WHITE);
		// ============================================== ������ ��ư ���� ����
		ArrayList<String> sizeName = new OptionView(130).getName();
		ArrayList<Integer> sizePrice = new OptionView(130).getPrice();
		ArrayList<OptionButton> sizeBtn = new ArrayList<>();
		for (int i = 0; i < sizeName.size(); i++) {
			sizeBtn.add(new OptionButton(sizeName.get(i), sizePrice.get(i)));
			sizeBtn.get(i).setBackground(Color.WHITE);
		}
		// ============================================== ��ü �޴� ����ϴ� ��ư ����
		JButton allDelBtn = new JButton("��ü ���");
		allDelBtn.setFont(new Font("���� ���", Font.BOLD, 30));
		allDelBtn.setBackground(new Color(3, 102, 53));
		allDelBtn.setForeground(Color.WHITE);
		

		// [CENTER-LEFT] �г� ����
		JPanel center_left = new JPanel(new BorderLayout());

		// [CENTER-LEFT-SOUTH] �г� ���� // �гθ��� Ŭ���� ������
		JPanel left_south = new JPanel(new GridLayout(3, 2));
		left_south.setBackground(Color.WHITE);

		// [CENTER-LEFT-CENTER]���̺� ���� // ���̺� �޼��� ����
		String[] header = { "����", "�޴�", "����", "�ݾ�" };
		// ���̺� ����Ŭ�� ���� ����
		model = new DefaultTableModel(header, 0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		table = new JTable(model);
		// ���̺� ���� ���� ����
		table.setRowHeight(35);
		table.getTableHeader().setReorderingAllowed(false); // �÷��� �̵� �Ұ�
		table.getTableHeader().setResizingAllowed(false); // �÷� ũ�� ���� �Ұ�
		// ���̺� �÷� ��� ����
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();

		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}

		// ��� ����, ���� �ʺ� ����
		JTableHeader hd = table.getTableHeader();
		hd.setPreferredSize(new Dimension(100, 45));
		hd.setFont(new Font("���� ���", Font.BOLD, 25));
		hd.setBackground(new Color(0, 66, 56));
		hd.setForeground(Color.WHITE);
		// ��� ���� ����
		table.getColumn(header[0]).setPreferredWidth(50);
		table.getColumn(header[1]).setPreferredWidth(350);
		table.getColumn(header[2]).setPreferredWidth(50);
		table.getColumn(header[3]).setPreferredWidth(100);

		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(750, 500));
		scrollPane.getViewport().setBackground(Color.WHITE); // ���̺� ��� �Ͼ�� �����
		scrollPane.setBorder(BorderFactory.createEmptyBorder()); // �̰Ŵ� ���̺� �׵θ� ������
		scrollPane.getHorizontalScrollBar();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // ���� ��ũ�ѹ� ��� ���̰��ϱ�
		scrollPane.setBackground(Color.WHITE);

		// [CENTER-RIGHT] �޴� �� ����
		menu = new JTabbedPane();
		menu.setFont(new Font("���� ���", Font.BOLD, 23));
		menu.setUI(new BasicTabbedPaneUI()); // �� �׵θ� �����Ǵ� ��Ÿ�Ϸ� ����
		menu.setBackground(Color.WHITE);

		// ���� �� ����
		drinks = new JTabbedPane();
		drinks.setFont(new Font("���� ���", Font.PLAIN, 30));
		// ���δ�Ʈ �� ����
		products = new JTabbedPane();
		products.setFont(new Font("���� ���", Font.PLAIN, 30));
		// RTD �� ����
		rtds = new JTabbedPane();
		rtds.setOpaque(true);
		rtds.setFont(new Font("���� ���", Font.PLAIN, 14));
		// �ɼ� �� ����
		option = new JTabbedPane();
		option.setFont(new Font("���� ���", Font.PLAIN, 14));
		// �ǿ� ������ �׸�� �߰�
		menu.addTab("����", drinks);
		menu.addTab("Ǫ��", products);
		menu.addTab("RTD", rtds);
		menu.addTab("�ɼ�", option);

		// ���� ��ư�� �߰�(Ÿ�� 10�� ~ 100������)
		for (int i = 0; i < 11; i++) {
			String[] typeName = { "������ ����������", "������ �帳", "�ݵ� ���", "��е�", "����������", "��ī����", "����Ǫġ��", "�����", "������", "Ƽ�ٳ�",
					"��Ÿ" };
			drinks.addTab(typeName[i], makeItemButtons("drink", 10 * (i + 1)));
			drinks.setFont(new Font("���� ���", Font.BOLD, 13));
			drinks.setOpaque(true);
			drinks.setBackground(Color.WHITE);
		}
		// Ǫ�� ��ư�� �߰� (Ÿ�� 140�� ~ 200������)
		for (int i = 0; i <= 6; i++) {
			String[] typeName = { "�극��", "����ũ/�̴� ����Ʈ", "������ġ/������", "������ Ǫ��", "����/���Ʈ", "����", "���̽�ũ��" };
			products.addTab(typeName[i], makeItemButtons("product", 140 + (10 * i)));
			products.setFont(new Font("���� ���", Font.BOLD, 13));
			products.setOpaque(true);
			products.setBackground(Color.WHITE);
		}
		// RTD ��ư�� �߰� (Ÿ�� 210)
		rtds.addTab("RTD", makeItemButtons("RTD", 210));
		rtds.setOpaque(true);
		rtds.setBackground(Color.WHITE);
		rtds.setFont(new Font("���� ���", Font.BOLD, 13));
		// �ɼ� ��ư�� �߰� (Ÿ�� 120)
		option.addTab("�ɼ�", makeItemButtons("option", 120));
		option.setOpaque(true);
		option.setBackground(Color.WHITE);
		option.setFont(new Font("���� ���", Font.BOLD, 13));

		// ���̺���� ��ư ��� ����
		MinusBtn.addActionListener(new MenuMinusButton(table, totalmoney, tablemoney));
		allDelBtn.addActionListener(new TableAllDelete(table, tableInfo));
		plusBtn.addActionListener(new MenuPlusButton(table));
		choosepage.addMouseListener(new BackButtonMouseActionForOrderFrame(this, table, grade, order_name));
		payment.addActionListener(new PaymentFinishButton(table, order_name));
		

		plusMinus.add(plusBtn);
		plusMinus.add(MinusBtn);
		for (int i = 0; i < sizeBtn.size(); i++) {
			size.add(sizeBtn.get(i));
			sizeBtn.get(i).setFont(new Font("���� ���", Font.PLAIN, 20));
			sizeBtn.get(i).addActionListener(new MenuOptionButtonAction(table, sizeName.get(i), sizePrice.get(i)));
		}

		center_left.add(scrollPane, BorderLayout.CENTER);
		center_left.add(left_south, BorderLayout.SOUTH);
		
		left_south.add(total); // �� �հ�
		left_south.add(totalmoney); // �� �ݾ�
		left_south.add(plusMinus); // ��-�� ��ư
		left_south.add(size); // ������ ��ư 3��
		left_south.add(allDelBtn); // ��ü ��� ��ư
		left_south.add(payment); // ������ư


		center.add(center_left);
		center.add(menu);

		add(top, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);

		setVisible(true);
		repaint();
	}

	private ArrayList<MenuButton> itemButtons(String itemType, int typeNum) {
		// Ÿ���� �޾Ƽ� �ٷ� ��ư �����(�ѹ��� ���� �ʹ� ������ �Ǽ� itemType�޾ƿ���)
		// View�����ߴµ� -> �̸�/���� ���� �޾ƿ� �� �־��
		if (itemType.equals("drink")) {
			name = new DrinkView(typeNum).getName();
			price = new DrinkView(typeNum).getPrice();
		} else if (itemType.equals("product")) {
			name = new ProductView(typeNum).getName();
			price = new ProductView(typeNum).getPrice();
		} else if (itemType.equals("RTD")) {
			name = new RtdView().getName();
			price = new RtdView().getPrice();
		} else if (itemType.equals("option")) {
			name = new OptionView(typeNum).getName();
			price = new OptionView(typeNum).getPrice();
		}

		// ��ư�� ���� ArrayList<>()�� �޾Ƽ� �������� ��. MenuButton(�̸�, ����)
		btns = new ArrayList<>();
		for (int i = 0; i < name.size(); i++) {
			btns.add(new MenuButton(name.get(i), price.get(i)));
			btns.get(i).setPreferredSize(new Dimension(182, 188));
			btns.get(i).setFont(new Font("���� ���", Font.BOLD, 13));
//			btns.get(i).setBackground(new Color(213, 213, 213));
//			btns.get(i).setForeground(Color.WHITE);
			btns.get(i).setBackground(Color.WHITE);
			if (itemType.equals("option")) {
				btns.get(i).addActionListener(new MenuOptionButtonAction(table, name.get(i), price.get(i)));
			} else {
				btns.get(i).addActionListener(new MenuButtonAction(table, name.get(i), price.get(i)));
			}
		}

		return btns;
	}

	private JPanel makeItemButtons(String itemType, int typeNum) {
		// �޴� �ǵ� �ȿ� �� ���̽� �г� �����
		menuPanelBase = new JPanel(new BorderLayout());
		// ���̽��� ���Ϳ� �� �гο� ī�� ���̾ƿ� �����ϱ�
		menuPanelBase_center = new JPanel(new CardLayout());
		// ���̽��� �ؿ� ��ư�� �� �г� �����
		menuPanelBase_south = new JPanel(new GridLayout());
		menuPanelBase_south.setBackground(Color.WHITE);
		// ���̽� ���Ϳ� �� �гε� ����Ʈ�� �����
		menuPanels = new ArrayList<>();

		// ��ǰ Ÿ���� �ִ� �׸� ��ư���� ��� ����
		btns = itemButtons(itemType, typeNum);
		// <ī��� ������� �г� ����> ��ư ������ �޾Ƽ� ��� (4 x 4)����
		for (int i = 0; i < btns.size() / 16 + 1; i++) {
			menuPanels.add(new JPanel(new FlowLayout(FlowLayout.LEFT, 1, 1))); // �׳� FlowLayout ��ư ũ�� ���缭 ����
			menuPanels.get(i).setBackground(Color.WHITE);
		}

		// ��ư�� ���� �ν��ؼ� 16������� �����ֱ� .... �ϴ� �� ���� ��� ���� �� ������ ���� �ּ��� �̰ſ���..
		for (int i = 0; i < btns.size(); ++i) {
			switch (i / 16) {
			case 0:
				menuPanels.get(0).add(btns.get(i));
				break;
			case 1:
				menuPanels.get(1).add(btns.get(i));
				break;
			case 2:
				menuPanels.get(2).add(btns.get(i));
				break;
			case 3:
				menuPanels.get(3).add(btns.get(i));
				break;
			}
		}

		// ������� �г� ������ŭ CardLayout������ �гο� �߰����ش�.
		for (int i = 0; i < menuPanels.size(); i++) {
			menuPanelBase_center.add("page" + (i + 1), menuPanels.get(i));
		}

		// �ϴܿ� ������ �ѱ� ��ư �߰�
		JButton prev = new JButton("<<");
		prev.setFont(new Font("���� ���", Font.BOLD, 20));
		prev.setHorizontalAlignment(SwingConstants.RIGHT);
		prev.setContentAreaFilled(false);
		prev.setBorderPainted(false);
		JLabel pageNum = new JLabel("Page1");
		pageNum.setHorizontalAlignment(JLabel.CENTER);
		pageNum.setFont(new Font("���� ���", Font.BOLD, 20));
		JButton next = new JButton(">>");
		next.setFont(new Font("���� ���", Font.BOLD, 20));
		next.setContentAreaFilled(false);
		next.setBorderPainted(false);
		next.setHorizontalAlignment(SwingConstants.LEFT);
		
		prev.addActionListener(new MenuListPrevButton(menuPanelBase_center, pageNum, menuPanels));
		next.addActionListener(new MenuListNextButton(menuPanelBase_center, pageNum, menuPanels));

		menuPanelBase_south.add(prev);
		menuPanelBase_south.add(pageNum);
		menuPanelBase_south.add(next);

		menuPanelBase.add(menuPanelBase_center, BorderLayout.CENTER);
		menuPanelBase.add(menuPanelBase_south, BorderLayout.SOUTH);

		return menuPanelBase;
	}
}