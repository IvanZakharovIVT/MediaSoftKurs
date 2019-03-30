package myPackage;
import java.util.*;

import java.io.*;
import java.sql.*;

public class myClass {
	public static String Out = "";
	public static void main(String[] args) {
		List<Movie> mv = new ArrayList<Movie>();
		ArrayList <Director> dr = new ArrayList<Director>(); 
		String url = "jdbc:postgresql://localhost:5432/Movies";
        String login = "postgres";
        String password = "";
        int id_max = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url,
            login, password);
            try { 
            Statement stmt = con.createStatement();
            String sel ="SELECT * FROM \"schem\".\"Directors\" ";
            ResultSet rs = stmt.executeQuery(sel);
            while (rs.next()) {
            	int idr = rs.getInt("id_Режисера");
            	String nm = rs.getString("Полное_Имя");
            	int in = rs.getInt("Фильмография");
            	dr.add(new Director(idr, nm, in));
            	if (idr > id_max) {
            		id_max = idr + 1;
            	}
            }
            rs.close();
            stmt.close();
            } finally { con.close(); }
        } catch (Exception e) { e.printStackTrace(); }
		List<Serial> sl = new LinkedList<Serial>();
		String S = "";
		File file1 = new File("C:\\Users\\User\\workspace\\Project1\\KursWork1.txt");
		S = FileRead(file1);
		S.trim();
		String []st = S.split("\n");
		for (String t: st) {
			t = t.trim();
			String []spt = t.split("-");
			int ids = Integer.parseInt(spt[0]);
			int ys = Integer.parseInt(spt[2]);
			int ye = Integer.parseInt(spt[3]);
			int numb = Integer.parseInt(spt[4]);
			int idr = Integer.parseInt(spt[6]);
			String name = spt[1];
			name = name.trim();
			String drtr = spt[5];
			drtr = drtr.trim();
			sl.add(new Serial(ids, name, ys, ye, numb, drtr, idr));
		}
		System.out.println(sl.get(1).getAge());
		System.out.println(sl.get(0).getName());
		file1 = new File("C:\\Users\\User\\workspace\\Project1\\KursWork2.txt");
		S = FileRead(file1);
		S.trim();
		String []sm = S.split("\n");
		for (String t: sm) {
			t = t.trim();
			String []spt = t.split("-");
			int idm = Integer.parseInt(spt[0]);
			int year = Integer.parseInt(spt[2]);
			int idr = Integer.parseInt(spt[3]);
			double rait = Double.parseDouble(spt[5]);
			String name = spt[1];
			name = name.trim();
			String drtr = spt[4];
			drtr = drtr.trim();
			mv.add(new Movie(idm, name, year, idr, drtr, rait));
		}
		System.out.println(((Movie) mv.get(0)).getName());
		System.out.println((mv.get(1).getAge()));
		Movie movchek;
		movchek = mv.get(1);
		System.out.println(movchek.getName());
		Collections.sort(mv, (m1, m2)->(int)(m1.rating*10 - m2.rating*10));
		Cmp cmp = new Cmp();
		Collections.sort(sl, cmp);
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, login, password);
			for (Movie vm: mv){
				vm.insert(con);
				int id_c = vm.id_d;
				int fn = drt(id_c, dr);
				if (fn > 0 ) {
					dr.get(fn).update(con);
				} else {
					Director d2 = new Director (vm.id_d, vm.Director, 1);
					dr.add(d2);
					id_max++;
					d2.insert(con);
				}
			}
			for (Serial ls: sl){
				ls.insert(con);
				int id_c = ls.id_drt;
				int fn = drt(id_c, dr);
				if (fn > 0) {
					dr.get(fn).update(con);
				} else {
					Director d2 = new Director (ls.id_drt, ls.Director, 1);
					dr.add(d2);
					id_max++;
					d2.insert(con);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*	
		for (Serial ls: sl){
			if (dr.idd.indexOf(ls.id_drt)) {
				
			}
		}
		for (Movie vm: mv){
			vm.insert();
		}
		String Out = "";
		for (Serial se: sl) {
			Out += se.inf() + "\n";
		}*/
	}
	public static String FileRead(File file){
		InputStream in = null;
		String S = "";
		try {
			in = new BufferedInputStream(new FileInputStream(file));
			while(in.available() > 0) {
				char symbol = (char)in.read();
				S += symbol;
			//	System.out.print(symbol);
			}
		}catch(Exception e){
			 System.out.println(e.getMessage());
		} finally {
			if (in != null)  {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return S;
	}
	public static List<Serial> slful (int i) {
		List <Serial> sl = null;
		return sl;
	}
	public static int drt (int idd, List<Director> dr){
		int i = 0;
		for (Director dt: dr){
			if (idd == dt.idd) {
				return i;
			}
			i++;
		}
		return -1;
	}
}
