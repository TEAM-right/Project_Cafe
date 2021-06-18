package action;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import jdbc.hikari.HikariCP;
import swing.frame.StockUpdateFrame;

public class StockDeleteBtnListener implements ActionListener {

	private JTable table;
	private String name;
	String id;
	private int count;

	private DefaultTableCellRenderer dtcr_center;
	private Font nomal_font = new Font("���� ���", Font.PLAIN, 20);
	private Font system_font = new Font("���� ���", Font.BOLD, 20);
	private Font small_font = new Font("���� ���", Font.BOLD, 15);
	private String sql = "DELETE FROM stock_table WHERE stock_id = ?";

	public StockDeleteBtnListener(JTable table) {
		this.table = table;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow(); // ������ ���� �� ��ȣ ���
		TableModel model = table.getModel();

		if (row == -1) {
			UIManager.put("OptionPane.messageFont", nomal_font);
			JOptionPane.showMessageDialog(null, "���� ����", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
		} else {
			id = (String) model.getValueAt(row, 0);

			try (Connection conn = HikariCP.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			DefaultTableModel originmodel = (DefaultTableModel) table.getModel();

			DefaultTableModel updatemodel = (DefaultTableModel) (new StockTableAddData().getStockTable().getModel());

			originmodel.setRowCount(0);

			table.setModel(updatemodel);

			table.getTableHeader().setReorderingAllowed(false); // ���̺� ��� �̵� �ȵǰ� �ϱ�
			table.getTableHeader().setBackground(new Color(163, 148, 132));// �÷��� ������ ����
			table.getTableHeader().setFont(new Font("���� ���", Font.BOLD, 30));
			table.getTableHeader().setForeground(Color.white);

			String[] header = new StockTableAddData().give_header();

			table.getColumn(header[0]).setPreferredWidth(100); // �÷��� ���� �����ε� ��� �÷��� ���̺��� ���̿� '����' �°� �����ؾ���
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

			UIManager.put("OptionPane.messageFont", system_font);
			JOptionPane.showMessageDialog(null, "���ǰ���� �����Ǿ����ϴ�", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
