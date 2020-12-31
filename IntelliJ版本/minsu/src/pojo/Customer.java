package pojo;

import java.util.Date;

/**
 * 顾客表
 * @author 羊羊羊
 *
 */
public class Customer {
	private String cId;			//身份证号
	private String cName;		//顾客姓名
	private String cSex;		//顾客性别
	private int cRoomNum;		//顾客入住房间号
	private Date cGetTime;		//顾客入住时间
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String cId, String cName, String cSex, int cRoomNum, Date cGetTime) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cSex = cSex;
		this.cRoomNum = cRoomNum;
		this.cGetTime = cGetTime;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcSex() {
		return cSex;
	}

	public void setcSex(String cSex) {
		this.cSex = cSex;
	}

	public int getcRoomNum() {
		return cRoomNum;
	}

	public void setcRoomNum(int cRoomNum) {
		this.cRoomNum = cRoomNum;
	}

	public Date getcGetTime() {
		return cGetTime;
	}

	public void setcGetTime(Date cGetTime) {
		this.cGetTime = cGetTime;
	}

	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", cName=" + cName + ", cSex=" + cSex + ", cRoomNum=" + cRoomNum + ", cGetTime="
				+ cGetTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cGetTime == null) ? 0 : cGetTime.hashCode());
		result = prime * result + ((cId == null) ? 0 : cId.hashCode());
		result = prime * result + ((cName == null) ? 0 : cName.hashCode());
		result = prime * result + cRoomNum;
		result = prime * result + ((cSex == null) ? 0 : cSex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (cGetTime == null) {
			if (other.cGetTime != null)
				return false;
		} else if (!cGetTime.equals(other.cGetTime))
			return false;
		if (cId == null) {
			if (other.cId != null)
				return false;
		} else if (!cId.equals(other.cId))
			return false;
		if (cName == null) {
			if (other.cName != null)
				return false;
		} else if (!cName.equals(other.cName))
			return false;
		if (cRoomNum != other.cRoomNum)
			return false;
		if (cSex == null) {
			if (other.cSex != null)
				return false;
		} else if (!cSex.equals(other.cSex))
			return false;
		return true;
	}
}



