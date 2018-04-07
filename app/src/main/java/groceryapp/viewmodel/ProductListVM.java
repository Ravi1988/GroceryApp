package groceryapp.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;

import javax.inject.Inject;

import groceryapp.model.ProductData;
import groceryapp.model.ProductData.Product;
import groceryapp.repo.ProductListRepo;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ravi.sharma01 on 1/29/18.
 */

public class ProductListVM {

	private final ProductListRepo productListRepo;
	private ObservableField<Boolean> showProgressBar;
	private ObservableField<Boolean> showError;

	private ObservableField<ProductData> productData;
	private ObservableField<Product> product;
	private ObservableList<Product> productList;

	@Inject
	public ProductListVM(ProductListRepo productListRepo) {
		showProgressBar = new ObservableField<>(false);
		showError = new ObservableField<>(false);
		productData = new ObservableField<>();
		product = new ObservableField<>();
		productList = new ObservableArrayList<>();

		this.productListRepo = productListRepo;
	}


	public void load(){
		showProgress();
		productListRepo.getTopStories().subscribe(new Observer<ProductData>() {
			@Override
			public void onSubscribe(Disposable d) {

			}

			@Override
			public void onNext(ProductData data) {
				productData.set(data);
				productList.clear();
				productList.addAll(data.getProducts());
				showError.set(false);
				hideProgress();
			}

			@Override
			public void onError(Throwable e) {
				hideProgress();
				showError.set(true);
			}

			@Override
			public void onComplete() {
				hideProgress();
			}
		});
	}

	private void hideProgress() {
		showProgressBar.set(false);
	}

	private void showProgress() {
		showProgressBar.set(true);
	}

	public ObservableField<Boolean> getShowProgressBar() {
		return showProgressBar;
	}

	public ObservableField<Boolean> getIsShowError() {
		return showError;
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
