package hexlet.code;
import hexlet.code.Validator;
import hexlet.code.StringSchema;

public class App {
    public static void main(String[] args) {
        var v = new Validator();
        var schema = v.number();
        schema.isValid(5); // true
        schema.isValid(null); // true
        schema.positive().isValid(null); // true
        schema.required();
        schema.isValid(null); // false
        schema.isValid(10); // true
        schema.isValid(-10); // false
        schema.isValid(0); // false
        schema.range(5, 10);
        schema.isValid(5); // true
        schema.isValid(10); // true
        schema.isValid(4); // false
        schema.isValid(11); // false
    }
}
