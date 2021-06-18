package action;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import jdbc.hikari.HikariCP;

public class UpdateConfirmBtn implements ActionListener {

   private JFrame frame;
   private JTextField tf, count;
   private String nameVal, countVal, name;
   private int countint;
   private JTable table;

   private DefaultTableCellRenderer dtcr_center;
   
   private Font system_font = new Font("���� ���", Font.BOLD, 20);
   Font bigger_font = new Font("���� ���", Font.BOLD, 50);
   Font big_font = new Font("���� ���", Font.BOLD, 30);
   Font nomal_font = new Font("���� ���", Font.PLAIN, 15);
   Font small_font = new Font("���� ���", Font.BOLD, 15);
   private String sql = "UPDATE stock_table SET stock_count = ? WHERE stock_name = ?";

   public UpdateConfirmBtn(JTextField count, JTable table, JFrame frame, String name) {
      this.frame = frame;
      this.table = table;
      this.count = count;
      this.name = name;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      try (Connection conn = HikariCP.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
         countVal = count.getText();

         countint = Integer.parseInt(countVal);

         pstmt.setInt(1, countint);
         pstmt.setString(2, name);
         ResultSet rs = pstmt.executeQuery();
         rs.close();
         DefaultTableModel originmodel = (DefaultTableModel) table.getModel();
         
         DefaultTableModel updatemodel = (DefaultTableModel) (new StockTableAddData().getStockTable().getModel());
         
         originmodel.setRowCount(0);
         
         table.setModel(updatemodel);
         
         table.getTableHeader().setReorderingAllowed(false); // ���̺� ��� �̵� �ȵǰ� �ϱ�
         table.getTableHeader().setBackground(new Color(163, 148, 132));// �÷��� ������ ����
         table.getTableHeader().setFont(new Font("���� ���", Font.BOLD, 25));
         table.getTableHeader().setForeground(Color.white);
         
         String[] header = new StockTableAddData().give_header();
         
         table.getColumn(header[0]).setPreferredWidth(160); // �÷��� ���� �����ε� ��� �÷��� ���̺��� ���̿� '����' �°� �����ؾ���
         table.getColumn(header[1]).setPreferredWidth(900);
         table.getColumn(header[2]).setPreferredWidth(160);
         table.setFont(nomal_font);
         
         dtcr_center = new DefaultTableCellRenderer();
         
         dtcr_center.setHorizontalAlignment(SwingConstants.CENTER); // dtcr_center�� ��ġ�� center�� ����
         
         TableColumnModel ts = table.getColumnModel(); // ������ ���̺��� columnModel�� ������
         ts.getColumn(0).setCellRenderer(dtcr_center);// product_id �÷��� ���� ����
         ts.getColumn(1).setCellRenderer(dtcr_center);
         ts.getColumn(2).setCellRenderer(dtcr_center);
         
         updatemodel.fireTableDataChanged();
         
//         UIManager.put("OptionPane.messageFont", system_font);
         JOptionPane.showMessageDialog(null, "�������� �����Ǿ����ϴ�", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
         frame.dispose();
      } catch (SQLDataException e3) {
//        UIManager.put("OptionPane.messageFont", system_font);
        JOptionPane.showMessageDialog(null, "�Է� ������ ���ڸ� ������ϴ�.", "SYSTEM", JOptionPane.ERROR_MESSAGE);
      } catch (SQLException e1) {
         e1.printStackTrace();
      } catch (NumberFormatException e2) {
//         UIManager.put("OptionPane.messageFont", system_font);
         JOptionPane.showMessageDialog(null, "������ �߸� �Է��ϼ̽��ϴ�.", "SYSTEM", JOptionPane.ERROR_MESSAGE);
      }

   }

}