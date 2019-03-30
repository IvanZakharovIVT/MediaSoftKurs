package myPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Comparator;

public class Serial implements Imyinterf, Iinsert{
	int yearStart;
	int yearEnd;
	int seasons;
	String Name;
	String Director;
	int id_drt;
	int id_Sl;
	public Serial(int Sl, String name, int yearS, int yearE, int seasons, String dir, int id_drt){
		this.yearStart = yearS;
		this.yearEnd = yearE;
		this.seasons = seasons;
		this.Name = name;
		this.Director = dir;
		this.id_drt = id_drt;
		this.id_Sl = Sl;
	}
	public String getName() {
		return ("Series:" + this.Name + ". Directed by "+ this.Director);
	}
	public String getAge() {
		int x1 = 2019 - this.yearStart;
		int x2 = 2019 - this.yearEnd; 
		String out = "";
		if (x2 > 0) {
			out = ("Series:" + this.Name + " Start " + x1 + " year ago and " + x2 + " year ago end");
		} else {
			out = ("Series:" + this.Name + " Start " + x1 + " year ago and" + " runing for nowday");
		}
		return out;
	}
	public String inf(){
		int x1 = 2019 - this.yearStart;
		int x2 = 2019 - this.yearEnd; 
		String S = "";
		if (x2 > 0) {
			S += "Series:" + this.Name + " Start " + x1 + " year ago and " + x2 + " year ago end";
		} else {
			S += "Series:" + this.Name + " Start " + x1 + " year ago and" + " runing for nowday";
		}
		S += " Directed by "+ this.Director; 
		return S;
	}
	public void insert(Connection con){
        try {
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO \"schem\".\"Serial\""
				   + "(id_сериала, Ќазвание_—ериала, год_выхода, "
				   + "год_закрыти€, количество_сезонов, им€_режисера, id_режисера)"
           	+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1,this.id_Sl);
			pstmt.setString(2,this.Name);
			pstmt.setInt(3,this.yearStart);
			pstmt.setInt(4,this.yearEnd);
			pstmt.setInt(5,this.seasons);
			pstmt.setString(6,this.Director);
			pstmt.setInt(7,this.id_drt);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Cmp implements Comparator<Serial>{
	@Override
	public int compare(Serial arg0, Serial arg1) {
		// TODO Auto-generated method stub
		return arg0.yearStart - arg1.yearStart;
	}
}
