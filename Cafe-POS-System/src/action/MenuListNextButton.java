package action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuListNextButton implements ActionListener {

   private JPanel cardPanel;
   private JLabel pageLabel;
   private ArrayList<JPanel> panels;
   
   
   public MenuListNextButton(JPanel cardPanel, JLabel pageLabel, ArrayList<JPanel> panels) {
      this.cardPanel = cardPanel;
      this.pageLabel = pageLabel;
      this.panels = panels;
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
	  int i = 1;
      // ī�� ���̾ƿ��� �ѱ�� ���ؼ��� ���̾ƿ��� ������ �����̳��� �ν��Ͻ��� �ʿ��ϴ�. ī�� ���̾ƿ��� ������ JPanel�� �Ѱܹ���
      CardLayout card = (CardLayout)cardPanel.getLayout();
      
      // ������ �ѹ� �Է��� ��
      // ī�巹�̾ƿ��� ��� ArrayList���� �޾Ƽ�, ������ �ε����� isVisible()�� �ƴ� ��츸 next�ǰ� ����
      if (!panels.get(panels.size() - 1).isVisible()) {
         card.next(cardPanel);
         i++;
         pageLabel.setText("( " + i + " / " + panels.size() + " )");
      }
      
      if (panels.get(panels.size() - 1).isVisible()) {
    	  pageLabel.setText("( " + panels.size() + " / " + panels.size() + " )");
    	  i = 1;
      }
      
   }
   
}