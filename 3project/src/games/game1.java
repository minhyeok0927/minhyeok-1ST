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
    private JButton[] buttons = new JButton[12];    // ��ư�� �迭ȭ �ؼ� �����Ѵ�.
    private ArrayList<ImageIcon> cardImage;        // ī�� �̹����� �̹�������Ʈ�� �迭
    private JButton firstCard, secondCard;
    private Timer timer;
    private int pairsFound = 0;
    private int attempt = 0;
    private ImageIcon scaledIcon1, chiIcon1;


    String ID_1;
    int score;

    public game1(String selectType) {    // selectType�� cardGame = new game("���ڿ�"); ó�� ���ڿ��� �޴´�.
        setTitle("ī�� ������");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430,150, 1068, 739);
        contentPane = new JPanel();
        setContentPane(contentPane);
        
		contentPane.setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));

        // ��ư �ʱ�ȭ �� ��ġ ����
        initializeButtons();

       
        // ����â���� ���� ��ư (Ȩ��ư)
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
      btnNewButton_12.setBorderPainted(false);     // ��ư �׵θ� ��Ȱ��ȭ
      btnNewButton_12.setContentAreaFilled(false); // ��ư ���� ���� ��Ȱ��ȭ
      btnNewButton_12.setFocusPainted(false);      // ��ư ��Ŀ�� ��Ȱ��ȭ
      contentPane.setLayout(null);                 // ���̾ƿ� ����
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
        
        

        // ī�� �̹��� �ε�
        loadCardImage(selectType);

        // ī�� �޸� �̹��� �ε�
        String cardBackPath = "/grim_game1/cardBack-fruit.png";
        ImageIcon cardBackIcon = new ImageIcon(getClass().getResource(cardBackPath));

        // �̹��� ũ�� ����
        Image scaledImage1 = cardBackIcon.getImage().getScaledInstance(91,100, Image.SCALE_SMOOTH);
        scaledIcon1 = new ImageIcon(scaledImage1);


        // ��ư�� �̹��� ���� �� Ŭ�� �̺�Ʈ �߰�
        Collections.shuffle(cardImage);               // ī�� �̹��� ����
        for (int i = 0; i < buttons.length; i++) {    // ��ư �迭 �ݺ�
            JButton button = buttons[i];              // ��ư ��������
            button.setIcon(scaledIcon1);              // ��ư�� �޸� �̹��� ����
            button.setDisabledIcon(cardImage.get(i)); // ��ư ��Ȱ��ȭ ������ ����
            button.addMouseListener(new CardClickListener());
        }
    }

    // ��ư �ʱ�ȭ �� ��ġ ���� �޼���
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

    // ī�� �̹��� �ε� �޼���
    private void loadCardImage(String selectType) {
    	 // �̹��� ����Ʈ �ʱ�ȭ
        cardImage = new ArrayList<>();             
        for (int i = 1; i <= 6; i++) {    // ī�� �̹��� 6�� �ε�
            // ���� �̹��� �ε�
            ImageIcon originalIcon = new ImageIcon(getClass().getResource("/grim_game1/" + selectType + i + ".png"));
            if (originalIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {       
            }
            // �̹��� ũ�� ����
            Image scaledImage = originalIcon.getImage().getScaledInstance(91,100, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // ī�� �̹��� ����Ʈ�� �߰�
            cardImage.add(scaledIcon);   
            cardImage.add(scaledIcon);  // �̹��� ����Ʈ�� �ߺ� �߰� (�� ���߱� ����)
        }
    }

    
    private class CardClickListener extends MouseAdapter {
        @Override
        public void mouseReleased(MouseEvent e) {
            JButton clickedButton = (JButton) e.getSource();

            if (!clickedButton.isEnabled()) { // Ȱ��ȭ���� ���� ��ư Ŭ�� ��
                return;                       // �ߴ�
            }

            if (firstCard == null) { // ù ��° ī�带 Ŭ���� ���
                firstCard = clickedButton;
                firstCard.setIcon((ImageIcon) firstCard.getDisabledIcon());
            } else if (secondCard == null && clickedButton != firstCard) { // �� ��° ī�带 Ŭ���� ���
                secondCard = clickedButton;
                secondCard.setIcon((ImageIcon) secondCard.getDisabledIcon());
                checkForMatch(); // ��ġ ���� Ȯ��
            }
        }

        // �� ī�尡 ��ġ�ϴ��� Ȯ���ϴ� �޼��� 
        private void checkForMatch() { 
        	
            try {
                ImageIcon changefirstcard = (ImageIcon) firstCard.getDisabledIcon();
                ImageIcon changesecondcard = (ImageIcon) secondCard.getDisabledIcon();
                
                if (changefirstcard.equals(changesecondcard)) { // ù ��° ī��� �� ��° ī�尡 ��ġ�ϴ� ���
                    firstCard.setEnabled(false); // ��ư ��Ȱ��ȭ
                    secondCard.setEnabled(false); // ��ư ��Ȱ��ȭ
                    firstCard.setIcon((ImageIcon) firstCard.getDisabledIcon()); // ������ ����
                    secondCard.setIcon((ImageIcon) secondCard.getDisabledIcon());
                    attempt += 5;
                    pairsFound++;
                    resetCards();
 
                    if (pairsFound == 6) {
                        JOptionPane.showMessageDialog(contentPane, "�����մϴ�!" + "\n" + "�õ� Ƚ�� : " + (attempt / 5) + "ȸ" + "\n" + "���� : " + (106 - attempt) + "��");
                        score = 106-attempt;
                        score_dao tidao = null;
                        
                        try {
                        tidao = new score_dao();
                     } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
               
                     } catch (SQLException e1) {
                        e1.printStackTrace();}
                        
                      //���� �ѱ��
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
                } else { // �� ī�尡 ��ġ���� �ʴ� ���
                   
                    timer = new Timer(500, e -> { // 0.5�� ��
                        firstCard.setIcon(scaledIcon1);  // ī�� �����
                        secondCard.setIcon(scaledIcon1); // ī�� �����
                        attempt += 5;
 //                       attemptLabel.setText("�õ��� Ƚ�� : " + (attempt / 5));
                        if ((106 - attempt) <= 6) {
                            JOptionPane.showMessageDialog(contentPane, "�����ϼ̽��ϴ�!" + "\n" + "���� : 0��");
                            score = 0;
                            chart.score1(score);
                            new game2().setVisible(true);
                            dispose();
                            setVisible(false);
                            
                        }
                        resetCards();    // �� ī�尡 ��ġ���� �ʴ� ��� ī���ʱ�ȭ 
                    });
                    
                    timer.setRepeats(false); // Ÿ�̸� �ݺ� ����
                    timer.start(); // 0.5�� Ÿ�̸� ����
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void resetCards() { // ī�� �ʱ�ȭ �޼���
            firstCard = null;       // ù ��° ī�� �ʱ�ȭ
            secondCard = null;      // �� ��° ī�� �ʱ�ȭ
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
