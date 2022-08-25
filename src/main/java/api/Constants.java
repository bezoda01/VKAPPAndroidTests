package api;

import static settings.Settings.config;

public class Constants {
    public static final String TOKEN_AND_API_VERSION = "&access_token=" + config.get("token").toString() + "&v=" + config.get("apiVersion").toString();
}