package groceryapp.viewmodel;

import groceryapp.util.Navigator;

/**
 * Created by ravi.sharma01 on 4/9/18.
 */

public class MainActivityVM extends BaseViewModel{
	private Navigator navigator;

	public MainActivityVM(Navigator navigator){
		this.navigator = navigator;
	}

	@Override
	public void onLoad() {
		super.onLoad();
		navigator.openProductDetailListPage();
	}
}
