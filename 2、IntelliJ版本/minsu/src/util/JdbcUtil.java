package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import pojo.Room;

/**
 * ���ݿ������������
 * @author ������
 *
 */
public class JdbcUtil {
	//1��jdbc��������
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	//2����̬�����
	static {
		//1����ȡProperties����
		Properties p = new Properties();
		//2����ȡ�ļ����ԣ���ȡ��������
		InputStream is = JdbcUtil.class.getResourceAsStream("/db.properties");
		//3�����ض�ȡ��
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//4�����ļ��л�ȡ������ֵ
		driver = p.getProperty("driver");
		url = p.getProperty("url");
		user = p.getProperty("user");
		password = p.getProperty("password");
		//5������������
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//3����ȡ���ݿ����Ӷ���Connection
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//4����ȡsql�������Statement
	public static Statement getStatement(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	//5����ȡsql�������PreparedStatement
	public static PreparedStatement getParparedStatement(String sql, Connection conn) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ps;
	}
	//6���ر���Դ
	public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//7����̬DML������ʵ�����ݿ�ģ�����ɾ����
	public static int executeDML(String sql, Object...objs) {
		//JDBC��������
		Connection conn = null;
		PreparedStatement ps = null;
		int j = -1;

		try {
			//1����ȡ���ݿ����Ӷ���
			conn = JdbcUtil.getConnection();
			//2�������ֶ��ύ����
			conn.setAutoCommit(false);
			//3����ȡPreparedStatement�������
			ps = conn.prepareStatement(sql);
			//4����ռλ����ֵ
			for(int i = 0; i < objs.length; i++) {
				ps.setObject(i+1, objs[i]);
			}
			//5��ִ��sql���
			j = ps.executeUpdate();
			//6���ύ����
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();		//����ع�
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 		                                     
			e.printStackTrace();
		}finally {
			//7���ر���Դ
			JdbcUtil.closeAll(null, ps, conn);
		}
		
		return j;
	}
	
	//8����ȡ��ѯ��ģ��������ResultSet��
	public static ResultSet getResultSet(String sql) {
		//1��Jdbc��������
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2����ȡ���ݿ����Ӷ���Connection
			conn = JdbcUtil.getConnection();
			//3����ȡPreparedStatement����
			ps = JdbcUtil.getParparedStatement(sql, conn);
			//4��ִ��sql���
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		//6�����ؽ��
		return rs;
	}
}
