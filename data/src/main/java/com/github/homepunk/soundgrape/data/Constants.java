package com.github.homepunk.soundgrape.data;

/**
 * Created by Homepunk on 19.10.2017.
 **/

public interface Constants {
    interface Browser {
        String HOME_PAGE = "about:blank";
    }

    interface Api {
        interface Youtube {
            String BASE_URL = "http://www.youtubeinmp3.com/fetch/";
            String CONVERT_TO_MP3 = "?format=JSON";
            String KEY_LINK = "link";
            String KEY_TITLE = "title";
            String KEY_LENGTH = "length";
            String PARAM_VIDEO = "video";
        }
    }
}
