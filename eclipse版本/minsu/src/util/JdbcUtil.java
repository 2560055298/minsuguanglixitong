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
 * 数据库操作：工具类
 * @author 羊羊羊
 *
 */
public class JdbcUtil {
	//1、jdbc参数声明
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	//2、静态代码块
	static {
		//1、获取Properties对象
		Properties p = new Properties();
		//2、获取文件属性（读取流）对象
		InputStream is = JdbcUtil.class.getResourceAsStream("/db.properties");
		//3、加载读取流
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//4、从文件中获取：属性值
		driver = p.getProperty("driver");
		url = p.getProperty("url");
		user = p.getProperty("user");
		password = p.getProperty("password");
		//5、加载驱动类
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//3、获取数据库连接对象：Connection
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//4、获取sql命令对象：Statement
	public static Statement getStatement(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	//5、获取sql命令对象：PreparedStatement
	public static PreparedStatement getParparedStatement(String sql, Connection conn) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ps;
	}
	//6、关闭资源
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
	//7、静态DML方法：实现数据库的：增、删、改
	public static int executeDML(String sql, Object...objs) {
		//JDBC变量声明
		Connection conn = null;
		PreparedStatement ps = null;
		int j = -1;

		try {
			//1、获取数据库连接对象
			conn = JdbcUtil.getConnection();
			//2、设置手动提交事务
			conn.setAutoCommit(false);
			//3、获取PreparedStatement命令对象
			ps = conn.prepareStatement(sql);
			//4、给占位符赋值
			for(int i = 0; i < objs.length; i++) {
				ps.setObject(i+1, objs[i]);
			}
			//5、执行sql语句
			j = ps.executeUpdate();
			//6、提交事务
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();		//事务回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 		                                     
			e.printStackTrace();
		}finally {
			//7、关闭资源
			JdbcUtil.closeAll(null, ps, conn);
		}
		
		return j;
	}
	
	//8、获取查询表的：结果集（ResultSet）
	public static ResultSet getResultSet(String sql) {
		//1、Jdbc参数声明
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2、获取数据库连接对象：Connection
			conn = JdbcUtil.getConnection();
			//3、获取PreparedStatement对象
			ps = JdbcUtil.getParparedStatement(sql, conn);
			//4、执行sql语句
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		//6、返回结果
		return rs;
	}
}
