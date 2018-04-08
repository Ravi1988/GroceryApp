package groceryapp.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Img {

		@JsonProperty("h")
		private Integer h;
		@JsonProperty("w")
		private Integer w;
		@JsonProperty("name")
		private String name;
		@JsonProperty("position")
		private Integer position;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		@JsonProperty("h")
		public Integer getH() {
			return h;
		}

		@JsonProperty("h")
		public void setH(Integer h) {
			this.h = h;
		}

		@JsonProperty("w")
		public Integer getW() {
			return w;
		}

		@JsonProperty("w")
		public void setW(Integer w) {
			this.w = w;
		}

		@JsonProperty("name")
		public String getName() {
			return name;
		}

		@JsonProperty("name")
		public void setName(String name) {
			this.name = name;
		}

		@JsonProperty("position")
		public Integer getPosition() {
			return position;
		}

		@JsonProperty("position")
		public void setPosition(Integer position) {
			this.position = position;
		}

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
			this.additionalProperties.put(name, value);
		}

	}
