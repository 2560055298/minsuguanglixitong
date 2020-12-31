package service;

/**
 * 房间表：业务代码层（接口）
 * @author 羊羊羊
 *
 */
public interface RoomService {
	//1、操作数据库层：查看所有房间的信息
	public void selAllRoomInfo();
	//2、操作数据库层：指定房间号：查看某个房间的信息
	public void selRoomInfoByRoom() ;
	//3、操作数据库层：添加房间的信息
	public void insRoomInfo();
	//4、操作数据库层：指定房间号：删除房间的信息
	public void delRoomInfo();
	//5、操作数据库层：指定房间号：修改房间的状态
	public void upRoomInfo(int rNum, String str);
	//6、操作数据库层：查询房间号：入住状态
	public boolean selRoomState(int rNum) ;
	//7、操作数据库层：指定房间号的：房间价格
	public int selRoomPrice(int rNum);
	//8、操作数据库层：查询房间类型
	public String selRoomType(int rNum);
}
