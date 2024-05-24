package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class NumberSchema {
    private final Map<String, Predicate<Object>> checkResults = new HashMap<>();
    public NumberSchema required() {
        Predicate<Object> check = (obj) -> obj instanceof Number;
        checkResults.put("required", check);
        return this;
    }
    public NumberSchema positive() {
        Predicate<Object> check = (obj) -> (obj instanceof Number num) && (num.intValue() > 0);
        checkResults.put("positive", check);
        return this;
    }
    public NumberSchema range(int down, int up) {
        Predicate<Object> check = (obj) -> (obj instanceof Number num) &&
                (num.intValue() >= down) && (num.intValue() <= up);
        checkResults.put("range", check);
        return this;
    }
    public final boolean isValid(Integer data) {
        return checkResults.values().stream().allMatch(p -> p.test(data));
    }
}

