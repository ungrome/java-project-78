package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        addChecking("required", (obj) -> obj instanceof String str && !str.isBlank());
        return this;
    }
    public StringSchema minLength(Integer minLen) {
        addChecking("minLength", (obj) -> obj instanceof String str && str.length() >= minLen);
        return this;
    }
    public StringSchema contains(String str) {
        addChecking("contains", (obj) -> obj instanceof String s && s.contains(str));
        return this;
    }

}
