package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        addChecking("required", Objects::nonNull);
        return this;
    }
    public NumberSchema positive() {
        addChecking("positive", (obj) -> ((obj == null) || (obj.intValue() > 0)));
        return this;
    }
    public NumberSchema range(int down, int up) {
        addChecking("range", (obj) -> ((obj == null)
               || ((obj.intValue() >= down) && (obj.intValue() <= up))));
        return this;
    }
}

