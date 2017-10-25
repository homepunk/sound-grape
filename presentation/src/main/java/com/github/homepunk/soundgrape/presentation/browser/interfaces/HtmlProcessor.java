package com.github.homepunk.soundgrape.presentation.browser.interfaces;

import android.webkit.JavascriptInterface;

import timber.log.Timber;

/**
 * Created by Homepunk on 19.10.2017.
 **/

public class HtmlProcessor {
    @JavascriptInterface
    public void processHtml(String html) {
        Timber.i(html);
    }
}
