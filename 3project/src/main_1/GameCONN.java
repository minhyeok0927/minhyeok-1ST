package main_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GameCONN {

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

    public GameCONN() {
        // �����ڰ� �ʿ��� ��� �߰����� �ʱ�ȭ �۾� ���� ����
    }

}
