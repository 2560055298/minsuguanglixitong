package dao;

import java.util.ArrayList;
import java.util.Date;

import pojo.Room;

/**
 * 房间表：数据库层（接口）
 * @author 羊羊羊
 *
 */
public interface RoomDao {
	//1、查看所有房间的信息
	public ArrayList<Room> selAllRoomInfo();
	//2、指定房间号：查看某个房间的信息
	public Room selRoomInfoByRoom(int rNum) ;
	//3、添加房间的信息
	public int insRoomInfo(int rNum, String rType, int rPrice, String rState);
	//4、指定房间号：删除房间的信息
	public int delRoomInfo(int rNum);
	//5、指定房间号：修改房间的信息
	public int upRoomInfo(int rNum, String rType);
}
