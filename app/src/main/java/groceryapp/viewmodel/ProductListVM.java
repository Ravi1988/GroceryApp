package groceryapp.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;

import javax.inject.Inject;

import groceryapp.model.Product;
import groceryapp.model.ProductData;
import groceryapp.repo.ProductsRepo;

/**
 * Created by ravi.sharma01 on 1/29/18.
 */

public class ProductListVM extends BaseViewModel{

	private final ProductsRepo productListRepo;
	private ObservableField<ProductData> productData;
	private ObservableField<Product> product;
	private ObservableList<Product> productList;

	@Inject
	public ProductListVM(ProductsRepo productListRepo) {
		productData = new ObservableField<>();
		product = new ObservableField<>();
		productList = new ObservableArrayList<>();
		this.productListRepo = productListRepo;
	}


	public void load(){
		showLoader();
		productListRepo.getProductList(0,20).subscribe(data -> {
			productData.set(data);
			productList.clear();
			productList.addAll(data.getProducts());
			hideLoader();},
			error -> {hideLoader();showError();
			},this::hideLoader);
	}

	public ObservableField<ProductData> getProductData() {
		return productData;
	}

	public ObservableField<Product> getProduct() {
		return product;
	}

	public void setProduct(Product value){
		product.set(value);
	}
	public ObservableList<Product> getProductList() {
		return productList;
	}
}
