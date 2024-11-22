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
		
		//��� ����
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
		lblNewLabel.setFont(new Font("����", Font.BOLD, 30));
		lblNewLabel.setBounds(297, 195, 166, 47);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 252, 681, 308);
		contentPane.add(scrollPane);
		
		scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBackground(new Color(0, 0, 0, 0));
        scrollPane.getViewport().setBackground(new Color(0, 0, 0, 0));

        // �׵θ� ����
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
        
        JLabel lblNewLabel_1 = new JLabel("<html><body>--- ���� ���� ---<br><br>"
				+ "�� ������ 3�ڸ� ���ڸ� �����ϴ� �����Դϴ�. <br>"
				+ "<br>"
				+ "�� �� �ϸ��� ������ ���ڿ� ���� ��Ʈ�� �޽��ϴ�.<br><br>"
				+ "�� ������ ��Ģ�� ���� ������ ���ڸ� ���ߴ� �����Դϴ�. <br><br>"
				+ "�� S(��Ʈ����ũ): ������ ���� �� ������ ���ڿ� <br> "
				+ "&nbsp��ġ�� ���� ��� ��ġ�ϴ� ������ ���Դϴ�.<br><br>"
				+ "�� B(��): ������ ���� �� ������ ���ڿ� ���� ��ġ������ <br> "
				+ "&nbsp��ġ�� �ٸ� ������ ���Դϴ�.<br><br>"
				+ "�� O(�ƿ�): ������ ���ڰ� ������ ���ڿ� <br>"
				+ "&nbsp �������� �ʽ��ϴ�.<br><br>"
				+ "�� 9���� Ƚ���ȿ� ���ڸ� �����Ͻʽÿ�.<br><br>"
				+ "�� �÷��̾�� 100���� ���� �����մϴ�.<br>"
				+ "<br>"
				+ "--- ���� ��Ģ ---<br>"
				+ "<br>"
				+ "1. ������ 3�ڸ� ���ڸ� �Է�â�� �Է����ּ���<br><br>"
				+ "2. �Է��� ���ڴ� ���� S,B,0�� ����� �˴ϴ�.<br><br>"
				+ "3. ������ ��� ������ �����ϴ�.<br><br>"
				+ "4. ������ �ƴҰ�� 1ȸ�� 10���� �����˴ϴ�<br><br>"
				+ "5. �־��� ��Ʈ�� ���� ������ ���ڸ� ���߽ø� �˴ϴ�.<br>"
				+ "</body></html>");
		scrollPane.setViewportView(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));
		
		// �Խ��� ���
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
