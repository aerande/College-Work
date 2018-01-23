import java.sql.*;
import java.io.*;

public class Data_insertion_logs {

        public static void main(String[] args) {
                Connection conn = null;
                FileInputStream fis = null;
                BufferedReader br = null;
                Statement st = null;
                PreparedStatement ps = null;
                try{
                        Class.forName("com.mysql.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost/Logs_Database","root","[your password]");
                        st = conn.createStatement();

                        st.executeUpdate("CREATE TABLE logs(id INT NOT NULL AUTO_INCREMENT, date VARCHAR(20), date_year VARCHAR(5), date_month VARCHAR(3), date_day VARCHAR(3), time_hour VARCHAR(3), time_minute VARCHAR(3), time_seconds VARCHAR(3), s_ip VARCHAR(15), cs_method VARCHAR(100), cs_uri_stem VARCHAR(300), cs_uri_query VARCHAR(800), s_port VARCHAR(4), cs_username VARCHAR(10), c_ip VARCHAR(15), cs_user_agent VARCHAR(500), sc_status VARCHAR(4), sc_substatus VARCHAR(5), sc_win32_status VARCHAR(4), time_taken VARCHAR(10), PRIMARY KEY(id))");

                        fis = new FileInputStream("logs.log");
                        br = new BufferedReader (new InputStreamReader(fis));

                        String line = "";
                        String s2 = "#";
	                String[] words = null;

                        for (int j=0; j< 4; j++){
                                line = br.readLine();
                        }
                        
                        line = br.readLine();
                        while(line!=null){
                                String s1 = line.substring(0,1);
                                if(!s1.equals(s2)){
                                        words = line.split("\\s");
                                        ps = conn.prepareStatement("INSERT INTO logs (date, date_year,date_month,date_day,time_hour,time_minute,time_seconds,s_ip,cs_method,cs_uri_stem,cs_uri_query,s_port,cs_username,c_ip,cs_user_agent,sc_status,sc_substatus,sc_win32_status,time_taken) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                                        String [] date_split = words[0].split("-");
                                        String [] time_split = words[1].split(":");

					ps.setString(1,words[0]);
                                        ps.setString(2,date_split[0]);
                                        ps.setString(3,date_split[1]);
                                        ps.setString(4,date_split[2]);
                                        ps.setString(5,time_split[0]);
                                        ps.setString(6,time_split[1]);
                                        ps.setString(7,time_split[2]);
                                        ps.setString(8,words[2]);
                                        ps.setString(9,words[3]);
                                        ps.setString(10,words[4]);
                                        ps.setString(11,words[5]);
                                        ps.setString(12,words[6]);
                                        ps.setString(13,words[7]);
                                        ps.setString(14,words[8]);
                                        ps.setString(15,words[9]);
                                        ps.setString(16,words[10]);
                                        ps.setString(17,words[11]);
                                        ps.setString(18,words[12]);
                                        ps.setString(19,words[13]);
                                        ps.execute();
                                        words = null;
                                }
                                line = br.readLine();
                        }
                        
                }
                catch(Exception e){
                        e.printStackTrace();
                }
                finally{
                        try{
                                st.close();
                                br.close();
                                fis.close();
                                ps.close();
                                conn.close();
                        }
                        catch(Exception ex){
                                ex.printStackTrace();
                        }
                }
        }
}