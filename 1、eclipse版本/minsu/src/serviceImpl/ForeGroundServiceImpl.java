package serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import dao.ForeGroundDao;
import daoImpl.ForeGroundDaoImpl;
import pojo.ForeGround;
import service.ForeGroundService;

/**
 * ǰ̨��ҵ����루ʵ�ֲ㣩
 * @author ������
 *
 */
public class ForeGroundServiceImpl implements ForeGroundService{
	ForeGroundDao fg = new ForeGroundDaoImpl();
	
	//1���������ݿ�㣺�鿴ǰ̨�洢�ģ�ȫ����Ϣ
	@Override
	public void selAllForeGroundInfo() {
		//1���������ϱ���
		ArrayList<ForeGround> lists = null;
		//2���������ݿ���ȡ��ǰ̨��Ϣ����
		lists = fg.selAllForeGroundInfo();
		//3���������
		for (ForeGround e : lists) {
			System.out.println(e);
		}
	}

	//2���������ݿ�㣺ָ�����֤�ţ��鿴ǰ̨�洢��Ϣ
	@Override
	public void selForeGroundInfoByForeGround() {
		//1���ӿ���̨����ָ���ģ��˿����֤��
				System.out.println("�����룺�˿����֤��");
				Scanner sc = new Scanner(System.in);
				String fGId = sc.nextLine();
				
				//2������ForeGround����
				ForeGround e = fg.selForeGroundInfoByForeGround(fGId);
				
				if(e != null) {
					System.out.println(e);
				}else {
					System.out.println("����,�ù˿���Ϣ���ˣ�����");
				}
	}

	//3���������ݿ�㣺���ǰ̨��Ϣ
	@Override
	public void insForeGroundInfo(String fGIds, int fGRoomNum,String iDate, String oDate, int fGExpense) {
		
		Date fGGetTime = null;
		Date fGLeaveTime = null;

		try {
			fGGetTime = new SimpleDateFormat("yyyy-MM-dd").parse(iDate);
			fGLeaveTime = new SimpleDateFormat("yyyy-MM-dd").parse(oDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		//2����ʾ������״̬
		int i = fg.insForeGroundInfo(fGIds, fGRoomNum, fGGetTime, fGLeaveTime, fGExpense);
		if(i > 0) {
			System.out.println("ǰ̨��Ϣ����ӳɹ�");
		}else {
			System.out.println("ǰ̨��Ϣ�����ʧ��");
		}
		
	}

	//4���������ݿ�㣺ָ�����֤�ţ�ɾ��ǰ̨��Ϣ
	@Override
	public void delForeGroundInfo() {
		//1���ӿ���̨���룺ָ��Ա�����
		Scanner sc = new Scanner(System.in);
		System.out.println("�����룬��ɾ���˿���Ϣ�ģ����֤");
		String fGId = sc.nextLine();
		
		//2����ʾ����״̬
		int i = fg.delForeGroundInfo(fGId);
		if(i > 0) {
			System.out.println("ǰ̨��Ϣ��ɾ���ɹ�");
		}else {
			System.out.println("ǰ̨��Ϣ��ɾ��ʧ��");
		}
	}

	//5���������ݿ�㣺ָ�����֤�ţ��޸�ǰ̨��¼�ģ������
	@Override
	public void upForeGroundInfo() {
		//1���ӿ���̨���룺ִ��Ա����źͱ��������
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�����룬�����˿͵ģ����֤��");
		String fGId = sc.nextLine();
		
		System.out.println("�����룺����ķ����");
		int fGRoomNum = sc.nextInt();
		
		//2����ʾ���
		int i = fg.upForeGroundInfo(fGId, fGRoomNum);
		if(i > 0) {
			System.out.println("Ա������������ɹ�");
		}else {
			System.out.println("Ա�����������ʧ��");
		}
	}
	
}
