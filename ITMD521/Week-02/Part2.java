import java.sql.*;
import java.io.*;

public class Part2 {

        public static void main(String[] args) {
                try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/temperature","root","safestsystemever");
                        Statement st = conn.createStatement();
						
			//Inserting data for first table with only 1990 data
                        st.executeUpdate("CREATE TABLE 1990_data (id INT NOT NULL AUTO_INCREMENT, obsHour VARCHAR(10), ofDate VARCHAR(10), tem INT, PRIMARY KEY(id))");
                        FileInputStream fis = new FileInputStream("1990");
                        BufferedReader br = new BufferedReader (new InputStreamReader(fis));
                        String line = br.readLine();
                        int i=0;
                        while(line!=null){
                                String tem = line.substring(88,92);
                                int temI = Integer.parseInt(tem);
                                String dat = line.substring(15,23);
                                String tim = line.substring(24,27);
                                PreparedStatement ps = conn.prepareStatement("insert into 1990_data (obsHour,ofDate,tem) values (?,?,?)");
                                ps.setString(1,tim);
                                ps.setString(2,dat);
                                ps.setInt(3,temI);
                                ps.execute();
                                line = br.readLine();
                        }
                        
                        ResultSet rs = st.executeQuery("select max(tem) from 1990_data");
                        while(rs.next()){
                                int max = rs.getInt(1);
                                System.out.println("Max temp for 1990_data set: "+max);
                        }
                        
						
						
						
			//Inserting data for second table with 1990 & 1992 data
						
			st.executeUpdate("CREATE TABLE 1990_1992_data (id INT NOT NULL AUTO_INCREMENT, obsHour VARCHAR(10), ofDate VARCHAR(10), tem INT, PRIMARY KEY(id))");
			FileInputStream fis1 = new FileInputStream("1992");
			BufferedReader br1 = new BufferedReader (new InputStreamReader(fis1));
                        String line1 = br1.readLine();
						
			while(line!=null){
                                String tem = line.substring(88,92);
                                int temI = Integer.parseInt(tem);
                                String dat = line.substring(15,23);
                                String tim = line.substring(24,27);
                                PreparedStatement ps = conn.prepareStatement("insert into 1990_1992_data (obsHour,ofDate,tem) values (?,?,?)");
                                ps.setString(1,tim);
                                ps.setString(2,dat);
                                ps.setInt(3,temI);
                                ps.execute();
                                line = br.readLine();
                        }
						
			while(line1!=null){
                                String tem = line1.substring(88,92);
                                int temI = Integer.parseInt(tem);
                                String dat = line1.substring(15,23);
                                String tim = line1.substring(24,27);
                                PreparedStatement ps = conn.prepareStatement("insert into 1990_1992_data (obsHour,ofDate,tem) values (?,?,?)");
                                ps.setString(1,tim);
                                ps.setString(2,dat);
                                ps.setInt(3,temI);
                                ps.execute();
                                line1 = br1.readLine();
                        }
						
			ResultSet rs1 = st.executeQuery("select max(tem) from 1990_1992_data");
                        while(rs1.next()){
                                int max = rs1.getInt(1);
                                System.out.println("Max temp for 1990_1992_data set: "+max);
                        }
						
						
						
			//Inserting data for third table with 1990, 1991, 1992 & 1993 data
						
			st.executeUpdate("CREATE TABLE all_data (id INT NOT NULL AUTO_INCREMENT, obsHour VARCHAR(10), ofDate VARCHAR(10), tem INT, PRIMARY KEY(id))");
						
			while(line!=null){
                                String tem = line.substring(88,92);
                                int temI = Integer.parseInt(tem);
                                String dat = line.substring(15,23);
                                String tim = line.substring(24,27);
                                PreparedStatement ps = conn.prepareStatement("insert into all_data (obsHour,ofDate,tem) values (?,?,?)");
                                ps.setString(1,tim);
                                ps.setString(2,dat);
                                ps.setInt(3,temI);
                                ps.execute();
                                line = br.readLine();
                        }
						
			while(line1!=null){
                                String tem = line1.substring(88,92);
                                int temI = Integer.parseInt(tem);
                                String dat = line1.substring(15,23);
                                String tim = line1.substring(24,27);
                                PreparedStatement ps = conn.prepareStatement("insert into all_data (obsHour,ofDate,tem) values (?,?,?)");
                                ps.setString(1,tim);
                                ps.setString(2,dat);
                                ps.setInt(3,temI);
                                ps.execute();
                                line1 = br1.readLine();
                        }
						
			FileInputStream fis2 = new FileInputStream("1991");
			BufferedReader br2 = new BufferedReader (new InputStreamReader(fis2));
                        String line2 = br2.readLine();
						
			while(line2!=null){
                                String tem = line2.substring(88,92);
                                int temI = Integer.parseInt(tem);
                                String dat = line2.substring(15,23);
                                String tim = line2.substring(24,27);
                                PreparedStatement ps = conn.prepareStatement("insert into all_data (obsHour,ofDate,tem) values (?,?,?)");
                                ps.setString(1,tim);
                                ps.setString(2,dat);
                                ps.setInt(3,temI);
                                ps.execute();
                                line2 = br2.readLine();
                        }
						
			FileInputStream fis3 = new FileInputStream("1993");
			BufferedReader br3 = new BufferedReader (new InputStreamReader(fis3));
                        String line3 = br3.readLine();
						
			while(line3!=null){
                                String tem = line3.substring(88,92);
                                int temI = Integer.parseInt(tem);
                                String dat = line3.substring(15,23);
                                String tim = line3.substring(24,27);
                                PreparedStatement ps = conn.prepareStatement("insert into all_data (obsHour,ofDate,tem) values (?,?,?)");
                                ps.setString(1,tim);
                                ps.setString(2,dat);
                                ps.setInt(3,temI);
                                ps.execute();
                                line3 = br3.readLine();
                        }
						
			ResultSet rs2 = st.executeQuery("select max(tem) from all_data");
                        while(rs2.next()){
                                int max = rs2.getInt(1);
                                System.out.println("Max temp for all_data set: "+max);
                        }
						

			br.close();
                        fis.close();
			rs.close();
			br1.close();
                        fis1.close();
			rs1.close();
			br2.close();
                        fis2.close();
			rs2.close();
			br3.close();
                        fis3.close();
                        conn.close();
                }
                catch(Exception e){
                        e.printStackTrace();
                }
        }

}
