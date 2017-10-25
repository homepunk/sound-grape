package com.github.homepunk.soundgrape.utils;

import static com.github.homepunk.soundgrape.data.Constants.Browser.HOME_PAGE;

/**
 * Created by Homepunk on 10.10.2017.
 **/

public class BrowserUtils {
    public static String getFormattedUrl(String address) {
        if (address != null && !address.equals(HOME_PAGE)) {
            if (!address.startsWith("www.") && !address.startsWith("http://")) {
                address = "www." + address;
            }

            if (!address.startsWith("http://")) {
                address = "http://" + address;
            }
        }

        return address;
    }
}
