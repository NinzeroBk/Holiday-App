package univ.stud.holiday.common;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public final class WebMapper {

    private WebMapper() {
        throw new AssertionError();
    }

    public static Map<String, String> of(String postMessage) {
        Map<String, String> map = new HashMap<>();
        String[] pairs = URLDecoder.decode(postMessage).split("&");
        for (String pair : pairs) {
            if (pair.contains("=")) {
                String[] content = pair.split("=");
                map.put(content[0], content.length == 1 ? "" : content[1]);
            }
        }
        return map;
    }
}
