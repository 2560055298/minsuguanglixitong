package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dao.CustomerDao;
import pojo.Customer;
import pojo.Customer;
import util.JdbcUtil;

/**
 * 顾客表：数据库层（实现类）
 * @author 羊羊羊
 *
 */
public class CustomerDaoImpl implements CustomerDao{

	//1、查看所有顾客的信息
	@Override
	public ArrayList<Customer> selAllCustomerInfo() {
		//1、Jdbc参数声明
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//2、集合声明
		ArrayList<Customer> lists = null;
		try {
			//3、获取数据库连接对象：Connection
			conn = JdbcUtil.getConnection();
			//4、创建sql语句
			String sql = "select * from Customer";
			//5、获取PreparedStatement对象
			ps = JdbcUtil.getParparedStatement(sql, conn);
			//6、执行sql语句
			rs = ps.executeQuery();
			//7、遍历
			lists = new ArrayList<Customer>();
			while(rs.next()) {
				Customer c = new Customer();
				c.setcId(rs.getString("cId"));;
				c.setcName(rs.getString("cName"));
				c.setcSex(rs.getString("cSex"));
				c.setcRoomNum(rs.getInt("cRoomNum"));
				c.setcGetTime(rs.getDate("cGetTime"));
				lists.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//8、关闭资源
			JdbcUtil.closeAll(rs, ps, conn);
		}
		//9、返回结果
		return lists;
	}

	//2、指定身份证号：查看某个顾客的信息
	@Override
	public Customer selCustomerInfoByCustomer(String cId) {
		//1、Jdbc参数声明
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//2、Customer对象声明
		Customer c = null;
		
		try {
			//3、获取数据库连接对象：Connection
			conn = JdbcUtil.getConnection();
			//4、创建sql语句
			String sql = "select * from Customer where cId = ?";
			//5、获取PreparedStatement对象
			ps = JdbcUtil.getParparedStatement(sql, conn);
			//6、给占位符赋值
			ps.setString(1, cId);
			//7、执行sql语句
			rs = ps.executeQuery();
			//8、遍历
			while(rs.next()) {
				c = new Customer();
				c.setcId(rs.getString("cId"));;
				c.setcName(rs.getString("cName"));
				c.setcSex(rs.getString("cSex"));
				c.setcRoomNum(rs.getInt("cRoomNum"));
				c.setcGetTime(rs.getDate("cGetTime"));
			}
		} catch (SQLException e11) {
			e11.printStackTrace();
		}finally {
			//9、关闭资源
			JdbcUtil.closeAll(rs, ps, conn);
		}
		//10、返回结果
		return c;
	}

	//3、添加顾客的信息
	@Override
	public int insCustomerInfo(String cId, String cName, String cSex, int cRoomNum, Date cGetTime) {
		java.sql.Date date = new java.sql.Date(cGetTime.getTime());
		return JdbcUtil.executeDML("insert into Customer values(?, ?, ?, ?, ?)", cId, cName, cSex, cRoomNum, date);
	}

	//4、指定身份证号：删除顾客的信息
	@Override
	public int delCustomerInfo(String cId) {
		return JdbcUtil.executeDML("delete from Customer where cId = ?", cId);
	}

	//5、指定身份证号：修改顾客的姓名
	@Override
	public int upCustomerInfo(String cId, String cName) {
		return JdbcUtil.executeDML("update Customer set cName = ? where cId = ?" , cName, cId);
	}

	//6、指定房间号：查看某个顾客的信息
	@Override
	public Customer selCustomerInfoByCustomer(int cNum) {
		//1、Jdbc参数声明
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//2、Customer对象声明
		Customer c = null;
		
		try {
			//3、获取数据库连接对象：Connection
			conn = JdbcUtil.getConnection();
			//4、创建sql语句
			String sql = "select * from Customer where cRoomNum = ?";
			//5、获取PreparedStatement对象
			ps = JdbcUtil.getParparedStatement(sql, conn);
			//6、给占位符赋值
			ps.setInt(1, cNum);
			//7、执行sql语句
			rs = ps.executeQuery();
			//8、遍历
			while(rs.next()) {
				c = new Customer();
				c.setcId(rs.getString("cId"));;
				c.setcName(rs.getString("cName"));
				c.setcSex(rs.getString("cSex"));
				c.setcRoomNum(rs.getInt("cRoomNum"));
				c.setcGetTime(rs.getDate("cGetTime"));
			}
		} catch (SQLException e11) {
			e11.printStackTrace();
		}finally {
			//9、关闭资源
			JdbcUtil.closeAll(rs, ps, conn);
		}
		//10、返回结果
		return c;
	}
}
