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

import action.CurrentTimeClock;
import action.EmployeeInfoAddButton;
import action.EmployeeInfoDelButton;
import action.EmployeeInfoUpdateButton;
import action.GetTableInfoForMouse;
import jdbc.method.SelectEmployeeInfo;

public class StaffManagementFrame extends DefaultFrame {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StaffManagementFrame() {
      setLayout(new BorderLayout());
      setTitle("Employees Management");
      
      // -- CENTER
      // ��� ������ �г� ����(1�� 2��)
      JPanel center = new JPanel(new GridLayout());
      
      // -- CENTER-LEFT
      // ������ �������̺� ���ʿ� �߰�(1, 1)��°
      JTable staff_info = new SelectEmployeeInfo().getEmployeeInfo();
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
      JScrollPane scorll_add_staff_info = new JScrollPane(staff_info);
      // ���̺� �� �����ϸ� �� �������� �̺�Ʈ ����
      staff_info.addMouseListener(new GetTableInfoForMouse(staff_info));
      
      
      // -- CENTER-RIGHT
      // ���� �г��� ������ ���� ����(1, 2)��°
      // JTabbedPane() �� ����� -> ������ �г� ������ �����
      JTabbedPane right_panel_tab = new JTabbedPane();
      right_panel_tab.setFont(new Font("���� ���", Font.BOLD, 30));
      right_panel_tab.setBackground(new Color(161, 192, 90));
      right_panel_tab.addTab("���", createTab("���"));
      right_panel_tab.addTab("����", createTab("����"));
      right_panel_tab.addTab("����", createTab("����"));
      
      // -- CENTER-TOP �ڷ� ���� ��ư
      JPanel top_panel_body = new JPanel(new GridLayout());
      JButton back_btn = new JButton("<<");
      back_btn.setPreferredSize(new Dimension(100, 80));
      back_btn.setFont(new Font("�ü�", Font.BOLD, 30));
      back_btn.setBackground(new Color(0, 60, 0));
      back_btn.setForeground(Color.WHITE);
      top_panel_body.add(back_btn, BorderLayout.WEST);
      // ��� �ý��۽ð�
      JLabel clock = new CurrentTimeClock().setClock();
      clock.setFont(new Font("���� ���", Font.PLAIN, 30));
      clock.setHorizontalAlignment(JLabel.CENTER);
      clock.setOpaque(true);
      clock.setBackground(Color.pink);
      top_panel_body.add(clock, BorderLayout.CENTER);
      // �����ʿ� �α����� ��� ���� �߰��ҷ��� �ϴ� �ӽ�
      JLabel login_name = new JLabel("����");
      login_name.setFont(new Font("���� ���", Font.PLAIN, 30));
      login_name.setHorizontalAlignment(JLabel.CENTER);
      login_name.setOpaque(true);
      login_name.setBackground(Color.cyan);
      top_panel_body.add(login_name, BorderLayout.EAST);

      // CENTER�� �гε� add
      center.add(scorll_add_staff_info);
      center.add(right_panel_tab);
      
      // Frame�� �г� ��ġ �����ϰ� �߰�
      add(top_panel_body, BorderLayout.NORTH);
      add(center, BorderLayout.CENTER);
      
      setVisible(true);
   }
   
   public JPanel createTab (String tab_name) {
      JPanel right_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 50));
      ArrayList<JLabel> labels = new ArrayList<>();
      ArrayList<TextField> fields = new ArrayList<>();
      String[] labels_name = {"�̡�����", "�н�����"};
      
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
      String[] grade_list = {"BARISTA", "MANAGER"};
      JComboBox<String> grade_box = new JComboBox<>(grade_list);
      grade_box.setFont(new Font("���� ���", Font.PLAIN, 30));
      grade_box.setPreferredSize(new Dimension(365, 80));
      right_panel.add(grade_box);
      
      JButton btn = new JButton(tab_name);
      btn.setPreferredSize(new Dimension(200, 80));
      btn.setFont(new Font("���� ���", Font.BOLD, 30));

      
      // ��ư�� ���, ����, ���� �׼� �߰�
      switch (tab_name) {
      case "���":
    	  btn.addActionListener(new EmployeeInfoAddButton(fields, grade_box));
    	  break;
      case "����":
    	  btn.addActionListener(new EmployeeInfoUpdateButton(fields, grade_box));
    	  break;
      case "����":
    	  btn.addActionListener(new EmployeeInfoDelButton(fields, grade_box));
    	  break;
      }
      
      right_panel.add(btn, BorderLayout.SOUTH);
      
      
      return right_panel;
   }
   
   public static void main(String[] args) {
      new StaffManagementFrame();
   }
}