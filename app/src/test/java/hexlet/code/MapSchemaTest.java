package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class MapSchemaTest {
    @Test
    public void isValidMapTest() {
        var v = new Validator();
        var schema = v.map();
        assertTrue(schema.isValid(null)); // true
        schema.required();
        assertFalse(schema.isValid(null)); // false
        assertTrue(schema.isValid(new HashMap<>())); // true
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data)); // true
        schema.sizeOf(2);
        assertFalse(schema.isValid(data));  // false
        data.put("key2", "value2");
        assertTrue(schema.isValid(data)); // true
    }
}
