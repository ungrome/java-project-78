package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected final Map<String, Predicate<T>> checkResults = new HashMap<>();
    public final boolean isValid(Object data) {
        return checkResults.values().stream().allMatch(p -> p.test((T) data));
    }


}
