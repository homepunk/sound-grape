package com.github.homepunk.soundgrape.presentation.browser.clients;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.homepunk.soundgrape.utils.BrowserUtils;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.github.homepunk.soundgrape.data.Constants.Browser.HOME_PAGE;

/**
 * Created by Homepunk on 09.10.2017.
 **/

public class GrapeWebViewClient extends WebViewClient {
    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (!url.equals(HOME_PAGE)) {
            view.setVisibility(VISIBLE);
        } else {
            view.loadUrl(BrowserUtils.getFormattedUrl(url));
            return true;
        }

        return super.shouldOverrideUrlLoading(view, url);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        String url = request.getUrl().toString();

        if (!url.equals(HOME_PAGE)) {
            view.setVisibility(VISIBLE);
        } else {
            view.loadUrl(BrowserUtils.getFormattedUrl(url));
            return true;
        }

        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        if (url.equals(HOME_PAGE)) {
            view.clearHistory();
            view.setVisibility(GONE);
        } else {
            view.loadUrl("javascript:window:HtmlProcessor.processHtml('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
        }
    }


}
