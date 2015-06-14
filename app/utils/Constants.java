package utils;

import com.squareup.okhttp.MediaType;

public class Constants {

    private Constants() {

    }

    public static final String URL = "https://android.googleapis.com/gcm/send";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

}
