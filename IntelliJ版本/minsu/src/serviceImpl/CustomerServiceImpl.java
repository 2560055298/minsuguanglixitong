package serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import dao.CustomerDao;
import daoImpl.CustomerDaoImpl;
import pojo.Customer;
import service.CustomerService;

/**
 * �˿ͱ�ҵ����루ʵ�ֲ㣩
 * @author ������
 *
 */
public class CustomerServiceImpl implements CustomerService {
	CustomerDao cd = new CustomerDaoImpl();
	
	//1���������ݿ�㣺�鿴���й˿͵���Ϣ
	@Override
	public void selAllCustomerInfo() {
		//1���������ϱ���
		ArrayList<Customer> lists = null;
		//2���������ݿ���ȡ���˿���Ϣ����
		lists = cd.selAllCustomerInfo();
		//3���������
		for (Customer c : lists) {
			System.out.println(c);
		}
	}

	//2���������ݿ�㣺ָ������ţ��鿴ĳ���˿͵���Ϣ
	@Override
	public Customer selCustomerInfoByCustomer(int num) {
			//1������Customer����
			Customer c = cd.selCustomerInfoByCustomer(num);
			return c;
	}

	//3���������ݿ�㣺��ӹ˿͵���Ϣ
	@Override
	public void insCustomerInfo() {
		//1���ӿ���̨����˿͵���Ϣ
				System.out.println("��������ӹ˿͵ģ������Ϣ");
				Scanner sc = new Scanner(System.in);
			
				System.out.println("�����룺�˿͵����֤��");
				String cId = sc.nextLine();
				
				System.out.println("�����룺�˿͵�����");
				String cName = sc.next();
				
				System.out.println("�����룺�˿͵��Ա�");
				String cSex = sc.next();
				
				System.out.println("�����룺�˿͵ķ����");
				int cRoomNum = sc.nextInt();
				
				System.out.println("�����룺��ס���� (��ʽ��yyyy-MM-dd)");
				String date = sc.next();
				Date cGetTime = null;
				try {
					cGetTime = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				//2����ʾ������״̬
				int i = cd.insCustomerInfo(cId, cName, cSex, cRoomNum, cGetTime);
				if(i > 0) {
					System.out.println("�˿���Ϣ����ӳɹ�");
				}else {
					System.out.println("�˿���Ϣ�����ʧ��");
				}
				
	}

	//4���������ݿ�㣺ָ�����֤�ţ�ɾ���˿͵���Ϣ
	@Override
	public void delCustomerInfo(String cId) {
		//1����ʾ����״̬
		int i = cd.delCustomerInfo(cId);
		if(i > 0) {
			System.out.println("�˿���Ϣ��ɾ���ɹ�");
		}else {
			System.out.println("�˿���Ϣ��ɾ��ʧ��");
		}
	}

	//5���������ݿ�㣺ָ�����֤�ţ��޸Ĺ˿͵�����
	@Override
	public void upCustomerInfo() {
		//1���ӿ���̨���룺ִ�й˿͵����֤�źͱ��������
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�����룬����Ա���ģ��˿����֤��");
		String cId = sc.nextLine();
		
		System.out.println("�����룺���������");
		String cName = sc.next();
		
		//2����ʾ���
		int i = cd.upCustomerInfo(cId, cName);
		if(i > 0) {
			System.out.println("�˿�����������ɹ�");
		}else {
			System.out.println("�˿����������ʧ��");
		}
	}
	
	//6���������֤�ţ����Ƿ�����ס�����䣩
	public boolean isInRoom(String cId) {
		//1������Customer����
		Customer c = cd.selCustomerInfoByCustomer(cId);
		if(c != null) {
			return true;			//�����֤�����ʹ��
		}else {
			return false;			//�����֤����һ��ʹ��
		}
	}
	
	
}
