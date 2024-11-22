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
        // 생성자가 필요한 경우 추가적인 초기화 작업 수행 가능
    }

}
