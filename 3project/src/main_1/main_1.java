package main_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chart.chart;
import chart.chart_main;
import conn.score_dao;
import games.game;
import games.game2;
import rule.game1_rule;
import rule.rule;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main_1 extends JFrame {

   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private static String ID_1;
   private ImageIcon chiIcon1;
   public String getID_1() {
         return ID_1;
      }

      // Setter 메서드
      public void setID_1(String ID_1) {
         this.ID_1 = ID_1;
      }


   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               main_1 frame = new main_1();
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
   public main_1() {
      // 기본 생성자는 여기서 로그인 정보를 받지 않음
      initializeUI();
   }

   /**
    * Create the frame with logged in user ID.
    */
   public main_1(String ID_1) {
      this.ID_1 = ID_1;
      score_dao.id_(ID_1);
      chart.id_(ID_1);
      main_1.id_(ID_1);
      chart_main.id_(ID_1);
      initializeUI();
   }
   
   
   public static String id_(String iD_12) {
	      ID_1 = iD_12;
	        return ID_1;
	   }

   private void initializeUI() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(430,150,1068,739);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      
		contentPane.setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
      
      JLabel lblUserId = new JLabel("ID:"+ID_1);
      lblUserId.setForeground(Color.WHITE);
      lblUserId.setFont(new Font("Arial", Font.BOLD, 14));
      lblUserId.setBounds(103, 73, 200, 30);
      contentPane.add(lblUserId);
      
      JButton GameStart = new JButton("");
      GameStart.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

         }
      });
      
      GameStart.setBorderPainted(false);
      GameStart.setContentAreaFilled(false);
      GameStart.setFocusPainted(false); 
      contentPane.setLayout(null);
      GameStart.setBounds(456, 450, 164, 78);
      contentPane.add(GameStart);

      // 게임시작 버튼 이벤트
      GameStart.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	// 게임 시작 로직 추가
        	 main_ex.ID_1 = ID_1;
             main_ex.startGame();
             
            try {
               System.out.println("게임버튼 클릭됨");
               game stagame = new game();

               stagame.setVisible(true);
               dispose(); // 창닫기               

            } catch(Exception ex) {
               ex.printStackTrace();
            }
         }
      });
      
      
      
      // 룰북
      JButton Rule = new JButton("");
      Rule.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // 규칙 책 보기 로직 추가
         }
      });
      
      
      
      Rule.setBounds(501, 548, 100, 89);
      Rule.setBorderPainted(false);
      Rule.setContentAreaFilled(false);
      Rule.setFocusPainted(false); 
      contentPane.setLayout(null);
      contentPane.add(Rule);
      
      Rule.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            new rule().setVisible(true);
         }
      });
      
      JButton Lank = new JButton("");
      Lank.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseReleased(MouseEvent e) {
      		
           try {
			new chart_main().setVisible(true);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           dispose();
           setVisible(false);
      	}
      });
      Lank.setBounds(841, 401, 87, 101);
      Lank.setBorderPainted(false);
      Lank.setContentAreaFilled(false);
      Lank.setFocusPainted(false); 
      contentPane.setLayout(null);
      contentPane.add(Lank);

      
      // 나가기 버튼    **** app있는 공간으로 가는 로직 만들어야함. 
      JButton logout = new JButton("");
      logout.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	 new f_main().setVisible(true);
             dispose();
             setVisible(false);
			
             
         }
      });
      logout.setBounds(858, 532, 80, 105);
      logout.setBorderPainted(false);
      logout.setContentAreaFilled(false);
      logout.setFocusPainted(false); 
      contentPane.setLayout(null);
      contentPane.add(logout);
      String icon1 = "./src/grimbang/main_tap.png";
      ImageIcon chiIcon1 = new ImageIcon(icon1);
      Image scaledImage1 = chiIcon1.getImage().getScaledInstance(1050, 700, Image.SCALE_SMOOTH);
      chiIcon1 = new ImageIcon(scaledImage1);
      
      JButton btnNewButton = new JButton("");
      btnNewButton.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		new f_main().setVisible(true);
      		dispose();
            setVisible(false);
			
      	}
      });
      btnNewButton.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      btnNewButton.setOpaque(false);
      btnNewButton.setContentAreaFilled(false);
      btnNewButton.setBorderPainted(false);
      btnNewButton.setBounds(966, 324, 60, 51);
      contentPane.add(btnNewButton);
      
      
            
            
            // 메인tab
            JLabel lblNewLabel = new JLabel("");
            lblNewLabel.setBounds(0, 0, 1050, 700);
            contentPane.add(lblNewLabel);
            lblNewLabel.setIcon(chiIcon1);
      
      
   }   
}
