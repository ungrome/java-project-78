package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema required() {
        addChecking("required", (obj) -> obj instanceof Map<?,?>);
        return this;
    }
    public MapSchema sizeof(int count) {
        addChecking("sizeof", (obj) -> obj instanceof Map && ((Map<?, ?>) obj).size() == count);
        return this;
    }
    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        addChecking("shape", value -> {
            for (var e: schemas.entrySet()) {
                Map<?,?> valueToCheck = (Map) value;
                if (!e.getValue().isValid(valueToCheck.get(e.getKey()))) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }

}
