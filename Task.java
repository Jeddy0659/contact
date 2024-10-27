package test.java;

public class Task {
    private final String taskId;
    private String name;
    private String description;

    public Task(String taskId, String name, String description) {
        if (taskId != null && taskId.length() <= 10) {
            this.taskId = taskId;
            this.setName(name);
            this.setDescription(description);
        } else {
            throw new IllegalArgumentException("Task ID cannot be null and must be at most 10 characters long.");
        }
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name != null && name.length() <= 20) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be null and must be at most 20 characters long.");
        }
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        if (description != null && description.length() <= 50) {
            this.description = description;
        } else {
            throw new IllegalArgumentException("Description cannot be null and must be at most 50 characters long.");
        }
    }
}
