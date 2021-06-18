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

public class AddConfirmBtn implements ActionListener {

	private JFrame frame;
	private JTextField name, count;
	private String nameVal, countVal;
	private int countint;
	private JTable table;
	private DefaultTableCellRenderer dtcr_center;
	Font bigger_font = new Font("���� ���", Font.BOLD, 50);
	Font big_font = new Font("���� ���", Font.PLAIN, 30);
	Font nomal_font = new Font("���� ���", Font.BOLD, 15);
	Font small_font = new Font("���� ���", Font.BOLD, 15);
	private Color y_color = new Color(163, 148, 132);
	private String sql = "INSERT INTO stock_table VALUES ('A0000000' || TO_CHAR(stock_id_seq.nextval), ?, ?)";

	public AddConfirmBtn(JTextField name, JTextField count, JTable table, JFrame frame) {
		this.frame = frame;
		this.table = table;
		this.name = name;
		this.count = count;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		try (Connection conn = HikariCP.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			nameVal = name.getText();
			if (nameVal.isEmpty()) {
				JOptionPane.showMessageDialog(null, "�̸��� �Է����ּ���.", "SYSTEM", JOptionPane.WARNING_MESSAGE);
			} else {
				countVal = count.getText();
				countint = Integer.parseInt(countVal);
				
				System.out.println(countint);
				System.out.println(nameVal);
				
				pstmt.setString(1, nameVal);
				pstmt.setString(2, countVal);
				ResultSet rs = pstmt.executeQuery();
				rs.close();
				DefaultTableModel originmodel = (DefaultTableModel) table.getModel();
				
				DefaultTableModel updatemodel = (DefaultTableModel) (new StockTableAddData().getStockTable().getModel());
				
				originmodel.setRowCount(0);
				
				table.setModel(updatemodel);
				
				table.getTableHeader().setReorderingAllowed(false); // ���̺� ��� �̵� �ȵǰ� �ϱ�
				table.getTableHeader().setBackground(y_color);// �÷��� ������ ����
				table.getTableHeader().setFont(big_font);
				table.getTableHeader().setForeground(Color.white);
				
				String[] header = new StockTableAddData().give_header();
				
				table.getColumn(header[0]).setPreferredWidth(160); // �÷��� ���� �����ε� ��� �÷��� ���̺��� ���̿� '����' �°� �����ؾ���
				table.getColumn(header[1]).setPreferredWidth(900);
				table.getColumn(header[2]).setPreferredWidth(160);
				table.setFont(new Font("���� ���", Font.PLAIN, 20));
				
				dtcr_center = new DefaultTableCellRenderer();
				
				dtcr_center.setHorizontalAlignment(SwingConstants.CENTER); // dtcr_center�� ��ġ�� center�� ����
				
				TableColumnModel ts = table.getColumnModel(); // ������ ���̺��� columnModel�� ������
				ts.getColumn(0).setCellRenderer(dtcr_center);// product_id �÷��� ���� ����
				ts.getColumn(1).setCellRenderer(dtcr_center);
				ts.getColumn(2).setCellRenderer(dtcr_center);
				
				updatemodel.fireTableDataChanged();
				
//			UIManager.put("OptionPane.messageFont", nomal_font);
				JOptionPane.showMessageDialog(null, "�����Ͱ� �߰��Ǿ����ϴ�.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
			}
		} catch (SQLDataException e3) {
//            UIManager.put("OptionPane.messageFont", system_font);
            JOptionPane.showMessageDialog(null, "�Է� ������ ���ڸ� ������ϴ�.", "SYSTEM", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e2) {
//			UIManager.put("OptionPane.messageFont", nomal_font);
			JOptionPane.showMessageDialog(null, "������ �߸� �Է��ϼ̽��ϴ�.", "SYSTEM", JOptionPane.ERROR_MESSAGE);
			System.out.println(e2);
		}

	}

}