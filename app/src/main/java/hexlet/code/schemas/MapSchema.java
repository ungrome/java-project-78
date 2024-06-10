package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    public MapSchema required() {
        Predicate<Object> check = (obj) -> obj instanceof Map;
        checkResults.put("required", check);
        return this;
    }
    public MapSchema sizeof(int count) {
        Predicate<Object> check;
        check = (obj) -> obj instanceof Map && ((Map<?, ?>) obj).size() == count;
        checkResults.put("sizeof", check);
        return this;
    }
    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        Predicate<Map> check = (Map value) -> {
            for (var e: schemas.entrySet()) {
                if (!e.getValue().isValid(value.get(e.getKey()))) {
                    return false;
                }
            }
            return true;
        };
        checkResults.put("shape", check);
        return this;
    }

}
