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

public class game2_rule extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game2_rule frame = new game2_rule();
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
	public game2_rule() {
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
		
		JLabel lblNewLabel = new JLabel("\uB4E3\uACE0 \uB9DE\uCD94\uAE30");
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
				+ "● 외국어 듣기 능력 향상에 도움이 되는 TTS GAME입니다.<br>"
				+ "<br>"
				+ "● 음성을 통해 나온 단어를 선택해주시면 됩니다.<br>"
				+ "<br>"
				+ "● 스피커 이미지를 누르시면 다시 들을 수 있습니다.<br>"
				+ "<br>"
				+ "● 플레이어는 100점을 갖고 시작합니다.<br>"
				+ "<br>"
				+ "※혹시나 게임 시작을 눌렀을때 단어가 출력되지 않으면 <br>"
				+ "&nbsp 다시한번 게임시작을 눌러주세요. <br>"
				+ " &nbsp 점수에 영향을 주지 않습니다. <br> "
				+ "<br>"
				+ "<br>"
				+ " --- 게임 규칙 ---<br>"
				+ "<br>"
				+ "1. 게임시작을 눌러주세요.<br>"
				+ "<br>"
				+ "2. 음성 파일을 듣고 정답일거 같은 단어를 눌러주세요<br>"
				+ "<br>"
				+ "3. 정답일 경우 다음 게임으로 넘어갑니다.<br>"
				+ "<br>"
				+ "4. 오답일 경우 스피커를 눌러 다시 듣고 버튼을 눌러주세요.<br>"
				+ "&nbsp 4-1. 오답일 경우 20점 차감됩니다.<br>"
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
