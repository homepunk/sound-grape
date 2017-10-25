package com.github.homepunk.soundgrape.domain.usecase.download;

import com.github.homepunk.soundgrape.domain.gateway.MusicDownloadGateway;
import com.github.homepunk.soundgrape.domain.usecase.UseCase;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by Homepunk on 25.10.2017.
 **/

public class DownloadMusicFromYoutube extends UseCase<Long> {
    private final MusicDownloadGateway youtubeMusicDownloadGateway;
    private String url = "";

    public DownloadMusicFromYoutube(Scheduler executorThread, Scheduler uiThread, MusicDownloadGateway youtubeMusicDownloadGateway) {
        super(executorThread, uiThread);
        this.youtubeMusicDownloadGateway = youtubeMusicDownloadGateway;
    }

    @Override
    protected Observable<Long> createUseCaseObservable() {
        return youtubeMusicDownloadGateway.download(url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
