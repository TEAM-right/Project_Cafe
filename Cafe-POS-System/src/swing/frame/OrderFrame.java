package swing.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import action.CurrentTimeClock;
import jdbc.hikari.HikariCP;
import jdbc.view.button.DrinkButton;
import jdbc.view.button.EspressoButton;

public class OrderFrame extends DefaultFrame {
	
	static int i=0;
	public OrderFrame() {
		
		// �⺻�����Ӽ��� 
		setTitle("Cafe Project");
		setLayout(null);
		getContentPane().setBackground(new Color(245, 235, 208));
		
		// �����Ӿ����� ���� 
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("./image/icon.png");
		setIconImage(img);
		
		// ���̺� ����  
		String[] header =new String[]{"�ֹ���ȣ","��ǰ��","��ǰ����","����","�ɼ�"};
		DefaultTableModel model = new DefaultTableModel(header,0); //���̺� ������
		JTable table =new JTable(model);
		table.setOpaque(true);
		table.setBackground(new Color(62,110,255));
		table.setRowHeight(45);
		JScrollPane scrollpane = new JScrollPane(table);
		// ��ũ�ѹ� ũ�� ����
		scrollpane.setPreferredSize(new Dimension(620,620));
		//���̺� �����ġ ���� 
		scrollpane.setLocation(10,110);
		scrollpane.setSize(620,620);
		add(scrollpane);
		
        // info 
        ImageIcon infoImg = new ImageIcon("./image/icon.png");
        JLabel info = new JLabel(infoImg); 
        info.setBounds(10, 10, 250, 80);
        info.setHorizontalAlignment(JLabel.CENTER);
        add(info);
        
        // infoTime 
        JLabel infoTime = new CurrentTimeClock().setClock();
        infoTime.setFont(new Font("���� ���", Font.BOLD, 30));
        infoTime.setBounds(260, 10, 540, 80);
        infoTime.setHorizontalAlignment(JLabel.CENTER);
        infoTime.setOpaque(true); 
        infoTime.setBackground(new Color(0,110,63));
        infoTime.setForeground(new Color(255,255,255));
        add(infoTime);
        
        // info
        JLabel infouser = new JLabel(" ����� : ������ ");
        infouser.setOpaque(true);
        infouser.setFont(new Font("���� ���", Font.BOLD, 30));
        infouser.setBounds(800, 10, 540, 80);
        infouser.setHorizontalAlignment(JLabel.CENTER);
        infouser.setBackground(new Color(0,110,63));
        infouser.setForeground(new Color(255,255,255));
        add(infouser);
        
        //�ڷΰ��� ��ư 
        ImageIcon backbtn = new ImageIcon("./image/backbtn.jpg");
        JButton choosepage = new JButton(backbtn);
        choosepage.setOpaque(true);
        choosepage.setBounds(1340, 10, 140, 80);
        choosepage.setBackground(new Color(0,110,63));
        choosepage.setBorderPainted(false);
        add(choosepage);
        
        // Menu �� ���� 
        JTabbedPane Menu = new JTabbedPane();  //JTabbedPane����
        Menu.setFont(new Font("���� ���", Font.BOLD, 30));
         
        
        //������ ���� 
        JTabbedPane drinkmenu = new JTabbedPane();  //JTabbedPane����
        drinkmenu.setFont(new Font("���� ���", Font.BOLD, 30));
        
       
        Menu.addTab("����", drinkmenu);
        
        JPanel drink1 = new JPanel(); //JPanel ����
        JPanel drink2 = new JPanel(); //JPanel ����
        drink1.setLayout(new GridLayout(3,3));
        drink2.setLayout(new GridLayout(3,3));
        
        // �����꿡�������� ��ư 
        drinkmenu.addTab("�����꿡��������", drink1);	
		String �����꿡�������� = "SELECT * FROM drink_table WHERE M_TYPE_ID = 10";
		try (
				Connection conn = HikariCP.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(�����꿡��������);
				ResultSet rs = pstmt.executeQuery();
				) {
			while (rs.next()) {
				JButton �����꿡�������ҹ�ư= new DrinkButton(rs.getString(3), rs.getString(4));
				drink1.add(�����꿡�������ҹ�ư);
				
				// �����꿡�������ҹ�ư�׼� ������
				�����꿡�������ҹ�ư.addActionListener( new ActionListener(){ 
		           public void actionPerformed(ActionEvent e) {     	   
		
		        	   String[] row = new String[5];
		        	   
		        	   //{"�ֹ���ȣ","��ǰ��","��ǰ����","����","�ɼ�"
		        	   row[0]= "A00000000000000"+i;
		        	   i++;
		        	   row[1]=  "1";
		        	   row[2]= ((DrinkButton)e.getSource()).getMenuName();
		        	   row[3]= ((DrinkButton)e.getSource()).getPrice();
		        	   model.addRow(row);  
		        	   
		           }
		           	
		       });
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		 // ������帳 ��ư 
        drinkmenu.addTab("������帳", drink2);	
		String ������帳 = "SELECT * FROM drink_table WHERE M_TYPE_ID = 20";
		try (
				Connection conn = HikariCP.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(������帳);
				ResultSet rs = pstmt.executeQuery();
				) {
			while (rs.next()) {
				JButton ������帳��ư= new DrinkButton(rs.getString(3), rs.getString(4));
				drink2.add(������帳��ư);
				
				// �����꿡�������ҹ�ư�׼� ������
				������帳��ư.addActionListener( new ActionListener(){ 
		           public void actionPerformed(ActionEvent e) {     	   
		
		        	   String[] row = new String[5];
		        	   
		        	   //{"�ֹ���ȣ","��ǰ��","��ǰ����","����","�ɼ�"
		        	   row[0]= "A00000000000000"+i;
		        	   i++;
		        	   row[1]= ((DrinkButton)e.getSource()).getMenuName();
		        	   row[2]=  "1";
		        	   row[3]= ((DrinkButton)e.getSource()).getPrice();
		        	   row[4]= "";
		        	   model.addRow(row);  
		        	   
		           }
		           	
		       });
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
       
        Menu.setBounds(660, 110, 800, 500);
        add(Menu);
        
        
        //���� ��ư ���� 
		JButton ����= new JButton("����");
		����.setBounds(670, 630, 100, 100);
		add(����);
		
		//���� ��ư ���� 
		JButton ���� = new JButton("����");
		����.setBounds(780, 630, 100, 100);
		add(����);
		
		//���� �׼� ������
		����.addActionListener( new ActionListener(){ 
		           public void actionPerformed(ActionEvent e) {
		        	   
		        	   if( table.getSelectedRow() != -1){
		        		   model.removeRow(table.getSelectedRow());
		        	   }
		        	   
		           }  	
		 });
	
		
		setVisible(true);
		repaint();
	}
	
	
	public static void main(String[] args) {
		new OrderFrame();
	}
}
