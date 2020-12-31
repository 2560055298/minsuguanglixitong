package serviceImpl;

import java.util.ArrayList;
import java.util.Scanner;

import dao.RoomDao;
import daoImpl.RoomDaoImpl;
import pojo.Room;
import service.RoomService;

/**
 * �����ҵ����루ʵ�ֲ㣩
 * @author ������
 *
 */

public class RoomServiceImpl implements RoomService{

	RoomDao rd = new RoomDaoImpl();
	
	//1���������ݿ�㣺�鿴���з������Ϣ
	@Override
	public void selAllRoomInfo() {
		//1���������ϱ���
		ArrayList<Room> lists = null;
		//2���������ݿ���ȡ���������
		lists = rd.selAllRoomInfo();
		//3���������
		for (Room e : lists) {
			System.out.println(e);
		}
	}

	//2���������ݿ�㣺ָ������ţ��鿴ĳ���������Ϣ
	@Override
	public void selRoomInfoByRoom() {
		//1���ӿ���̨����ָ���ģ������
		System.out.println("�����룺�����");
		Scanner sc = new Scanner(System.in);
		int rNum = sc.nextInt();
		
		//2������Room����
		Room e = rd.selRoomInfoByRoom(rNum);
		
		if(e != null) {
			System.out.println(e);
		}else {
			System.out.println("���ޣ��˷��䣡����");
		}
	}

	//3���������ݿ�㣺��ӷ������Ϣ
	@Override
	public void insRoomInfo() {
		//1���ӿ���̨����Ա����Ϣ
		System.out.println("��������ӷ���ģ������Ϣ");
		Scanner sc = new Scanner(System.in);
	
		System.out.println("�����룺�����");
		int rNum = sc.nextInt();
		
		System.out.println("�����룺��������");
		String rType = sc.next();
		
		System.out.println("�����룺����۸�");
		int rPrice = sc.nextInt();
		
		System.out.println("�����룺����״̬");
		String rState = sc.next();
		
		//2����ʾ������״̬
		int i = rd.insRoomInfo(rNum, rType, rPrice, rState);
		if(i > 0) {
			System.out.println("������Ϣ����ӳɹ�");
		}else {
			System.out.println("������Ϣ�����ʧ��");
		}
	}

	//4���������ݿ�㣺ָ������ţ�ɾ���������Ϣ
	@Override
	public void delRoomInfo() {
		//1���ӿ���̨���룺ָ�������
				Scanner sc = new Scanner(System.in);
				System.out.println("�����룬��ɾ������ģ������");
				int rNum = sc.nextInt();
				
				//2����ʾ����״̬
				int i = rd.delRoomInfo(rNum);
				if(i > 0) {
					System.out.println("������Ϣ��ɾ���ɹ�");
				}else {
					System.out.println("������Ϣ��ɾ��ʧ��");
				}
	}

	//5���������ݿ�㣺ָ������ţ��޸ķ����״̬
	@Override
	public void upRoomInfo(int rNum, String str) {
		//1���ӿ���̨���룺����źͱ��Ϊ�ģ�������Ϣ
		int i = rd.upRoomInfo(rNum, str);
		if(i > 0) {
			System.out.println("����״̬������ɹ�");
		}else {
			System.out.println("����״̬�����ʧ��");
		}
	}
	
	//6���������ݿ�㣺��ѯ����ţ���ס״̬
	@Override
	public boolean selRoomState(int rNum) {
		//1������Room����
		Room e = rd.selRoomInfoByRoom(rNum);
		
		if(e.getrState().equals("����ס")) {
			return true;			//����ס
		}else {
			return false;			//δ��ס
		}
	}
	
	//7���������ݿ�㣺ָ������ŵģ�����۸�
	@Override
	public int selRoomPrice(int rNum) {
		Room r = rd.selRoomInfoByRoom(rNum);
		return r.getrPrice();
	}
	
	//8���������ݿ�㣺��ѯ��������
	public String selRoomType(int rNum) {
		Room r = rd.selRoomInfoByRoom(rNum);
		return r.getrType();
	}
}
