package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main_1.f_main;
import main_1.main_1;
import javax.swing.ImageIcon;


public class test_main2 extends JFrame {

    private JPanel contentPane;
    private JTextField ID_TEXT;
    private JPasswordField PW_TEXT;
    private test_dao2 test_dao;
    
    
   

    private String ID_1; // 로그인 성공한 사용자의 ID를 저장할 변수

    public String getID_1() {
      return ID_1;
   }

   public void setID_1(String iD_1) {
      this.ID_1 = iD_1;
   }

   /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    test_main2 frame = new test_main2();
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
    public test_main2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430,150,1068,739);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
		contentPane.setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
        
        JButton Login_Button = new JButton("");
        Login_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    try {
						loginCheck();
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } catch (SQLException | ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        Login_Button.setBorderPainted(false);
        Login_Button.setContentAreaFilled(false);
        Login_Button.setFocusPainted(false); 
        contentPane.setLayout(null);
        Login_Button.setBounds(317, 510, 187, 45);
        contentPane.add(Login_Button);
        
        JButton Join_Mem_BT = new JButton("");
        Join_Mem_BT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Join_membership2 joinFrame = new Join_membership2();
                joinFrame.setVisible(true);
                setVisible(false);
            }
        });
        Join_Mem_BT.setBorderPainted(false);
        Join_Mem_BT.setContentAreaFilled(false);
        Join_Mem_BT.setFocusPainted(false); 
        contentPane.setLayout(null);
        Join_Mem_BT.setBounds(563, 510, 181, 45);
        contentPane.add(Join_Mem_BT);
        
        ID_TEXT = new JTextField();
        ID_TEXT.setFont(new Font("굴림", Font.BOLD, 20));
        ID_TEXT.setBounds(509, 309, 212, 45);
        ID_TEXT.setBorder(new EmptyBorder(0, 0, 0, 0)); // 테두리 없애기
        ID_TEXT.setOpaque(false); // 배경색 없애기
        contentPane.add(ID_TEXT);
        
        ID_TEXT.setColumns(10);
     // 메인창으로 가는 버튼 (홈버튼)
        JButton btnNewButton_12 = new JButton("");
        btnNewButton_12.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_12.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
        	   new f_main().setVisible(true);
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
        
        PW_TEXT = new JPasswordField();
        PW_TEXT.setFont(new Font("굴림", Font.BOLD, 20));
        PW_TEXT.setBounds(509, 414, 212, 45);
        PW_TEXT.setBorder(new EmptyBorder(0, 0, 0, 0)); // 테두리 없애기
        PW_TEXT.setOpaque(false); // 배경색 없애기
        contentPane.add(PW_TEXT);
        PW_TEXT.setColumns(10);
        String icon1 = "./src/grimbang/login_1.png";
        ImageIcon chiIcon1 = new ImageIcon(icon1);
        Image scaledImage1 = chiIcon1.getImage().getScaledInstance(1050, 700, Image.SCALE_SMOOTH);
        chiIcon1 = new ImageIcon(scaledImage1);
        
        // background
        JLabel background = new JLabel("");
        background.setBounds(0, 0, 1050, 700);
        contentPane.add(background);
        background.setIcon(chiIcon1);
     
        
        
    }
    
    private void loginCheck() throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        String id = ID_TEXT.getText();
        SHA256 sha256 = new SHA256();
        String pw = new String(PW_TEXT.getPassword());
        String cryptogram = null;
        cryptogram = sha256.encrypt(pw);

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        

        try {
            con = test_conn2.getConnection();
            String sql = "SELECT pw FROM ID_ WHERE id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbPw = rs.getString("pw");
                if (cryptogram.equals(dbPw)) {
                    // 로그인 성공
                    ID_1 = id; // 로그인한 사용자의 ID를 저장
                    JOptionPane.showMessageDialog(this, "로그인 되었습니다.");
                    

                    // main_1 창 열기
                    openMain1();
                } else {
                    JOptionPane.showMessageDialog(this, "비밀번호가 틀렸습니다.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "아이디를 확인해주세요.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
   

    private void openMain1() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    main_1 frame = new main_1(ID_1);
                      // 로그인한 사용자의 ID를 전달

                     frame.setVisible(true);
                    dispose(); // 현재 창 닫기
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
