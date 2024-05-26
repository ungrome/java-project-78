package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {
    public final Map<String, Predicate<Object>> checkResults = new HashMap<>();
    public final boolean isValid(Object data) {
        return checkResults.values().stream().allMatch(p -> p.test(data));
    }
}
