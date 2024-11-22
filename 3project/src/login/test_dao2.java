// test_dao.java

package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test_dao2 {
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    public test_dao2() throws ClassNotFoundException, SQLException {
        con = new test_conn2().getConnection(); // ConnDB로부터 연결 객체 가져오기
    }
    
    public boolean checkDuplicateId(String id) {
        try {
            String sql = "SELECT COUNT(*) FROM ID_ WHERE id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                return true; // 중복된 ID가 존재
            } else {
                return false; // 사용 가능한 ID
            }
        } catch (SQLException ex) {
            System.err.println("데이터베이스 오류: " + ex.getMessage());
            return true; // 오류 발생 시 중복 처리
        } finally {
            close();
        }
    }
    
    public boolean registerMember(test_vo2 vo) {
        try {
            String sql = "INSERT INTO ID_ (id, pw, tel) VALUES (?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getPw());
            pstmt.setString(3, vo.getTel());
            
            int count = pstmt.executeUpdate();
            return count > 0;
        } catch (SQLException ex) {
            System.out.println("insertion error: " + ex.getMessage());
            return false;
        } finally {
            close();
        }
    }
    
    private void close() {
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
    }
}
