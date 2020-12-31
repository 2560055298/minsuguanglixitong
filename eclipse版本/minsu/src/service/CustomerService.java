package service;

import pojo.Customer;

/**
 * 顾客表：业务代码层（接口）
 * @author 羊羊羊
 *
 */
public interface CustomerService {
	//1、操作数据库层：查看所有顾客的信息
	public void selAllCustomerInfo();
	//2、操作数据库层：指定房间号：查看某个顾客的信息
	public Customer selCustomerInfoByCustomer(int num) ;
	//3、操作数据库层：添加顾客的信息
	public void insCustomerInfo();
	//4、操作数据库层：指定身份证号：删除顾客的信息
	public void delCustomerInfo(String id);
	//5、操作数据库层：指定身份证号：修改顾客的姓名
	public void upCustomerInfo();
	//6、根据身份证号：看是否已入住（房间）
	public boolean isInRoom(String cId);
}
