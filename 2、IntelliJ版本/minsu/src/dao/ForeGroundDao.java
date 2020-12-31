package dao;

import java.util.ArrayList;
import java.util.Date;

import pojo.ForeGround;

/**
 * ǰ̨�����ݿ�㣨�ӿڣ�
 * @author ������
 *
 */
public interface ForeGroundDao {
	//1���鿴ǰ̨�洢�ģ�ȫ����Ϣ
	public ArrayList<ForeGround> selAllForeGroundInfo();
	//2��ָ�����֤�ţ��鿴ǰ̨�洢��Ϣ
	public ForeGround selForeGroundInfoByForeGround(String fGId) ;
	//3�����ǰ̨��Ϣ
	public int insForeGroundInfo(String fGId, int fGRoomNum, Date fGGetTime, Date fGLeaveTime, int fGExpense);
	//4��ָ�����֤�ţ�ɾ��ǰ̨��Ϣ
	public int delForeGroundInfo(String fGId);
	//5��ָ�����֤�ţ��޸�ǰ̨��¼�ģ������
	public int upForeGroundInfo(String fGId, int fGRoomNum);
}
