package hexlet.code;

public class Validator {
    public StringSchema string() {
        return new StringSchema();
    }
    public NumberSchema number() {
        return new NumberSchema();
    }
    public MapSchema map() {
        return new MapSchema();
    }
}
