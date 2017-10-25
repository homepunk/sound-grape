package com.github.homepunk.soundgrape.presentation.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Homepunk on 11.10.2017.
 **/

public abstract class BaseActivity<B extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {
    protected B binding;
    protected VM viewModel;

    protected abstract VM getViewModel();
    protected abstract int getVariable();
    protected abstract @LayoutRes int getLayoutResId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind();
    }

    @UiThread
    private void bind() {
        viewModel = viewModel == null ? getViewModel() : viewModel;
        binding = DataBindingUtil.setContentView(this, getLayoutResId());
        binding.setVariable(getVariable(), viewModel);
        binding.executePendingBindings();
    }
}
