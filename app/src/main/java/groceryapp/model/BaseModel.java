package groceryapp.model;

/**
 * Created by ravi.sharma01 on 4/7/18.
 */

public class BaseModel {

	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public class Status{
		private String msg;
		private int code;

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}
	}
}
