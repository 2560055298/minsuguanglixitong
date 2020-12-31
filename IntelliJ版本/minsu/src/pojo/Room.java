package pojo;

/**
 * 房间表
 * @author 羊羊羊
 *
 */
public class Room {
	private int rNum;		//房间号
	private String rType;	//房间类型
	private int rPrice;		//房间价格
	private String rState;	//房间状态
	
	public Room() {
		super();
	}
	
	public Room(int rNum, String rType, int rPrice, String rState) {
		super();
		this.rNum = rNum;
		this.rType = rType;
		this.rPrice = rPrice;
		this.rState = rState;
	}
	
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public String getrType() {
		return rType;
	}
	public void setrType(String rType) {
		this.rType = rType;
	}
	public int getrPrice() {
		return rPrice;
	}
	public void setrPrice(int rPrice) {
		this.rPrice = rPrice;
	}
	public String getrState() {
		return rState;
	}
	public void setrState(String rState) {
		this.rState = rState;
	}

	@Override
	public String toString() {
		return "Room [rNum=" + rNum + ", rType=" + rType + ", rPrice=" + rPrice + ", rState=" + rState + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rNum;
		result = prime * result + rPrice;
		result = prime * result + ((rState == null) ? 0 : rState.hashCode());
		result = prime * result + ((rType == null) ? 0 : rType.hashCode());
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
		Room other = (Room) obj;
		if (rNum != other.rNum)
			return false;
		if (rPrice != other.rPrice)
			return false;
		if (rState == null) {
			if (other.rState != null)
				return false;
		} else if (!rState.equals(other.rState))
			return false;
		if (rType == null) {
			if (other.rType != null)
				return false;
		} else if (!rType.equals(other.rType))
			return false;
		return true;
	}
	
	
	
}
