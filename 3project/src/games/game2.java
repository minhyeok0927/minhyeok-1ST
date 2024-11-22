package games;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chart.chart;
//import test.chart;
import conn.score_dao;
import jaco.mp3.player.MP3Player;
import main_1.main_1;
import rule.game2_rule;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
public class game2 extends JFrame {

   
   private JPanel contentPane;
   private JButton btnNewButton;
   private JButton btnNewButton_1;
   private JButton btnNewButton_2;
   private JButton btnNewButton_3;
   private JButton btnNewButton_4;
   private JButton btnNewButton_5;
   private JButton btnNewButton_6;
   private static String[] aa = {"solid","operate","individual","recycling","packaging",
                           "mystery","language","appliance","inform","contact"};
   private static String[] bb = {"responsibility","hydrogen","temperature","mammal","pronunciation",
                           "agricultural","comparison", "demonstration", "prioritize" , "fallacy"};
   private static String[] cc = {"thermometer", "appointment", "hollow", "funeral" , "caprice",
                           "profitable" ,  "nerve", "substantive", "hereditary",  "insurance"};
   private static String[] dd = {"endemic","accomplishment","invulnerable","manufacturer", "scrupulous","trepid"};
   
   static String aa1;
   static String bb1;
   static String cc1;
   static String dd1;
   static Random random = new Random();
   static String[] mp3Files = {"D:\\TTS\\accomplishment.mp3","D:\\TTS\\endemic.mp3","D:\\TTS\\trepid.mp3",
                           "D:\\TTS\\invulnerable.mp3","D:\\TTS\\manufacturer.mp3","D:\\TTS\\scrupulous.mp3"};
   static String mpf1;
   static String mpff;
   int pp;
   int count = 0 ;
   private JLabel lblNewLabel;
   private JButton btnNewButton_7;
   static String ID_1;
   
   private ImageIcon classIcon1;
   private ImageIcon wooferIcon1;
   private ImageIcon testIcon1;
   private JLabel lblNewLabel_1;
   private JLabel lblNewLabel_2;
   private ImageIcon tabletIcon1;

   /**
    * Launch the application.
    */
   public static void main(String[] args) throws ClassNotFoundException, SQLException {
      

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            
            try {
               game2 frame = new game2();
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
   public game2() {
      
      
      
      
            
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(430,150, 1068, 739);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
		contentPane.setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
      
      JButton btnNewButton = new JButton("");
      String icon1 = "./src/grimbang/woofer.png";
      ImageIcon wooferIcon = new ImageIcon(icon1);

      // 이미지 크기 조정
      Image scaledImage1 = wooferIcon.getImage().getScaledInstance(308, 195, Image.SCALE_SMOOTH);
      wooferIcon1 = new ImageIcon(scaledImage1);
      
      btnNewButton.setIcon(new ImageIcon(game2.class.getResource("/grimbang/game2_sound.png")));
      
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
         }
      });
      btnNewButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {

            File mpf2= new File(mpf1);
              MP3Player mp3Player = new MP3Player(mpf2);
              mp3Player.play();
            
         }
            
      });
      btnNewButton.setBounds(154, 434, 170, 170);
      contentPane.add(btnNewButton);
      
      btnNewButton_1 = new JButton();
      btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
      btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 30));
      btnNewButton_1.setBorderPainted(false);
      btnNewButton_1.setContentAreaFilled(false);
      btnNewButton_1.setFocusPainted(false);
      btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnNewButton_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            
          
           count += 1;
            lblNewLabel.setText("시도 횟수: " + count);
            if (!btnNewButton_1.getText().equals(mpff)) {
            
            JOptionPane.showMessageDialog(null, "틀렸습니다");
            }else {

                int score= (120-(count*20));
                
                JOptionPane.showMessageDialog(contentPane, "축하합니다!" + "\n" + "시도 횟수 : " + count + "회" + "\n" + "점수 : " + score + "점");
                score_dao tidao = null;
                
              try {
                 tidao = new score_dao();
              } catch (ClassNotFoundException e1) {
                 e1.printStackTrace();
        
              } catch (SQLException e1) {
                 e1.printStackTrace();
              } 
                //점수 출력 팝업
               boolean b1 = tidao.game2_score(score);
               chart.score2(score);
//               if(b1) {
//               System.out.println("update ok");
//            }
//            else {
//               System.out.println("update error");
//            }
               dispose(); 
               setVisible(false);
               new game3().setVisible(true);
            }
            
         }
      });
      btnNewButton_1.setBounds(391, 225, 302, 51);
      contentPane.add(btnNewButton_1);
      
      btnNewButton_2 = new JButton();
      btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
      btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 30));
      btnNewButton_2.setBorderPainted(false);
      btnNewButton_2.setContentAreaFilled(false);
      btnNewButton_2.setFocusPainted(false);
      btnNewButton_2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            score_dao tidao = null;
             
          try {
             tidao = new score_dao();
          } catch (ClassNotFoundException e1) {
             e1.printStackTrace();
    
          } catch (SQLException e1) {
             e1.printStackTrace();
          } 
          count += 1;
          lblNewLabel.setText("시도 횟수: " + count);
//          
            if (!btnNewButton_2.getText().equals(mpff)) {
   
            JOptionPane.showMessageDialog(null, "틀렸습니다");
            }else {
            int score= (120-(count*20));
            JOptionPane.showMessageDialog(contentPane, "축하합니다!" + "\n" + "시도 횟수 : " + count + "회" + "\n" + "점수 : " + score + "점"); // 점수 출력 팝업
               boolean b1 = tidao.game2_score(score);
               chart.score2(score);
//               if(b1) {
//               System.out.println("update ok");
//            }
//            else
//               System.out.println("update error");
               dispose(); 
               setVisible(false);
               new game3().setVisible(true);
               
            }

         }
      });
      btnNewButton_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnNewButton_2.setBounds(391, 319, 302, 51);
      contentPane.add(btnNewButton_2);
      
      btnNewButton_3 = new JButton("");
      btnNewButton_3.setIcon(new ImageIcon(game2.class.getResource("/grimbang/game2_start.png")));
      btnNewButton_3.setBorderPainted(false);
      btnNewButton_3.setContentAreaFilled(false);
      btnNewButton_3.setFocusPainted(false);

      btnNewButton_3.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            
            
         }
      });
      JButton btnNewButton_5 = new JButton("");
      btnNewButton_5.setHorizontalAlignment(SwingConstants.LEFT);
      btnNewButton_5.setFont(new Font("굴림", Font.PLAIN, 30));
      btnNewButton_5.setBorderPainted(false);
      btnNewButton_5.setContentAreaFilled(false);
      btnNewButton_5.setFocusPainted(false);
      btnNewButton_5.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            score_dao tidao = null;
             
          try {
             tidao = new score_dao();
          } catch (ClassNotFoundException e1) {
             e1.printStackTrace();
    
          } catch (SQLException e1) {
             e1.printStackTrace();
          } 
            count += 1;
            lblNewLabel.setText("시도 횟수: " + count);
            if (!btnNewButton_5.getText().equals(mpff)) {
            JOptionPane.showMessageDialog(null, "틀렸습니다");
            }else {
                int score= (120-(count*20));
                JOptionPane.showMessageDialog(contentPane, "축하합니다!" + "\n" + "시도 횟수 : " + count + "회" + "\n" + "점수 : " + score + "점");
                boolean b1 = tidao.game2_score(score);
                chart.score2(score);
//                if(b1) {
//                System.out.println("update ok");
//             }
//             else {
//                System.out.println("update error");
//             }
                
                
               
               // 점수 출력 팝업
               
               dispose(); 
               setVisible(false);
               new game3().setVisible(true);
            }
         }
      });
      btnNewButton_5.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
         }
      });
      JButton btnNewButton_6 = new JButton("");
      btnNewButton_6.setHorizontalAlignment(SwingConstants.LEFT);
      btnNewButton_6.setFont(new Font("굴림", Font.PLAIN, 30));
      btnNewButton_6.setBorderPainted(false);
      btnNewButton_6.setContentAreaFilled(false);
      btnNewButton_6.setFocusPainted(false);
      btnNewButton_6.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnNewButton_6.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            score_dao tidao = null;
             
          try {
             tidao = new score_dao();
          } catch (ClassNotFoundException e1) {
             e1.printStackTrace();
    
          } catch (SQLException e1) {
             e1.printStackTrace();
          } 
          
          count += 1;
          lblNewLabel.setText("시도 횟수: " + count);
            if (!btnNewButton_6.getText().equals(mpff)) {
            JOptionPane.showMessageDialog(null, "틀렸습니다");
            }else {
               int score= (120-(count*20));
               JOptionPane.showMessageDialog(contentPane, "축하합니다!" + "\n" + "시도 횟수 : " + count + "회" + "\n" + "점수 : " + score + "점"); // 점수 출력 팝업
               boolean b1 = tidao.game2_score(score);
               chart.score2(score);               
               dispose(); 
               setVisible(false);
               new game3().setVisible(true);
            }
         }
      });
      
      btnNewButton_3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            aa1=aa[random.nextInt(10)];
            bb1=bb[random.nextInt(10)];
            cc1=cc[random.nextInt(10)];
            mpf1=mp3Files[random.nextInt(6)];
            mpff=mpf1.substring(7,mpf1.length()-4);
            int pp=(int)(Math.random()*4)+1;
            if (pp==1) {
               btnNewButton_1.setText(mpff);
               btnNewButton_2.setText(bb1);
               btnNewButton_5.setText(cc1);
               btnNewButton_6.setText(aa1);
            } else if(pp==2) {

               btnNewButton_1.setText(cc1);
               btnNewButton_2.setText(mpff);
               btnNewButton_5.setText(bb1);
               btnNewButton_6.setText(aa1);
            }else if(pp==3) {

               btnNewButton_1.setText(cc1);
               btnNewButton_2.setText(aa1);
               btnNewButton_5.setText(mpff);
               btnNewButton_6.setText(bb1);
            }else{
               btnNewButton_1.setText(aa1);
            btnNewButton_2.setText(cc1);
            btnNewButton_5.setText(bb1);
            btnNewButton_6.setText(mpff);
               
            }

            File mpf2= new File(mpf1);
   MP3Player mp3Player = new MP3Player(mpf2);
   mp3Player.play();
         }
      });
      btnNewButton_3.setBounds(141, 199, 200, 107);
      contentPane.add(btnNewButton_3);
      
      btnNewButton_4 = new JButton("");
      btnNewButton_4.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            
           
           
            main_1 stagame = new main_1();
            stagame.setVisible(true);
            dispose();
         }
      });
      btnNewButton_4.setBounds(975, 326, 44, 44);
      btnNewButton_4.setBorderPainted(false);
      btnNewButton_4.setContentAreaFilled(false);
      btnNewButton_4.setFocusPainted(false);
     main_1 stagame = new main_1();
      contentPane.add(btnNewButton_4);
      
      
      btnNewButton_5.setBounds(391, 416, 302, 51);
      contentPane.add(btnNewButton_5);
      
      
      btnNewButton_6.setBounds(391, 501, 302, 51);
      contentPane.add(btnNewButton_6);
      
      lblNewLabel = new JLabel("");
      lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
      
      lblNewLabel.setText("시도 횟수: ");
      
      lblNewLabel.setBounds(686, 369, 206, 37);
      contentPane.add(lblNewLabel);
      
      btnNewButton_7 = new JButton("");
      btnNewButton_7.setBackground(Color.WHITE);
      btnNewButton_7.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            game2_rule stagame = new game2_rule ();
            stagame.setVisible(true);
           
         }
      });
      
      btnNewButton_7.setIcon(new ImageIcon(game2.class.getResource("/grimbang/rule.png")));
      btnNewButton_7.setBounds(113, 105, 39, 47);
      contentPane.add(btnNewButton_7);
      
      
      
      
      
      JLabel lblNewLabel_3 = new JLabel("");
      lblNewLabel_3.setBounds(0, 0, 1050, 700);
      contentPane.add(lblNewLabel_3);
      
      
      String icon3 = "./src/grimbang/game2_tab.png";
      ImageIcon testIcon = new ImageIcon(icon3);

      Image scaledImage3 = testIcon.getImage().getScaledInstance(1050, 700, Image.SCALE_SMOOTH);
      testIcon1 = new ImageIcon(scaledImage3);
      lblNewLabel_3.setIcon(testIcon1);
      
     
      

      

      
      
      
      
   }
}
