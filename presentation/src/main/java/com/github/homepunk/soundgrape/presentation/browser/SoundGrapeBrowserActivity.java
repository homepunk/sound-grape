package com.github.homepunk.soundgrape.presentation.browser;

import android.app.DownloadManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.github.homepunk.soundgrape.BR;
import com.github.homepunk.soundgrape.R;
import com.github.homepunk.soundgrape.data.remote.gateway.YoutubeMusicDownloadGateway;
import com.github.homepunk.soundgrape.databinding.ActivityGrapeBrowserBinding;
import com.github.homepunk.soundgrape.domain.gateway.MusicDownloadGateway;
import com.github.homepunk.soundgrape.domain.usecase.download.DownloadMusicFromYoutube;
import com.github.homepunk.soundgrape.presentation.browser.interfaces.HtmlProcessor;
import com.github.homepunk.soundgrape.presentation.browser.viewmodel.GrapeBrowserViewModel;
import com.github.homepunk.soundgrape.presentation.browser.viewmodel.GrapeListViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

import static com.github.homepunk.soundgrape.data.Constants.Browser.HOME_PAGE;

public class SoundGrapeBrowserActivity extends AppCompatActivity {
    private WebView grapeBrowser;
    private GrapeListViewModel grapeListViewModel;
    private GrapeBrowserViewModel grapeBrowserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        bind();
        MusicDownloadGateway youtubeMusicDownloadGateway = new YoutubeMusicDownloadGateway((DownloadManager) getSystemService(DOWNLOAD_SERVICE));
        DownloadMusicFromYoutube downloadMusicFromYoutube = new DownloadMusicFromYoutube(Schedulers.io(), AndroidSchedulers.mainThread(), youtubeMusicDownloadGateway);
        downloadMusicFromYoutube.setUrl("http://www.youtube.com/watch?v=0FcDXL5Aw0o");
        downloadMusicFromYoutube.execute(new DisposableObserver<Long>() {
            @Override
            public void onNext(@NonNull Long downloadId) {
                Timber.i(String.valueOf(downloadId));
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Timber.e(e);
            }

            @Override
            public void onComplete() {
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        grapeBrowser.addJavascriptInterface(new HtmlProcessor(), "HtmlProcessor");
        grapeListViewModel.getGrapeItemEventStream()
                .subscribe(grapeModel -> {
                    if (grapeModel != null && !grapeModel.getResourceUrl().isEmpty()) {
                        grapeBrowserViewModel.setUrl(grapeModel.getResourceUrl());
                        grapeBrowserViewModel.setVisibility(true);
                    }
                });
    }

    @Override
    public void onBackPressed() {
        if (grapeBrowser.canGoBack()) {
            grapeBrowser.goBack();
        } else if (grapeBrowser.getUrl() != null) {
            grapeBrowserViewModel.setUrl(HOME_PAGE);
        }
    }

    private void init() {
        grapeListViewModel = new GrapeListViewModel();
        grapeBrowserViewModel = new GrapeBrowserViewModel();
    }

    @UiThread
    private void bind() {
        ActivityGrapeBrowserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_grape_browser);
        setSupportActionBar(binding.activityGrapeBrowserToolbar);
        binding.setVariable(BR.grapeListViewModel, grapeListViewModel);
        binding.setVariable(BR.grapeBrowserViewModel, grapeBrowserViewModel);
        binding.executePendingBindings();
        grapeBrowser = binding.activityGrapeBrowserWebView;
    }
}
