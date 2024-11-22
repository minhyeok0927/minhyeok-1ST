package games;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main_1.main_1;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import java.awt.BasicStroke; // 굵기설정

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JToolBar;
import java.awt.Font;
import java.awt.FontFormatException;

public class game extends JFrame {

   private JPanel contentPane;
   private Random random;
   private Float stroke = 5f;
   int lastX;
   int lastY;
   Color color2;
   int i; //굵기 설정
   private ImageIcon tabletIcon1;
   
   /**
    * Launch the application.
    * @return 
    */
            
   public void Panel() {
      
      
   }
        
   
   
   public static void main(String args[]) {
         
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               game frame = new game();
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
   public game() {
      setTitle("\uADF8\uB9BC\uADF8\uB9AC\uAE30");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(430,150, 1068, 739);
      contentPane = new JPanel();
      
      JLabel lblNewLabel = new JLabel("");
      lblNewLabel.setBackground(Color.WHITE);
      lblNewLabel.setBounds(202, 137, 430, 468);
      contentPane.add(lblNewLabel);
      JPanel drawingPanel = new JPanel();
      drawingPanel.setBounds(202, 137, 430, 468);
      drawingPanel.setBackground(Color.WHITE);
      contentPane.add(drawingPanel);
      

      drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
         @Override
         public void mouseDragged(MouseEvent e) {
            int newX = e.getX();
            int newY = e.getY();

            // 마우스가 패널 내에 있을 때만 그리기
            if (newX >= 0 && newX <= drawingPanel.getWidth() && newY >= 0 && newY <= drawingPanel.getHeight()) {
               Graphics g = drawingPanel.getGraphics();
               g.setColor(color2);
               ((Graphics2D) g).setStroke(new BasicStroke(stroke));
               g.drawLine(lastX, lastY, newX, newY);
               lastX = newX;
               lastY = newY;
            }
         }
      });

      drawingPanel.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            lastX = e.getX();
            lastY = e.getY();
         }
      });
      
      
      
      
      contentPane.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            lastX=e.getX();
            lastY=e.getY();
         }
      });
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      
		contentPane.setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
      JButton btnNewButton = new JButton("\uAD75\uAE30\r\n");
      btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
      btnNewButton.setForeground(new Color(255, 255, 255));
      btnNewButton.setBorderPainted(false);
      btnNewButton.setContentAreaFilled(false);
      btnNewButton.setFocusPainted(false);
      btnNewButton.setIcon(new ImageIcon(game.class.getResource("/grimbang/game_plus.png")));
      btnNewButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            
            
         }
      });
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             stroke += 1f;
                 // Ensure stroke doesn't go below 1
                 if (stroke < 1f) {
                     stroke = 1f;
                 }
                 // Inform user or update UI as needed
                 System.out.println("Current stroke width: " + stroke);

            
               
         }
      });
      btnNewButton.setBounds(737, 335, 187, 73);
      contentPane.add(btnNewButton);
      
      JButton btnNewButton_1 =   new JButton("\uC2DC\uC791");
      btnNewButton_1.setIcon(new ImageIcon(game.class.getResource("/grimbang/game_start.png")));
      btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 20));
      btnNewButton_1.setForeground(new Color(255, 255, 255));
      btnNewButton_1.setBorderPainted(false);
      btnNewButton_1.setContentAreaFilled(false);
      btnNewButton_1.setFocusPainted(false);
      btnNewButton_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	 
            
            
         }
      });
      
      
      btnNewButton_1.setBounds(737, 152, 150, 95);
      contentPane.add(btnNewButton_1);
      
      
      

      btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            i=(int)(Math.random()*6);
            if (i==0) {
               lblNewLabel.setIcon(new ImageIcon("./src/grimbang/game_pic1.png"));
            } else if (i==1) {
               lblNewLabel.setIcon(new ImageIcon("./src/grimbang/game_pic2.png"));
               }
            else if (i==2) {
                lblNewLabel.setIcon(new ImageIcon("./src/grimbang/game_pic3.png"));
                }
            else if (i==3) {
                lblNewLabel.setIcon(new ImageIcon("./src/grimbang/game_pic4.png"));
                }
         
            
            else {
                  lblNewLabel.setIcon(new ImageIcon("./src/grimbang/game_pic5.png"));
               }
         }
         });
      
      JButton btnNewButton_2 = new JButton("\uC0C9\uAE54\r\n\r\n");
      btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 20));
      btnNewButton_2.setForeground(new Color(255, 255, 255));
      btnNewButton_2.setBorderPainted(false);
      btnNewButton_2.setContentAreaFilled(false);
      btnNewButton_2.setFocusPainted(false);
      btnNewButton_2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            color2 = JColorChooser.showDialog(null, "컬러", Color.blue);
            
         }
      });
      btnNewButton_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            
            
            
         }
         
      });
      btnNewButton_2.setIcon(new ImageIcon(game.class.getResource("/grimbang/game_pencil.png")));
      btnNewButton_2.setBounds(710, 252, 199, 73);
      contentPane.add(btnNewButton_2);
      
      JButton btnNewButton_3 = new JButton("\r\n\r\n\uB2E4\uC74C");
      btnNewButton_3.setFont(new Font("굴림", Font.PLAIN, 20));
      btnNewButton_3.setForeground(new Color(255, 255, 255));
      btnNewButton_3.setIcon(new ImageIcon(game.class.getResource("/grimbang/game_arrow.png")));
      btnNewButton_3.setBorderPainted(false);
      btnNewButton_3.setContentAreaFilled(false);
      btnNewButton_3.setFocusPainted(false);
      btnNewButton_3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnNewButton_3.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            
            game1_sel stagame = null;
			try {
				stagame = new game1_sel();
			} catch (FontFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

             stagame.setVisible(true);
              dispose(); // 창닫기 
            
         }
      });
      btnNewButton_3.setBounds(721, 499, 183, 81);
      contentPane.add(btnNewButton_3);
      
      JButton btnNewButton_4 = new JButton("\uAD75\uAE30");
      btnNewButton_4.setForeground(new Color(255, 255, 255));
      btnNewButton_4.setFont(new Font("굴림", Font.PLAIN, 20));
      btnNewButton_4.setBorderPainted(false);
      btnNewButton_4.setContentAreaFilled(false);
      btnNewButton_4.setFocusPainted(false);
      btnNewButton_4.setIcon(new ImageIcon(game.class.getResource("/grimbang/game_minus.png")));
      btnNewButton_4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
         }
      });
      btnNewButton_4.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            stroke -= 1f;
              // Ensure stroke doesn't go below 1
              if (stroke < 1f) {
                  stroke = 1f;
              }
              // Inform user or update UI as needed
              System.out.println("Current stroke width: " + stroke);
         }
         
      });
      btnNewButton_4.setBounds(759, 418, 145, 75);
      contentPane.add(btnNewButton_4);
      
      JButton btnNewButton_5 = new JButton("");
      btnNewButton_5.setBorderPainted(false);
      btnNewButton_5.setContentAreaFilled(false);
      btnNewButton_5.setFocusPainted(false);
      btnNewButton_5.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            main_1 stagame = new main_1();

            stagame.setVisible(true);
             dispose();
         }
      });
      btnNewButton_5.setBounds(975, 335, 43, 50);
      contentPane.add(btnNewButton_5);
      
      JLabel lblNewLabel_1 = new JLabel("");
      lblNewLabel_1.setBackground(new Color(135, 206, 250));
      lblNewLabel_1.setBounds(684, 107, 166, 473);
      contentPane.add(lblNewLabel_1);
      
      JLabel lblNewLabel_2 = new JLabel("");
      lblNewLabel_2.setIcon(new ImageIcon(game.class.getResource("/grimbang/game_board.png")));
      lblNewLabel_2.setBounds(0, 0, 1050, 700);
      contentPane.add(lblNewLabel_2);
      
      String icon2 = "./src/grimbang/game_board.png";
      ImageIcon tabletIcon = new ImageIcon(icon2);

      // 이미지 크기 조정
      Image scaledImage3 = tabletIcon.getImage().getScaledInstance(1050, 700, Image.SCALE_SMOOTH);
      tabletIcon1 = new ImageIcon(scaledImage3);
      lblNewLabel_2.setIcon(tabletIcon1);
   }
}
