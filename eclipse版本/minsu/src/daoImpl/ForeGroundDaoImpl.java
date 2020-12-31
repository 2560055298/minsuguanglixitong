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
 * ǰ̨�����ݿ�㣨ʵ���ࣩ
 * @author ������
 *
 */

public class ForeGroundDaoImpl implements ForeGroundDao{

	//1���鿴ǰ̨�洢�ģ�ȫ����Ϣ
	@Override
	public ArrayList<ForeGround> selAllForeGroundInfo() {
		//1��Jdbc��������
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//2����������
		ArrayList<ForeGround> lists = null;
		try {
			//3����ȡ���ݿ����Ӷ���Connection
			conn = JdbcUtil.getConnection();
			//4������sql���
			String sql = "select * from ForeGround";
			//5����ȡPreparedStatement����
			ps = JdbcUtil.getParparedStatement(sql, conn);
			//6��ִ��sql���
			rs = ps.executeQuery();
			//7������
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
			//8���ر���Դ
			JdbcUtil.closeAll(rs, ps, conn);
		}
		//9�����ؽ��
		return lists;
	}

	//2��ָ�����֤�ţ��鿴ǰ̨�洢��Ϣ
	@Override
	public ForeGround selForeGroundInfoByForeGround(String fGId) {
		//1��Jdbc��������
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				//2��ForeGround��������
				ForeGround fg = null;
				
				try {
					//3����ȡ���ݿ����Ӷ���Connection
					conn = JdbcUtil.getConnection();
					//4������sql���
					String sql = "select * from ForeGround where fGId = ?";
					//5����ȡPreparedStatement����
					ps = JdbcUtil.getParparedStatement(sql, conn);
					//6����ռλ����ֵ
					ps.setString(1, fGId);
					//7��ִ��sql���
					rs = ps.executeQuery();
					//8������
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
					//9���ر���Դ
					JdbcUtil.closeAll(rs, ps, conn);
				}
				//10�����ؽ��
				return fg;
	}

	//3�����ǰ̨��Ϣ
	@Override
	public int insForeGroundInfo(String fGId, int fGRoomNum, Date fGGetTime, Date fGLeaveTime, int fGExpense) {
		java.sql.Date date1 = new java.sql.Date(fGGetTime.getTime());
		java.sql.Date date2 = new java.sql.Date(fGLeaveTime.getTime());
		return JdbcUtil.executeDML("insert into ForeGround values(?, ?, ?, ?, ?)", fGId, fGRoomNum, date1, date2, fGExpense);
	}

	//4��ָ�����֤�ţ�ɾ��ǰ̨��Ϣ
	@Override
	public int delForeGroundInfo(String fGId) {
		return JdbcUtil.executeDML("delete from ForeGround where fGId = ?", fGId);
	}

	//5��ָ�����֤�ţ��޸�ǰ̨��¼�ģ������
	@Override
	public int upForeGroundInfo(String fGId, int fGRoomNum) {
		return JdbcUtil.executeDML("update ForeGround set fGRoomNum = ? where fGId = ?" , fGRoomNum, fGId);
	}	
}
