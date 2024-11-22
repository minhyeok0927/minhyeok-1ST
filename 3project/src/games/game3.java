package games;

import java.awt.EventQueue;
import conn.score_dao;
import rule.game3_rule;
import rule.game4_rule;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chart.chart;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;



class ImagePanel extends JPanel {
    private Image backgroundImage;

    public ImagePanel(String imagePath) {
        this.backgroundImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

public class game3 extends JFrame {
	private ImageIcon tabletIcon2;
   private ImageIcon tabletIcon1;
   private JPanel contentPane;
   private String secretWord; // 단어 설정
    private JLabel lblSecretWord;
    public int wrongGuesses = 0;
    public int maxscore = 100;
    private JLabel lblNewLabel_3 = new JLabel("\uD2C0\uB9B0 \uD69F\uC218");
    private JLabel lblNewLabel_2 = new JLabel("\uADF8\uB9BC\r\n");
    private String[] Word = { "monster", "basketball", "train", "telephone", "magic", "elephant", "science", "project", "oxigen" };
    private String[] images = {
            "./src/grimbang/hangman0.jpg",
              "./src/grimbang/hangman1.jpg",
              "./src/grimbang/hangman2.jpg",
              "./src/grimbang/hangman3.jpg",
              "./src/grimbang/hangman4.jpg",
              "./src/grimbang/hangman5.jpg",
              "./src/grimbang/hangman6.jpg",
              "./src/grimbang/hangman7.jpg",
              "./src/grimbang/hangman8.jpg",
              "./src/grimbang/hangman9.jpg",
              "./src/grimbang/hangman10.jpg",
              
              
    };

    static String ID_1;
    
    public String test_id(String id) {
        ID_1 = id;
        return ID_1;
     }
//    
//    int score;

    /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               game3 frame = new game3();
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
   public game3() {
      
     
     
     
     
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(430,150, 1068, 739);

        //ContentPane에 ImagePanel을 사용하여 배경 이미지 설정
       contentPane = new JPanel();
       contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

       setContentPane(contentPane);
       contentPane.setLayout(null);
       
		contentPane.setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
      
      JLabel lblNewLabel = new JLabel("Hangman");
      lblNewLabel.setForeground(new Color(255, 255, 255));
      lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 27));
      lblNewLabel.setBounds(127, 271, 180, 64);
      contentPane.add(lblNewLabel);
      
      JButton btnNewButton = new JButton("");
      btnNewButton.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		new game3_rule().setVisible(true);
      	}
      });
      btnNewButton.setIcon(new ImageIcon(game3.class.getResource("/grimbang/rule.png")));
      btnNewButton.setBackground(Color.WHITE);
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnNewButton.setBounds(113, 73, 39, 47);
      contentPane.add(btnNewButton);
      
      lblSecretWord = new JLabel("");
      lblSecretWord.setForeground(new Color(255, 255, 255));
        lblSecretWord.setFont(new Font("굴림", Font.PLAIN, 30));
        lblSecretWord.setBounds(281, 171, 273, 93);
        contentPane.add(lblSecretWord);
      
      JButton btnNewButton_1 = new JButton("A");
     
      btnNewButton_1.addMouseListener(new MouseAdapter() {
         
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('a');
         }
         
      });
      btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 20));
      btnNewButton_1.setBounds(208, 501, 50, 50);
      contentPane.add(btnNewButton_1);
      makeButtonInvisible(btnNewButton_1);
      
      JButton btnNewButton_1_1 = new JButton("B\r\n");
      makeButtonInvisible(btnNewButton_1_1);
      btnNewButton_1_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            
               checkLetter('B');
            
          
         }
      });
      btnNewButton_1_1.setBounds(469, 561, 50, 50);
      contentPane.add(btnNewButton_1_1);
   
      
      JButton btnNewButton_1_2 = new JButton("C\r\n");
      makeButtonInvisible(btnNewButton_1_2);
      btnNewButton_1_2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('C');
         }
      });
      btnNewButton_1_2.setBounds(350, 561, 50, 50);
      contentPane.add(btnNewButton_1_2);
      
      JButton btnNewButton_1_3 = new JButton("D\r\n");
      makeButtonInvisible(btnNewButton_1_3);
      btnNewButton_1_3.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('D');
         }
      });
      btnNewButton_1_3.setBounds(322, 501, 50, 50);
      contentPane.add(btnNewButton_1_3);
      
      JButton btnNewButton_1_4 = new JButton("E");
      makeButtonInvisible(btnNewButton_1_4);
      btnNewButton_1_4.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('E');
         }
         
      });
      btnNewButton_1_4.setBounds(312, 452, 50, 50);
      contentPane.add(btnNewButton_1_4);
      
      JButton btnNewButton_1_5 = new JButton("F");
      makeButtonInvisible(btnNewButton_1_5);
      btnNewButton_1_5.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('F');
         }
      });
      btnNewButton_1_5.setBounds(376, 501, 50, 50);
      contentPane.add(btnNewButton_1_5);
      
      JButton btnNewButton_1_6 = new JButton("G");
      makeButtonInvisible(btnNewButton_1_6);
      btnNewButton_1_6.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('G');
         }
      });
      btnNewButton_1_6.setBounds(438, 501, 50, 50);
      contentPane.add(btnNewButton_1_6);
      
      
      
      
      JButton btnNewButton_1_7 = new JButton("H");
      makeButtonInvisible(btnNewButton_1_7);
      btnNewButton_1_7.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('H');
         }
      });
      btnNewButton_1_7.setBounds(500, 501, 50, 50);
      contentPane.add(btnNewButton_1_7);
      
      JButton btnNewButton_1_8 = new JButton("I");
      makeButtonInvisible(btnNewButton_1_8);
      btnNewButton_1_8.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('I');
         }
      });
      btnNewButton_1_8.setBounds(604, 452, 50, 50);
      contentPane.add(btnNewButton_1_8);
      
      JButton btnNewButton_1_9 = new JButton("J");
      makeButtonInvisible(btnNewButton_1_9);
      btnNewButton_1_9.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('J');
         }
      });
      btnNewButton_1_9.setBounds(562, 501, 50, 50);
      contentPane.add(btnNewButton_1_9);
      
      JButton btnNewButton_1_10 = new JButton("K");
      makeButtonInvisible(btnNewButton_1_10);
      btnNewButton_1_10.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('K');
         }
      });
      btnNewButton_1_10.setBounds(614, 501, 50, 50);
      contentPane.add(btnNewButton_1_10);
      
      JButton btnNewButton_1_11 = new JButton("L");
      makeButtonInvisible(btnNewButton_1_11);
      btnNewButton_1_11.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('L');
         }
      });
      btnNewButton_1_11.setBounds(678, 501, 50, 50);
      contentPane.add(btnNewButton_1_11);
      
      JButton btnNewButton_1_12 = new JButton("M");
      makeButtonInvisible(btnNewButton_1_12);
      btnNewButton_1_12.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('M');
         }
      });
      btnNewButton_1_12.setBounds(588, 561, 50, 50);
      contentPane.add(btnNewButton_1_12);
      
      JButton btnNewButton_1_13 = new JButton("N");
      makeButtonInvisible(btnNewButton_1_13);
      btnNewButton_1_13.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('N');
         }
      });
      btnNewButton_1_13.setBounds(526, 561, 50, 50);
      contentPane.add(btnNewButton_1_13);
      
      JButton btnNewButton_1_14 = new JButton("O");
      makeButtonInvisible(btnNewButton_1_14);
      btnNewButton_1_14.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('O');
         }
      });
      btnNewButton_1_14.setBounds(658, 452, 50, 50);
      contentPane.add(btnNewButton_1_14);
      
      JButton btnNewButton_1_15 = new JButton("P");
      makeButtonInvisible(btnNewButton_1_15);
      btnNewButton_1_15.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('P');
         }
      });
      btnNewButton_1_15.setBounds(720, 452, 50, 50);
      contentPane.add(btnNewButton_1_15);
      
      JButton btnNewButton_1_16 = new JButton("Q");
      makeButtonInvisible(btnNewButton_1_16);
      btnNewButton_1_16.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('Q');
         }
      });
      btnNewButton_1_16.setBounds(188, 452, 50, 50);
      contentPane.add(btnNewButton_1_16);
      
      JButton btnNewButton_1_17 = new JButton("R");
      makeButtonInvisible(btnNewButton_1_17);
      btnNewButton_1_17.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('R');
         }
      });
      btnNewButton_1_17.setBounds(362, 452, 50, 50);
      contentPane.add(btnNewButton_1_17);
      
      JButton btnNewButton_1_18 = new JButton("S");
      makeButtonInvisible(btnNewButton_1_18);
      btnNewButton_1_18.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('S');
         }
      });
      btnNewButton_1_18.setBounds(260, 501, 50, 50);
      contentPane.add(btnNewButton_1_18);
      
      JButton btnNewButton_1_19 = new JButton("T");
      makeButtonInvisible(btnNewButton_1_19);
      btnNewButton_1_19.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('T');
         }
      });
      btnNewButton_1_19.setBounds(424, 452, 50, 50);
      contentPane.add(btnNewButton_1_19);
      
      JButton btnNewButton_1_20 = new JButton("U");
      makeButtonInvisible(btnNewButton_1_20);
      btnNewButton_1_20.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('U');
         }
      });
      btnNewButton_1_20.setBounds(542, 452, 50, 50);
      contentPane.add(btnNewButton_1_20);
      
      JButton btnNewButton_1_21 = new JButton("V");
      makeButtonInvisible(btnNewButton_1_21);
      btnNewButton_1_21.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('V');
         }
      });
      btnNewButton_1_21.setBounds(411, 561, 50, 50);
      contentPane.add(btnNewButton_1_21);
      
      JButton btnNewButton_1_22 = new JButton("W");
      makeButtonInvisible(btnNewButton_1_22);
      btnNewButton_1_22.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('W');
         }
      });
      btnNewButton_1_22.setBounds(250, 452, 50, 50);
      contentPane.add(btnNewButton_1_22);
      
      JButton btnNewButton_1_23 = new JButton("X");
      makeButtonInvisible(btnNewButton_1_23);
      btnNewButton_1_23.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('X');
         }
      });
      btnNewButton_1_23.setBounds(295, 561, 50, 50);
      contentPane.add(btnNewButton_1_23);
      
      JButton btnNewButton_1_24 = new JButton("Y");
      makeButtonInvisible(btnNewButton_1_24);
      btnNewButton_1_24.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('Y');
         }
      });
      btnNewButton_1_24.setBounds(481, 452, 50, 50);
      contentPane.add(btnNewButton_1_24);
      
      JButton btnNewButton_1_25 = new JButton("Z");
      makeButtonInvisible(btnNewButton_1_25);
      btnNewButton_1_25.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            checkLetter('Z');
         }
      });
      btnNewButton_1_25.setBounds(233, 561, 50, 50);
      contentPane.add(btnNewButton_1_25);
      
      JButton btnNewButton_2 = new JButton("");
      btnNewButton_2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	 new main_1.main_1().setVisible(true);
             dispose(); 
             setVisible(false);
             
         }
      });
      btnNewButton_2.setBounds(976, 326, 44, 44);
      btnNewButton_2.setBorderPainted(false);
      btnNewButton_2.setContentAreaFilled(false);
      btnNewButton_2.setFocusPainted(false);
      
      
      contentPane.add(btnNewButton_2);
      lblNewLabel_3.setForeground(Color.WHITE);
      
      JLabel lblNewLabel_6 = new JLabel("");
      lblNewLabel_6.setBounds(373, 608, 315, 63);
      contentPane.add(lblNewLabel_6);
      lblNewLabel_3.setBackground(new Color(255, 255, 255));
      lblNewLabel_3.setForeground(new Color(0, 0, 0));
      
      String icon3 = "./src/grimbang/game3_logo.png";
      ImageIcon tabletIcon3 = new ImageIcon(icon3);

      // 이미지 크기 조정
      Image scaledImage4 = tabletIcon3.getImage().getScaledInstance(300, 50, Image.SCALE_SMOOTH);
      tabletIcon2 = new ImageIcon(scaledImage4);
      lblNewLabel_6.setIcon(tabletIcon2);
      
      
      
      lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 25));
      lblNewLabel_3.setBounds(127, 312, 203, 70);
      contentPane.add(lblNewLabel_3);
      
      
      lblNewLabel_2.setIcon(new ImageIcon(images[0]));
      lblNewLabel_2.setBounds(99, 66, 853, 341);
      contentPane.add(lblNewLabel_2);
      
      JLabel lblNewLabel_1 = new JLabel("");
      lblNewLabel_1.setIcon(new ImageIcon(game3.class.getResource("/grimbang/key.png")));
      lblNewLabel_1.setBounds(99, 372, 853, 328);
      contentPane.add(lblNewLabel_1);
      
      JLabel lblNewLabel_5 = new JLabel("");
      lblNewLabel_5.setBounds(0, 0, 1050, 700);
      contentPane.add(lblNewLabel_5);
      
      
      
      String icon2 = "./src/grimbang/tab.png";
      ImageIcon tabletIcon = new ImageIcon(icon2);

      // 이미지 크기 조정
      Image scaledImage3 = tabletIcon.getImage().getScaledInstance(1050, 700, Image.SCALE_SMOOTH);
      tabletIcon1 = new ImageIcon(scaledImage3);
      lblNewLabel_5.setIcon(tabletIcon1);
      
      JLabel lblNewLabel_4 = new JLabel("");
      lblNewLabel_4.setBounds(99, 66, 853, 341);
      contentPane.add(lblNewLabel_4);

      
      
      initializeGame();
     

      
   }
   
   private void initializeGame() {
       // 단어 랜덤 선택
       Random random = new Random();
       int randomIndex = random.nextInt(Word.length);
       secretWord = Word[randomIndex];

       // 라벨 초기화
       lblSecretWord.setText(getHiddenWord(secretWord));
       
   }

   private String getHiddenWord(String secretWord) {
      // TODO Auto-generated method stub
      if (secretWord == null || secretWord.length() == 0) {
           return ""; // 빈 문자열 반환 또는 에러 처리 방법에 맞게 수정
       }
      StringBuilder hidden = new StringBuilder(secretWord.length());
        for (int i = 0; i < secretWord.length(); i++) {
            hidden.append("_ ");
        }
        return hidden.toString();
   }
   private void updateImage() {
       if (wrongGuesses < images.length) {
           lblNewLabel_2.setIcon(new ImageIcon(images[wrongGuesses]));
       }
   }
   
   
   public void checkLetter(char guess) {
           boolean found = false;
           StringBuilder currentWord = new StringBuilder(lblSecretWord.getText());

           // 단어에 추측한 알파벳이 포함되어 있는지 확인
           for (int i = 0; i < secretWord.length(); i++) {
               if (Character.toUpperCase(secretWord.charAt(i)) == Character.toUpperCase(guess)) {
                  
                   found = true;
                   
                   currentWord.setCharAt(i*2, secretWord.charAt(i));
               
               }
               
               lblSecretWord.setText(currentWord.toString());    
           }
           
           if (!found) {
               wrongGuesses++;
               updateImage();
//               JOptionPane.showMessageDialog(null, "안들어갑니다. 틀린 횟수: " + wrongGuesses + " " +secretWord);
               JOptionPane.showMessageDialog(this,
                     "안들어갑니다. 틀린 횟수: " + wrongGuesses + " " +secretWord,
                       
                        "게임결과", JOptionPane.INFORMATION_MESSAGE);
               lblNewLabel_3.setText("틀린 횟수: " + wrongGuesses);
               checkGameOver();
           }else {
           checkIfWon(currentWord.toString());
           }
}
    public void checkIfWon(String currentGuess) {
       //끝나는 메세지
        // 모든 글자를 맞추었는지 확인
       String formattedSecretWord = secretWord.replaceAll(" ", "");
        String formattedCurrentGuess = currentGuess.replaceAll(" ", "");

        score_dao tidao = null;
        
      try {
         tidao = new score_dao();
      } catch (ClassNotFoundException e1) {
         e1.printStackTrace();

      } catch (SQLException e1) {
         e1.printStackTrace();
      } // 연결
        
        if (formattedCurrentGuess.equalsIgnoreCase(secretWord)) {
            
            JOptionPane.showMessageDialog(contentPane, "축하합니다!" + "\n" + "틀린 횟수 : " + wrongGuesses + "회" + "\n" + "점수 : " + (maxscore - 5 * wrongGuesses) + "점");
            
            int score = 100 -5*wrongGuesses;
            
        



//디비로 넘기기
             boolean b1 = tidao.game3_score(score);
             chart.score3(score);
             if(b1) {
            System.out.println("update ok");
            }
         else {
            System.out.println("update error");}

            
            dispose(); 
            setVisible(false);
            new game4().setVisible(true);
        }
    }
    
    public void makeButtonInvisible(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setText("");
    }
    
    public void checkGameOver() {
        if (wrongGuesses >= 10) {
           JOptionPane.showMessageDialog(contentPane, "실패하셨습니다!" + "\n" + "점수 : "+(maxscore - 5 * wrongGuesses));
           // 게임 종료
           int score = maxscore -5*wrongGuesses;
           score_dao tidao = null;
           
         try {
            tidao = new score_dao();
         } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
   
         } catch (SQLException e1) {
            e1.printStackTrace();
         } // 연결



//디비로 넘기기
                  boolean b1 = tidao.game3_score(score);
                  chart.score3(score);
                  if(b1) {
                  System.out.println("update ok");
               }
               else {
                  System.out.println("update error");}
           dispose(); 
           setVisible(false);
           new game4().setVisible(true);
        }
        
     }
    }