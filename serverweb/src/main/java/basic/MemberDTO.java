package basic;

import java.sql.Date;

//Data Transfer Object
// -> table record 한 개를 객체로 표현해 놓음
// -> business logic을 담고있지 않고 순수하게 값만 표현해 놓은 객체
// -> 계층 간 data 교환을 위해 생성
// -> 사용자가 입력한 data를 담아서 server로 전송
// -> server에서 발생한 datat를 view로 전송

public class MemberDTO {
	//field로 table의 col을 정의.
	private String id;
	private String pass;
	private String name;
	private String addr;
	private Date regdate;
	private int point;
	private String info;
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	
	//insert용
	public MemberDTO(String id, String pass, String name, String addr, String info) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.info = info;
	}
	
	//select용
	public MemberDTO(String id, String pass, String name, String addr, Date regdate, int point, String info) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.regdate = regdate;
		this.point = point;
		this.info = info;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
}
