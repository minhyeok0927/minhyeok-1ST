package games;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chart.chart;
import conn.score_dao;
import main_1.main_1;
import rule.game4_rule;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

import conn.score_dao;


public class game4 extends JFrame {
   
   Random random = new Random();
   static int answer[] = new int[3]; // 컴퓨터 정답
   int[] input = new int[3]; // 사용자 입력
   static int count = 0; // 입력 횟수
   int strike = 0;
   int ball = 0;
   String num; // 숫자 전환을 위한 입력
   
   static String ID_1; // 아이디 가져오기
   
   int b =0; // 전광판
   static String aa; ////완성시 삭제
   
   private JPanel contentPane;
   private JTextField num_1;
   private ImageIcon chiIcon1;

   /**
    * Launch the application.
    * @return 
    */
   
   public String test_id(String id) {
      ID_1 = id;
      return ID_1;
   }
   
   public static void main(String[] args) {
      
      
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               game4 frame = new game4();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
      

      
   }// main끝

   /**
    * Create the frame.
    */
   public game4() {
	  count = 0;
      for(int i = 0; i < 3; i++) {
         answer[i] = (int)(Math.random()*10);
         
         for(int j = 0;j < i; j++) {
            if(answer[j]==answer[i]) {
               i--;
               break;
               }
            
            }

         }
      
      aa=Arrays.toString(answer); /////완성시 삭제
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(430,150, 1068, 739);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      
		contentPane.setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
      
      JPanel panel = new JPanel();
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.setBounds(189, 65, 763, 227);
      contentPane.add(panel);
      
      JLabel lblNewLabel_1 = new JLabel(" 1      2      3      4      5      6      7      8      9");
      lblNewLabel_1.setForeground(Color.WHITE);
      lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 22));
      lblNewLabel_1.setBounds(25, 10, 557, 30);
      panel.add(lblNewLabel_1);
      
      JLabel a_1 = new JLabel("");
      a_1.setFont(new Font("굴림", Font.PLAIN, 20));
      a_1.setHorizontalAlignment(SwingConstants.CENTER);
      a_1.setForeground(Color.WHITE);
      a_1.setBounds(23, 61, 30, 87);
      panel.add(a_1);
      
      JLabel a_2 = new JLabel("");
      a_2.setHorizontalAlignment(SwingConstants.CENTER);
      a_2.setFont(new Font("굴림", Font.PLAIN, 20));
      a_2.setForeground(Color.WHITE);
      a_2.setBounds(78, 61, 37, 87);
      panel.add(a_2);
      
      JLabel a_3 = new JLabel("");
      a_3.setHorizontalAlignment(SwingConstants.CENTER);
      a_3.setFont(new Font("굴림", Font.PLAIN, 20));
      a_3.setForeground(Color.WHITE);
      a_3.setBounds(135, 61, 30, 87);
      panel.add(a_3);
      
      JLabel a_4 = new JLabel("");
      a_4.setFont(new Font("굴림", Font.PLAIN, 20));
      a_4.setHorizontalAlignment(SwingConstants.CENTER);
      a_4.setForeground(Color.WHITE);
      a_4.setBounds(190, 61, 30, 87);
      panel.add(a_4);
      
      JLabel a_5 = new JLabel("");
      a_5.setHorizontalAlignment(SwingConstants.CENTER);
      a_5.setFont(new Font("굴림", Font.PLAIN, 20));
      a_5.setForeground(Color.WHITE);
      a_5.setBounds(245, 61, 30, 87);
      panel.add(a_5);
      
      JLabel a_6 = new JLabel("");
      a_6.setFont(new Font("굴림", Font.PLAIN, 20));
      a_6.setHorizontalAlignment(SwingConstants.CENTER);
      a_6.setForeground(Color.WHITE);
      a_6.setBounds(298, 61, 30, 87);
      panel.add(a_6);
      
      JLabel a_7 = new JLabel("");
      a_7.setHorizontalAlignment(SwingConstants.CENTER);
      a_7.setFont(new Font("굴림", Font.PLAIN, 20));
      a_7.setForeground(Color.WHITE);
      a_7.setBounds(355, 61, 30, 87);
      panel.add(a_7);
      
      JLabel a_8 = new JLabel("");
      a_8.setFont(new Font("굴림", Font.PLAIN, 20));
      a_8.setHorizontalAlignment(SwingConstants.CENTER);
      a_8.setForeground(Color.WHITE);
      a_8.setBounds(410, 61, 30, 87);
      panel.add(a_8);
      
      JLabel a_9 = new JLabel("");
      a_9.setHorizontalAlignment(SwingConstants.CENTER);
      a_9.setFont(new Font("굴림", Font.PLAIN, 20));
      a_9.setForeground(Color.WHITE);
      a_9.setBounds(464, 61, 30, 87);
      panel.add(a_9);
      
      JLabel b__1 = new JLabel("");
      b__1.setHorizontalAlignment(SwingConstants.CENTER);
      b__1.setFont(new Font("굴림", Font.PLAIN, 18));
      b__1.setForeground(Color.WHITE);
      b__1.setBounds(15, 183, 51, 29);
      panel.add(b__1);
      
      JLabel b__2 = new JLabel("");
      b__2.setHorizontalAlignment(SwingConstants.CENTER);
      b__2.setFont(new Font("굴림", Font.PLAIN, 18));
      b__2.setForeground(Color.WHITE);
      b__2.setBounds(70, 183, 51, 29);
      panel.add(b__2);
      
      JLabel b__3 = new JLabel("");
      b__3.setHorizontalAlignment(SwingConstants.CENTER);
      b__3.setFont(new Font("굴림", Font.PLAIN, 18));
      b__3.setForeground(Color.WHITE);
      b__3.setBounds(127, 183, 51, 29);
      panel.add(b__3);
      
      JLabel b__4 = new JLabel("");
      b__4.setHorizontalAlignment(SwingConstants.CENTER);
      b__4.setFont(new Font("굴림", Font.PLAIN, 18));
      b__4.setForeground(Color.WHITE);
      b__4.setBounds(182, 183, 51, 29);
      panel.add(b__4);
      
      JLabel b__5 = new JLabel("");
      b__5.setHorizontalAlignment(SwingConstants.CENTER);
      b__5.setFont(new Font("굴림", Font.PLAIN, 18));
      b__5.setForeground(Color.WHITE);
      b__5.setBounds(237, 183, 51, 29);
      panel.add(b__5);
      
      JLabel b__6 = new JLabel("");
      b__6.setHorizontalAlignment(SwingConstants.CENTER);
      b__6.setFont(new Font("굴림", Font.PLAIN, 18));
      b__6.setForeground(Color.WHITE);
      b__6.setBounds(290, 183, 51, 29);
      panel.add(b__6);
      
      JLabel b__7 = new JLabel("");
      b__7.setHorizontalAlignment(SwingConstants.CENTER);
      b__7.setFont(new Font("굴림", Font.PLAIN, 18));
      b__7.setForeground(Color.WHITE);
      b__7.setBounds(347, 183, 51, 29);
      panel.add(b__7);
      
      JLabel b__8 = new JLabel("");
      b__8.setHorizontalAlignment(SwingConstants.CENTER);
      b__8.setFont(new Font("굴림", Font.PLAIN, 18));
      b__8.setForeground(Color.WHITE);
      b__8.setBounds(402, 183, 51, 29);
      panel.add(b__8);
      
      JLabel b__9 = new JLabel("");
      b__9.setHorizontalAlignment(SwingConstants.CENTER);
      b__9.setFont(new Font("굴림", Font.PLAIN, 18));
      b__9.setForeground(Color.WHITE);
      b__9.setBounds(456, 183, 51, 29);
      panel.add(b__9);
      
      JButton btnNewButton_1 = new JButton("");
      btnNewButton_1.setBackground(new Color(255, 255, 255));
      btnNewButton_1.setBounds(527, 0, 3, 227);
      panel.add(btnNewButton_1);
      
      JLabel lblNewLabel = new JLabel("S");
      lblNewLabel.setFont(new Font("굴림", Font.BOLD, 40));
      lblNewLabel.setForeground(new Color(255, 255, 255));
      lblNewLabel.setBounds(542, 84, 57, 54);
      panel.add(lblNewLabel);
      
      JLabel lblNewLabel_3 = new JLabel("B");
      lblNewLabel_3.setForeground(Color.WHITE);
      lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 40));
      lblNewLabel_3.setBounds(542, 20, 57, 54);
      panel.add(lblNewLabel_3);
      
      JLabel lblNewLabel_4 = new JLabel("O");
      lblNewLabel_4.setForeground(Color.WHITE);
      lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 40));
      lblNewLabel_4.setBounds(542, 148, 57, 54);
      panel.add(lblNewLabel_4);
      
      JButton btnNewButton_4 = new JButton("");
      btnNewButton_4.setBackground(new Color(255, 255, 255));
      btnNewButton_4.setBounds(0, 46, 530, 3);
      panel.add(btnNewButton_4);
      
      JLabel s1 = new JLabel("");
      s1.setForeground(new Color(255, 255, 255));
      s1.setBounds(582, 86, 44, 44);
      panel.add(s1);
      
      JLabel s2 = new JLabel("");
      s2.setForeground(Color.WHITE);
      s2.setBounds(638, 86, 44, 44);
      panel.add(s2);
      
      JLabel s4 = new JLabel("");
      s4.setForeground(Color.WHITE);
      s4.setBounds(582, 20, 44, 44);
      panel.add(s4);
      
      JLabel s5 = new JLabel("");
      s5.setForeground(Color.WHITE);
      s5.setBounds(638, 20, 44, 44);
      panel.add(s5);
      
      JLabel s6 = new JLabel("");
      s6.setForeground(Color.WHITE);
      s6.setBounds(694, 20, 44, 44);
      panel.add(s6);
      
      JLabel s7 = new JLabel("");
      s7.setForeground(Color.WHITE);
      s7.setBounds(582, 148, 44, 44);
      panel.add(s7);
      
      JButton btnNewButton_7 = new JButton("");
      btnNewButton_7.setBackground(new Color(255, 255, 255));
      btnNewButton_7.setBounds(0, 165, 530, 3);
      panel.add(btnNewButton_7);
      
      
      // 룰 북
      JButton btnNewButton = new JButton("");
      btnNewButton.setBackground(new Color(255, 255, 255));
      btnNewButton.setIcon(new ImageIcon(game4.class.getResource("/grimbang/rule.png")));
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnNewButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            new game4_rule().setVisible(true);
         }
      });

      JLabel delete = new JLabel("");
      delete.setBounds(12, 617, 160, 94);
      contentPane.add(delete);
      btnNewButton.setFont(new Font("굴림", Font.BOLD, 25));
      btnNewButton.setBounds(113, 73, 39, 47);
      contentPane.add(btnNewButton);
      
      // 유저가 쓴 숫자 출력
      JLabel print_1 = new JLabel("");
      print_1.setHorizontalAlignment(SwingConstants.CENTER);
      print_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 22));
      print_1.setBackground(Color.WHITE);
      print_1.setBounds(470, 433, 107, 37);
      contentPane.add(print_1);
      
      // ball, strike, out 표시 
      JLabel fin = new JLabel("");
      fin.setHorizontalAlignment(SwingConstants.CENTER);
      fin.setFont(new Font("굴림", Font.BOLD, 25));
      fin.setBounds(396, 348, 268, 75);
      contentPane.add(fin);
      
      // 숫자 입력창
      num_1 = new JTextField();
      num_1.setFont(new Font("굴림", Font.BOLD, 35));
      num_1.setBounds(833, 332, 107, 47);
      contentPane.add(num_1);
      num_1.setColumns(10);
      
      // 야구공
      JLabel lblNewLabel_7 = new JLabel("");
      lblNewLabel_7.setBounds(486, 403, 89, 88);
      contentPane.add(lblNewLabel_7);
      
      
      // "숫자를 입력해 주세요"
      JLabel lblNewLabel_2 = new JLabel("\uC22B\uC790\uB97C \uC785\uB825\uD574 \uC8FC\uC138\uC694");
      lblNewLabel_2.setForeground(Color.GREEN);
      lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel_2.setBounds(747, 302, 195, 21);
      contentPane.add(lblNewLabel_2);
      
      // 숫자 입력 버튼
      JButton btnNewButton_6 = new JButton("\uC785\uB825");
      btnNewButton_6.setBackground(new Color(255, 255, 255));
      btnNewButton_6.addMouseListener(new MouseAdapter() {   
         @Override
         public void mouseClicked(MouseEvent e) {
            delete.setText(aa);//////// 정답출력
            count++; // 9번 하면 끝내기 위함
            strike = 0;
            ball = 0;
            int a = 0;

            String pr_1,pr_2,pr_3;
            
            num = num_1.getText();
            char[] ca = num.toCharArray();
            
            
            if(num.length()!=3) {
            }else {
            for (int i = 0; i < input.length; i++) {
                input[i] = Character.getNumericValue(ca[i]);
            }            
            for(int i = 0; i < input.length; i++) {               
             for(int j = 0;j < i; j++) {
                if(input[j]==input[i]) {
                   a = 1; // 같은 숫자 입력
                   count--;
                   
                   }
                }
             }
            }
            if(a==1) {
                JOptionPane.showMessageDialog(null, "같은 숫자를 입력했습니다");
                num_1.setText("");
             }else if(num.length()!=3){
                JOptionPane.showMessageDialog(null, "숫자 3개를 입력해 주세요");
                count--;
                num_1.setText("");
             }else if(!num.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "숫자를 입력해 주세요");
                count--;
                num_1.setText("");
             }
             else { 
            

            
                     

            for (int i= 0; i<input.length; i++) {
               for(int j = 0; j < answer.length; j++) {
                           if(answer[i] == input[j]) {                             
                              if(i==j) {
                                 strike++;
                              }else {
                                 ball++;
                              }
                            }
               }
            } //for문끝
            
            score_dao tidao = null;
          
         try {
            tidao = new score_dao();
         } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
   
         } catch (SQLException e1) {
            e1.printStackTrace();
         } // 연결
            
            //결과값 뜨기
            if(strike == 3){
                   int score = 110-(count*10);                  
                   JOptionPane.showMessageDialog(contentPane, "축하합니다!" + "\n" + "시도 횟수 : " + count + "회" + "\n" + "점수 : " + score + "점");
                   //디비로 넘기기
                   boolean b1 = tidao.game4_score(score);
                   chart.score4(score);
                   
                   //창닫기
                   dispose();
                setVisible(false);
               try {
				new chart().setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            

                }
            else if (strike == 0 && ball == 0){
               fin.setText("out");
            }else if(strike == 0) {
               fin.setText(ball + " ball");
                }else if(ball ==0) {
                   fin.setText(strike + " strike");
                }else {                   
                   fin.setText(strike + " strike" + ball + " ball");
                }
            
            print_1.setText(num); // 입력한 값 출력
            
            lblNewLabel_7.setIcon(new ImageIcon(getClass().getResource("/grimbang/game4_4.png")));
            
            //전광판 신호등
            s1.setIcon(new ImageIcon(getClass().getResource("")));
            s2.setIcon(new ImageIcon(getClass().getResource("")));
            s4.setIcon(new ImageIcon(getClass().getResource("")));
            s5.setIcon(new ImageIcon(getClass().getResource("")));
            s6.setIcon(new ImageIcon(getClass().getResource("")));
            s7.setIcon(new ImageIcon(getClass().getResource("")));
            ImageIcon icon1 = new ImageIcon(getClass().getResource("/grimbang/s2.jpg"));
            ImageIcon icon2 = new ImageIcon(getClass().getResource("/grimbang/s1.jpg"));
            ImageIcon icon3 = new ImageIcon(getClass().getResource("/grimbang/s3.jpg"));
            Image img = icon1.getImage();
            Image newImg = img.getScaledInstance(s1.getWidth(), s1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(newImg);
            if (strike == 2) {                
                s1.setIcon(scaledIcon);
                s2.setIcon(scaledIcon);
            }else if(strike == 1){
               s1.setIcon(scaledIcon);
            }
            img = icon2.getImage();
            newImg = img.getScaledInstance(s1.getWidth(), s1.getHeight(), Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(newImg);
            if (ball == 3) {
               s4.setIcon(scaledIcon);
               s5.setIcon(scaledIcon);
               s6.setIcon(scaledIcon);
            }else if(ball == 2){
               s4.setIcon(scaledIcon);
               s5.setIcon(scaledIcon);
            }else if(ball == 1){
               s4.setIcon(scaledIcon);
            }
            
            img = icon3.getImage();
            newImg = img.getScaledInstance(s1.getWidth(), s1.getHeight(), Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(newImg);
            if(ball==0&&strike==0) {
               s7.setIcon(scaledIcon);
            }
            
         
            
            //전광판 숫자 표시
            b++;
            pr_1 = num.substring(0, 1);
            pr_2 = num.substring(1, 2);
            pr_3 = num.substring(2, 3);

            if(b==1) {
               a_1.setText("<html><body><center>"+pr_1+"<br>"+pr_2+"<br>"+pr_3+"</center></body></html>");            
               if (strike == 0 && ball == 0){
                  b__1.setText("OUT");;
               }else if(strike == 0) {
                  b__1.setText(ball+"B");
                   }else if(ball ==0) {
                      b__1.setText(strike+"S");
                   }else {                   
                      b__1.setText(strike+"S"+ball+"B");
                   }
            }else if(b==2) {
               a_2.setText("<html><body><center>"+pr_1+"<br>"+pr_2+"<br>"+pr_3+"</center></body></html>");
               if (strike == 0 && ball == 0){
                  b__2.setText("OUT");;
               }else if(strike == 0) {
                  b__2.setText(ball+"B");
                   }else if(ball ==0) {
                      b__2.setText(strike+"S");
                   }else {                   
                      b__2.setText(strike+"S"+ball+"B");
                   }
            }else if(b==3) {
               a_3.setText("<html><body><center>"+pr_1+"<br>"+pr_2+"<br>"+pr_3+"</center></body></html>");
               if (strike == 0 && ball == 0){
                  b__3.setText("OUT");;
               }else if(strike == 0) {
                  b__3.setText(ball+"B");
                   }else if(ball ==0) {
                      b__3.setText(strike+"S");
                   }else {                   
                      b__3.setText(strike+"S"+ball+"B");
                   }
            }else if(b==4) {
               a_4.setText("<html><body><center>"+pr_1+"<br>"+pr_2+"<br>"+pr_3+"</center></body></html>");
               if (strike == 0 && ball == 0){
                  b__4.setText("OUT");;
               }else if(strike == 0) {
                  b__4.setText(ball+"B");
                   }else if(ball ==0) {
                      b__4.setText(strike+"S");
                   }else {                   
                      b__4.setText(strike+"S"+ball+"B");
                   }
            }else if(b==5) {
               a_5.setText("<html><body><center>"+pr_1+"<br>"+pr_2+"<br>"+pr_3+"</center></body></html>");
               if (strike == 0 && ball == 0){
                  b__5.setText("OUT");;
               }else if(strike == 0) {
                  b__5.setText(ball+"B");
                   }else if(ball ==0) {
                      b__5.setText(strike+"S");
                   }else {                   
                      b__5.setText(strike+"S"+ball+"B");
                   }
            }else if(b==6) {
               a_6.setText("<html><body><center>"+pr_1+"<br>"+pr_2+"<br>"+pr_3+"</center></body></html>");
               if (strike == 0 && ball == 0){
                  b__6.setText("OUT");;
               }else if(strike == 0) {
                  b__6.setText(ball+"B");
                   }else if(ball ==0) {
                      b__6.setText(strike+"S");
                   }else {                   
                      b__6.setText(strike+"S"+ball+"B");
                   }
            }else if(b==7) {
               a_7.setText("<html><body><center>"+pr_1+"<br>"+pr_2+"<br>"+pr_3+"</center></body></html>");
               if (strike == 0 && ball == 0){
                  b__7.setText("OUT");;
               }else if(strike == 0) {
                  b__7.setText(ball+"B");
                   }else if(ball ==0) {
                      b__7.setText(strike+"S");
                   }else {                   
                      b__7.setText(strike+"S"+ball+"B");
                   }
            }else if(b==8) {
               a_8.setText("<html><body><center>"+pr_1+"<br>"+pr_2+"<br>"+pr_3+"</center></body></html>");
               if (strike == 0 && ball == 0){
                  b__8.setText("OUT");;
               }else if(strike == 0) {
                  b__8.setText(ball+"B");
                   }else if(ball ==0) {
                      b__8.setText(strike+"S");
                   }else {                   
                      b__8.setText(strike+"S"+ball+"B");
                   }
            }else if(b==9) {
               a_9.setText("<html><body><center>"+pr_1+"<br>"+pr_2+"<br>"+pr_3+"</center></body></html>");
               if (strike == 0 && ball == 0){
                  b__9.setText("OUT");;
               }else if(strike == 0) {
                  b__9.setText(ball+"B");
                   }else if(ball ==0) {
                      b__9.setText(strike+"S");
                   }else {                   
                      b__9.setText(strike+"S"+ball+"B");
                   }
               
            }
            if(b==9 && strike <3){ 
                   int score = 0;
                  
                   JOptionPane.showMessageDialog(contentPane, "실패하셨습니다!" + "\n" + "점수 : 0점");
                   
                 //디비로 넘기기
                   boolean b1 = tidao.game4_score(score);
                   chart.score4(score);
                   //창닫기
                   dispose();
                setVisible(false);
                
                try {
					new chart().setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
            }
            
            
            num_1.setText("");
            }
            
                     
         }
      });
      
      
      btnNewButton_6.setBounds(845, 388, 89, 23);
      contentPane.add(btnNewButton_6);
      
      
       // 투수 
      JLabel lblNewLabel_6 = new JLabel("");
      lblNewLabel_6.setBounds(239, 262, 195, 210);
      contentPane.add(lblNewLabel_6);
      String icon3 = "./src/grimbang/game4_3.png";
      ImageIcon chiIcon3 = new ImageIcon(icon3);
      Image scaledImage3 = chiIcon3.getImage().getScaledInstance(140,145, Image.SCALE_SMOOTH);
      chiIcon3 = new ImageIcon(scaledImage3);
      lblNewLabel_6.setIcon(chiIcon3);
      
     
      // 타자 
      JLabel lblNewLabel_5 = new JLabel("");
      lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_5.setBounds(626, 262, 326, 400);
      contentPane.add(lblNewLabel_5);
      String icon4 = "./src/grimbang/game4_2.png";
      ImageIcon chiIcon4 = new ImageIcon(icon4);
      Image scaledImage4 = chiIcon4.getImage().getScaledInstance(400,400, Image.SCALE_SMOOTH);
      chiIcon4 = new ImageIcon(scaledImage4);
      lblNewLabel_5.setIcon(chiIcon4);
      
      
      // 야구 운동장 
      JLabel lblNewLabel_8 = new JLabel("");
      lblNewLabel_8.setBounds(98, 65, 854, 597);
      contentPane.add(lblNewLabel_8);
      String icon2 = "./src/grimbang/game4_back.png";
      ImageIcon chiIcon2 = new ImageIcon(icon2);
      Image scaledImage2 = chiIcon2.getImage().getScaledInstance(1050, 700, Image.SCALE_SMOOTH);
      chiIcon2 = new ImageIcon(scaledImage2);
      lblNewLabel_8.setIcon(chiIcon2);
      
      // 홈으로 나가기 버튼
      JButton btnNewButton_2 = new JButton("");
      btnNewButton_2.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		new main_1().setVisible(true);
      		setVisible(false);
            dispose();
      	}
      });
      btnNewButton_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      btnNewButton_2.setOpaque(false);
      btnNewButton_2.setContentAreaFilled(false);
      btnNewButton_2.setBorderPainted(false);
      btnNewButton_2.setBounds(964, 321, 64, 58);
      contentPane.add(btnNewButton_2);
      
      
      // tablet
      JLabel lblNewLabel_9 = new JLabel("");
      lblNewLabel_9.setBounds(0, 0, 1050, 700);
      contentPane.add(lblNewLabel_9);
      String icon1 = "./src/grimbang/tab.png";
      ImageIcon chiIcon = new ImageIcon(icon1);
      Image scaledImage = chiIcon.getImage().getScaledInstance(1050, 700, Image.SCALE_SMOOTH);
      chiIcon1 = new ImageIcon(scaledImage);
      lblNewLabel_9.setIcon(chiIcon1);
      
      
   
      
   }
}
