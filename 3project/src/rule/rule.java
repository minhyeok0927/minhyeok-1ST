package rule;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main_1.main_1;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class rule extends JFrame {

   private JPanel contentPane;
   private ImageIcon tabletIcon1;
   private ImageIcon tabletIcon2;
   private ImageIcon tabletIcon3;
   private ImageIcon tabletIcon4;
   private ImageIcon tabletIcon5;
   private ImageIcon tabletIcon6;
   private ImageIcon tabletIcon7;
   private ImageIcon tabletIcon8;
   private ImageIcon chiIcon1;
   

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               rule frame = new rule();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public rule() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(430, 150, 1068, 739);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      
		contentPane.setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
      
      // 그림 뒤집기
      JButton btnNewButton_1 = new JButton("");
      
      String icon6 = "./src/grimbang/game1_R.png";
      ImageIcon tabletIcon5_1 = new ImageIcon(icon6);

      // 이미지 크기 조정
      Image scaledImage6 = tabletIcon5_1.getImage().getScaledInstance(353, 253, Image.SCALE_SMOOTH);
      tabletIcon5 = new ImageIcon(scaledImage6);
      btnNewButton_1.setIcon(tabletIcon5);
      
      btnNewButton_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            new game1_rule().setVisible(true);
         }
      });
      btnNewButton_1.setBounds(137, 94, 353, 253);
      contentPane.add(btnNewButton_1);
      
      // tts
      JButton btnNewButton_2 = new JButton("");
      
      
      String icon7 = "./src/grimbang/game2_R.png";
      ImageIcon tabletIcon7 = new ImageIcon(icon7);

      // 이미지 크기 조정
      Image scaledImage7 = tabletIcon7.getImage().getScaledInstance(344, 244, Image.SCALE_SMOOTH);
      tabletIcon6 = new ImageIcon(scaledImage7);
      btnNewButton_2.setIcon(tabletIcon6);
      
      btnNewButton_2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            new game2_rule().setVisible(true);
         }
      });
      btnNewButton_2.setBounds(564, 97, 350, 243);
      contentPane.add(btnNewButton_2);
      
      // 행맨
      JButton btnNewButton_3 = new JButton("");
      
      
      String icon8 = "./src/grimbang/game3_R.png";
      ImageIcon tabletIcon7_1 = new ImageIcon(icon8);

      // 이미지 크기 조정
      Image scaledImage8 = tabletIcon7_1.getImage().getScaledInstance(350, 250, Image.SCALE_SMOOTH);
      tabletIcon7 = new ImageIcon(scaledImage8);
      btnNewButton_3.setIcon(tabletIcon7);
      
      btnNewButton_3.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {

            new game3_rule().setVisible(true);
         }
      });
      btnNewButton_3.setBounds(142, 393, 350, 250);
      contentPane.add(btnNewButton_3);
      
      // 숫자야구
      JButton btnNewButton_4 = new JButton("");
      
      String icon9 = "./src/grimbang/game4_R.png";
      ImageIcon tabletIcon8_1 = new ImageIcon(icon9);

      // 이미지 크기 조정
      Image scaledImage9 = tabletIcon8_1.getImage().getScaledInstance(347, 245, Image.SCALE_SMOOTH);
      tabletIcon8 = new ImageIcon(scaledImage9);
      btnNewButton_4.setIcon(tabletIcon8);
      btnNewButton_4.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {

            new game4_rule().setVisible(true);
         }
      });
      btnNewButton_4.setBounds(564, 395, 349, 243);
      contentPane.add(btnNewButton_4);
      
      // 나가기
      JButton btnNewButton_5 = new JButton("");
      btnNewButton_5.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnNewButton_5.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
             new main_1().setVisible(true); //=>rule대신 메인으로 연결되게 하면됨
            dispose();
            setVisible(false);

         }
      });
      btnNewButton_5.setBounds(975, 330, 45, 39);
      contentPane.add(btnNewButton_5);
      btnNewButton_5.setBounds(975, 336, 44, 44);
      btnNewButton_5.setBorderPainted(false);
      btnNewButton_5.setContentAreaFilled(false);
      btnNewButton_5.setFocusPainted(false);
      
      
      
      
      
      
      ///////////////////////////////////////////////////////////////////////
      JLabel lblNewLabel = new JLabel("");
      
      lblNewLabel.setBounds(99, 66, 427, 305);
      contentPane.add(lblNewLabel);
      
      String icon2 = "./src/grimbang/rule_frame.png";
      ImageIcon tabletIcon = new ImageIcon(icon2);

      // 이미지 크기 조정
      Image scaledImage3 = tabletIcon.getImage().getScaledInstance(436, 310, Image.SCALE_SMOOTH);
      tabletIcon1 = new ImageIcon(scaledImage3);
      lblNewLabel.setIcon(tabletIcon1);
      //////////////////////////////////////////////////////
      
      
      
      
      JLabel lblNewLabel_1 = new JLabel("");
      lblNewLabel_1.setBounds(99, 370, 427, 290);
      contentPane.add(lblNewLabel_1);
      String icon3 = "./src/grimbang/rule_frame.png";
      ImageIcon tabletIcon2_1 = new ImageIcon(icon3);
      Image scaledImage4 = tabletIcon2_1.getImage().getScaledInstance(436, 310, Image.SCALE_SMOOTH);
      tabletIcon2 = new ImageIcon(scaledImage4);
      lblNewLabel_1.setIcon(tabletIcon2);

      // 이미지 크기 조정
     
      
      JLabel lblNewLabel_3 = new JLabel("");
      
      lblNewLabel_3.setBounds(520, 66, 436, 305);
      contentPane.add(lblNewLabel_3);
      contentPane.add(lblNewLabel);
      
      String icon4 = "./src/grimbang/rule_frame.png";
      ImageIcon tabletIcon3_1 = new ImageIcon(icon4);

      // 이미지 크기 조정
      Image scaledImage5 = tabletIcon3_1.getImage().getScaledInstance(436, 310, Image.SCALE_SMOOTH);
      tabletIcon3 = new ImageIcon(scaledImage5);
      lblNewLabel_3.setIcon(tabletIcon3);
      
      JLabel lblNewLabel_4 = new JLabel("");
      lblNewLabel_4.setIcon(new ImageIcon("./src/grimbang/rule_frame.png"));
      lblNewLabel_4.setBounds(520, 372, 436, 290);
      contentPane.add(lblNewLabel_4);
      String icon5 = "./src/rule_frame.png";
      ImageIcon tabletIcon3_11 = new ImageIcon(icon4);
      Image scaledImage2 = tabletIcon3_11.getImage().getScaledInstance(436, 310, Image.SCALE_SMOOTH);
      tabletIcon3 = new ImageIcon(scaledImage2);
      lblNewLabel_4.setIcon(tabletIcon3);
      
      
      
      
      
      
      
      
      
      
      JLabel lblNewLabel_9 = new JLabel("");
      lblNewLabel_9.setBounds(0, 0, 1050, 700);
      contentPane.add(lblNewLabel_9);
      String icon1 = "./src/grimbang/tab.png";
      ImageIcon chiIcon = new ImageIcon(icon1);
      Image scaledImage = chiIcon.getImage().getScaledInstance(1050, 700, Image.SCALE_SMOOTH);
      chiIcon1 = new ImageIcon(scaledImage);
      lblNewLabel_9.setIcon(chiIcon1);
      
      JLabel lblNewLabel_2 = new JLabel("");
      lblNewLabel_2.setBounds(0, 0, 1050, 700);
      contentPane.add(lblNewLabel_2);
      
      
   }
}
