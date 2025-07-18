package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // assertEquals
        assertEquals(5, 2 + 3, "2 + 3 should equal 5");

        // assertTrue
        assertTrue(5 > 3, "5 should be greater than 3");

        // assertFalse
        assertFalse(5 < 3, "5 should not be less than 3");

        // assertNull
        Object obj = null;
        assertNull(obj, "Object should be null");

        // assertNotNull
        Object anotherObj = new Object();
        assertNotNull(anotherObj, "Object should not be null");
    }
}
