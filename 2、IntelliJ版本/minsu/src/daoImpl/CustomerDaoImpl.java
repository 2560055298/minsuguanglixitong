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
 * �˿ͱ����ݿ�㣨ʵ���ࣩ
 * @author ������
 *
 */
public class CustomerDaoImpl implements CustomerDao{

	//1���鿴���й˿͵���Ϣ
	@Override
	public ArrayList<Customer> selAllCustomerInfo() {
		//1��Jdbc��������
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//2����������
		ArrayList<Customer> lists = null;
		try {
			//3����ȡ���ݿ����Ӷ���Connection
			conn = JdbcUtil.getConnection();
			//4������sql���
			String sql = "select * from Customer";
			//5����ȡPreparedStatement����
			ps = JdbcUtil.getParparedStatement(sql, conn);
			//6��ִ��sql���
			rs = ps.executeQuery();
			//7������
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
			//8���ر���Դ
			JdbcUtil.closeAll(rs, ps, conn);
		}
		//9�����ؽ��
		return lists;
	}

	//2��ָ�����֤�ţ��鿴ĳ���˿͵���Ϣ
	@Override
	public Customer selCustomerInfoByCustomer(String cId) {
		//1��Jdbc��������
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//2��Customer��������
		Customer c = null;
		
		try {
			//3����ȡ���ݿ����Ӷ���Connection
			conn = JdbcUtil.getConnection();
			//4������sql���
			String sql = "select * from Customer where cId = ?";
			//5����ȡPreparedStatement����
			ps = JdbcUtil.getParparedStatement(sql, conn);
			//6����ռλ����ֵ
			ps.setString(1, cId);
			//7��ִ��sql���
			rs = ps.executeQuery();
			//8������
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
			//9���ر���Դ
			JdbcUtil.closeAll(rs, ps, conn);
		}
		//10�����ؽ��
		return c;
	}

	//3����ӹ˿͵���Ϣ
	@Override
	public int insCustomerInfo(String cId, String cName, String cSex, int cRoomNum, Date cGetTime) {
		java.sql.Date date = new java.sql.Date(cGetTime.getTime());
		return JdbcUtil.executeDML("insert into Customer values(?, ?, ?, ?, ?)", cId, cName, cSex, cRoomNum, date);
	}

	//4��ָ�����֤�ţ�ɾ���˿͵���Ϣ
	@Override
	public int delCustomerInfo(String cId) {
		return JdbcUtil.executeDML("delete from Customer where cId = ?", cId);
	}

	//5��ָ�����֤�ţ��޸Ĺ˿͵�����
	@Override
	public int upCustomerInfo(String cId, String cName) {
		return JdbcUtil.executeDML("update Customer set cName = ? where cId = ?" , cName, cId);
	}

	//6��ָ������ţ��鿴ĳ���˿͵���Ϣ
	@Override
	public Customer selCustomerInfoByCustomer(int cNum) {
		//1��Jdbc��������
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//2��Customer��������
		Customer c = null;
		
		try {
			//3����ȡ���ݿ����Ӷ���Connection
			conn = JdbcUtil.getConnection();
			//4������sql���
			String sql = "select * from Customer where cRoomNum = ?";
			//5����ȡPreparedStatement����
			ps = JdbcUtil.getParparedStatement(sql, conn);
			//6����ռλ����ֵ
			ps.setInt(1, cNum);
			//7��ִ��sql���
			rs = ps.executeQuery();
			//8������
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
			//9���ر���Դ
			JdbcUtil.closeAll(rs, ps, conn);
		}
		//10�����ؽ��
		return c;
	}
}
