package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import action.ExitAccumulatedResults;

public class AccumulatedResultsFrame extends DefaultFrame{
	
	public AccumulatedResultsFrame(AccumulatedFundFrame accumulatedFundFrame,
			String phoneNum, int point, int coupon) {
		accumulatedFundFrame.dispose();
		
		//�⺻ ������ ����
		setTitle("ȸ�� ����");
		setSize(330,430);
		setLocation(500,180);
		setResizable(false);
		getContentPane().setBackground(new Color(243, 235, 207));
		
		//���� �г� ���� ���� �г�
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0,0,330,310);
		mainPanel.setLayout(new GridLayout(3,1,10,10));
		mainPanel.setBackground(new Color(243, 235, 207));
		
		
		//�����г�,�� ����
		ArrayList<JPanel> subPanelArr = new ArrayList<>();
		ArrayList<JLabel> labelArr = new ArrayList<>();
		
		JLabel label1 = new JLabel(String.format(" ��ȭ��ȣ%20s", phoneNum));
		JLabel label2 = new JLabel(String.format(" ��������Ʈ%20s%s", point, "p"));
		JLabel label3 = new JLabel(String.format(" ��������%20s%s", coupon, "��"));
		
		JPanel subPanel;
		for(int i = 0; i < 3; i++) {
			//�����г�
			subPanelArr.add(new JPanel());
			JPanel panel = subPanelArr.get(i);
			panel.setBackground(new Color(255,255,255));
			
			mainPanel.add(panel);
			
			//�� ����Ʈ�� �� �߰�
			labelArr.add(label1);
			labelArr.add(label2);
			labelArr.add(label3);
			
			subPanel = subPanelArr.get(i);
			//�����г� ���̾ƿ��� null ����(setBounds �ϱ� ����)
			subPanel.setLayout(null);
			
			//�����гο� �� �߰�
			subPanel.add(labelArr.get(i));
	
		}
		
		//�� ��ġ�� ��Ʈ ��Ÿ�� ����
		labelStyle(label1);
		labelStyle(label2);
		labelStyle(label3);
		
		//��ư
		JButton btn = new JButton("Ȯ��");
		btn.setFont(new Font("���� ���",Font.PLAIN,16));
		btn.setBackground(new Color(115,185,112));
		btn.setForeground(Color.white);
		btn.setBounds(110, 325, 90, 50);
		btn.setBorderPainted(false);

		//Ȯ�� ������ ����
		btn.addActionListener(new ExitAccumulatedResults());
		
		add(mainPanel);
		add(btn);
	
		setVisible(true);
		repaint();
	
	}
	
	//�� ��Ÿ�� �޼���
	private void labelStyle(JLabel label) {
		label.setBounds(60, 0, 330, 100);
		label.setForeground(Color.GRAY);
		label.setFont(new Font("���� ���",Font.PLAIN,14));
		
	}
}












