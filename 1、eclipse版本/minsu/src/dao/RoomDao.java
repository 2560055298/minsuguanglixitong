package dao;

import java.util.ArrayList;
import java.util.Date;

import pojo.Room;

/**
 * ��������ݿ�㣨�ӿڣ�
 * @author ������
 *
 */
public interface RoomDao {
	//1���鿴���з������Ϣ
	public ArrayList<Room> selAllRoomInfo();
	//2��ָ������ţ��鿴ĳ���������Ϣ
	public Room selRoomInfoByRoom(int rNum) ;
	//3����ӷ������Ϣ
	public int insRoomInfo(int rNum, String rType, int rPrice, String rState);
	//4��ָ������ţ�ɾ���������Ϣ
	public int delRoomInfo(int rNum);
	//5��ָ������ţ��޸ķ������Ϣ
	public int upRoomInfo(int rNum, String rType);
}
