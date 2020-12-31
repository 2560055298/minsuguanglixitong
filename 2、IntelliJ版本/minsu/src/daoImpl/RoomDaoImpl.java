package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.RoomDao;
import pojo.Room;
import util.JdbcUtil;

/**
 * 房间表：数据库层（实现类）
 * @author 羊羊羊
 *
 */

public class RoomDaoImpl implements RoomDao {

	//1、查看所有房间的信息
	@Override
	public ArrayList<Room> selAllRoomInfo() {
		//1、Jdbc参数声明
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//2、集合声明
		ArrayList<Room> lists = null;
		try {
			//3、获取数据库连接对象：Connection
			conn = JdbcUtil.getConnection();
			//4、创建sql语句
			String sql = "select * from Room";
			//5、获取PreparedStatement对象
			ps = JdbcUtil.getParparedStatement(sql, conn);
			//6、执行sql语句
			rs = ps.executeQuery();
			//7、遍历
			lists = new ArrayList<Room>();
			while(rs.next()) {
				Room r = new Room();
				r.setrNum(rs.getInt("rNum"));
				r.setrType(rs.getString("rType"));
				r.setrPrice(rs.getInt("rPrice"));
				r.setrState(rs.getString("rState"));
				lists.add(r);
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

	//2、指定房间号：查看某个房间的信息
	@Override
	public Room selRoomInfoByRoom(int rNum) {
		//1、Jdbc参数声明
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				//2、Room对象声明
				Room r = null;
				
				try {
					//3、获取数据库连接对象：Connection
					conn = JdbcUtil.getConnection();
					//4、创建sql语句
					String sql = "select * from Room where rNum = ?";
					//5、获取PreparedStatement对象
					ps = JdbcUtil.getParparedStatement(sql, conn);
					//6、给占位符赋值
					ps.setInt(1, rNum);
					//7、执行sql语句
					rs = ps.executeQuery();
					//8、遍历
					while(rs.next()) {
						r = new Room();
						r.setrNum(rs.getInt("rNum"));
						r.setrType(rs.getString("rType"));
						r.setrPrice(rs.getInt("rPrice"));
						r.setrState(rs.getString("rState"));
					}
				} catch (SQLException e11) {
					e11.printStackTrace();
				}finally {
					//9、关闭资源
					JdbcUtil.closeAll(rs, ps, conn);
				}
				//10、返回结果
				return r;
	}

	//3、添加房间的信息
	@Override
	public int insRoomInfo(int rNum, String rType, int rPrice, String rState) {
		return JdbcUtil.executeDML("insert into Room values(?, ?, ?, ?)", rNum, rType, rPrice, rState);
	}

	//4、指定房间号：删除房间的信息
	@Override
	public int delRoomInfo(int rNum) {
		return JdbcUtil.executeDML("delete from Room where rNum = ?", rNum);
	}

	//5、指定房间号：修改房间的信息
	@Override
	public int upRoomInfo(int rNum, String rState) {
		return JdbcUtil.executeDML("update Room set rState = ? where rNum = ?" , rState, rNum);
	}
	
}
