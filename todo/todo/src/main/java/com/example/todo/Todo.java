package com.example.todo;

public class Todo {
    private long id;
    private String task;
    private boolean complete;

    public Todo() {}

    public Todo(long id, String task, boolean complete) {
        this.id = id;
        this.task = task;
        this.complete = complete;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
