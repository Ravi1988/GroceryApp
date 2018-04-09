package groceryapp.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import javax.inject.Inject;

import groceryapp.BR;
import groceryapp.model.Product;
import groceryapp.util.Navigator;

/**
 * Created by ravi.sharma01 on 2/24/18.
 */

public class ProductVM extends BaseObservable {

	private final Navigator navigator;
	private int pos;
	private Product product;

	@Inject
	public ProductVM(Navigator navigator) {
		this.navigator = navigator;
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
}
