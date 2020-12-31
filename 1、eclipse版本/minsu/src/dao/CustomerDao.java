package dao;

import java.util.ArrayList;
import java.util.Date;

import pojo.Customer;

/**
 * 顾客表：数据库层（接口）
 * @author 羊羊羊
 *
 */
public interface CustomerDao {
	//1、查看所有顾客的信息
	public ArrayList<Customer> selAllCustomerInfo();
	//2、指定身份证号：查看某个顾客的信息
	public Customer selCustomerInfoByCustomer(String cId) ;
	//3、添加顾客的信息
	public int insCustomerInfo(String cId, String cName, String cSex, int cRoomNum, Date cGetTime);
	//4、指定身份证号：删除顾客的信息
	public int delCustomerInfo(String cId);
	//5、指定身份证号：修改顾客的姓名
	public int upCustomerInfo(String cId, String cName);
	//6、指定房间号：查看某个顾客的信息
	public Customer selCustomerInfoByCustomer(int cNum) ;
}
