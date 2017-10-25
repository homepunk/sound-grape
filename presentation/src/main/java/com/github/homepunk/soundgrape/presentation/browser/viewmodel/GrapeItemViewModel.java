package com.github.homepunk.soundgrape.presentation.browser.viewmodel;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.github.homepunk.soundgrape.presentation.base.BaseViewModel;
import com.github.homepunk.soundgrape.presentation.browser.model.GrapeModel;

/**
 * Created by Homepunk on 12.10.2017.
 **/

public class GrapeItemViewModel extends BaseViewModel {
    private ObservableInt backgroundColor;
    private ObservableField<String> resourceUrl;
    private ObservableField<String> resourceName;

    public GrapeItemViewModel(GrapeModel grapeModel) {
        resourceUrl = new ObservableField<>(grapeModel.getResourceUrl());
        resourceName = new ObservableField<>(grapeModel.getResourceName());
        backgroundColor = new ObservableInt(grapeModel.getBackgroundColor());
    }

    public ObservableInt getBackgroundColor() {
        return backgroundColor;
    }

    public ObservableField<String> getResourceUrl() {
        return resourceUrl;
    }

    public ObservableField<String> getResourceName() {
        return resourceName;
    }
}
