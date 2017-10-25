package com.github.homepunk.soundgrape.presentation.browser.model;

/**
 * Created by Homepunk on 10.10.2017.
 **/

public class GrapeModel {
    private String resourceName;
    private String resourceUrl;
    private int backgroundColor;

    public GrapeModel(String resourceName, String resourceUrl, int backgroundColor) {
        this.resourceName = resourceName;
        this.resourceUrl = resourceUrl;
        this.backgroundColor = backgroundColor;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
