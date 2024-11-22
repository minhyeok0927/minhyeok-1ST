package login;

import java.awt.EventQueue;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import games.game2;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.NoSuchAlgorithmException;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Join_membership2 extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldID;
    private JPasswordField passwordFieldPW;
    private JPasswordField passwordFieldConfirmPW;
    private JTextField textFieldPhone;
    private test_dao2 dao;
    private JCheckBox chckbxFemale;
    private JCheckBox chckbxMale;
    private boolean isIdChecked = false;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Join_membership2 frame = new Join_membership2();
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
    public Join_membership2() {
        try {
            dao = new test_dao2(); // DAO ��ü �ʱ�ȭ
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430,150, 1068, 739);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        textFieldID = new JTextField();
        textFieldID.setFont(new Font("����", Font.BOLD, 18));
        textFieldID.setBounds(457, 243, 218, 37);
        textFieldID.setBorder(new EmptyBorder(0, 0, 0, 0)); // �׵θ� ���ֱ�
        textFieldID.setOpaque(false); // ���� ���ֱ�
        contentPane.add(textFieldID);
        textFieldID.setColumns(10);
        
        JButton btnCheckDuplication = new JButton("");
        btnCheckDuplication.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
              
           }
        });
        
        btnCheckDuplication.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                checkDuplicateId();
            }
        });
        
        btnCheckDuplication.setBorderPainted(false);
        btnCheckDuplication.setContentAreaFilled(false);
        btnCheckDuplication.setFocusPainted(false); 
         
        btnCheckDuplication.setBounds(695, 241, 37, 37);
        contentPane.add(btnCheckDuplication);
        
        passwordFieldPW = new JPasswordField();
        passwordFieldPW.setFont(new Font("����", Font.BOLD, 18));
        passwordFieldPW.setBounds(457, 302, 218, 37);
        passwordFieldPW.setBorder(new EmptyBorder(0, 0, 0, 0)); // �׵θ� ���ֱ�
        passwordFieldPW.setOpaque(false); // ���� ���ֱ�
        contentPane.add(passwordFieldPW);
        passwordFieldPW.setColumns(10);
        
        passwordFieldConfirmPW = new JPasswordField();
        passwordFieldConfirmPW.setFont(new Font("����", Font.BOLD, 18));
        passwordFieldConfirmPW.setBounds(457, 364, 218, 37);
        passwordFieldConfirmPW.setBorder(new EmptyBorder(0, 0, 0, 0)); // �׵θ� ���ֱ�
        passwordFieldConfirmPW.setOpaque(false); // ���� ���ֱ�
        contentPane.add(passwordFieldConfirmPW);
        passwordFieldConfirmPW.setColumns(10);
        
        chckbxFemale = new JCheckBox("����");
        chckbxFemale.setBounds(487, 542, 60, 20);
        contentPane.add(this.chckbxFemale);
        chckbxFemale.setBorderPainted(false);
        chckbxFemale.setContentAreaFilled(false);
        chckbxFemale.setFocusPainted(false); 
        
        
        chckbxMale = new JCheckBox("����");
        chckbxMale.setBounds(597, 542, 60, 20);
        contentPane.add(this.chckbxMale);
        chckbxMale.setBorderPainted(false);
        chckbxMale.setContentAreaFilled(false);
        chckbxMale.setFocusPainted(false); 
        
        
        textFieldPhone = new JTextField();
        textFieldPhone.setFont(new Font("����", Font.BOLD, 18));
        textFieldPhone.setBounds(457, 425, 218, 37);
        textFieldPhone.setBorder(new EmptyBorder(0, 0, 0, 0)); // �׵θ� ���ֱ�
        textFieldPhone.setOpaque(false); // ���� ���ֱ�
        contentPane.add(textFieldPhone);
        textFieldPhone.setColumns(10);
        
        JButton btnConfirm = new JButton("");
        btnConfirm.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
           }
        });
        btnConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isIdChecked) {
                    if (checkPasswordsMatch()) {
                        try {
                            registerMember();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    } else {
                       JOptionPane.showMessageDialog(e.getComponent(),
                              "��й�ȣ�� ��ġ���� �ʽ��ϴ�",
                              "��й�ȣ����ġ", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(e.getComponent(),
                              "ID �ߺ� üũ�� ���� ���ּ���.",
                              "���̵��ߺ�üũ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        btnConfirm.setBorderPainted(false);
        btnConfirm.setContentAreaFilled(false);
        btnConfirm.setFocusPainted(false); 
         
        btnConfirm.setBounds(695, 541, 77, 54);
        contentPane.add(btnConfirm);
        
        // background
        JLabel background = new JLabel("");
        background.setBounds(0, 0, 1050, 700);
        contentPane.add(background);
        String icon1 = "./src/grimbang/login.png";
        ImageIcon chiIcon1 = new ImageIcon(icon1);
        Image scaledImage1 = chiIcon1.getImage().getScaledInstance(1050, 700, Image.SCALE_SMOOTH);
        chiIcon1 = new ImageIcon(scaledImage1);
        background.setIcon(chiIcon1);
    }

    private void checkDuplicateId() {
        String id = textFieldID.getText();
        boolean isDuplicate = dao.checkDuplicateId(id);
        
        if (isDuplicate) {
            JOptionPane.showMessageDialog(this,
                   "�ߺ��� ���̵��Դϴ�.",
                   "���̵��ߺ�", JOptionPane.INFORMATION_MESSAGE);
            isIdChecked = false;
        } else {
            JOptionPane.showMessageDialog(this,
                   "��밡���� ���̵��Դϴ�.",
                   
                   "���̵��밡��", JOptionPane.INFORMATION_MESSAGE);
            
            isIdChecked = true;
        }
    }
    
    private boolean checkPasswordsMatch() {
        String pw = new String(passwordFieldPW.getPassword());
        String confirmPw = new String(passwordFieldConfirmPW.getPassword());
        return pw.equals(confirmPw);
    }

    private void registerMember() throws SQLException {
        String id = textFieldID.getText();
        String pw = new String(passwordFieldPW.getPassword());
        SHA256 sha256 = new SHA256();
        String cryptogram = null;
        
        try {
            cryptogram = sha256.encrypt(pw);
            System.out.println("���� ��й�ȣ: " + pw);
            System.out.println("��ȣȭ�� ��й�ȣ: " + cryptogram);
        } catch (NoSuchAlgorithmException e) {
           System.err.println("��ȣȭ �������� ���� �߻�: " + e.getMessage());
            e.printStackTrace();
        }
        
        String gender = chckbxFemale.isSelected() ? "����" : (chckbxMale.isSelected() ? "����" : "");
        String tel = textFieldPhone.getText();
        
        test_vo2 vo = new test_vo2(id, cryptogram, tel);
//        test_vo2 vo = new test_vo2(id, tel);
        boolean isSuccess = dao.registerMember(vo);
        
        if (isSuccess) {
            JOptionPane.showMessageDialog(this,
                   "ȸ������ ����",
                   "ȸ�����Լ���", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            setVisible(false);
            new test_main2().setVisible(true);
            // �߰����� UI ó���� â �ݱ� ���� �� �� �ֽ��ϴ�.
        } else {
            JOptionPane.showMessageDialog(this,
                   "ȸ������ ����.",
                   "ȸ�����Խ���", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
