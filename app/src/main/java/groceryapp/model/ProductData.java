package groceryapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class ProductData extends BaseModel{
	@JsonProperty("total")
	private int total;
	private int page;
	@JsonProperty("page_size")
	private int pageSize;

	public int getTotalResults() {
		return this.total;
	}

	public void setTotalResults(int total) {
		this.total = total;
	}

	private ArrayList<Product> products;

	public ArrayList<Product> getProducts() {
		return this.products;
	}

	public void setProducts(ArrayList<Product> articles) {
		this.products = articles;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}





}