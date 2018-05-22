package com.groceryapp.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.groceryapp.BR;
import com.groceryapp.viewmodel.BaseViewModel;

import javax.inject.Inject;

public abstract class BaseMVVMFragment <T extends BaseViewModel> extends DialogFragment {

    @Inject
	T viewModel;

    public BaseMVVMFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(inflater,
                getFragmentLayout(), container, false);
        dataBinding.setVariable(BR.vm, getViewModel());
        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.onLoad();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.onDestroy();
        viewModel = null;
    }

    public T getViewModel() {
        return viewModel;
    }

    public abstract int getFragmentLayout();

}
