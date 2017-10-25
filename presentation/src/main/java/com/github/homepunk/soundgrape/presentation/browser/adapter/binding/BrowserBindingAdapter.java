package com.github.homepunk.soundgrape.presentation.browser.adapter.binding;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Homepunk on 18.10.2017.
 **/

public class BrowserBindingAdapter {
    @BindingAdapter({"app:webViewClient", "app:webChromeClient", "app:javaScriptEnabled"})
    public static void setUpBrowser(WebView view, WebViewClient webViewClient, WebChromeClient webChromeClient, boolean enable) {
        view.setWebViewClient(webViewClient);
        view.setWebChromeClient(webChromeClient);
        view.getSettings().setJavaScriptEnabled(enable);
    }

    @BindingAdapter("app:url")
    public static void loadUrl(WebView view, String url) {
        if (!TextUtils.isEmpty(url)) {
            view.loadUrl(url);
        }
    }

    @BindingAdapter("app:isGoBack")
    public static void goBack(WebView view, boolean isGoBack) {
        if (isGoBack) {
            if (view.canGoBack()) {
                view.goBack();
            } else {
                view.clearHistory();
                view.clearCache(true);
                view.setVisibility(View.GONE);
            }
        }
    }
}
