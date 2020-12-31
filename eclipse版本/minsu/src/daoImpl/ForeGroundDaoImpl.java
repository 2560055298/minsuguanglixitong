package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dao.ForeGroundDao;
import pojo.ForeGround;
import util.JdbcUtil;

/**
 * 前台表：数据库层（实现类）
 * @author 羊羊羊
 *
 */

public class ForeGroundDaoImpl implements ForeGroundDao{

	//1、查看前台存储的：全部信息
	@Override
	public ArrayList<ForeGround> selAllForeGroundInfo() {
		//1、Jdbc参数声明
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//2、集合声明
		ArrayList<ForeGround> lists = null;
		try {
			//3、获取数据库连接对象：Connection
			conn = JdbcUtil.getConnection();
			//4、创建sql语句
			String sql = "select * from ForeGround";
			//5、获取PreparedStatement对象
			ps = JdbcUtil.getParparedStatement(sql, conn);
			//6、执行sql语句
			rs = ps.executeQuery();
			//7、遍历
			lists = new ArrayList<ForeGround>();
			while(rs.next()) {
				ForeGround fg = new ForeGround();
				fg.setfGId(rs.getString("fGId"));
				fg.setfGRoomNum(rs.getInt("fGRoomNum"));
				fg.setfGGetTime(rs.getDate("fGGetTime"));
				fg.setfGLeaveTime(rs.getDate("fGLeaveTime"));
				fg.setfGExpense(rs.getInt("fGExpense"));
			
				lists.add(fg);
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

	//2、指定身份证号：查看前台存储信息
	@Override
	public ForeGround selForeGroundInfoByForeGround(String fGId) {
		//1、Jdbc参数声明
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				//2、ForeGround对象声明
				ForeGround fg = null;
				
				try {
					//3、获取数据库连接对象：Connection
					conn = JdbcUtil.getConnection();
					//4、创建sql语句
					String sql = "select * from ForeGround where fGId = ?";
					//5、获取PreparedStatement对象
					ps = JdbcUtil.getParparedStatement(sql, conn);
					//6、给占位符赋值
					ps.setString(1, fGId);
					//7、执行sql语句
					rs = ps.executeQuery();
					//8、遍历
					while(rs.next()) {
						fg = new ForeGround();
						fg.setfGId(rs.getString("fGId"));
						fg.setfGRoomNum(rs.getInt("fGRoomNum"));
						fg.setfGGetTime(rs.getDate("fGGetTime"));
						fg.setfGLeaveTime(rs.getDate("fGLeaveTime"));
						fg.setfGExpense(rs.getInt("fGExpense"));
					}
				} catch (SQLException e11) {
					e11.printStackTrace();
				}finally {
					//9、关闭资源
					JdbcUtil.closeAll(rs, ps, conn);
				}
				//10、返回结果
				return fg;
	}

	//3、添加前台信息
	@Override
	public int insForeGroundInfo(String fGId, int fGRoomNum, Date fGGetTime, Date fGLeaveTime, int fGExpense) {
		java.sql.Date date1 = new java.sql.Date(fGGetTime.getTime());
		java.sql.Date date2 = new java.sql.Date(fGLeaveTime.getTime());
		return JdbcUtil.executeDML("insert into ForeGround values(?, ?, ?, ?, ?)", fGId, fGRoomNum, date1, date2, fGExpense);
	}

	//4、指定身份证号：删除前台信息
	@Override
	public int delForeGroundInfo(String fGId) {
		return JdbcUtil.executeDML("delete from ForeGround where fGId = ?", fGId);
	}

	//5、指定身份证号：修改前台记录的：房间号
	@Override
	public int upForeGroundInfo(String fGId, int fGRoomNum) {
		return JdbcUtil.executeDML("update ForeGround set fGRoomNum = ? where fGId = ?" , fGRoomNum, fGId);
	}	
}
