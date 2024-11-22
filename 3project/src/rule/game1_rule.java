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
		
		JLabel lblNewLabel = new JLabel("\uCE74\uB4DC \uB4A4\uC9D1\uAE30");
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
		
        
		JLabel lblNewLabel_1 = new JLabel("<html><body>"
				+ " --- ���� ���� --- <br>"
				+ "<br>"
				+ "�� ���� ��� ������ �Ǵ� ī�� �������Դϴ�.<br>"
				+ "<br>"
				+ "�� ī���� ��ġ�� ����Ͽ� ���� �׸��� ī�� ���� <br>"
				+ "<br>"
				+ "&nbsp ���簡�� �����Դϴ�.<br>"
				+ "<br>"
				+ "�� �÷��̾�� 100���� ���� �����մϴ�.<br>"
				+ "<br>"
				+ "<br>"
				+ "--- ���� ��Ģ ---<br>"
				+ "<br>"
				+ "1. ī�忡 �� �̹����� �����Ͻÿ�<br>"
				+ "&nbsp (���� OR ����)<br>"
				+ "<br>"
				+ "2. ī�尡 ��ġ�� ���õ˴ϴ�.<br>"
				+ "<br>"
				+ "3. 2���� ī�带 Ŭ���Ͽ�, �������ϴ�.<br>"
				+ "<br>"
				+ "4. 2���� ī�尡 ���� �׸��̸� �����Դϴ�.<br>"
				+ "&nbsp 4-1. ī��� �ٽ� ������ ���� �ʽ��ϴ�.<br>"
				+ "<br>"
				+ "5.  2���� ī���� �׸��� �ٸ��ٸ� �����Դϴ�.<br>"
				+ "&nbsp 5-1. 5���� �����ϰ� ī��� �ٽ� ������ ���ϴ�.<br>"
				+ "<br>"
				+ "6. ��� ī�� ���� ���߸� ������ �����ϴ�.<br>"
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
