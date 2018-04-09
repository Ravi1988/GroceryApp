package groceryapp.util;

public interface ProgressIndicator {

    void showError();

    void hideError();

    void showLoader();

    void hideLoader();

}