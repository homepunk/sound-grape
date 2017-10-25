package com.github.homepunk.soundgrape.presentation.browser.viewmodel;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.github.homepunk.soundgrape.presentation.base.BaseViewModel;
import com.github.homepunk.soundgrape.presentation.browser.clients.GrapeWebChromeClient;
import com.github.homepunk.soundgrape.presentation.browser.clients.GrapeWebViewClient;
import com.github.homepunk.soundgrape.utils.BrowserUtils;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by Homepunk on 11.10.2017.
 **/

public class GrapeBrowserViewModel extends BaseViewModel {
    private ObservableInt visibility = new ObservableInt(GONE);
    private ObservableField<String> url = new ObservableField<>();
    private GrapeWebViewClient grapeWebViewClient;
    private GrapeWebChromeClient grapeWebChromeClient;

    public GrapeBrowserViewModel() {
        grapeWebViewClient = new GrapeWebViewClient();
        grapeWebChromeClient = new GrapeWebChromeClient();
    }

    public GrapeWebViewClient getGrapeWebViewClient() {
        return grapeWebViewClient;
    }

    public GrapeWebChromeClient getGrapeWebChromeClient() {
        return grapeWebChromeClient;
    }

    public void setUrl(String url) {
        this.url.set(BrowserUtils.getFormattedUrl(url));
    }


    public void setVisibility(boolean isVisible) {
        this.visibility.set(isVisible ? VISIBLE : GONE);
    }

    public ObservableField<String> getUrl() {
        return url;
    }

    public ObservableInt getVisibility() {
        return visibility;
    }
}
