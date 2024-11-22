package main_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GameDAO {

    private Connection con;

    public GameDAO(Connection con) {
        this.con = con;
    }

    public void insertGameRecord(String tableName, String id, int score, String date) throws SQLException {
        String sql = "INSERT INTO " + tableName + " (id, score, DATE_) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setInt(2, score);  // Ç×»ó 0À» »ðÀÔ
            pstmt.setString(3, date);
            pstmt.executeUpdate();
        }
    }

    
    }

