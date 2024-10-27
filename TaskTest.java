package test.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
    TaskTest() {
    }

    @Test
    void testValidTaskCreation() {
        Task task = new Task("1234567890", "Task Name", "Valid Description");
        Assertions.assertEquals("1234567890", task.getTaskId());
        Assertions.assertEquals("Task Name", task.getName());
        Assertions.assertEquals("Valid Description", task.getDescription());
    }

    @Test
    void testInvalidTaskId() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Task Name", "Valid Description");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task((String)null, "Task Name", "Valid Description");
        });
    }

    @Test
    void testInvalidName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "This name is too long", "Valid Description");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", (String)null, "Valid Description");
        });
    }

    @Test
    void testInvalidDescription() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "Task Name", "This description is absolutely too long to be accepted.");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "Task Name", (String)null);
        });
    }
}
