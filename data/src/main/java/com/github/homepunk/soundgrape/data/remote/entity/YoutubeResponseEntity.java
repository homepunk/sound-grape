package com.github.homepunk.soundgrape.data.remote.entity;

import com.google.gson.annotations.SerializedName;

import static com.github.homepunk.soundgrape.data.Constants.Api.Youtube.KEY_LENGTH;
import static com.github.homepunk.soundgrape.data.Constants.Api.Youtube.KEY_LINK;
import static com.github.homepunk.soundgrape.data.Constants.Api.Youtube.KEY_TITLE;

/**
 * Created by Homepunk on 24.10.2017.
 **/

public class YoutubeResponseEntity {
    @SerializedName(KEY_TITLE)
    private String title;
    @SerializedName(KEY_LENGTH)
    private String length;
    @SerializedName(KEY_LINK)
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDownloadUrl() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
