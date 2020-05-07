package univ.stud.holiday.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class WebMapper {

    private WebMapper() {
        throw new AssertionError();
    }

    public static Map<String, String> of(String postMessage) {
        Map<String, String> map = new HashMap<>();
        String[] pairs = postMessage.split("&");
        for (String pair : pairs) {
            if (pair.contains("=")) {
                String[] content = pair.split("=");
                map.put(content[0], content.length == 1 ? "" : content[1]);
            }
        }
        return map;
    }
}
