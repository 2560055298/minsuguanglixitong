package pojo;

import java.util.Date;

/**
 * 前台表
 * @author 羊羊羊
 *
 */
public class ForeGround {
	private String fGId;		//结账人：身份证号
	private int fGRoomNum;		//结账：房间号
	private Date fGGetTime;		//入住时间
	private Date fGLeaveTime;	//退房时间
	private int fGExpense;		//本次消费金额
	
	public ForeGround() {
		super();
	}

	public ForeGround(String fGId, int fGRoomNum, Date fGGetTime, Date fGLeaveTime, int fGExpense) {
		super();
		this.fGId = fGId;
		this.fGRoomNum = fGRoomNum;
		this.fGGetTime = fGGetTime;
		this.fGLeaveTime = fGLeaveTime;
		this.fGExpense = fGExpense;
	}

	public String getfGId() {
		return fGId;
	}

	public void setfGId(String fGId) {
		this.fGId = fGId;
	}

	public int getfGRoomNum() {
		return fGRoomNum;
	}

	public void setfGRoomNum(int fGRoomNum) {
		this.fGRoomNum = fGRoomNum;
	}

	public Date getfGGetTime() {
		return fGGetTime;
	}

	public void setfGGetTime(Date fGGetTime) {
		this.fGGetTime = fGGetTime;
	}

	public Date getfGLeaveTime() {
		return fGLeaveTime;
	}

	public void setfGLeaveTime(Date fGLeaveTime) {
		this.fGLeaveTime = fGLeaveTime;
	}

	public int getfGExpense() {
		return fGExpense;
	}

	public void setfGExpense(int fGExpense) {
		this.fGExpense = fGExpense;
	}

	@Override
	public String toString() {
		return "ForeGround [fGId=" + fGId + ", fGRoomNum=" + fGRoomNum + ", fGGetTime=" + fGGetTime + ", fGLeaveTime="
				+ fGLeaveTime + ", fGExpense=" + fGExpense + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fGExpense;
		result = prime * result + ((fGGetTime == null) ? 0 : fGGetTime.hashCode());
		result = prime * result + ((fGId == null) ? 0 : fGId.hashCode());
		result = prime * result + ((fGLeaveTime == null) ? 0 : fGLeaveTime.hashCode());
		result = prime * result + fGRoomNum;
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
		ForeGround other = (ForeGround) obj;
		if (fGExpense != other.fGExpense)
			return false;
		if (fGGetTime == null) {
			if (other.fGGetTime != null)
				return false;
		} else if (!fGGetTime.equals(other.fGGetTime))
			return false;
		if (fGId == null) {
			if (other.fGId != null)
				return false;
		} else if (!fGId.equals(other.fGId))
			return false;
		if (fGLeaveTime == null) {
			if (other.fGLeaveTime != null)
				return false;
		} else if (!fGLeaveTime.equals(other.fGLeaveTime))
			return false;
		if (fGRoomNum != other.fGRoomNum)
			return false;
		return true;
	}

	
}
