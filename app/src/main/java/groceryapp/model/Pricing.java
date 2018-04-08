package groceryapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pricing {

		@JsonProperty("on_sale")
		private Integer onSale;
		@JsonProperty("price")
		private Double price;
		@JsonProperty("promo_price")
		private Double promoPrice;
		@JsonProperty("savings_type")
		private Integer savingsType;

		@JsonProperty("on_sale")
		public Integer getOnSale() {
			return onSale;
		}

		@JsonProperty("on_sale")
		public void setOnSale(Integer onSale) {
			this.onSale = onSale;
		}

		@JsonProperty("price")
		public Double getPrice() {
			return price;
		}

		@JsonProperty("price")
		public void setPrice(Double price) {
			this.price = price;
		}

		@JsonProperty("promo_price")
		public Double getPromoPrice() {
			return promoPrice;
		}

		@JsonProperty("promo_price")
		public void setPromoPrice(Double promoPrice) {
			this.promoPrice = promoPrice;
		}

		@JsonProperty("savings_type")
		public Integer getSavingsType() {
			return savingsType;
		}

		@JsonProperty("savings_type")
		public void setSavingsType(Integer savingsType) {
			this.savingsType = savingsType;
		}


	}