package main_1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.test_main2;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class f_main extends JFrame {
	
	private ImageIcon chiIcon1;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					f_main frame = new f_main();
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
	public f_main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(430,150, 1068, 739);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		
		
        // 메인창으로 가는 버튼 (홈버튼)
        JButton btnNewButton_12 = new JButton("");
        btnNewButton_12.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_12.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
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
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new test_main2().setVisible(true);  ////////////로그인 창이랑 연결
				dispose();
				setVisible(false);
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(481, 267, 91, 79);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_9 = new JLabel("");
	      lblNewLabel_9.setBounds(0, 0, 1050, 700);
	      contentPane.add(lblNewLabel_9);
	      String icon1 = "./src/grimbang/f_main.png";
	      ImageIcon chiIcon = new ImageIcon(icon1);
	      Image scaledImage = chiIcon.getImage().getScaledInstance(1050, 700, Image.SCALE_SMOOTH);
	      chiIcon1 = new ImageIcon(scaledImage);
	      lblNewLabel_9.setIcon(chiIcon1);
	      

	}

}
