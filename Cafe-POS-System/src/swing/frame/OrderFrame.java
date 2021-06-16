package swing.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import action.CurrentTimeClock;
import action.MenuButtonAction;
import action.MenuListNextButton;
import action.MenuListPrevButton;
import action.MenuPlusButton;
import action.OrdertableDeleteAction;
import jdbc.model.MenuButton;
import swing.view.DrinkView;
import swing.view.ProductView;
import swing.view.RtdView;

public class OrderFrame extends DefaultFrame {

   private JPanel center;
   private JPanel top;
   private JPanel west;
   private JPanel south;
   private JTable table;
   private JScrollPane scrollPane;
   private JTabbedPane menu;
   private JTabbedPane drinks;
   private JTabbedPane products;
   private JTabbedPane rtds;
   private ArrayList<String> name;
   private ArrayList<Integer> price;
   private ArrayList<MenuButton> btns;
   private JPanel menuPanelBase;
   private JPanel menuPanelBase_center;
   private JPanel menuPanelBase_south;
   private ArrayList<JPanel> menuPanels;
   private DefaultTableModel model;
   static int tablemoney = 0;
   static JLabel totalmoney = new JLabel(String.valueOf(tablemoney));

   public OrderFrame() {
      setLayout(new BorderLayout());
      setTitle("Cafe-Project");
      
      // �����Ӿ����� ���� 
   		Toolkit toolkit = Toolkit.getDefaultToolkit();
   		Image img = toolkit.getImage("./image/icon.png");
   		setIconImage(img);

      // [CENTER]�г� ����
      center = new JPanel(new GridLayout());
      center.setBackground(new Color(243, 243, 243));

      // [TOP]�г� ����
      top = new JPanel(new GridLayout());
      
      // [west]�г� ����
     
      JButton ���� = new JButton("����");
      ����.setFont(new Font("���� ���", Font.BOLD, 30));
      ����.setBounds(600, 600, 50, 50);
 
      JButton delete = new JButton("-");
      delete.setFont(new Font("���� ���", Font.BOLD, 30));
      JLabel ���հ� = new JLabel("���հ�");
      ���հ�.setFont(new Font("���� ���", Font.BOLD, 30));
      totalmoney.setFont(new Font("���� ���", Font.BOLD, 30));
      

      // info 
      ImageIcon infoImg = new ImageIcon("./image/icon.png");
      JLabel info = new JLabel(infoImg); 
      info.setOpaque(true);
      info.setBounds(10, 10, 250, 80);
      info.setBackground(new Color(0,110,63));
      info.setHorizontalAlignment(JLabel.LEFT);
      top.add(info);
      
      // infoTime 
      JLabel infoTime = new CurrentTimeClock().setClock();
      infoTime.setFont(new Font("���� ���", Font.BOLD, 30));
      infoTime.setBounds(260, 10, 540, 80);
      infoTime.setHorizontalAlignment(JLabel.CENTER);
      infoTime.setOpaque(true); 
      infoTime.setBackground(new Color(0,110,63));
      infoTime.setForeground(new Color(255,255,255));
      top.add(infoTime);
      
      // info
      JLabel infouser = new JLabel(" ����� : ������ ");
      infouser.setOpaque(true);
      infouser.setFont(new Font("���� ���", Font.BOLD, 30));
      infouser.setBounds(800, 10, 540, 80);
      infouser.setHorizontalAlignment(JLabel.CENTER);
      infouser.setBackground(new Color(0,110,63));
      infouser.setForeground(new Color(255,255,255));
      top.add(infouser);
      
      //�ڷΰ��� ��ư 
      ImageIcon backbtn = new ImageIcon("./image/backbtn.jpg");
      JButton choosepage = new JButton(backbtn);
      choosepage.setOpaque(true);
      choosepage.setBounds(1340, 10, 140, 80);
      choosepage.setBackground(new Color(0,110,63));
      choosepage.setBorderPainted(false);
      top.add(choosepage);
      
      // table_plus ��ư ���� 
      JButton tplus = new JButton("+");
      
      // [CENTER-LEFT] �г� ����
      JPanel center_left = new JPanel(new BorderLayout());
      
      // [CENTER-LEFT_SOUTH] �г� ����
      JPanel left_south = new JPanel(new GridLayout(3,2));
      
      // [CENTER-LEFT]���̺� ����
      String[] header = { "��ȣ", "��ǰ��", "��ǰ����", "����" };
      model = new DefaultTableModel(header, 0);
      table = new JTable(model);
      // ���̺� ���� ���� ����
      table.setRowHeight(50);

      // ��� ����, ���� �ʺ� ����
      JTableHeader hd = table.getTableHeader();
      hd.setPreferredSize(new Dimension(100, 50));
      hd.setFont(new Font("���� ���", Font.BOLD, 25));
      hd.setBackground(new Color(163, 148, 132));
      hd.setForeground(Color.WHITE);

      scrollPane = new JScrollPane(table);
      scrollPane.setPreferredSize(new Dimension(750, 500));
      scrollPane.getViewport().setBackground(Color.WHITE); // ���̺� ��� �Ͼ�� �����
      scrollPane.setBorder(BorderFactory.createEmptyBorder()); // �̰Ŵ� ���̺� �׵θ� ������

      // [CENTER-RIGHT]�޴� �� ����
      menu = new JTabbedPane();
      menu.setFont(new Font("���� ���", Font.BOLD, 30));
      menu.setBackground(new Color(95, 148, 153));
      menu.setForeground(Color.WHITE);
      
      // ���� �� ����
      drinks = new JTabbedPane();
      // ���δ�Ʈ �� ����
      products = new JTabbedPane();
      products.setFont(new Font("���� ���", Font.BOLD, 30));
      products.setBackground(new Color(95, 148, 153));
      products.setForeground(Color.WHITE);
      
      // RTD �� ����
      rtds = new JTabbedPane();

      // �ǿ� ������ �׸�� �߰�
      menu.addTab("����", drinks);
      menu.addTab("Ǫ��", products);
      menu.addTab("RTD", rtds);

      // ���� ��ư�� �߰�(Ÿ�� 10�� ~ 100������)
      for (int i = 0; i < 11; i++) {
         String[] typeName = {"<HTML>������<br>����������</HTML>", "<HTML>������<br>�帳</HTML>",
               "�ݵ� ���", "��е�", "����������", "��ī����", "����Ǫġ��", "�����", "������", "Ƽ�ٳ�", "��Ÿ"};
         drinks.addTab(typeName[i], makeItemButtons("drink",10 * (i + 1)));
         drinks.setFont(new Font("���� ���", Font.BOLD, 13));
      }

      // Ǫ�� ��ư�� �߰� (Ÿ�� 140�� ~ 200������)s
      for (int i = 0; i <= 6; i++) {
         String[] typeName = { "�극��", "����ũ/�̴� ����Ʈ", "������ġ/������", "������ Ǫ��", "����/���Ʈ", "����", "���̽�ũ��" };
         products.addTab(typeName[i], makeItemButtons("product", 140 + (10 * i)));
         products.setFont(new Font("���� ���", Font.BOLD, 13));
      }
     

      // RTD��ư �߰� (Ÿ�� 210)
      rtds.addTab("RTD", makeItemButtons("RTD", 210));
      
    
      // ���̺���� ��ư ��� ����
      delete.addActionListener(new OrdertableDeleteAction(table,totalmoney,tablemoney));
      
      center_left.add(scrollPane,BorderLayout.CENTER);
      center_left.add(left_south,BorderLayout.SOUTH);
      
      left_south.add(���հ�);
      left_south.add(totalmoney);
      left_south.add(tplus);
      left_south.add(delete);
      left_south.add(����);
      
      
      tplus.addActionListener(new MenuPlusButton(table));
      
      center.add(center_left);
      center.add(menu);    
      
      add(top, BorderLayout.NORTH);
      add(center, BorderLayout.CENTER);
      
      totalmoney.setText(String.valueOf(tablemoney));

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
      }

      // ��ư�� ���� ArrayList<>()�� �޾Ƽ� �������� ��. MenuButton(�̸�, ����)
      btns = new ArrayList<>();
      for (int i = 0; i < name.size(); i++) {
         btns.add(new MenuButton(name.get(i), price.get(i)));
         btns.get(i).setPreferredSize(new Dimension(180, 180));
         btns.get(i).setFont(new Font("���� ���", Font.BOLD, 15));
         btns.get(i).setForeground(Color.white);
         btns.get(i).setBackground(new Color(161, 161, 161));
         btns.get(i).addActionListener(new MenuButtonAction(name.get(i) , price.get(i),table ,totalmoney));
      }
      
      btns.get(0).getName();
      return btns;
   }
   
   private JPanel makeItemButtons(String itemType, int typeNum) {
      // �޴� �ǵ� �ȿ� �� ���̽� �г� �����
      menuPanelBase = new JPanel(new BorderLayout());
      // ���̽��� ���Ϳ� �� �гο� ī�� ���̾ƿ� �����ϱ�
      menuPanelBase_center = new JPanel(new CardLayout());
      // ���̽��� �ؿ� ��ư�� �� �г� �����
      menuPanelBase_south = new JPanel(new GridLayout());
      menuPanelBase_south.setBackground(new Color(243, 243, 243));
      // ���̽� ���Ϳ� �� �гε� ����Ʈ�� �����
      menuPanels = new ArrayList<>();
      
      // ��ǰ Ÿ���� �ִ� �׸� ��ư���� ��� ����
      btns = itemButtons(itemType, typeNum);
      // <ī��� ������� �г� ����> ��ư ������ �޾Ƽ� ��� (4 x 4)����
      for (int i = 0; i < btns.size() / 16 + 1; i++) {
         menuPanels.add(new JPanel(new GridLayout(4, 5)));
         menuPanels.get(i).setBackground(new Color(243, 243, 243));
      }
      
      // ��ư�� ���� �ν��ؼ� 16������� �����ֱ� .... �ϴ� �� ���� ��� ���� �� ������ ���� �ּ��� �̰ſ���..
      for (int i = 0; i < btns.size(); i++) {
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
      prev.setFont(new Font("���� ���", Font.BOLD, 30));
      prev.setHorizontalAlignment(SwingConstants.RIGHT);
      prev.setContentAreaFilled(false);
      prev.setBorderPainted(false);
      JLabel pageNum = new JLabel("������ ��ȣ");
      pageNum.setFont(new Font("���� ���", Font.BOLD, 30));
      JButton next = new JButton(">>");
      next.setFont(new Font("���� ���", Font.BOLD, 30));
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
   
   public static void main(String[] args) {
      new OrderFrame();
   }

}