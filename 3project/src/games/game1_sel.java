package games;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conn.score_dao;
import main_1.main_1;
import rule.game3_rule;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class game1_sel extends JFrame {

   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private ImageIcon chiIcon1, chiIcon6;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               game1_sel frame = new game1_sel();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
   
   /**
    * Create the frame.
 * @throws IOException 
 * @throws FontFormatException 
    */
   public game1_sel() throws FontFormatException, IOException {
	   
	   
	   
      setTitle("\uCE74\uB4DC \uC774\uBBF8\uC9C0 \uC120\uD0DD");
      setBackground(new Color(240, 240, 240));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(430,150, 1068, 739);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      
		contentPane.setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
      
      Random rand = new Random();

      //  fruit
      for (int i = 1; i <= 3; i++) {   
         int randomNum = rand.nextInt(3) + 1;    //  0, 1, 또는 2 중 하나의 정수를 반환 후, randomNum변수에 1,2,3 이란 수를 저장
         JButton fruitBtn = new JButton("");
         fruitBtn.setBackground(Color.WHITE); // 버튼 흰색으로
         fruitBtn.setBorderPainted(false); // 버튼 테두리 없애기   
         String resourcePath = "/grim_game1/fruitsel" + randomNum + ".png";
         ImageIcon fruitIcon = new ImageIcon(getClass().getResource(resourcePath)); 
         
         Image fruitImage = fruitIcon.getImage();
         Image scaledFruitImage = fruitImage.getScaledInstance(248,282, Image.SCALE_SMOOTH);
         fruitIcon = new ImageIcon(scaledFruitImage);
         fruitBtn.setIcon(fruitIcon);
         fruitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {          // 과일 버튼 클릭
               game1 cardGame = new game1("fruit");
               System.out.println("?!?!?!"+cardGame);
               cardGame.setVisible(true);
               dispose(); 
            }
         });
         fruitBtn.setBounds(203, 299, 248, 282);
         contentPane.add(fruitBtn);
      }
      
      
      //  animal
      for (int j = 1; j <= 3; j++) {
         int randomNum = rand.nextInt(3) + 1;    //  0, 1, 또는 2 중 하나의 정수를 반환 후, randomNum변수에 1,2,3 이란 수를 저장
         JButton animalBtn1 = new JButton("");
         animalBtn1.setBackground(Color.WHITE); // 버튼 흰색으로
         animalBtn1.setBorderPainted(false); // 버튼 테두리 없애기
         String resourcePath = "/grim_game1/animalsel" + randomNum + ".png";
         ImageIcon animalIcon = new ImageIcon(getClass().getResource(resourcePath)); 

         Image animalImage = animalIcon.getImage();
         Image scaledAnimalImage = animalImage.getScaledInstance(248,282, Image.SCALE_SMOOTH);
         animalIcon = new ImageIcon(scaledAnimalImage);
         animalBtn1.setIcon(animalIcon);
         animalBtn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {           // 동물 버튼 클릭
               game1 cardGame = new game1("animal");
               cardGame.setVisible(true);
               dispose(); 
            }
         });
         animalBtn1.setBounds(613, 299, 248, 282);
         contentPane.add(animalBtn1);
      }
     
      
      // card select 제목
      JLabel lblNewLabel_3 = new JLabel("");
      lblNewLabel_3.setBounds(380, 71, 290,217);
      contentPane.add(lblNewLabel_3);
      String icon6= "./src/grim_game1/selicon.png";
      ImageIcon chiIcon6 = new ImageIcon(icon6);
      Image scaledImage7 = chiIcon6.getImage().getScaledInstance(290,290, Image.SCALE_SMOOTH);
      chiIcon6 = new ImageIcon(scaledImage7);
      lblNewLabel_3.setIcon(chiIcon6);
      
      
   // background
      JLabel lblNewLabel_5 = new JLabel("");
      lblNewLabel_5.setBounds(98, 65, 854, 599);
      contentPane.add(lblNewLabel_5);
      String icon7= "./src/grim_game1/selback.jpg";
      ImageIcon chiIcon7 = new ImageIcon(icon7);
      Image scaledImage8 = chiIcon7.getImage().getScaledInstance(854,603, Image.SCALE_SMOOTH);
      chiIcon7 = new ImageIcon(scaledImage8);
      lblNewLabel_5.setIcon(chiIcon7);
      
      JButton btnNewButton = new JButton("");
      btnNewButton.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		new main_1().setVisible(true);
      		setVisible(false);
            dispose();
      	}
      });
      btnNewButton.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      btnNewButton.setOpaque(false);
      btnNewButton.setContentAreaFilled(false);
      btnNewButton.setBorderPainted(false);
      btnNewButton.setBounds(967, 325, 58, 51);
      contentPane.add(btnNewButton);

      
      // 태블릿 pc
      JLabel lblNewLabel_9 = new JLabel("");
      lblNewLabel_9.setBounds(0, 0, 1050, 700);
      contentPane.add(lblNewLabel_9);  
      String icon1 = "./src/grimbang/tab.png";
      ImageIcon chiIcon = new ImageIcon(icon1);
      Image scaledImage2 = chiIcon.getImage().getScaledInstance(1050, 700, Image.SCALE_SMOOTH);
      chiIcon1 = new ImageIcon(scaledImage2);
      lblNewLabel_9.setIcon(chiIcon1);
      
      

   }
}
