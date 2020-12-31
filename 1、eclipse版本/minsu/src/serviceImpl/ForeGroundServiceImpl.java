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
 * 前台表：业务代码（实现层）
 * @author 羊羊羊
 *
 */
public class ForeGroundServiceImpl implements ForeGroundService{
	ForeGroundDao fg = new ForeGroundDaoImpl();
	
	//1、操作数据库层：查看前台存储的：全部信息
	@Override
	public void selAllForeGroundInfo() {
		//1、声明集合变量
		ArrayList<ForeGround> lists = null;
		//2、调用数据库层获取：前台信息集合
		lists = fg.selAllForeGroundInfo();
		//3、遍历输出
		for (ForeGround e : lists) {
			System.out.println(e);
		}
	}

	//2、操作数据库层：指定身份证号：查看前台存储信息
	@Override
	public void selForeGroundInfoByForeGround() {
		//1、从控制台输入指定的：顾客身份证号
				System.out.println("请输入：顾客身份证号");
				Scanner sc = new Scanner(System.in);
				String fGId = sc.nextLine();
				
				//2、声明ForeGround对象
				ForeGround e = fg.selForeGroundInfoByForeGround(fGId);
				
				if(e != null) {
					System.out.println(e);
				}else {
					System.out.println("查无,该顾客信息此人！！！");
				}
	}

	//3、操作数据库层：添加前台信息
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
		
		//2、显示操作：状态
		int i = fg.insForeGroundInfo(fGIds, fGRoomNum, fGGetTime, fGLeaveTime, fGExpense);
		if(i > 0) {
			System.out.println("前台信息：添加成功");
		}else {
			System.out.println("前台信息：添加失败");
		}
		
	}

	//4、操作数据库层：指定身份证号：删除前台信息
	@Override
	public void delForeGroundInfo() {
		//1、从控制台输入：指定员工编号
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入，需删除顾客信息的：身份证");
		String fGId = sc.nextLine();
		
		//2、显示操作状态
		int i = fg.delForeGroundInfo(fGId);
		if(i > 0) {
			System.out.println("前台信息：删除成功");
		}else {
			System.out.println("前台信息：删除失败");
		}
	}

	//5、操作数据库层：指定身份证号：修改前台记录的：房间号
	@Override
	public void upForeGroundInfo() {
		//1、从控制台输入：执行员工编号和变更的姓名
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入，需变更顾客的：身份证号");
		String fGId = sc.nextLine();
		
		System.out.println("请输入：变更的房间号");
		int fGRoomNum = sc.nextInt();
		
		//2、显示结果
		int i = fg.upForeGroundInfo(fGId, fGRoomNum);
		if(i > 0) {
			System.out.println("员工姓名：变更成功");
		}else {
			System.out.println("员工姓名：变更失败");
		}
	}
	
}
