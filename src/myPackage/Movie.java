package myPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Movie implements Imyinterf, Iinsert {
	public int id_m;
	public int Year;
	public int id_d;
	public String Name;
	public String Director;
	public double rating;
	public Movie(int idm, String name, int year, int idd, String director2, double d) {
		this.Year = year;
		this.Name = name;
		this.id_d = idd;
		this.id_m = idm;
		this.Director = director2;
		this.rating = d;
	}
	public String getName() {
		String S = "Movie:" + this.Name + ". Directed by "+ this.Director;
		return S;
	}
	public String getAge() {
		int x = 2019 - this.Year;
		return ("Movie:" + this.Name + " " + x + " year old");
	}
	public void insert(Connection con){
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(
					"INSERT INTO \"schem\".\"Movie\""
				   + "(id_фильма, название_фильма, Год_выхода, "
				   + "id_режисера, Режисер, Рейтинг)"
			+ "VALUES (?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1,this.id_m);
			pstmt.setString(2, this.Name);
			pstmt.setInt(3,this.Year);
			pstmt.setInt(4,this.id_d);
			pstmt.setString(5,this.Director);
			pstmt.setDouble(6,this.rating);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
