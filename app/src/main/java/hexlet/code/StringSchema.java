package hexlet.code;

import com.sun.jdi.ObjectReference;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class StringSchema {

    private final Map<String, Predicate<Object>> checkResults = new HashMap<>();
    public StringSchema required() {
        Predicate <Object> check = (obj) -> obj instanceof String str && !str.isBlank();
        checkResults.put("required", check);
        return this;
    }
    public StringSchema minLength(Integer minLen) {
        Predicate <Object> check = (obj) -> obj instanceof String str && str.length() >= minLen;
        checkResults.put("minLength", check);
        return this;
    }

    public StringSchema contains(String str) {
        Predicate <Object> check = (obj) -> obj instanceof String s && s.contains(str);
        checkResults.put("contains", check);
        return this;
    }
    public final boolean isValid(String data) {
        return checkResults.values().stream().allMatch(p -> p.test(data));
    }
}
