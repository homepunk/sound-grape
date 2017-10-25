package com.github.homepunk.soundgrape.domain.gateway;


import io.reactivex.Observable;

/**
 * Created by Homepunk on 25.10.2017.
 **/

public interface MusicDownloadGateway {
    Observable<Long> download(String url);
}
