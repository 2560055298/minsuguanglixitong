package dao;

import java.util.ArrayList;
import java.util.Date;

import pojo.ForeGround;

/**
 * 前台表：数据库层（接口）
 * @author 羊羊羊
 *
 */
public interface ForeGroundDao {
	//1、查看前台存储的：全部信息
	public ArrayList<ForeGround> selAllForeGroundInfo();
	//2、指定身份证号：查看前台存储信息
	public ForeGround selForeGroundInfoByForeGround(String fGId) ;
	//3、添加前台信息
	public int insForeGroundInfo(String fGId, int fGRoomNum, Date fGGetTime, Date fGLeaveTime, int fGExpense);
	//4、指定身份证号：删除前台信息
	public int delForeGroundInfo(String fGId);
	//5、指定身份证号：修改前台记录的：房间号
	public int upForeGroundInfo(String fGId, int fGRoomNum);
}
