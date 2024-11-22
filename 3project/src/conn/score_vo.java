package conn;

import java.util.Date;

public class score_vo {
	
	double score1;
	double score2;
	double score3;
	double score4;
	int rank;
	
	String id;
	int jum;
	


	public score_vo() {}

	public score_vo(double score1, double score2, double score3, double score4) {//인자있는 생성자
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.score4 = score4;
	}
	
	public score_vo(int rank) {//인자있는 생성자
		this.rank = rank;

	}
	
	public score_vo(String id, int jum) {//인자있는 생성자
		this.id = id;
		this.jum = jum;

	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getJum() {
		return jum;
	}

	public void setJum(int jum) {
		this.jum = jum;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public double getScore1() {
		return score1;
	}

	public void setScore1(Double score1) {
		this.score1 = score1;
	}

	public double getScore2() {
		return score2;
	}

	public void setScore2(Double score2) {
		this.score2 = score2;
	}

	public double getScore3() {
		return score3;
	}

	public void setScore3(Double score3) {
		this.score3 = score3;
	}

	public double getScore4() {
		return score4;
	}

	public void setScore4(Double score4) {
		this.score4 = score4;
	}




}
