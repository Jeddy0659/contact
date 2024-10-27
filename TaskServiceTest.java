package test.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
    TaskServiceTest() {
    }

    @Test
    void testAddAndRetrieveTask() {
        TaskService service = new TaskService();
        Task task = new Task("1234", "This Task", "Description of something");
        service.addTask(task);
        Assertions.assertEquals(task, service.getTask("1234"), "Task should be delivered correctly.");
    }

    @Test
    void testAddTaskWithSameIdThrowsException() {
        TaskService service = new TaskService();
        Task task1 = new Task("1234", "This Task", "Description of something");
        Task task2 = new Task("1234", "That Task", "Description of this thing");
        service.addTask(task1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        }, "Adding a task with the same ID should throw an exception.");
    }

    @Test
    void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("1234", "This Task 2", "Description of something");
        service.addTask(task);
        service.deleteTask("1234");
        Assertions.assertNull(service.getTask("1234"), "Task should be null after deleting.");
    }

    @Test
    void testUpdateTask() {
        TaskService service = new TaskService();
        Task task = new Task("1234", "This Task 3", "Description of something");
        service.addTask(task);
        service.updateTask("1234", "Updated Name", "Updated Description");
        Assertions.assertEquals("Updated Name", service.getTask("1234").getName(), "Task name should be updated.");
        Assertions.assertEquals("Updated Description", service.getTask("1234").getDescription(), "Task description should be updated.");
    }
}
