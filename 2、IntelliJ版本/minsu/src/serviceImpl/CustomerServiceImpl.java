package serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import dao.CustomerDao;
import daoImpl.CustomerDaoImpl;
import pojo.Customer;
import service.CustomerService;

/**
 * 顾客表：业务代码（实现层）
 * @author 羊羊羊
 *
 */
public class CustomerServiceImpl implements CustomerService {
	CustomerDao cd = new CustomerDaoImpl();
	
	//1、操作数据库层：查看所有顾客的信息
	@Override
	public void selAllCustomerInfo() {
		//1、声明集合变量
		ArrayList<Customer> lists = null;
		//2、调用数据库层获取：顾客信息集合
		lists = cd.selAllCustomerInfo();
		//3、遍历输出
		for (Customer c : lists) {
			System.out.println(c);
		}
	}

	//2、操作数据库层：指定房间号：查看某个顾客的信息
	@Override
	public Customer selCustomerInfoByCustomer(int num) {
			//1、声明Customer对象
			Customer c = cd.selCustomerInfoByCustomer(num);
			return c;
	}

	//3、操作数据库层：添加顾客的信息
	@Override
	public void insCustomerInfo() {
		//1、从控制台输入顾客的信息
				System.out.println("请输入添加顾客的：相关信息");
				Scanner sc = new Scanner(System.in);
			
				System.out.println("请输入：顾客的身份证号");
				String cId = sc.nextLine();
				
				System.out.println("请输入：顾客的姓名");
				String cName = sc.next();
				
				System.out.println("请输入：顾客的性别");
				String cSex = sc.next();
				
				System.out.println("请输入：顾客的房间号");
				int cRoomNum = sc.nextInt();
				
				System.out.println("请输入：入住日期 (格式：yyyy-MM-dd)");
				String date = sc.next();
				Date cGetTime = null;
				try {
					cGetTime = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				//2、显示操作：状态
				int i = cd.insCustomerInfo(cId, cName, cSex, cRoomNum, cGetTime);
				if(i > 0) {
					System.out.println("顾客信息：添加成功");
				}else {
					System.out.println("顾客信息：添加失败");
				}
				
	}

	//4、操作数据库层：指定身份证号：删除顾客的信息
	@Override
	public void delCustomerInfo(String cId) {
		//1、显示操作状态
		int i = cd.delCustomerInfo(cId);
		if(i > 0) {
			System.out.println("顾客信息：删除成功");
		}else {
			System.out.println("顾客信息：删除失败");
		}
	}

	//5、操作数据库层：指定身份证号：修改顾客的姓名
	@Override
	public void upCustomerInfo() {
		//1、从控制台输入：执行顾客的身份证号和变更的姓名
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入，需变更员工的：顾客身份证号");
		String cId = sc.nextLine();
		
		System.out.println("请输入：变更的姓名");
		String cName = sc.next();
		
		//2、显示结果
		int i = cd.upCustomerInfo(cId, cName);
		if(i > 0) {
			System.out.println("顾客姓名：变更成功");
		}else {
			System.out.println("顾客姓名：变更失败");
		}
	}
	
	//6、根据身份证号：看是否已入住（房间）
	public boolean isInRoom(String cId) {
		//1、声明Customer对象
		Customer c = cd.selCustomerInfoByCustomer(cId);
		if(c != null) {
			return true;			//该身份证：多次使用
		}else {
			return false;			//该身份证：第一次使用
		}
	}
	
	
}
