package chart;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import conn.score_dao;
import conn.score_vo;
import main_1.main_1;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

public class chart_main extends JFrame {
	
	private static String ID_1;
	int rank;
	int rank_1;
	public static String[] id_rank = new String[5];
	public static int[] jum_rank = new int[5];
	private JLabel[] labels;
	
	public static String id_(String iD_12) {
		ID_1 = iD_12;
		return ID_1;
	}
	
	public String[] str_jum = new String[jum_rank.length];
	

	private JPanel contentPane;
	private JButton[] buttons = new JButton[10];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chart_main frame = new chart_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public chart_main() throws SQLException {
		

		
		//�� ���� ������ ���� ����
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
			 ArrayList<conn.score_vo> tiArray=tidao.rank_me();	
			 for(conn.score_vo imsi : tiArray){
				  rank = imsi.getRank();
				  
			  }
			 
		// 1�� ���� ������ ���� ����
			 score_dao tidao1 = null;
			 ArrayList<conn.score_vo> tiArray1=tidao.rank_1();	
			 for(conn.score_vo imsi : tiArray1){
				  rank_1 = imsi.getRank();
				  
			  }
			 
			 ArrayList<score_vo> tiArray11=tidao.top_rank();//�޼ҵ� ȣ�� 
			 int i= 0;
             // �÷�����ü�� ���� ���Ƿ� 
		        for (conn.score_vo imsi : tiArray11) {		        	
		            id_rank[i] = imsi.getId();
		            jum_rank[i] = imsi.getJum();
		            i++;
		        }
		        
		        
		        
		        //���� ���ڿ��� �ٲٱ�
		        
		        for (i = 0; i < jum_rank.length; i++) {
		        	str_jum[i] = String.valueOf(jum_rank[i]);
		        }

			 
		        //initializeButtons();

		 
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
		btnNewButton.setBounds(966, 320, 62, 54);
	    contentPane.add(btnNewButton);
	    btnNewButton.setBorderPainted(false);
	    btnNewButton.setContentAreaFilled(false);
	    btnNewButton.setFocusPainted(false); 
	    contentPane.setLayout(null);
	    
	    initializeButtons();
	    
	    for(int a =0 ; a < 9; a++) {
	    	contentPane.add(buttons[a]);
	    }
	    rotationForButtons1();


	    
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	    btnNewButton.addMouseListener(new MouseAdapter() {
	    	    	@Override
	    	    	public void mouseReleased(MouseEvent e) {
	    	    		main_1 stagame = new main_1();

	    	               stagame.setVisible(true);
	    	               dispose(); // â�ݱ� 
	    	    		
	    	    	}
	    	    });	
	    

	    
	    	}
	    });

	      // ��Ʈ ���� �� ǥ��
		CategoryDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(560, 370));
		chartPanel.setBounds(136, 182, 265, 453);  // ��Ʈ ��ġ �� ũ�� ����
		contentPane.add(chartPanel);
		    
		    
	      
		    String icon2 = "C:/Myjava/3project/src/grimbang/rank_bg.png";
	        ImageIcon tabletIcon = new ImageIcon(icon2);

	      // �̹��� ũ�� ����
	    Image scaledImage3 = tabletIcon.getImage().getScaledInstance(1050, 700, Image.SCALE_SMOOTH);
	    tabletIcon = new ImageIcon(scaledImage3);
	    
//	    JLabel lblNewLabel = new JLabel("New label");
//	    lblNewLabel.setBounds(604, 216, 135, 54);
//	    contentPane.add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("New label");
	    lblNewLabel_1.setBounds(588, 303, 128, 54);
	    contentPane.add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_2 = new JLabel("New label");
	    lblNewLabel_2.setBounds(577, 386, 120, 54);
	    contentPane.add(lblNewLabel_2);
	    
	    JLabel lblNewLabel_2_1 = new JLabel("New label");
	    lblNewLabel_2_1.setBounds(562, 466, 120, 47);
	    contentPane.add(lblNewLabel_2_1);
	    
	    JLabel lblNewLabel_2_2 = new JLabel("New label");
	    lblNewLabel_2_2.setBounds(554, 523, 128, 54);
	    contentPane.add(lblNewLabel_2_2);
	    
	    JLabel lblNewLabel_2_3 = new JLabel("New label");
	    lblNewLabel_2_3.setBounds(751, 230, 135, 54);
	    contentPane.add(lblNewLabel_2_3);
	    
	    JLabel lblNewLabel_2_4 = new JLabel("New label");
	    lblNewLabel_2_4.setBounds(735, 320, 128, 54);
	    contentPane.add(lblNewLabel_2_4);
	    
	    JLabel lblNewLabel_2_5 = new JLabel("New label");
	    lblNewLabel_2_5.setBounds(719, 398, 135, 54);
	    contentPane.add(lblNewLabel_2_5);
	    
	    JLabel lblNewLabel_2_6 = new JLabel("New label");
	    lblNewLabel_2_6.setBounds(708, 462, 135, 54);
	    contentPane.add(lblNewLabel_2_6);
	    
	    JLabel lblNewLabel_2_7 = new JLabel("New label");
	    lblNewLabel_2_7.setBounds(695, 523, 135, 54);
	    contentPane.add(lblNewLabel_2_7);
	    JLabel b = new JLabel(tabletIcon);
	    b.setBounds(0, 0, 1052, 700);
	    contentPane.add(b);
        
	    

	    
	    
	}
	
	
    // ��ư �迭�� ���� ȸ�� �޼��� ȣ��
	
	 private void rotationForButtons1() {
	        for (JButton button : buttons) {
	            button.setBorder(new javax.swing.border.EmptyBorder(10, 4, 10, 4)); // ��ư �׵θ� ����
//	            button.setText("�������� ��������"); // ��ư �ؽ�Ʈ ����
	            double theta = (0.05) * Math.PI; // ȸ�� ���� ����
	            AffineTransform rotate = AffineTransform.getRotateInstance(theta); // ȸ�� ��ȯ �ν��Ͻ� ����
	            Font originalFont = button.getFont(); // ��ư�� ���� ��Ʈ ��������
	            Font rotatedFont = originalFont.deriveFont(rotate); // ȸ���� ��Ʈ ����
	            button.setFont(rotatedFont); // ��ư�� ȸ���� ��Ʈ ����

	            button.setContentAreaFilled(false); // ��ư ����� �����ϰ� ����
	        }
	    }

	    // ��ư �ʱ�ȭ �� ��ġ ���� �޼���
        private void initializeButtons() {                
    	buttons[0] = new JButton(id_rank[0]);
    	buttons[0].setBounds(604, 216, 97, 23);
	    contentPane.add(buttons[0]);
//        	buttons[0] = new JButton("11111111");
//        	buttons[0].setBounds(604, 216, 135, 54);
//    	    contentPane.add(buttons[0]);
	    
	    buttons[1] = new JButton(id_rank[1]);
	    buttons[1].setBounds(600, 285, 97, 23);
	    contentPane.add(buttons[1]);
	    
	    buttons[2] = new JButton(id_rank[2]);
	    buttons[2].setBounds(600, 351, 97, 23);
	    contentPane.add(buttons[2]);
	    
	    buttons[3] = new JButton(id_rank[3]);
	    buttons[3].setBounds(600, 406, 97, 23);
	    contentPane.add(buttons[3]);
	    
	    buttons[4] = new JButton(id_rank[4]);
	    buttons[4].setBounds(600, 471, 97, 23);
	    contentPane.add(buttons[4]);
	    
	    buttons[5] = new JButton(str_jum[0]);
	    buttons[5].setBounds(760, 222, 97, 23);
	    contentPane.add(buttons[5]);
	    
	    buttons[6] = new JButton(str_jum[1]);
	    buttons[6].setBounds(760, 285, 97, 23);
	    contentPane.add(buttons[6]);
	    
	    buttons[7] = new JButton(str_jum[2]);
	    buttons[7].setBounds(760, 351, 97, 23);
	    contentPane.add(buttons[7]);
	    
	    buttons[8] = new JButton(str_jum[3]);
	    buttons[8].setBounds(760, 406, 97, 23);
	    contentPane.add(buttons[8]);
	    
	    buttons[9] = new JButton(str_jum[4]);
	    buttons[9].setBounds(760, 471, 97, 23);
	    contentPane.add(buttons[9]);
	    
	    
        }

	   private CategoryDataset createDataset() {
	       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	       dataset.addValue(rank,"me","score");
	       dataset.addValue(rank_1,"1 st","score");

	       
	       
	       return dataset;
	   }
	
	   private JFreeChart createChart(CategoryDataset dataset) {
	       JFreeChart chart = ChartFactory.createBarChart(
	               "GAME OLYMPIAD",     // ��Ʈ ����
	               "",              // X �� ���̺�
	               "����",                 // Y �� ���̺�
	               dataset,                 // �����ͼ�
	               PlotOrientation.VERTICAL, // ��Ʈ ���� (����)
	               true,                    // ���� ���� ����
	               true,                    // ������ ǥ�� ����
	               false                    // URL ��ũ ���� ����
	       );

	       chart.getTitle().setFont(new Font("���� ���", Font.BOLD, 18));  // ���÷� '���� ���' ��Ʈ ���
	       chart.getCategoryPlot().getDomainAxis().setLabelFont(new Font("���� ���", Font.PLAIN, 14));
	       chart.getCategoryPlot().getRangeAxis().setLabelFont(new Font("���� ���", Font.PLAIN, 14));
	       chart.getLegend().setItemFont(new Font("���� ���", Font.PLAIN, 12));

	       return chart;

	   }
}
