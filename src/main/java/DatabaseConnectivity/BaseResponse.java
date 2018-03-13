package DatabaseConnectivity;

public class BaseResponse {
	private String status = "SUCCESS";
	private int code = 200;
	private String message;
	private StringBuffer str;
	
	public StringBuffer getStr() {
		return str;
	}
	public void setStr(StringBuffer str) {
		this.str = str;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
