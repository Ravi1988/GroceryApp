package groceryapp.viewmodel;

import android.databinding.Bindable;

import javax.inject.Inject;

import groceryapp.BR;
import groceryapp.model.Product;
import groceryapp.repo.ProductsRepo;
import groceryapp.util.Navigator;

/**
 * Created by ravi.sharma01 on 2/24/18.
 */

public class ProductVM extends BaseViewModel {

	private final Navigator navigator;
	private final ProductsRepo productsRepo;
	private int pos;
	private Product product;
	private long id;

	@Inject
	public ProductVM(Navigator navigator, ProductsRepo productsRepo) {
		this.navigator = navigator;
		this.productsRepo = productsRepo;
	}
	
	@Override
	public void onLoad() {
		super.onLoad();
		showLoader();
		productsRepo.getProductById(getId()).subscribe(this::setProduct,
		error-> {showError();hideLoader();},
		this::hideLoader);
	}

	@Bindable
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
		notifyPropertyChanged(BR.product);
	}

	public void openNewsDetail() {
		if (product != null) {
			navigator.openProductDetailPage(getPos());
		}
	}

	@Bindable
	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
		notifyPropertyChanged(BR.pos);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
