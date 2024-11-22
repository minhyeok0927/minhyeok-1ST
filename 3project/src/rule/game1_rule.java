package rule;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class game1_rule extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game1_rule frame = new game1_rule();
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
	public game1_rule() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(580, 230, 764, 592);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//배경 투명
		contentPane.setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:/Myjava/3project/src/grimbang/x.png"));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(683, 212, 35, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\uCE74\uB4DC \uB4A4\uC9D1\uAE30");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(297, 195, 166, 47);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 252, 681, 308);
		contentPane.add(scrollPane);
		
		scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBackground(new Color(0, 0, 0, 0));
        scrollPane.getViewport().setBackground(new Color(0, 0, 0, 0));

        // 테두리 제거
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
        
		JLabel lblNewLabel_1 = new JLabel("<html><body>"
				+ " --- 게임 설명 --- <br>"
				+ "<br>"
				+ "● 기억력 향상에 도움이 되는 카드 뒤집기입니다.<br>"
				+ "<br>"
				+ "● 카드의 위치를 기억하여 같은 그림의 카드 쌍을 <br>"
				+ "<br>"
				+ "&nbsp 맞춰가는 게임입니다.<br>"
				+ "<br>"
				+ "● 플레이어는 100점을 갖고 시작합니다.<br>"
				+ "<br>"
				+ "<br>"
				+ "--- 게임 규칙 ---<br>"
				+ "<br>"
				+ "1. 카드에 들어갈 이미지를 선택하시오<br>"
				+ "&nbsp (동물 OR 과일)<br>"
				+ "<br>"
				+ "2. 카드가 위치가 셔플됩니다.<br>"
				+ "<br>"
				+ "3. 2개의 카드를 클릭하여, 뒤집습니다.<br>"
				+ "<br>"
				+ "4. 2개의 카드가 같은 그림이면 정답입니다.<br>"
				+ "&nbsp 4-1. 카드는 다시 뒤집어 지지 않습니다.<br>"
				+ "<br>"
				+ "5.  2개의 카드의 그림이 다르다면 오답입니다.<br>"
				+ "&nbsp 5-1. 5점을 차감하고 카드는 다시 뒤집어 집니다.<br>"
				+ "<br>"
				+ "6. 모든 카드 쌍을 맞추면 게임이 끝납니다.<br>"
				+ "</body></html>");
		scrollPane.setViewportView(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		
		// 게시판 배경
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 764, 592);
		contentPane.add(lblNewLabel_2); 
	    String icon1 = "C:/Myjava/3project/src/grimbang/rule_b.png";
	    ImageIcon chiIcon1 = new ImageIcon(icon1);
	    Image scaledImage1 = chiIcon1.getImage().getScaledInstance(764, 592, Image.SCALE_SMOOTH);
	    chiIcon1 = new ImageIcon(scaledImage1);
	    lblNewLabel_2.setIcon(chiIcon1);
	}
}
