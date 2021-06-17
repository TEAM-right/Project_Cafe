package swing.method;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import jdbc.method.SelectEmployeeInfo;

public class RenewalToTable {
	
	public RenewalToTable(JTable table) {
		// 1. ���ŵǱ� �� ���̺��� �Ű������� �޾� �𵨷� Ÿ��ĳ����
		DefaultTableModel originModel = (DefaultTableModel)table.getModel();
		// 2. ���ŵ� ���� SelectEmployeeInfo()Ŭ������ getModel()�޼��带 ���� �޾ƿ���
		DefaultTableModel updateModel = new SelectEmployeeInfo().getModel();
		// 3. ���� �� �� setRowCount(0)�޼���� ȭ�鿡�� ����
		originModel.setRowCount(0);
		// 4. �Ű������� ���� ���̺� �ٽ� ���ŵ� �� �ݿ�
		table.setModel(updateModel);
		updateModel.fireTableDataChanged();
		
		// 5. ���� ���̺��� �����ߴٰ� ���� ����ִ� ���̹Ƿ� �ٽ� ��� ���� �������
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}
}
