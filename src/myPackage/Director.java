package myPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Director implements Iinsert {
	int idd;
	String Name;
	int films;
	public Director(int id, String nm, int fm) {
		this.idd = id;
		this.Name = nm;
		this.films = fm;
	}
	public void insert(Connection con){
        try {
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO \"schem\".\"Directors\""
				   + "(id_Режисера, Полное_Имя, Фильмография)"
           	+ "VALUES (?, ?, ?)");
			pstmt.setInt(1,this.idd);
			pstmt.setString(2, this.Name);
			pstmt.setInt(3,this.films);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(Connection con){
        try {
			PreparedStatement pstmt = con.prepareStatement(
					"UPDATE \"schem\".\"Directors\""
				   + " SET Фильмография = ? WHERE id_Режисера = ?");
			this.films++;
			pstmt.setInt(1,this.films);
			pstmt.setInt(2,this.idd);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
