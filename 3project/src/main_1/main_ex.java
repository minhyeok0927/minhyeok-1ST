package main_1;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import chart.chart;
import conn.score_dao;
public class main_ex {

    static String ID_1;
    static String DATE_1;
    
    

    // ID 초기화

    public static void startGame() {
        Connection con = null;

        try {
            con = GameCONN.getConnection();
            
            if (ID_1 == null || ID_1.isEmpty()) {
                System.out.println("ID_1 is null or empty");
                return; // ID_1이 null이거나 비어 있으면 메서드 종료
            }

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date();
            DATE_1 = formatter.format(date);
            score_dao.date_(DATE_1);
            chart.date_(DATE_1);

            GameDAO gameDAO = new GameDAO(con);

            String[] tables = {"game_1", "game_2", "game_3", "game_4"};
            for (String table : tables) {
                gameDAO.insertGameRecord(table, ID_1, 0, DATE_1);  // 초기 점수는 0
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
