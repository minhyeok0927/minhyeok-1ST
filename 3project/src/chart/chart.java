package chart;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import conn.score_dao;
import games.game;
import main_1.main_1;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;


import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class chart extends JFrame {

   private JPanel contentPane;
   private static String ID_1;
   private static String DATE;
   private static int score1;
   private static int score2;
   private static int score3;
   private static int score4;
   private double score1_avg;
   private double score2_avg;
   private double score3_avg;
   private double score4_avg;
   private static boolean scoresProcessed = false;
   private ImageIcon chiIcon1;

   
    
   public static String id_(String iD_12) {
      ID_1 = iD_12;
        return ID_1;
   }
   
   public static String date_(String date2) {
      DATE = date2;
        return DATE;
   }
   
   public static int score1(int score2) {
      score1 = score2;
        return score1;
      
   }
   public static int score2(int score3) {
	  score2 = score3;
	        return score2;
	      
	   }
   public static int score3(int score2) {
	      score3 = score2;
	        return score3;
	      
	   }
   public static int score4(int score2) {
	      score4 = score2;
	        return score4;
	      
	   }
   
   

    
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               chart frame = new chart();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
   


   public chart() throws SQLException{
	   
	   score_dao tidao = null;

		try {
			tidao = new score_dao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		  tidao.rank_score(score1,score2,score3,score4);
		  
		  
		  
		  ArrayList<conn.score_vo> tiArray=tidao.getscore_avg();
	      // 컬렉션전체를 갖고 오므로 
		  for(conn.score_vo imsi : tiArray){
			  score1_avg = imsi.getScore1();
			  score2_avg = imsi.getScore2();
			  score3_avg = imsi.getScore3();
			  score4_avg = imsi.getScore4();
		  }
		  

  

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(430,150, 1068, 739);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      
		contentPane.setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
      
      JLabel ID = new JLabel(ID_1);
      ID.setFont(new Font("굴림", Font.PLAIN, 25));
      ID.setHorizontalAlignment(SwingConstants.CENTER);
      ID.setBounds(123, 206, 349, 43);
      contentPane.add(ID);
      
      JLabel date = new JLabel(DATE);
      date.setHorizontalAlignment(SwingConstants.CENTER);
      date.setFont(new Font("굴림", Font.PLAIN, 25));
      date.setBounds(471, 206, 459, 43);
      contentPane.add(date);
      
      JLabel num1 = new JLabel(String.valueOf(score1));
      num1.setFont(new Font("굴림", Font.PLAIN, 25));
      num1.setHorizontalAlignment(SwingConstants.CENTER);
      num1.setBounds(313, 300, 159, 37);
      contentPane.add(num1);
      
      JLabel num2 = new JLabel(String.valueOf(score2));
      num2.setFont(new Font("굴림", Font.PLAIN, 25));
      num2.setHorizontalAlignment(SwingConstants.CENTER);
      num2.setBounds(471, 300, 148, 37);
      contentPane.add(num2);
      
      JLabel num3 = new JLabel(String.valueOf(score3));
      num3.setFont(new Font("굴림", Font.PLAIN, 25));
      num3.setHorizontalAlignment(SwingConstants.CENTER);
      num3.setBounds(625, 300, 148, 37);
      contentPane.add(num3);
      
      JLabel num4 = new JLabel(String.valueOf(score4));
      num4.setFont(new Font("굴림", Font.PLAIN, 25));
      num4.setHorizontalAlignment(SwingConstants.CENTER);
      num4.setBounds(777, 300, 153, 37);
      contentPane.add(num4);
      
      JLabel lblNewLabel_10 = new JLabel("\uB514 \uC9C0 \uD138  \uB3D9 \uB8CC \uB4E4  \uD3C9 \uAC00 \uC7A5");
      lblNewLabel_10.setFont(new Font("굴림", Font.PLAIN, 25));
      lblNewLabel_10.setBounds(394, 624, 308, 37);
      contentPane.add(lblNewLabel_10);
      
      // 차트 생성 및 표시
      CategoryDataset dataset = createDataset();
      JFreeChart chart = createChart(dataset);
      ChartPanel chartPanel = new ChartPanel(chart);
      chartPanel.setPreferredSize(new Dimension(560, 370));
      chartPanel.setBounds(123, 347, 813, 267);  // 차트 위치 및 크기 설정
      contentPane.add(chartPanel);
      
      JLabel lblNewLabel = new JLabel("");
      lblNewLabel.setBounds(661, 612, 57, 57);
      contentPane.add(lblNewLabel);
      String icon11 = "C:/Myjava/3project/src/grimbang/in.png";
      ImageIcon chiIcon = new ImageIcon(icon11);
      Image scaledImage2 = chiIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
      chiIcon1 = new ImageIcon(scaledImage2);
      lblNewLabel.setIcon(chiIcon1);
      
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
    btnNewButton_12.setBorderPainted(false);
    btnNewButton_12.setContentAreaFilled(false);
    btnNewButton_12.setFocusPainted(false); 
     
      contentPane.setLayout(null);
      contentPane.add(btnNewButton_12);
      
   // tablet
      JLabel lblNewLabel_9 = new JLabel("");
      lblNewLabel_9.setBounds(0, 0, 1050, 700);
      contentPane.add(lblNewLabel_9);
      String icon111 = "C:/Myjava/3project/src/grimbang/chart.png";
      ImageIcon chiIcon1 = new ImageIcon(icon111);
      Image scaledImage21 = chiIcon1.getImage().getScaledInstance(1050, 700, Image.SCALE_SMOOTH);
      chiIcon1 = new ImageIcon(scaledImage21);
      lblNewLabel_9.setIcon(chiIcon1);
      
      

      setVisible(true);
   }

   private CategoryDataset createDataset() {
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       dataset.addValue(score1, "내 점수", "Card Select");
       dataset.addValue(score2, "내 점수", "TTS");
       dataset.addValue(score3, "내 점수", "Hangman");
       dataset.addValue(score4, "내 점수", "Number Baseball");
       dataset.addValue(score1_avg, "평균 점수", "Card Select");
       dataset.addValue(score2_avg, "평균 점수", "TTS");
       dataset.addValue(score3_avg, "평균 점수", "Hangman");
       dataset.addValue(score4_avg, "평균 점수", "Number Baseball");
       
       
       return dataset;
   }

   private JFreeChart createChart(CategoryDataset dataset) {
       JFreeChart chart = ChartFactory.createBarChart(
               "GAME OLYMPIAD 성적표",     // 차트 제목
               "게임명",              // X 축 레이블
               "점수",                 // Y 축 레이블
               dataset,                 // 데이터셋
               PlotOrientation.VERTICAL, // 차트 방향 (수직)
               true,                    // 범례 포함 여부
               true,                    // 도구팁 표시 여부
               false                    // URL 링크 포함 여부
       );

       chart.getTitle().setFont(new Font("맑은 고딕", Font.BOLD, 18));  // 예시로 '맑은 고딕' 폰트 사용
       chart.getCategoryPlot().getDomainAxis().setLabelFont(new Font("맑은 고딕", Font.PLAIN, 14));
       chart.getCategoryPlot().getRangeAxis().setLabelFont(new Font("맑은 고딕", Font.PLAIN, 14));
       chart.getLegend().setItemFont(new Font("맑은 고딕", Font.PLAIN, 12));

       return chart;

   }
}
