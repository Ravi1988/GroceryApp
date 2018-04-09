package groceryapp.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import groceryapp.util.ProgressIndicator;

public class BaseViewModel extends BaseObservable implements ProgressIndicator {

    private final ObservableField<Boolean> isLoading;
	private final ObservableField<Boolean> showError;
    private ProgressIndicator indicator;

    public BaseViewModel() {
        isLoading = new ObservableField<>(false);
        showError = new ObservableField<>(false);
        this.indicator = null;
    }
    public BaseViewModel(ProgressIndicator indicator) {
        this();
        this.indicator = indicator;
    }


    public ObservableField<Boolean> getIsLoading() {
        return isLoading;
    }

    public ObservableField<Boolean> getShowError() {
        return showError;
    }

    public void showError() {
        if (indicator == null) {
            showError.set(true);
        } else {
            indicator.showError();
        }
    }

    public void hideError() {
        if (indicator == null) {
            showError.set(false);
        } else {
            indicator.hideError();
        }
    }

    public void showLoader() {
        if (indicator == null) {
            isLoading.set(true);
        } else {
            indicator.showLoader();
        }
    }

    public void hideLoader() {
        if (indicator == null) {
            isLoading.set(false);
        } else {
            indicator.hideLoader();
        }
    }

    public void onLoad() {}

    public void onDestroy() {}
}