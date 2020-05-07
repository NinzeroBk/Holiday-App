package univ.stud.holiday.common;

import univ.stud.holiday.model.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
                map.put(content[0], content.length == 1 ? null : content[1]);
            }
        }
        return map;
    }

    public static Map<String, String> of(HttpServletRequest request) throws IOException {
        return WebMapper.of(request.getReader().lines().collect(Collectors.joining()));
    }

    public static User toUser(Map<String, String> userMap) {
        return new User(userMap.get("username"),
                userMap.get("password"),
                userMap.get("imageUrl"),
                userMap.get("emailAddress"),
                userMap.get("firstName"),
                userMap.get("lastName"));
    }
}
