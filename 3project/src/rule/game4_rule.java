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

public class game4_rule extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game4_rule frame = new game4_rule();
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
	public game4_rule() {
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
		
		JLabel lblNewLabel = new JLabel("\uC22B\uC790 \uC57C\uAD6C");
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
		
        
        JLabel lblNewLabel_1 = new JLabel("<html><body>--- 게임 설명 ---<br><br>"
				+ "● 숨겨진 3자리 숫자를 추측하는 게임입니다. <br>"
				+ "<br>"
				+ "● 각 턴마다 추측한 숫자에 대한 힌트를 받습니다.<br><br>"
				+ "● 정해진 규칙에 따라 상대방의 숫자를 맞추는 게임입니다. <br><br>"
				+ "● S(스트라이크): 제시한 숫자 중 숨겨진 숫자에 <br> "
				+ "&nbsp위치와 값이 모두 일치하는 숫자의 수입니다.<br><br>"
				+ "● B(볼): 제시한 숫자 중 숨겨진 숫자에 값은 일치하지만 <br> "
				+ "&nbsp위치는 다른 숫자의 수입니다.<br><br>"
				+ "● O(아웃): 제시한 숫자가 숨겨진 숫자에 <br>"
				+ "&nbsp 존재하지 않습니다.<br><br>"
				+ "● 9번의 횟수안에 숫자를 유추하십시오.<br><br>"
				+ "● 플레이어는 100점을 갖고 시작합니다.<br>"
				+ "<br>"
				+ "--- 게임 규칙 ---<br>"
				+ "<br>"
				+ "1. 추측한 3자리 숫자를 입력창에 입력해주세요<br><br>"
				+ "2. 입력한 숫자는 위에 S,B,0로 출력이 됩니다.<br><br>"
				+ "3. 정답일 경우 게임이 끝납니다.<br><br>"
				+ "4. 정답이 아닐경우 1회당 10점이 차감됩니다<br><br>"
				+ "5. 주어진 힌트를 통해 숨겨진 숫자를 맞추시면 됩니다.<br>"
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
