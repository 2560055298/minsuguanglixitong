package service;

import java.util.Date;

/**
 * ǰ̨��ҵ�����㣨�ӿڣ�
 * @author ������
 *
 */
public interface ForeGroundService {
	//1���������ݿ�㣺�鿴ǰ̨�洢�ģ�ȫ����Ϣ
	public void selAllForeGroundInfo();
	//2���������ݿ�㣺ָ�����֤�ţ��鿴ǰ̨�洢��Ϣ
	public void selForeGroundInfoByForeGround() ;
	//3���������ݿ�㣺���ǰ̨��Ϣ
	public void insForeGroundInfo(String fGIds, int fGRoomNum,String iDate, String oDate, int fGExpense);
	//4���������ݿ�㣺ָ�����֤�ţ�ɾ��ǰ̨��Ϣ
	public void delForeGroundInfo();
	//5���������ݿ�㣺ָ�����֤�ţ��޸�ǰ̨��¼�ģ������
	public void upForeGroundInfo();
}
