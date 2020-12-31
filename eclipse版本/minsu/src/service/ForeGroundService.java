package service;

import java.util.Date;

/**
 * 前台表：业务代码层（接口）
 * @author 羊羊羊
 *
 */
public interface ForeGroundService {
	//1、操作数据库层：查看前台存储的：全部信息
	public void selAllForeGroundInfo();
	//2、操作数据库层：指定身份证号：查看前台存储信息
	public void selForeGroundInfoByForeGround() ;
	//3、操作数据库层：添加前台信息
	public void insForeGroundInfo(String fGIds, int fGRoomNum,String iDate, String oDate, int fGExpense);
	//4、操作数据库层：指定身份证号：删除前台信息
	public void delForeGroundInfo();
	//5、操作数据库层：指定身份证号：修改前台记录的：房间号
	public void upForeGroundInfo();
}
