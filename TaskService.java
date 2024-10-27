package test.java;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> taskMap = new HashMap();

    public TaskService() {
    }

    public void addTask(Task task) {
        if (this.taskMap.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task with this ID already exists.");
        } else {
            this.taskMap.put(task.getTaskId(), task);
        }
    }

    public void deleteTask(String taskId) {
        if (!this.taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found.");
        } else {
            this.taskMap.remove(taskId);
        }
    }

    public void updateTask(String taskId, String newName, String newDescription) {
        Task task = (Task)this.taskMap.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        } else {
            task.setName(newName);
            task.setDescription(newDescription);
        }
    }

    public Task getTask(String taskId) {
        return (Task)this.taskMap.get(taskId);
    }
}
