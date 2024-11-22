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

public class game3_rule extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game3_rule frame = new game3_rule();
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
	public game3_rule() {
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
		
		JLabel lblNewLabel = new JLabel("\uD589\uB9E8");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
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
		
        
        JLabel lblNewLabel_1 = new JLabel("<html><body>--- 게임 설명 ---<br>"
				+ "<br>"
				+ "● 단어 능력향상에 도움이 되는 HANG MAN 게임 입니다.<br>"
				+ "<br>"
				+ "● A부터 Z까지의 단어중 하나를 선택하여 단어를 <br>"
				+ "&nbsp 유추하는 게임입니다.<br>"
				+ "<br>"
				+ "● 그림속 사람이 물에 빠지기 전에 단어를 완성시켜서 <br> "
				+ "&nbsp 구해주세요.<br>"
				+ "<br>"
				+ "● 플레이어는 100점을 갖고 시작합니다.<br>"
				+ "<br>"
				+ "<br>"
				+ "--- 게임 규칙 ---<br>"
				+ "<br>"
				+ "1.  A~Z중 원하시는 하나를 눌러주세요.<br>"
				+ "<br>"
				+ "2.  고른 알파벳이 화면에 출력된 경우 정답입니다<br>"
				+ "<br>"
				+ "3.  고른 알파벳이 화면에 출력되지 않으면 오답입니다.<br>"
				+ "&nbsp 3-1. 점수가 5점 차감됩니다.<br>"
				+ "&nbsp 3-2. 그림속에 물이 서서히 차오릅니다. 최대 9회까지 <br>"
				+ "&nbsp &nbsp &nbsp 선택가능합니다<br>"
				+ "<br>"
				+ "4.  알파벳을 잘 골라 단어를 맞춥니다.<br>"
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
