package jdbc.hikari;

import java.sql.Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * hikariCP DB�� ��������ִ� Ŭ�����Դϴ�. DB���� ���� �ҷ��� �� ����ϸ� �˴ϴ�. <br>(�ٷ��� ���� �߻��� �����ϱ� ����)
 * <br><br>
 * [��� ���]
 * HikariCP import �� getConnection() �޼��� ���. Auto Close������� ���
 * <br>
 * EX) 
 * <br><pre>
 * try (
 * 	Connection conn = HikariCP.getConnection();
 * 	PreparedStatement pstmt = conn.prepareStatement(sql);
 * ) {
 * 
 * 	���ϴ� ��ɹ� �ۼ�.
 * 
 * } catch (SQLException e1) {
 * 	e1.printStackTrace();
 * }
 * </pre>
 * 
 * */
public class HikariCP {
	
	private static HikariConfig config;
	private static HikariDataSource ds;
	
	static {
		config = new HikariConfig("./data/hikari.properties");
		config.setConnectionTestQuery("SELECT 1 FROM dual");
		
		ds = new HikariDataSource(config);
	};
	
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (Exception e) {
			System.out.println("[ERROR] HikariCP Class getConnection");
			return null;
		}
	}
	
}
