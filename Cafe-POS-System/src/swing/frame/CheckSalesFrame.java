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

import action.ChangePageActionForChooseFrame;
import action.CheckSalesSelectButton;
import action.CurrentTimeClock;
import jdbc.method.TotalComboAddData;
import jdbc.method.TotalInfo;

public class CheckSalesFrame extends DefaultFrame {

   private JPanel center;
   private JPanel center_top;
   private JPanel top_panel_body;

   public CheckSalesFrame() {
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

      JButton select_btn = new JButton("������ȸ");
      setJButtonStyle(select_btn); // �⺻ ��ư ��Ÿ�� ���� �޼ҵ� ȣ��
      select_btn.addActionListener(new CheckSalesSelectButton(
    		  this, select_btn, model, total_model, jt, jt2, year_combo, month_combo));

      center_top.add(sortation_txt);
      center_top.add(year_combo);
      center_top.add(month_combo);
      center_top.add(select_btn);

      center.add(center_top, BorderLayout.NORTH);
      center.add(jscroll);

      // -- [CENTER-TOP] --
      top_panel_body = new JPanel(new GridLayout());
      
      // �ڷ� ���� ��ư
      JButton back_btn = new JButton("<<");
      back_btn.setPreferredSize(new Dimension(100, 80));
      back_btn.setFont(new Font("�ü�", Font.BOLD, 30));
      
      // GridLayout�� ���� ��ư �۾� ���� ����
      back_btn.setHorizontalAlignment(SwingConstants.LEFT);
      back_btn.setBackground(new Color(110, 88, 68));
      back_btn.setForeground(Color.WHITE);
      
      // ��ư �׵θ� ���ֱ�
      back_btn.setBorderPainted(false);
      back_btn.addActionListener(new ChangePageActionForChooseFrame(this));
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

      add(top_panel_body, BorderLayout.NORTH);
      add(center, BorderLayout.CENTER);
      add(jscroll2, BorderLayout.SOUTH);

      setVisible(true);
   }

   // JLabel �⺻ ��Ÿ�� ���� �޼���
   public static void setJLabelStyle(JLabel txt) {
      txt.setPreferredSize(new Dimension(200, 50));
      txt.setOpaque(true); // setBackground �����ϱ� ���� ���� ����
      txt.setBackground(new Color(95, 148, 153)); // ��׶��� ���� ����
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
      btn.setBackground(new Color(232, 114, 36)); // ��׶��� ���� ����
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
      header.setBackground(new Color(163, 148, 132));
      header.setForeground(Color.WHITE);
      
      // �÷� �̵� �Ұ�
      table.getTableHeader().setReorderingAllowed(false);
      
      // �� �۾� Ű���
      table.setFont(new Font("���� ���", Font.PLAIN, 20));
      
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

   public static void main(String[] args) {
      new CheckSalesFrame();
   }

}
