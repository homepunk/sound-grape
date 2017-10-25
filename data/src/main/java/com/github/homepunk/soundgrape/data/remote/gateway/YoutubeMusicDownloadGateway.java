package com.github.homepunk.soundgrape.data.remote.gateway;


import android.app.DownloadManager;
import android.net.Uri;
import android.os.Environment;

import com.github.homepunk.soundgrape.data.remote.api.YoutubeMusicApi;
import com.github.homepunk.soundgrape.data.remote.api.YoutubeMusicApiConnection;
import com.github.homepunk.soundgrape.data.remote.entity.YoutubeResponseEntity;
import com.github.homepunk.soundgrape.domain.gateway.MusicDownloadGateway;

import io.reactivex.Observable;

import static android.app.DownloadManager.Request.NETWORK_MOBILE;
import static android.app.DownloadManager.Request.NETWORK_WIFI;

/**
 * Created by Homepunk on 25.10.2017.
 **/

public class YoutubeMusicDownloadGateway implements MusicDownloadGateway {
    private final YoutubeMusicApi youtubeMusicApi;
    private final DownloadManager downloadManager;

    public YoutubeMusicDownloadGateway(DownloadManager downloadManager) {
        this.downloadManager = downloadManager;
        this.youtubeMusicApi = YoutubeMusicApiConnection.getApiInstance();
    }

    @Override
    public Observable<Long> download(String url) {
        return youtubeMusicApi.getConvertedTrack(url)
                .flatMapObservable(responseEntity -> {
                    if (responseEntity.getDownloadUrl() == null) {
                        throw new IllegalArgumentException("Download url shouldn't be null");
                    }
                    DownloadManager.Request downloadRequest = getDownloadRequest(responseEntity);
                    return Observable.just(downloadManager.enqueue(downloadRequest));
                });
    }

    private DownloadManager.Request getDownloadRequest(YoutubeResponseEntity youtubeResponseEntity) {
        Uri downloadUri = Uri.parse(youtubeResponseEntity.getDownloadUrl());
        DownloadManager.Request request = new DownloadManager.Request(downloadUri);
        request.setAllowedNetworkTypes(NETWORK_WIFI | NETWORK_MOBILE);
        request.setAllowedOverRoaming(false);
        request.setTitle(youtubeResponseEntity.getTitle());
        request.setDescription("Downloading  " + youtubeResponseEntity.getTitle());
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "/SoundGrape/" + "/" + youtubeResponseEntity.getTitle() + ".mp3");
        return request;
    }
}
