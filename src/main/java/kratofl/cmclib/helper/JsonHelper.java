package kratofl.cmclib.helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kratofl.cmclib.advancements.adapter.*;

import java.util.List;
import java.util.Map;

public class JsonHelper {
    private static final Gson GSON = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .registerTypeAdapter(List.class, new ListAdapter())
            .registerTypeAdapter(Map.class, new MapAdapter())
            .setPrettyPrinting()
            .create();
    public static String getJsonFromClass(Object object) {
        return GSON.toJson(object);
    }
}
