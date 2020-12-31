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
 * ��������ݿ�㣨ʵ���ࣩ
 * @author ������
 *
 */

public class RoomDaoImpl implements RoomDao {

	//1���鿴���з������Ϣ
	@Override
	public ArrayList<Room> selAllRoomInfo() {
		//1��Jdbc��������
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//2����������
		ArrayList<Room> lists = null;
		try {
			//3����ȡ���ݿ����Ӷ���Connection
			conn = JdbcUtil.getConnection();
			//4������sql���
			String sql = "select * from Room";
			//5����ȡPreparedStatement����
			ps = JdbcUtil.getParparedStatement(sql, conn);
			//6��ִ��sql���
			rs = ps.executeQuery();
			//7������
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
			//8���ر���Դ
			JdbcUtil.closeAll(rs, ps, conn);
		}
		//9�����ؽ��
		return lists;
	}

	//2��ָ������ţ��鿴ĳ���������Ϣ
	@Override
	public Room selRoomInfoByRoom(int rNum) {
		//1��Jdbc��������
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				//2��Room��������
				Room r = null;
				
				try {
					//3����ȡ���ݿ����Ӷ���Connection
					conn = JdbcUtil.getConnection();
					//4������sql���
					String sql = "select * from Room where rNum = ?";
					//5����ȡPreparedStatement����
					ps = JdbcUtil.getParparedStatement(sql, conn);
					//6����ռλ����ֵ
					ps.setInt(1, rNum);
					//7��ִ��sql���
					rs = ps.executeQuery();
					//8������
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
					//9���ر���Դ
					JdbcUtil.closeAll(rs, ps, conn);
				}
				//10�����ؽ��
				return r;
	}

	//3����ӷ������Ϣ
	@Override
	public int insRoomInfo(int rNum, String rType, int rPrice, String rState) {
		return JdbcUtil.executeDML("insert into Room values(?, ?, ?, ?)", rNum, rType, rPrice, rState);
	}

	//4��ָ������ţ�ɾ���������Ϣ
	@Override
	public int delRoomInfo(int rNum) {
		return JdbcUtil.executeDML("delete from Room where rNum = ?", rNum);
	}

	//5��ָ������ţ��޸ķ������Ϣ
	@Override
	public int upRoomInfo(int rNum, String rState) {
		return JdbcUtil.executeDML("update Room set rState = ? where rNum = ?" , rState, rNum);
	}
	
}
