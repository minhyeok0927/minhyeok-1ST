package conn;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





public class score_dao {
	private static String ID_1;
	private static String DATE;

   private Connection con;
   PreparedStatement  pstmt=null;//////////
   ResultSet rs = null;

   
   //持失切
   public score_dao() throws ClassNotFoundException, SQLException{//DAO税 持失切
   con=new conn().getConnection();
   
   
   }
   
   public static String id_(String iD_12) {
	      ID_1 = iD_12;
	        return ID_1;
	   }
	   
	   public static String date_(String date2) {
	      DATE = date2;
	        return DATE;
	   }
	   
   public  boolean   game1_score(int score) {
   String sql="UPDATE GAME_1 SET SCORE = ?  where ID=? AND DATE_=?";
   try {
      con.setAutoCommit(false);
      pstmt=con.prepareStatement(sql);

      pstmt.setInt(1,score);
      pstmt.setString(2,ID_1);
      pstmt.setString(3, DATE);
 
      pstmt.executeUpdate(); 
      con.commit();
   }  catch(SQLException e) {
      System.out.println("Update error");
      return false;   
   }
   
   return true;   
   }
   

   
   public  boolean   game2_score(int score) {
   String sql="UPDATE GAME_2 SET SCORE = ?  where ID=? AND DATE_=?";
   try {
      con.setAutoCommit(false);
      pstmt=con.prepareStatement(sql);

      pstmt.setInt(1,score);
      pstmt.setString(2,ID_1);
      pstmt.setString(3, DATE);
      
 
      pstmt.executeUpdate(); 
      con.commit();
   }  catch(SQLException e) {
      System.out.println("Update error");
      return false;   
   }
   return true;   
   }
   
   public  boolean  game3_score(int score) {
   String sql="UPDATE GAME_3 SET SCORE = ?  where ID=? AND DATE_=?";
   try {
      con.setAutoCommit(false);
      pstmt=con.prepareStatement(sql);

      pstmt.setInt(1,score);
      pstmt.setString(2,ID_1);
      pstmt.setString(3, DATE);
      
 
      pstmt.executeUpdate(); 
      con.commit();
   }  catch(SQLException e) {
      System.out.println("Update error");
      return false;   
   }
   return true;   
   }
   
   
   
   public  boolean   game4_score(int score) {
   String sql="UPDATE GAME_4 SET SCORE = ?  where ID=? AND DATE_=?";
   try {
      con.setAutoCommit(false);
      pstmt=con.prepareStatement(sql);

      pstmt.setInt(1,score);
      pstmt.setString(2,ID_1);
      pstmt.setString(3, DATE);
      
 
      pstmt.executeUpdate(); 
      con.commit();
   }  catch(SQLException e) {
      System.out.println("Update error");
      return false;   
   }
   return true;   
   }
   
   public boolean rank_score(int score1, int score2, int score3, int score4) throws SQLException {
       String sql = "INSERT INTO RANK (ID, game1_score, game2_score, game3_score, game4_score, sum_score, date_) VALUES (?, ?, ?, ?, ?, ?, ?)";

           con.setAutoCommit(false);
           pstmt = con.prepareStatement(sql);

           pstmt.setString(1, ID_1);
           pstmt.setInt(2, score1);
           pstmt.setInt(3, score2);
           pstmt.setInt(4, score3);
           pstmt.setInt(5, score4);
           pstmt.setInt(6, score1+score2+score3+score4);
           pstmt.setString(7, DATE);


           pstmt.executeUpdate();
           con.commit();

       return true;
   }
   

   public ArrayList<score_vo> getscore_avg() throws SQLException {
       ArrayList<score_vo> tiarray = new ArrayList<score_vo>();
       String sql = "SELECT avg(game1_score) as avg_game1, avg(game2_score) as avg_game2, avg(game3_score) as avg_game3, avg(game4_score) as avg_game4 FROM rank";
       try {
           pstmt = con.prepareStatement(sql);
           rs = pstmt.executeQuery();

           if (rs.next()) {
        	   double score1 = rs.getDouble("avg_game1");
               double score2 = rs.getDouble("avg_game2");
               double score3 = rs.getDouble("avg_game3");
               double score4 = rs.getDouble("avg_game4");

               score_vo tv = new score_vo(score1, score2, score3, score4);
               tiarray.add(tv);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           closeResources();
       }
       return tiarray;
   }
   

   
   public ArrayList<score_vo> rank_me() throws SQLException {
       ArrayList<score_vo> tiarray = new ArrayList<score_vo>();
       String sql = "SELECT max(sum_score) AS ra_sum FROM rank where ID=?";
       try {
           pstmt = con.prepareStatement(sql);
           
           pstmt.setString(1, ID_1);
           
           rs = pstmt.executeQuery();
           
           if (rs.next()) {
        	  int rank = rs.getInt("ra_sum");

               score_vo tv = new score_vo(rank);
               tiarray.add(tv);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           closeResources();
       }
       return tiarray;
   }
   
   public ArrayList<score_vo> rank_1() throws SQLException {
       ArrayList<score_vo> tiarray = new ArrayList<score_vo>();
       String sql = "SELECT max(sum_score) AS ra FROM rank";
       try {
           pstmt = con.prepareStatement(sql);           
           rs = pstmt.executeQuery();
           
           if (rs.next()) {
        	  int rank = rs.getInt("ra");

               score_vo tv = new score_vo(rank);
               tiarray.add(tv);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           closeResources();
       }
       return tiarray;
   }
   
   public ArrayList<score_vo> top_rank() throws SQLException {
       ArrayList<score_vo> tiarray = new ArrayList<score_vo>();
       String sql = "SELECT ID, ra_sum FROM "
       		+ "( SELECT id, ra_sum, ROW_NUMBER() "
       		+ "OVER (ORDER BY ra_sum DESC) AS rank_position "
       		+ "FROM ( SELECT id, sum_score AS ra_sum FROM rank) r1) "
       		+ "ranked WHERE rank_position <= 5 ORDER BY ra_sum DESC";
       try {
           pstmt = con.prepareStatement(sql);           
           rs = pstmt.executeQuery();
           
           while (rs.next()) {
        	  String id = rs.getString("ID");
        	  int jum = rs.getInt("ra_sum");


               score_vo tv = new score_vo(id,jum);
               tiarray.add(tv);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           closeResources();
       }
       return tiarray;
   }
   
   
   

   
   
   
   

   private void closeResources() {
       if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
       if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
   }


}
   
