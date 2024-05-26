package hexlet.code;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public StringSchema required() {
        Predicate<Object> check = (obj) -> obj instanceof String str && !str.isBlank();
        checkResults.put("required", check);
        return this;
    }
    public StringSchema minLength(Integer minLen) {
        Predicate<Object> check = (obj) -> obj instanceof String str && str.length() >= minLen;
        checkResults.put("minLength", check);
        return this;
    }

    public StringSchema contains(String str) {
        Predicate<Object> check = (obj) -> obj instanceof String s && s.contains(str);
        checkResults.put("contains", check);
        return this;
    }

}
