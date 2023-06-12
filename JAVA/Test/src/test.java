import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
	public static void main(String[] args) {
		Connection conn = null; //DB 커넥션 연결 객체
	    final String USERNAME = "root";//DBMS접속 시 아이디
	    final String PASSWORD = "root";//DBMS접속 시 비밀번호
	    final String URL = "jdbc:mysql://localhost:3306/staff2303";
	    
	    try {
            System.out.println("생성자");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("드라이버 로딩 성공");
            java.sql.Statement st = conn.createStatement();
            ResultSet result = st.executeQuery("select * from member");
            while (result.next()) {	
				String name = result.getString("name");
				System.out.println(name);
			}
            
        } catch (Exception e) {
            System.out.println("드라이버 로딩 실패 ");
            try {
                conn.close();
            } catch (SQLException e1) {    }
        }
	}
}
