package service;

/**
 * �����ҵ�����㣨�ӿڣ�
 * @author ������
 *
 */
public interface RoomService {
	//1���������ݿ�㣺�鿴���з������Ϣ
	public void selAllRoomInfo();
	//2���������ݿ�㣺ָ������ţ��鿴ĳ���������Ϣ
	public void selRoomInfoByRoom() ;
	//3���������ݿ�㣺��ӷ������Ϣ
	public void insRoomInfo();
	//4���������ݿ�㣺ָ������ţ�ɾ���������Ϣ
	public void delRoomInfo();
	//5���������ݿ�㣺ָ������ţ��޸ķ����״̬
	public void upRoomInfo(int rNum, String str);
	//6���������ݿ�㣺��ѯ����ţ���ס״̬
	public boolean selRoomState(int rNum) ;
	//7���������ݿ�㣺ָ������ŵģ�����۸�
	public int selRoomPrice(int rNum);
	//8���������ݿ�㣺��ѯ��������
	public String selRoomType(int rNum);
}
