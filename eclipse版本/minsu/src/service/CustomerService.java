package service;

import pojo.Customer;

/**
 * �˿ͱ�ҵ�����㣨�ӿڣ�
 * @author ������
 *
 */
public interface CustomerService {
	//1���������ݿ�㣺�鿴���й˿͵���Ϣ
	public void selAllCustomerInfo();
	//2���������ݿ�㣺ָ������ţ��鿴ĳ���˿͵���Ϣ
	public Customer selCustomerInfoByCustomer(int num) ;
	//3���������ݿ�㣺��ӹ˿͵���Ϣ
	public void insCustomerInfo();
	//4���������ݿ�㣺ָ�����֤�ţ�ɾ���˿͵���Ϣ
	public void delCustomerInfo(String id);
	//5���������ݿ�㣺ָ�����֤�ţ��޸Ĺ˿͵�����
	public void upCustomerInfo();
	//6���������֤�ţ����Ƿ�����ס�����䣩
	public boolean isInRoom(String cId);
}
