package serviceImpl;

import java.util.ArrayList;
import java.util.Scanner;

import dao.RoomDao;
import daoImpl.RoomDaoImpl;
import pojo.Room;
import service.RoomService;

/**
 * 房间表：业务代码（实现层）
 * @author 羊羊羊
 *
 */

public class RoomServiceImpl implements RoomService{

	RoomDao rd = new RoomDaoImpl();
	
	//1、操作数据库层：查看所有房间的信息
	@Override
	public void selAllRoomInfo() {
		//1、声明集合变量
		ArrayList<Room> lists = null;
		//2、调用数据库层获取：房间表集合
		lists = rd.selAllRoomInfo();
		//3、遍历输出
		for (Room e : lists) {
			System.out.println(e);
		}
	}

	//2、操作数据库层：指定房间号：查看某个房间的信息
	@Override
	public void selRoomInfoByRoom() {
		//1、从控制台输入指定的：房间号
		System.out.println("请输入：房间号");
		Scanner sc = new Scanner(System.in);
		int rNum = sc.nextInt();
		
		//2、声明Room对象
		Room e = rd.selRoomInfoByRoom(rNum);
		
		if(e != null) {
			System.out.println(e);
		}else {
			System.out.println("查无，此房间！！！");
		}
	}

	//3、操作数据库层：添加房间的信息
	@Override
	public void insRoomInfo() {
		//1、从控制台输入员工信息
		System.out.println("请输入添加房间的：相关信息");
		Scanner sc = new Scanner(System.in);
	
		System.out.println("请输入：房间号");
		int rNum = sc.nextInt();
		
		System.out.println("请输入：房间类型");
		String rType = sc.next();
		
		System.out.println("请输入：房间价格");
		int rPrice = sc.nextInt();
		
		System.out.println("请输入：房间状态");
		String rState = sc.next();
		
		//2、显示操作：状态
		int i = rd.insRoomInfo(rNum, rType, rPrice, rState);
		if(i > 0) {
			System.out.println("房间信息：添加成功");
		}else {
			System.out.println("房间信息：添加失败");
		}
	}

	//4、操作数据库层：指定房间号：删除房间的信息
	@Override
	public void delRoomInfo() {
		//1、从控制台输入：指定房间号
				Scanner sc = new Scanner(System.in);
				System.out.println("请输入，需删除房间的：房间号");
				int rNum = sc.nextInt();
				
				//2、显示操作状态
				int i = rd.delRoomInfo(rNum);
				if(i > 0) {
					System.out.println("房间信息：删除成功");
				}else {
					System.out.println("房间信息：删除失败");
				}
	}

	//5、操作数据库层：指定房间号：修改房间的状态
	@Override
	public void upRoomInfo(int rNum, String str) {
		//1、从控制台输入：房间号和变更为的：房间信息
		int i = rd.upRoomInfo(rNum, str);
		if(i > 0) {
			System.out.println("房间状态：变更成功");
		}else {
			System.out.println("房间状态：变更失败");
		}
	}
	
	//6、操作数据库层：查询房间号：入住状态
	@Override
	public boolean selRoomState(int rNum) {
		//1、声明Room对象
		Room e = rd.selRoomInfoByRoom(rNum);
		
		if(e.getrState().equals("已入住")) {
			return true;			//已入住
		}else {
			return false;			//未入住
		}
	}
	
	//7、操作数据库层：指定房间号的：房间价格
	@Override
	public int selRoomPrice(int rNum) {
		Room r = rd.selRoomInfoByRoom(rNum);
		return r.getrPrice();
	}
	
	//8、操作数据库层：查询房间类型
	public String selRoomType(int rNum) {
		Room r = rd.selRoomInfoByRoom(rNum);
		return r.getrType();
	}
}
