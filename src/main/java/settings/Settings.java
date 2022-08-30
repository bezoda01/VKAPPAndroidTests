package settings;

import org.json.simple.JSONObject;

import static utils.FilesUtils.read;
import static utils.JsonUtils.readJson;

public class Settings {
    public static JSONObject caps = readJson(read("src/main/resources/caps.json"));
    public static JSONObject config = readJson(read("src/main/resources/config.json"));
    public static JSONObject timeouts = (JSONObject) config.get("timeouts");
}