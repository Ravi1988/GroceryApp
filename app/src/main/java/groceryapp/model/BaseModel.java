package groceryapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ravi.sharma01 on 4/7/18.
 */
@JsonIgnoreProperties
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
