package univ.stud.holiday.common;

<<<<<<< HEAD
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class WebMapper {

    private WebMapper() {
        throw new AssertionError();
    }

<<<<<<< HEAD
    public static Map<String, String> of(String postMessage) {
        Map<String, String> map = new HashMap<>();
=======
    public static Map<String, Object> of(String postMessage) {
        Map<String, Object> map = new HashMap<>();
>>>>>>> a57ef37a2a45259db7c24ab97fecb66e0acfce3b
        String[] pairs = URLDecoder.decode(postMessage).split("&");
        for (String pair : pairs) {
            if (pair.contains("=")) {
                String[] content = pair.split("=");
                map.put(content[0], content.length == 1 ? null : content[1]);
            }
        }
        return map;
    }

    public static Map<String, Object> of(Holiday holiday) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("startDate", Converter.fromLocalDate(holiday.getStartDate()));
        objectMap.put("endDate", Converter.fromLocalDate(holiday.getEndDate()));
        objectMap.put("description", holiday.getDescription());
        objectMap.put("holidayId", holiday.getId());
        objectMap.put("username", holiday.getUsername());
        objectMap.put("title", holiday.getTitle());
        return objectMap;
    }

    public static Map<String, Object> of(Visited visited) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("visitedId", String.valueOf(visited.getId()));
        objectMap.put("holidayId", String.valueOf(visited.getHolidayId()));
        objectMap.put("attractionId", String.valueOf(visited.getAttractionId()));
        objectMap.put("startDate", Converter.fromLocalDateTime(visited.getStartDate()));
        objectMap.put("endDate", Converter.fromLocalDateTime(visited.getEndDate()));
        return objectMap;
    }


    public static Map<String, Object> of(HttpServletRequest request) throws IOException {
        return WebMapper.of(request.getReader().lines().collect(Collectors.joining()));
    }

    public static User toUser(Map<String, Object> map) {
        return new User(
                (String) map.get("username"),
                (String) map.get("password"),
                (String) map.get("imageUrl"),
                (String) map.get("emailAddress"),
                (String) map.get("firstName"),
                (String) map.get("lastName")
        );
    }

    public static Holiday toHoliday(Map<String, Object> map) {
        if (map.get("holidayId") != null) {
            return new Holiday(
                    (Integer) map.get("holidayId"),
                    (String) map.get("title"),
                    (String) map.get("username"),
                    (String) map.get("description"),
                    Converter.toLocalDate((String) map.get("startDate")),
                    Converter.toLocalDate((String) map.get("endDate"))
            );
        }
        return new Holiday(
                (String) map.get("title"),
                (String) map.get("username"),
                (String) map.get("description"),
                Converter.toLocalDate((String) map.get("startDate")),
                Converter.toLocalDate((String) map.get("endDate"))
        );
    }

    public static Visited toVisited(Map<String, Object> map) {
        if (map.get("visitedId") != null) {
            return new Visited(
                    (int) map.get("visitedId"),
                    (int) map.get("holidayId"),
                    Integer.parseInt((String) map.get("attractionId")),
                    Converter.toLocalDateTime((String) map.get("startDate")),
                    Converter.toLocalDateTime((String) map.get("endDate"))
            );
        }
        return new Visited(
                (int) map.get("holidayId"),
                Integer.parseInt((String) map.get("attractionId")),
                Converter.toLocalDateTime((String) map.get("startDate")),
                Converter.toLocalDateTime((String) map.get("endDate"))
        );
    }

    public static Review toReview(Map<String, Object> map) {
        if (map.get("reviewId") != null) {
            return new Review(
                    (int) map.get("reviewId"),
                    (int) map.get("visitedId"),
                    (String) map.get("title"),
                    (String) map.get("content"),
                    Double.parseDouble((String) map.get("rating")),
                    Converter.toLocalDateTime((String) map.get("timestamp"))
            );
        }
        return new Review(
                (int) map.get("visitedId"),
                (String) map.get("title"),
                (String) map.get("content"),
                Double.parseDouble((String) map.get("rating")),
                Converter.toLocalDateTime((String) map.get("timestamp"))
        );
    }

    public static Map<String, Object> of(Review review) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("reviewId", String.valueOf(review.getId()));
        objectMap.put("visitedId", String.valueOf(review.getVisitedId()));
        objectMap.put("title", review.getTitle());
        objectMap.put("content", review.getContent());
        objectMap.put("rating", String.valueOf(review.getRating()));
        objectMap.put("timestamp", Converter.fromLocalDateTime(review.getTimestamp()));
        return objectMap;
    }

    public static Expense toExpense(Map<String, Object> objectMap) {
        if (objectMap.get("expenseId") != null) {
            return new Expense(
                    (int) objectMap.get("expenseId"),
                    (int) objectMap.get("visitedId"),
                    Double.parseDouble((String) objectMap.get("price")),
                    (String) objectMap.get("name")
            );
        }
        return new Expense(
                (int) objectMap.get("visitedId"),
                Double.parseDouble((String) objectMap.get("price")),
                (String) objectMap.get("name")
        );
    }

    public static Map<String, Object> of(Expense expense) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("expenseId", String.valueOf(expense.getId()));
        objectMap.put("visitedId", String.valueOf(expense.getVisitedId()));
        objectMap.put("price", String.valueOf(expense.getPrice()));
        objectMap.put("name", expense.getName());
        return objectMap;
    }

    public static Resource toResource(Map<String, Object> objectMap) {
        if (objectMap.get("resourceId") != null) {
            return new Resource(
                    (int) objectMap.get("resourceId"),
                    (int) objectMap.get("visitedId"),
                    (String) objectMap.get("title"),
                    (String) objectMap.get("imageUrl"),
                    Converter.toLocalDateTime((String) objectMap.get("timestamp"))
            );
        }
        return new Resource(
                (int) objectMap.get("visitedId"),
                (String) objectMap.get("title"),
                (String) objectMap.get("imageUrl"),
                Converter.toLocalDateTime((String) objectMap.get("timestamp"))
        );
    }

    public static Map<String, Object> of(Resource resource) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("resourceId", String.valueOf(resource.getId()));
        objectMap.put("visitedId", String.valueOf(resource.getVisitedId()));
        objectMap.put("title", resource.getTitle());
        objectMap.put("imageUrl", resource.getImageUrl());
        objectMap.put("timestamp", Converter.fromLocalDateTime(resource.getTimestamp()));
        return objectMap;
    }
}
