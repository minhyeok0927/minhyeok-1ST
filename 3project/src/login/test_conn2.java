package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test_conn2 {

    private static Connection con;

    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
              
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    public test_conn2() {
        // �����ڰ� �ʿ��� ��� �߰����� �ʱ�ȭ �۾� ���� ����
    }

}
