package games;

import javax.swing.*;

import chart.chart;
import conn.score_dao;
import main_1.main_1;
import rule.game1_rule;
import rule.game4_rule;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class game1 extends JFrame {
    private JPanel contentPane;
    private JButton[] buttons = new JButton[12];    // 버튼을 배열화 해서 저장한다.
    private ArrayList<ImageIcon> cardImage;        // 카드 이미지를 이미지리스트로 배열
    private JButton firstCard, secondCard;
    private Timer timer;
    private int pairsFound = 0;
    private int attempt = 0;
    private ImageIcon scaledIcon1, chiIcon1;


    String ID_1;
    int score;

    public game1(String selectType) {    // selectType은 cardGame = new game("문자열"); 처럼 문자열을 받는다.
        setTitle("카드 뒤집기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430,150, 1068, 739);
        contentPane = new JPanel();
        setContentPane(contentPane);
        
		contentPane.setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));

        // 버튼 초기화 및 위치 설정
        initializeButtons();

       
        // 메인창으로 가는 버튼 (홈버튼)
        JButton btnNewButton_12 = new JButton("");
        btnNewButton_12.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_12.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
        	   new main_1().setVisible(true);
              dispose(); 
              setVisible(false); 
              
         }
      });
      btnNewButton_12.setBounds(975, 326, 44, 44);
      btnNewButton_12.setBorderPainted(false);     // 버튼 테두리 비활성화
      btnNewButton_12.setContentAreaFilled(false); // 버튼 내용 영역 비활성화
      btnNewButton_12.setFocusPainted(false);      // 버튼 포커스 비활성화
      contentPane.setLayout(null);                 // 레이아웃 설정
      contentPane.add(btnNewButton_12);
        
     
        JButton btnNewButton_13 = new JButton("");
        btnNewButton_13.setBackground(Color.WHITE);
        btnNewButton_13.setBounds(113, 73, 39, 47);
        btnNewButton_13.setIcon(new ImageIcon(game1.class.getResource("/grimbang/rule.png")));
        btnNewButton_13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                game1_rule stagame = new game1_rule();
                stagame.setVisible(true);
            }
        });
        contentPane.add(btnNewButton_13);
        

        
        
        // tablet
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(0, 0, 1050, 700);
        contentPane.add(lblNewLabel_1);
        String icon1 = "./src/grim_game1/cardback.png";
        ImageIcon chiIcon = new ImageIcon(icon1);
        Image scaledImage2 = chiIcon.getImage().getScaledInstance(1050, 700, Image.SCALE_SMOOTH);
        chiIcon1 = new ImageIcon(scaledImage2);
        lblNewLabel_1.setIcon(chiIcon1);
        
        

        // 카드 이미지 로드
        loadCardImage(selectType);

        // 카드 뒷면 이미지 로드
        String cardBackPath = "/grim_game1/cardBack-fruit.png";
        ImageIcon cardBackIcon = new ImageIcon(getClass().getResource(cardBackPath));

        // 이미지 크기 조정
        Image scaledImage1 = cardBackIcon.getImage().getScaledInstance(91,100, Image.SCALE_SMOOTH);
        scaledIcon1 = new ImageIcon(scaledImage1);


        // 버튼에 이미지 설정 및 클릭 이벤트 추가
        Collections.shuffle(cardImage);               // 카드 이미지 셔플
        for (int i = 0; i < buttons.length; i++) {    // 버튼 배열 반복
            JButton button = buttons[i];              // 버튼 가져오기
            button.setIcon(scaledIcon1);              // 버튼에 뒷면 이미지 설정
            button.setDisabledIcon(cardImage.get(i)); // 버튼 비활성화 아이콘 설정
            button.addMouseListener(new CardClickListener());
        }
    }

    // 버튼 초기화 및 위치 설정 메서드
    private void initializeButtons() {                
        buttons[0] = new JButton("");
        buttons[0].setBounds(286, 287, 91, 100);
        contentPane.add(buttons[0]);
        buttons[0].setBackground(Color.WHITE);

        buttons[1] = new JButton("");
        buttons[1].setBounds(286, 404, 91, 100);
        contentPane.add(buttons[1]);
        buttons[1].setBackground(Color.WHITE);

        buttons[2] = new JButton("");
        buttons[2].setBounds(286, 521, 91, 100);
        contentPane.add(buttons[2]);
        buttons[2].setBackground(Color.WHITE);

        buttons[3] = new JButton("");
        buttons[3].setBounds(417, 287, 91, 100);
        contentPane.add(buttons[3]);
        buttons[3].setBackground(Color.WHITE);

        buttons[4] = new JButton("");
        buttons[4].setBounds(547, 287, 91, 100);
        contentPane.add(buttons[4]);
        buttons[4].setBackground(Color.WHITE);

        buttons[5] = new JButton("");
        buttons[5].setBounds(677, 287, 91, 100);
        contentPane.add(buttons[5]);
        buttons[5].setBackground(Color.WHITE);

        buttons[6] = new JButton("");
        buttons[6].setBounds(417, 404, 91, 100);
        contentPane.add(buttons[6]);
        buttons[6].setBackground(Color.WHITE);

        buttons[7] = new JButton("");
        buttons[7].setBounds(547, 404, 91, 100);
        contentPane.add(buttons[7]);
        buttons[7].setBackground(Color.WHITE);

        buttons[8] = new JButton("");
        buttons[8].setBounds(677, 404, 91, 100);
        contentPane.add(buttons[8]);
        buttons[8].setBackground(Color.WHITE);

        buttons[9] = new JButton("");       
        buttons[9].setBounds(417, 521, 91, 100);
        contentPane.add(buttons[9]);
        buttons[9].setBackground(Color.WHITE);

        buttons[10] = new JButton("");        
        buttons[10].setBounds(547, 521, 91, 100);
        contentPane.add(buttons[10]);
        buttons[10].setBackground(Color.WHITE);

        buttons[11] = new JButton("");       
        buttons[11].setBounds(677, 521, 91, 100);
        contentPane.add(buttons[11]);
        buttons[11].setBackground(Color.WHITE);
    }

    // 카드 이미지 로드 메서드
    private void loadCardImage(String selectType) {
    	 // 이미지 리스트 초기화
        cardImage = new ArrayList<>();             
        for (int i = 1; i <= 6; i++) {    // 카드 이미지 6쌍 로드
            // 원본 이미지 로드
            ImageIcon originalIcon = new ImageIcon(getClass().getResource("/grim_game1/" + selectType + i + ".png"));
            if (originalIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {       
            }
            // 이미지 크기 조정
            Image scaledImage = originalIcon.getImage().getScaledInstance(91,100, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // 카드 이미지 리스트에 추가
            cardImage.add(scaledIcon);   
            cardImage.add(scaledIcon);  // 이미지 리스트에 중복 추가 (쌍 맞추기 위해)
        }
    }

    
    private class CardClickListener extends MouseAdapter {
        @Override
        public void mouseReleased(MouseEvent e) {
            JButton clickedButton = (JButton) e.getSource();

            if (!clickedButton.isEnabled()) { // 활성화되지 않은 버튼 클릭 시
                return;                       // 중단
            }

            if (firstCard == null) { // 첫 번째 카드를 클릭한 경우
                firstCard = clickedButton;
                firstCard.setIcon((ImageIcon) firstCard.getDisabledIcon());
            } else if (secondCard == null && clickedButton != firstCard) { // 두 번째 카드를 클릭한 경우
                secondCard = clickedButton;
                secondCard.setIcon((ImageIcon) secondCard.getDisabledIcon());
                checkForMatch(); // 일치 여부 확인
            }
        }

        // 두 카드가 일치하는지 확인하는 메서드 
        private void checkForMatch() { 
        	
            try {
                ImageIcon changefirstcard = (ImageIcon) firstCard.getDisabledIcon();
                ImageIcon changesecondcard = (ImageIcon) secondCard.getDisabledIcon();
                
                if (changefirstcard.equals(changesecondcard)) { // 첫 번째 카드와 두 번째 카드가 일치하는 경우
                    firstCard.setEnabled(false); // 버튼 비활성화
                    secondCard.setEnabled(false); // 버튼 비활성화
                    firstCard.setIcon((ImageIcon) firstCard.getDisabledIcon()); // 아이콘 설정
                    secondCard.setIcon((ImageIcon) secondCard.getDisabledIcon());
                    attempt += 5;
                    pairsFound++;
                    resetCards();
 
                    if (pairsFound == 6) {
                        JOptionPane.showMessageDialog(contentPane, "축하합니다!" + "\n" + "시도 횟수 : " + (attempt / 5) + "회" + "\n" + "점수 : " + (106 - attempt) + "점");
                        score = 106-attempt;
                        score_dao tidao = null;
                        
                        try {
                        tidao = new score_dao();
                     } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
               
                     } catch (SQLException e1) {
                        e1.printStackTrace();}
                        
                      //디비로 넘기기
                        boolean b1 = tidao.game1_score(score);
                        chart.score1(score);
                        if(b1) {
                       System.out.println("update ok");
                    }
                    else
                       System.out.println("update error"); 
                        new game2().setVisible(true);
                        dispose();
                        setVisible(false);
                        
                    }
                } else { // 두 카드가 일치하지 않는 경우
                   
                    timer = new Timer(500, e -> { // 0.5초 후
                        firstCard.setIcon(scaledIcon1);  // 카드 숨기기
                        secondCard.setIcon(scaledIcon1); // 카드 숨기기
                        attempt += 5;
 //                       attemptLabel.setText("시도한 횟수 : " + (attempt / 5));
                        if ((106 - attempt) <= 6) {
                            JOptionPane.showMessageDialog(contentPane, "실패하셨습니다!" + "\n" + "점수 : 0점");
                            score = 0;
                            chart.score1(score);
                            new game2().setVisible(true);
                            dispose();
                            setVisible(false);
                            
                        }
                        resetCards();    // 두 카드가 일치하지 않는 경우 카드초기화 
                    });
                    
                    timer.setRepeats(false); // 타이머 반복 방지
                    timer.start(); // 0.5초 타이머 시작
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void resetCards() { // 카드 초기화 메서드
            firstCard = null;       // 첫 번째 카드 초기화
            secondCard = null;      // 두 번째 카드 초기화
        }
    }

    public static void main(String[] args) {
            try {
                game1 frame = new game1("animal");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
          
    }
}
