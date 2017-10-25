package com.github.homepunk.soundgrape.data.remote.api;

import com.github.homepunk.soundgrape.data.remote.entity.YoutubeResponseEntity;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.github.homepunk.soundgrape.data.Constants.Api.Youtube.CONVERT_TO_MP3;
import static com.github.homepunk.soundgrape.data.Constants.Api.Youtube.PARAM_VIDEO;

/**
 * Created by Homepunk on 24.10.2017.
 **/

public interface YoutubeMusicApi {
    @GET(CONVERT_TO_MP3)
    Single<YoutubeResponseEntity> getConvertedTrack(@Query(PARAM_VIDEO) String videoUrl);
}
