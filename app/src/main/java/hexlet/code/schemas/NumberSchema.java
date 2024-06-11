package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        Predicate<Integer> check = Objects::nonNull;
        checkResults.put("required", check);
        return this;
    }
    public NumberSchema positive() {
        Predicate<Integer> check = (obj) -> ((obj == null) || (obj.intValue() > 0));
        checkResults.put("positive", check);
        return this;
    }
    public NumberSchema range(int down, int up) {
        Predicate<Integer> check = (obj) -> ((obj == null)
               || ((obj.intValue() >= down) && (obj.intValue() <= up)));
        checkResults.put("range", check);
        return this;
    }
}

