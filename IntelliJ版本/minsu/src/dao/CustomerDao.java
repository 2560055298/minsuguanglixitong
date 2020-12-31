package dao;

import java.util.ArrayList;
import java.util.Date;

import pojo.Customer;

/**
 * �˿ͱ����ݿ�㣨�ӿڣ�
 * @author ������
 *
 */
public interface CustomerDao {
	//1���鿴���й˿͵���Ϣ
	public ArrayList<Customer> selAllCustomerInfo();
	//2��ָ�����֤�ţ��鿴ĳ���˿͵���Ϣ
	public Customer selCustomerInfoByCustomer(String cId) ;
	//3����ӹ˿͵���Ϣ
	public int insCustomerInfo(String cId, String cName, String cSex, int cRoomNum, Date cGetTime);
	//4��ָ�����֤�ţ�ɾ���˿͵���Ϣ
	public int delCustomerInfo(String cId);
	//5��ָ�����֤�ţ��޸Ĺ˿͵�����
	public int upCustomerInfo(String cId, String cName);
	//6��ָ������ţ��鿴ĳ���˿͵���Ϣ
	public Customer selCustomerInfoByCustomer(int cNum) ;
}
