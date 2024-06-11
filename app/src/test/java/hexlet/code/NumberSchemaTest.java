package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class NumberSchemaTest {
    private Validator validator;
    @BeforeEach
    void setUp() {
        validator = new Validator();
    }
    @Test
    void testNumberSchemaRequired() {
        var schema = validator.number();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(-1));
        assertTrue(schema.isValid(0));
        assertTrue(schema.isValid(1));
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(20));
        assertTrue(schema.isValid(-20));
        assertTrue(schema.isValid(0));
    }

    @Test
    void testNumberSchemaPositive() {
        var schema = validator.number();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(-1));
        schema.positive();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));
    }

    @Test
    void testNumberSchemaRange() {
        var schema = validator.number();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(100));
        schema.range(-30, 40);
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(-30));
        assertTrue(schema.isValid(40));
        assertFalse(schema.isValid(-31));
        assertFalse(schema.isValid(41));
    }
    @Test
    void testNumberSchemaChained() {
        var schema = validator.number();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(-100));
        schema.required().positive().range(30, 40);
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(30));
        assertTrue(schema.isValid(40));
        assertFalse(schema.isValid(29));
        assertFalse(schema.isValid(41));
    }
}
